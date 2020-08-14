package com.huly.springboot.bo;

import com.huly.springboot.po.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * TODO
 *
 * @author huluy
 * @date 2020/8/12 9:42
 */
public class User extends SysUser implements UserDetails {

    public User(){}

    public User(String username, String passord, List<GrantedAuthority> authorities) {
        super.setUsername(username);
        super.setPassword(passord);
        this.authorities = authorities;
    }

    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
