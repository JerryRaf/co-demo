--迭代脚本，一个迭代一个sql文件，前面ddl，后面dml，按顺序排放
--20220501 xxx说明
alter table co_cms_db.cms_user add index idx_create_time(create_time);

alter table co_cms_db.cms_user add column create_time datetime not null comment '创建时间' after id;
alter table co_cms_db.cms_user modify column account varchar(128);

alter table co_cms_db.cms_user comment 'xx';