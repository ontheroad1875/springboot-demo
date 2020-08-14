package com.huly.springboot.security;

import com.huly.springboot.bo.User;
import com.huly.springboot.po.SysPermission;
import com.huly.springboot.po.SysUser;
import com.huly.springboot.repository.ISysPermissionRepository;
import com.huly.springboot.repository.ISysUserRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//import org.springframework.security.core.userdetails.User;

/**
 * TODO
 *
 * @author huluy
 * @date 2020/8/11 13:52
 */

@Component
public class CustomerUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerUserDetailsService.class);

    @Autowired
    private ISysUserRepository sysUserRepository;

    @Autowired
    private ISysPermissionRepository sysPermissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isNotEmpty(username)) {
            SysUser user = sysUserRepository.findByUsername(username);
            List<SysPermission> permissions = sysPermissionRepository.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (SysPermission permission : permissions) {
                if (permission != null && permission.getName()!=null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    logger.info("权限控制，用户为:{}的权限为:{}", user.getUsername(), permission.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }
}
