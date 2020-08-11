package com.huly.springboot.repository;

import com.huly.springboot.po.SysRole;
import com.huly.springboot.po.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TODO
 *
 * @author huluy
 * @date 2020/8/11 13:35
 */
public interface ISysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);

    List<SysRole> findRolesByUsername(String username);
}
