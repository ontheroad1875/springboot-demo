package com.huly.springboot.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 授权信息表
 * @Author huly
 * @Date 2020-08-11 11:42:21 
 */

@Entity
@Table(name ="sys_permission")
public class SysPermission  implements Serializable {

	private static final long serialVersionUID =  5999160862031881471L;

	/**
	 * 主键ID
	 */
	@Id
   	@Column(name = "id" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 名称
	 */
   	@Column(name = "name" )
	private String name;

	/**
	 * 访问地址
	 */
   	@Column(name = "url" )
	private String url;

	/**
	 * 父级ID
	 */
   	@Column(name = "pid" )
	private Long pid;

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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getPid() {
		return this.pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
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
					"url='" + url + '\'' +
					"pid='" + pid + '\'' +
					"description='" + description + '\'' +
				'}';
	}

}
