package com.huly.springboot.repository;

import com.huly.springboot.po.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TODO
 *
 * @author huluy
 * @date 2020/8/11 13:38
 */
public interface ISysPermissionRepository extends JpaRepository<SysPermission, Long> {

    @Query(value="select p.* from sys_user u\n" +
            "    LEFT JOIN sys_role_user sur on u.id= sur.user_id\n" +
            "    LEFT JOIN sys_role r on sur.role_id=r.id\n" +
            "    LEFT JOIN sys_permission_role srp on srp.role_id=r.id\n" +
            "    LEFT JOIN sys_permission p on p.id =srp.permission_id\n" +
            "    where u.id=#{userId}", nativeQuery=true)
    List<SysPermission> findByAdminUserId(Long userId);

    @Query("select p from SysPermission p")
    List<SysPermission> findAll();
}
