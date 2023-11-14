create table co_oms_db.oms_demo
(
    id          bigint unsigned  not null auto_increment,
    name        varchar(64)      not null default '' comment '名称',
    is_deleted  tinyint unsigned not null default 0 comment '是否删除 1是，0否',
    create_by   bigint unsigned  not null default 0 comment '创建人',
    create_time datetime         not null default current_timestamp comment '创建时间',
    update_by   bigint unsigned  not null default 0 comment '最后修改人',
    update_time datetime         not null default current_timestamp on update current_timestamp comment '最后修改时间',
    primary key (id)
) engine = innodb
  auto_increment = 1
  default charset = utf8mb4 comment ='多数据源测试表';