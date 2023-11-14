-- 表命名规则:cms(业务模块名称)_user(表名称)
create table co_cms_db.cms_user
(
    id                  bigint unsigned  not null auto_increment,
    account             varchar(64)      not null default '' comment '账号',
    password            varchar(64)      not null default '' comment '密码',
    email               varchar(64)      not null default '' comment '邮箱',
    sex                 tinyint unsigned not null default 1 comment '性别 1男 2女',
    money               decimal(12, 2)   not null default 0 comment '余额',
    status              tinyint unsigned not null default 1 comment '状态 1正常 2禁用',
    id_card             varchar(32)      not null default '' comment '身份证',
    id_card_cipher_id   bigint           not null default 0 comment '身份证秘钥数据id',
    id_card_cipher_text varchar(32)      not null default '' comment '身份证秘钥',
    is_deleted          tinyint unsigned not null default 0 comment '是否删除 1是，0否',
    create_by           bigint unsigned  not null default 0 comment '创建人',
    create_time         datetime         not null default current_timestamp comment '创建时间',
    update_by           bigint unsigned  not null default 0 comment '最后修改人',
    update_time         datetime         not null default current_timestamp on update current_timestamp comment '最后修改时间',
    primary key (id)
) engine = innodb
  auto_increment = 1
  default charset = utf8mb4 comment ='用户表';

-- 普通索引idx_字段名_字段名，唯一索引uk_字段名_字段名
alter table co_cms_db.cms_user
    add index idx_account (account);

create table co_cms_db.cms_cipher
(
    id          bigint unsigned not null auto_increment,
    iv          varchar(64)     not null default '' comment 'iv',
    secure_key  varchar(64)     not null default '' comment '秘钥',
    create_by   bigint unsigned not null default 0 comment '创建人',
    create_time datetime        not null default current_timestamp comment '创建时间',
    primary key (id)
) engine = innodb
  auto_increment = 1
  default charset = utf8mb4 comment ='秘钥表';

