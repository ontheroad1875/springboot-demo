package com.huly.springboot.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 角色授权关系表
 * @Author huly
 * @Date 2020-08-11 11:42:21 
 */

@Entity
@Table(name ="sys_permission_role")
public class SysPermissionRole  implements Serializable {

	private static final long serialVersionUID =  5317458269774309555L;

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
   	@Column(name = "role_id" )
	private Long roleId;

	/**
	 * 授权ID
	 */
   	@Column(name = "permission_id" )
	private Long permissionId;

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

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
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
					"roleId='" + roleId + '\'' +
					"permissionId='" + permissionId + '\'' +
					"description='" + description + '\'' +
				'}';
	}

}
