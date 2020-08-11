package com.huly.springboot.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 用户信息表
 * @Author huly
 * @Date 2020-08-11 11:42:21 
 */

@Entity
@Table(name ="sys_user")
public class SysUser  implements Serializable {

	private static final long serialVersionUID =  3724280877158834991L;

	/**
	 * 主键ID
	 */
	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 用户名称
	 */
   	@Column(name = "username" )
	private String username;

	/**
	 * 用户密码
	 */
   	@Column(name = "password" )
	private String password;

	/**
	 * 描述
	 */
   	@Column(name = "description" )
	private String description;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "{" +
					"id='" + id + '\'' +
					"username='" + username + '\'' +
					"password='" + password + '\'' +
					"description='" + description + '\'' +
				'}';
	}

}
