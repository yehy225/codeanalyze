--Create Table
drop table if exists all_column_table;
CREATE TABLE `all_column_table` (
  `id` BIGINT(19)  NOT NULL  AUTO_INCREMENT COMMENT 'id',
  `col_tinyint` TINYINT(3)     COMMENT 'col_tinyint',
  `col_smallint` SMALLINT(5)     COMMENT 'col_smallint',
  `col_mediumint` MEDIUMINT(7)     COMMENT 'col_mediumint',
  `col_integer` INT(10)     COMMENT 'col_integer',
  `col_float` FLOAT(9,3)     COMMENT 'col_float',
  `col_double` DOUBLE(15,3)     COMMENT 'col_double',
  `col_decimal` DECIMAL(11)     COMMENT 'col_decimal',
  `col_date` DATE(10)     COMMENT 'col_date',
  `col_time` TIME(8)     COMMENT 'col_time',
  `col_year` YEAR(0)     COMMENT 'col_year',
  `col_char` CHAR(10)     COMMENT 'col_char',
  `col_varchar` VARCHAR(100)     COMMENT 'col_varchar',
  `col_tinyblob` TINYBLOB(255)     COMMENT 'col_tinyblob',
  `col_blob` BLOB(65535)     COMMENT 'col_blob',
  `col_mediumblob` MEDIUMBLOB(16777215)     COMMENT 'col_mediumblob',
  `col_longblob` LONGBLOB(2147483647)     COMMENT 'col_longblob',
  `col_tinytext` TINYTEXT(255)     COMMENT 'col_tinytext',
  `col_text` MEDIUMTEXT(16777215)     COMMENT 'col_text',
  `col_mediumtext` MEDIUMTEXT(16777215)     COMMENT 'col_mediumtext',
  `col_longtext` LONGTEXT(2147483647)     COMMENT 'col_longtext',
  `col_geometry` GEOMETRY(0)     COMMENT 'col_geometry',
  `col_binary` BINARY(1)     COMMENT 'col_binary',
  `col_varbinary` VARBINARY(1)     COMMENT 'col_varbinary',
  `gmt_create` DATETIME    COMMENT 'gmt_create',
  `gmt_modified` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP  COMMENT 'gmt_modified',
  PRIMARY KEY (`id`)  
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 11264 kB';
--Create Table
drop table if exists analyze_file;
CREATE TABLE `analyze_file` (
  `id` BIGINT(19)  NOT NULL  AUTO_INCREMENT COMMENT 'id',
  `filename` VARCHAR(200)     COMMENT 'filename',
  `linecount` INT(10)     COMMENT 'linecount',
  `codecount` INT(10)     COMMENT 'codecount',
  `commentcount` INT(10)     COMMENT 'commentcount',
  `blankcount` INT(10)     COMMENT 'blankcount',
  `gmt_create` DATETIME    COMMENT 'gmt_create',
  `gmt_modified` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP  COMMENT 'gmt_modified',
  PRIMARY KEY (`id`),  
   KEY `IDX_filename` (`filename`)  
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='analyze_file';
--Create Table
drop table if exists class_ref;
CREATE TABLE `class_ref` (
  `id` BIGINT(19)  NOT NULL  AUTO_INCREMENT COMMENT 'id',
  `class_name` VARCHAR(200)     COMMENT 'class_name',
  `ref_class` VARCHAR(200)     COMMENT 'ref_class',
  `gmt_create` DATETIME    COMMENT 'gmt_create',
  `gmt_modified` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP  COMMENT 'gmt_modified',
  PRIMARY KEY (`id`)  
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='class_ref';
--Create Table
drop table if exists package_class;
CREATE TABLE `package_class` (
  `id` BIGINT(19)  NOT NULL  AUTO_INCREMENT COMMENT 'id',
  `module_path` VARCHAR(200)     COMMENT 'module_path',
  `package_name` VARCHAR(200)     COMMENT 'package_name',
  `class_name` VARCHAR(200)     COMMENT 'class_name',
  `file_name` VARCHAR(200)     COMMENT 'file_name',
  `gmt_create` DATETIME    COMMENT 'gmt_create',
  `gmt_modified` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP  COMMENT 'gmt_modified',
  PRIMARY KEY (`id`)  
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='package_class';
--Create Table
drop table if exists sys_menu;
CREATE TABLE `sys_menu` (
  `id` BIGINT(19)  NOT NULL  AUTO_INCREMENT COMMENT 'id',
  `menucode` VARCHAR(40)  NOT NULL DEFAULT   COMMENT 'menucode',
  `menuname` VARCHAR(40)  NOT NULL DEFAULT   COMMENT 'menuname',
  `menuurl` VARCHAR(255)     COMMENT 'menuurl',
  `menulevel` TINYINT(3)     COMMENT 'menulevel',
  `isleaf` TINYINT(3)     COMMENT 'isleaf',
  `parentscode` VARCHAR(40)     COMMENT 'parentscode',
  `rootcode` VARCHAR(40)     COMMENT 'rootcode',
  `displayorder` CHAR(10)     COMMENT 'displayorder',
  `status` TINYINT(3)     COMMENT 'status',
  `issys` TINYINT(3)     COMMENT 'issys',
  `gmt_create` DATETIME    COMMENT 'gmt_create',
  `gmt_modified` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP  COMMENT 'gmt_modified',
  PRIMARY KEY (`id`)  
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='sys_menu';
--Create Table
drop table if exists sys_user;
CREATE TABLE `sys_user` (
  `id` BIGINT(19)  NOT NULL  AUTO_INCREMENT COMMENT 'id',
  `username` VARCHAR(64)  NOT NULL DEFAULT   COMMENT 'username',
  `password` VARCHAR(100)     COMMENT 'password',
  `name` VARCHAR(64)     COMMENT 'name',
  `issys` TINYINT(3)     COMMENT 'issys',
  `status` TINYINT(3)     COMMENT 'status',
  `memo` VARCHAR(200)     COMMENT 'memo',
  `gmt_create` DATETIME    COMMENT 'gmt_create',
  `gmt_modified` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP  COMMENT 'gmt_modified',
  PRIMARY KEY (`id`)  
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='sys_user';
--Create Table
drop table if exists sys_user_menu;
CREATE TABLE `sys_user_menu` (
  `id` BIGINT(19)  NOT NULL  AUTO_INCREMENT COMMENT 'id',
  `userid` BIGINT(19)  NOT NULL DEFAULT   COMMENT 'userid',
  `menuid` BIGINT(19)  NOT NULL DEFAULT   COMMENT 'menuid',
  `gmt_create` DATETIME    COMMENT 'gmt_create',
  `gmt_modified` TIMESTAMP  DEFAULT CURRENT_TIMESTAMP  COMMENT 'gmt_modified',
  PRIMARY KEY (`id`),  
   KEY `fk_sum_reference_su` (`userid`),  
   KEY `fk_sum_reference_sm` (`menuid`)  
)ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='sys_user_menu';
