package com.huly.springboot.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 用户角色关系表
 * @Author huly
 * @Date 2020-08-11 11:42:21 
 */

@Entity
@Table(name ="sys_role_user")
public class SysRoleUser  implements Serializable {

	private static final long serialVersionUID =  8856461189055988816L;

	/**
	 * 主键ID
	 */
	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 用户ID
	 */
   	@Column(name = "user_id" )
	private Long userId;

	/**
	 * 角色ID
	 */
   	@Column(name = "role_id" )
	private Long roleId;

	/**
	 * 用户名称
	 */
   	@Column(name = "user_name" )
	private String userName;

	/**
	 * 角色名称
	 */
   	@Column(name = "role_name" )
	private String roleName;

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

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
					"userId='" + userId + '\'' +
					"roleId='" + roleId + '\'' +
					"userName='" + userName + '\'' +
					"roleName='" + roleName + '\'' +
					"description='" + description + '\'' +
				'}';
	}

}
