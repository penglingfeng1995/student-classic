create table t_student(
    id bigint comment 'pk',
    studentName varchar(255) comment '姓名',
    studentAge int comment '年龄',
    studentEmail varchar(255) comment '邮箱',
    primary key (id)
)default charset=utf8mb4 engine=innodb;