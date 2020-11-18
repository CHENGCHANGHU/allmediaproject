/* 01 sysy_log ��־��*/
create table if not exists sys_log(
	`id` bigint(40) not null auto_increment,		/*����*/
	`ip` varchar(20) not null,					/*������ַip*/
	`create_by` datetime not null default now(),	/*����ʱ��*/
	`remark` varchar(255) not null,				/*��������*/
	`operate_url` varchar(50) not null,			/*�����ķ��ʵ�ַ*/
	`operate_by` varchar(20) not null,			/*�����������*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 02 tbl_user �û���*/
create table if not exists tbl_user(
	`id` bigint(40) not null auto_increment,		/*����(�û�id)*/
	`name` varchar(20),							/*�û���*/
	`password` varchar(255),						/*�û���¼����(��ϣ)*/
	`email `varchar(50),							/*��¼����*/
	`phone` varchar(20),							/*��¼�ֻ���*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`modified_by` datetime,						/*�޸�ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 03 tbl_user_info �û���Ϣ��*/
create table if not exists tbl_user_info(
	`id` bigint(40) not null auto_increment,		/*����*/
	`user_id` bigint(40) not null,				/*�û�id*/
	`real_name` varchar(20),						/*��ʵ����*/
	`gender` tinyint(1),							/*�Ա�*/
	`birthday` date,								/*��������*/
	`id_number` varchar(20),						/*���֤��*/
	`head_portrait` varchar(50),					/*ͷ��url*/
	`description`	varchar(255),					/*�˺�����*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`modified_by` datetime,						/*�޸�ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 04 tbl_role_authentication �û���ɫ��֤��*/
create table if not exists tbl_role_authentication(
	`id` bigint(40) not null auto_increment,		/*����*/
	`user_id` bigint(40) not null,				/*�û�id*/
	`role` tinyint(1) not null,					/*��֤��ɫ*/
	`certificate_id` bigint(40),					/*��֤����id*/
	`auth_status` tinyint(1),						/*��֤״̬*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 05 tbl_certificate ��֤���ϱ�*/
create table if not exists tbl_certificate(
	`id` bigint(40) not null auto_increment,		/*����*/
	`user_id` bigint(40) not null,				/*�û�id*/
	`field` tinyint(2) not null,					/*ý������*/
	`name` varchar(20) not null,					/*��������*/
	`description` varchar(255),					/*��������*/
	`head_portrait` varchar(50),					/*����ͷ��*/
	`operate_name` varchar(20),					/*��Ӫ������*/
	`id_number` varchar(20) not null,				/*���֤��*/
	`enterprise_name` varchar(20) not null,		/*��ҵ/��������*/
	`enterprise_number` varchar(50) not null,		/*Ӫҵִ�ձ�Ż����*/
	`license_picture` varchar(50) not null,		/*Ӫҵִ����Ƭurl*/
	`internet_permit_picture` varchar(50) not null,/*�������������֤*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`modified_by` datetime,						/*�޸�ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 06 tbl_article_info������Ϣ��*/
create table if not exists tbl_article_info(
	`id` bigint(40) not null auto_increment,		/*����*/
	`title` varchar(50),							/*���±���*/
	`user_id`	bigint(40) not null,				/*���·����û�id*/
	`level` tinyint(1) not null,					/*����ȼ�*/
	`status` tinyint(2),							/*���״̬*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`modified_by`	datetime,						/*�޸�ʱ��*/
	`commited_by`	datetime,						/*�ύʱ��*/
	`published_by` datetime,						/*����ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 07 tbl_article_detail���������*/
create table if not exists tbl_article_detail(
	`id` bigint(40) not null auto_increment,		/*����*/
	`article_id` bigint(40) not null,				/*����id*/
	`title` varchar(50),							/*����*/
	`author_id` bigint(40) not null,				/*����id*/
	`abstract` varchar(255),						/*ժҪ*/
	`keywords` varchar(50),						/*�ؼ���*/
	`content`	text,								/*����*/
	`source` varchar(10),							/*������Դ*/
	`category` varchar(10),						/*һ�����*/
	`subcategory`	varchar(10),					/*�������*/
	`topic` varchar(10),							/*����*/
	`copyright` varchar(255),						/*��Ȩ��Ϣ*/
	`originality`	varchar(255),					/*ԭ������*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 08 tbl_comment ���۱�*/
create table if not exists tbl_comment(
	`id` bigint(40) not null auto_increment,		/*����*/
	`content`	varchar(255),						/*��������*/
	`author_id` bigint(40) not null,				/*����id*/
	`ip` varchar(50),								/*����ip*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`modified_by`	datetime,						/*�޸�ʱ��*/
	`is_effective` tinyint(1) default 1,			/*�Ƿ���Ч*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 09 tbl_article_comment�������۱�*/
create table if not exists tbl_article_comment(
	`id` bigint(40) not null auto_increment,		/*����*/
	`article_id` bigint(40) not null,				/*����id*/		
	`comment_id`	bigint(40) not null,			/*����id*/			
	`create_by` datetime default now(),			/*����ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 10 tbl_article_picture ������ͼ�� */
create table if not exists tbl_article_picture(
	`id` bigint(40) not null auto_increment,		/*����*/
	`title` varchar(50),							/*ͼƬ����*/
	`author_id` bigint(40),						/*����id*/
	`type` tinyint(1),							/*ͼƬ����*/
	`height` int(5),								/*�߶�*/
	`weight` int(5),								/*���*/
	`size` int(5),								/*��С*/
	`article_id` bigint(40) not null,				/*����id*/
	`save_url` varchar(50),						/*�洢��ַ*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 11 tbl_article_vedio ������Ƶ��*/
create table if not exists tbl_article_vedio(
	`id` bigint(40) not null auto_increment,		/*����*/
	`title` varchar(50),							/*ͼƬ����*/
	`author_id` bigint(40),						/*����id*/
	`article_id` bigint(40) not null,				/*����id*/
	`duration` int(10),							/*��Ƶʱ��*/
	`mime_type` tinyint(2),						/*��װ��ʽ*/
	`height` int(5),								/*�߶�*/
	`weight` int(5),								/*���*/
	`size` int(10),								/*��С*/
	`save_url` varchar(50),						/*�洢��ַ*/
	`frame_url` varchar(50),						/*�����ַ*/
	`vbit` int(10),								/*��Ƶ����*/
	`frame_rate` decimal,							/*��Ƶ֡��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 12 tbl_userinfo_review �û���Ϣ��˱�*/
create table if not exists tbl_userinfo_review(
	`id` bigint(40) not null auto_increment,		/*����*/
	`authentication_id` bigint(40) not null,		/*��֤����id*/
	`reviewer_id`	bigint(40) not null,			/*���Աid*/
	`is_feedback`	tinyint(1),						/*�Ƿ���*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 13 tbl_article_review ������˱�*/
create table if not exists tbl_article_review(
	`id` bigint(40) not null auto_increment,		/*����*/
	`article_id` bigint(40) not null,				/*����id*/
	`reviewer_id`	bigint(40) not null,			/*���Աid*/
	`is_feedback`	tinyint(1),						/*�Ƿ���*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 14 tbl_user_message �û���Ϣ֪ͨ��*/
create table if not exists tbl_user_message(
	`id` bigint(40) not null auto_increment,		/*����*/
	`user_id`	bigint(40) not null,				/*�û�id*/
	`message_type` tinyint(1),					/*��Ϣ����*/
	`message_content`	text,						/*��Ϣ����*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 15 tbl_article_collect�����ղر�*/
create table if not exists tbl_article_collect(
	`id` bigint(40) not null auto_increment,		/*����*/
	`user_id`	bigint(40) not null,				/*�û�id*/
	`article_id` bigint(40) not null,				/*����id*/
	`article_title` varchar(50),					/*���±���*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

/* 16 tbl_user_follow�û���ע��*/
create table if not exists tbl_user_follow(
	`id` bigint(40) not null auto_increment,		/*����*/
	`user_id`	bigint(40) not null,				/*�û�id*/
	`follower_id`	bigint(40) not null,			/*��ע�û�id*/
	`create_by` datetime default now(),			/*����ʱ��*/
	`idDeleted` tinyint(1) default 0,				/*ɾ����־λ*/
	primary key(id)
)engine=innodb auto_increment=1 default charset=utf8;

