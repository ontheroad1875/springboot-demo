#用户
create table sys_user(
	id int(11) PRIMARY KEY auto_increment comment '主键ID',
	username VARCHAR(255) COMMENT '用户名称',
	password varchar(255) comment '用户密码',
	description varchar(255) comment '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

#用户角色
create table sys_role(
	id int(11) PRIMARY KEY auto_increment comment '主键ID',
	name VARCHAR(255) COMMENT '角色名称',
	description varchar(255) comment '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';

#用户角色关系表
create table sys_role_user(
	id int(11) PRIMARY KEY auto_increment comment '主键ID',
	user_id int(11) COMMENT '用户ID',
	role_id int(11) comment '角色ID',
	user_name varchar(255) comment '用户名称',
	role_name varchar(255) comment '角色名称',
	description varchar(255) comment '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

#授权可以访问的地址
create table sys_permission(
	id int(11) PRIMARY KEY auto_increment comment '主键ID',
	name VARCHAR(255) COMMENT '名称',
	url varchar(255) comment '访问地址',
	pid int(11) comment'父级ID',
	description varchar(255) comment '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权信息表';

#角色与授权关系表
create table sys_permission_role(
	id int(11) PRIMARY KEY auto_increment comment '主键ID',
	role_id int(11) COMMENT '用户名称',
	permission_id int(11) comment '授权ID',
	description varchar(255) comment '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色授权关系表';


#用户姓名唯一索引
ALTER TABLE sys_user ADD UNIQUE (username);