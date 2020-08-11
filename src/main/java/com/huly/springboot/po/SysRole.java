package com.huly.springboot.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 角色信息表
 * @Author huly
 * @Date 2020-08-11 11:42:21 
 */

@Entity
@Table(name ="sys_role")
public class SysRole  implements Serializable {

	private static final long serialVersionUID =  1535246384224130348L;

	/**
	 * 主键ID
	 */
	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 角色名称
	 */
   	@Column(name = "name" )
	private String name;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
					"name='" + name + '\'' +
					"description='" + description + '\'' +
				'}';
	}

}
