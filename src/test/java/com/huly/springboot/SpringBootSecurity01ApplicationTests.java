package com.huly.springboot;

import com.huly.springboot.po.SysUser;
import com.huly.springboot.repository.ISysUserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSecurity01ApplicationTests {

    @Autowired
    private ISysUserRepository sysUserRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sysUserTest() {
        SysUser admin = sysUserRepository.findByUsername("admin");
        Assert.assertEquals("admin", admin.getUsername());
    }

}
