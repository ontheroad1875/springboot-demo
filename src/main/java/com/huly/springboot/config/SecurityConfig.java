package com.huly.springboot.config;

import com.huly.springboot.security.CustomerUserDetailsService;
import com.huly.springboot.security.MyFilterSecurityInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

/**
 * spring security 的基本配置
 * 该配合之后就会要求访问的url进行登录操作，为什么要引入EnableWebSecurity，因为security主要是通过springSecurityFilterChain 来生效的，实际上我们从该注解中可以看到该文件中引入了WebSecurityConfiguration，
 * 而该文件中确实也包含了springSecurityFilterChain
 *
 * @author huly
 * @date 2020/8/10 10:48
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

//    @Bean
//    public UserDetailsManager userDetailsManager() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(new User("admin", "{bcrypt}$2a$10$Y8nJQ8s2ZEk1atkCtvKgCuCSmwK2P8YNfSY.bYiM.r/F56es..vD6", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
//        return manager;
//    }

    /**
     *
     * 确保对我们应用程序的任何请求都需要对用户进行身份验证
     * 允许用户使用基于表单的登录进行身份验证
     * 允许用户使用HTTP Basic身份验证进行身份验证
     *
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        logger.debug("Using default configure(HttpSecurity). If subclassed this will potentially override subclass configure(HttpSecurity).");
        // anthorizeRequests每个子级都按照他们的顺序考虑
        // 任何以“ / admin /”开头的URL都将限于角色为“ ROLE_ADMIN”的用户。您将注意到，由于我们正在调用该hasRole方法，因此无需指定“ ROLE_”前缀。
        // 任何以“ / db /”开头的URL都要求用户同时具有“ ROLE_ADMIN”和“ ROLE_DBA”。您会注意到，由于我们使用的是hasRole表达式，因此无需指定“ ROLE_”前缀
        // 任何尚未匹配的URL仅要求对用户进行身份验证
        // 关闭csrf验证， 是一个关于token的验证。
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/templates/**", "/js/**", "/css/**").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login.html").failureForwardUrl("/error").permitAll()//登录页面用户任意访问
                .and()
                .headers()
                .frameOptions().sameOrigin(); //注销行为任意访问

        // 退出登录配置
        http.logout().logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .addLogoutHandler(new SecurityContextLogoutHandler());

        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }

    /**
     * 配置自定义的UserDetailsService实现
     * @return
     */
//    public UserDetailsService customerUserDetailsService() {
//        return new CustomerUserDetailsService();
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题（plugins目录在工程resources/static/下）
        web.ignoring().antMatchers("/plugins/**","/login.html");
    }
    //    public static void main(String[] args) {
//
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	    System.out.println(encoder.encode("password"));
//
//	    //outputs {bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG
//
//    }
}
