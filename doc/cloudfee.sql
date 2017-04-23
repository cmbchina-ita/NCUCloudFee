-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: cloudfee
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `QRTZ_BLOB_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_BLOB_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `BLOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `SCHED_NAME` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_BLOB_TRIGGERS`
--

LOCK TABLES `QRTZ_BLOB_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_BLOB_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_BLOB_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_CALENDARS`
--

DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_CALENDARS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `CALENDAR_NAME` varchar(200) NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`CALENDAR_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_CALENDARS`
--

LOCK TABLES `QRTZ_CALENDARS` WRITE;
/*!40000 ALTER TABLE `QRTZ_CALENDARS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_CALENDARS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_CRON_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_CRON_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `CRON_EXPRESSION` varchar(120) NOT NULL,
  `TIME_ZONE_ID` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_CRON_TRIGGERS`
--

LOCK TABLES `QRTZ_CRON_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_CRON_TRIGGERS` DISABLE KEYS */;
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('RenrenScheduler','TASK_1','DEFAULT','0 0/30 * * * ?','Asia/Hong_Kong'),('RenrenScheduler','TASK_2','DEFAULT','0 0/30 * * * ?','Asia/Hong_Kong');
/*!40000 ALTER TABLE `QRTZ_CRON_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_FIRED_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_FIRED_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `ENTRY_ID` varchar(95) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) NOT NULL,
  `JOB_NAME` varchar(200) DEFAULT NULL,
  `JOB_GROUP` varchar(200) DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`ENTRY_ID`),
  KEY `IDX_QRTZ_FT_TRIG_INST_NAME` (`SCHED_NAME`,`INSTANCE_NAME`),
  KEY `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY` (`SCHED_NAME`,`INSTANCE_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_FT_J_G` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_FT_T_G` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_FT_TG` (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_FIRED_TRIGGERS`
--

LOCK TABLES `QRTZ_FIRED_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_FIRED_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_FIRED_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_JOB_DETAILS`
--

DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_JOB_DETAILS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) NOT NULL,
  `IS_DURABLE` varchar(1) NOT NULL,
  `IS_NONCONCURRENT` varchar(1) NOT NULL,
  `IS_UPDATE_DATA` varchar(1) NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) NOT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_J_REQ_RECOVERY` (`SCHED_NAME`,`REQUESTS_RECOVERY`),
  KEY `IDX_QRTZ_J_GRP` (`SCHED_NAME`,`JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_JOB_DETAILS`
--

LOCK TABLES `QRTZ_JOB_DETAILS` WRITE;
/*!40000 ALTER TABLE `QRTZ_JOB_DETAILS` DISABLE KEYS */;
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('RenrenScheduler','TASK_1','DEFAULT',NULL,'io.renren.utils.ScheduleJob','0','0','0','0','�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"io.renren.entity.ScheduleJobEntity\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0testTasksr\0java.util.Datehj�KYt\0\0xpw\0\0X���0xt\00 0/30 * * * ?sr\0java.lang.Long;�\�̏#\�\0J\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0\0\0\0\0t\0testt\0renrent\0有参数测试sr\0java.lang.Integer⠤���8\0I\0valuexq\0~\0\0\0\0\0x\0'),('RenrenScheduler','TASK_2','DEFAULT',NULL,'io.renren.utils.ScheduleJob','0','0','0','0','�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYsr\0\"io.renren.entity.ScheduleJobEntity\0\0\0\0\0\0\0\0L\0beanNamet\0Ljava/lang/String;L\0\ncreateTimet\0Ljava/util/Date;L\0cronExpressionq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0\nmethodNameq\0~\0	L\0paramsq\0~\0	L\0remarkq\0~\0	L\0statust\0Ljava/lang/Integer;xpt\0testTasksr\0java.util.Datehj�KYt\0\0xpw\0\0X\�w\�`xt\00 0/30 * * * ?sr\0java.lang.Long;�\�̏#\�\0J\0valuexr\0java.lang.Number����\��\0\0xp\0\0\0\0\0\0\0t\0test2pt\0无参数测试sr\0java.lang.Integer⠤���8\0I\0valuexq\0~\0\0\0\0x\0');
/*!40000 ALTER TABLE `QRTZ_JOB_DETAILS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_LOCKS`
--

DROP TABLE IF EXISTS `QRTZ_LOCKS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_LOCKS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `LOCK_NAME` varchar(40) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`LOCK_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_LOCKS`
--

LOCK TABLES `QRTZ_LOCKS` WRITE;
/*!40000 ALTER TABLE `QRTZ_LOCKS` DISABLE KEYS */;
INSERT INTO `QRTZ_LOCKS` VALUES ('RenrenScheduler','STATE_ACCESS'),('RenrenScheduler','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `QRTZ_LOCKS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_PAUSED_TRIGGER_GRPS`
--

DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_PAUSED_TRIGGER_GRPS`
--

LOCK TABLES `QRTZ_PAUSED_TRIGGER_GRPS` WRITE;
/*!40000 ALTER TABLE `QRTZ_PAUSED_TRIGGER_GRPS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_PAUSED_TRIGGER_GRPS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_SCHEDULER_STATE`
--

DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SCHEDULER_STATE` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `INSTANCE_NAME` varchar(200) NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`INSTANCE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_SCHEDULER_STATE`
--

LOCK TABLES `QRTZ_SCHEDULER_STATE` WRITE;
/*!40000 ALTER TABLE `QRTZ_SCHEDULER_STATE` DISABLE KEYS */;
INSERT INTO `QRTZ_SCHEDULER_STATE` VALUES ('RenrenScheduler','rechen-Latitude-E72401492927981139',1492929923695,15000);
/*!40000 ALTER TABLE `QRTZ_SCHEDULER_STATE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_SIMPLE_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_SIMPLE_TRIGGERS`
--

LOCK TABLES `QRTZ_SIMPLE_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_SIMPLE_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_SIMPLE_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_SIMPROP_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `QRTZ_TRIGGERS` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_SIMPROP_TRIGGERS`
--

LOCK TABLES `QRTZ_SIMPROP_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_SIMPROP_TRIGGERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `QRTZ_SIMPROP_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QRTZ_TRIGGERS`
--

DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QRTZ_TRIGGERS` (
  `SCHED_NAME` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `JOB_NAME` varchar(200) NOT NULL,
  `JOB_GROUP` varchar(200) NOT NULL,
  `DESCRIPTION` varchar(250) DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) DEFAULT NULL,
  `PRIORITY` int(11) DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) NOT NULL,
  `TRIGGER_TYPE` varchar(8) NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) DEFAULT NULL,
  `JOB_DATA` blob,
  PRIMARY KEY (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_J` (`SCHED_NAME`,`JOB_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_JG` (`SCHED_NAME`,`JOB_GROUP`),
  KEY `IDX_QRTZ_T_C` (`SCHED_NAME`,`CALENDAR_NAME`),
  KEY `IDX_QRTZ_T_G` (`SCHED_NAME`,`TRIGGER_GROUP`),
  KEY `IDX_QRTZ_T_STATE` (`SCHED_NAME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_STATE` (`SCHED_NAME`,`TRIGGER_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_N_G_STATE` (`SCHED_NAME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NEXT_FIRE_TIME` (`SCHED_NAME`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST` (`SCHED_NAME`,`TRIGGER_STATE`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_STATE`),
  KEY `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP` (`SCHED_NAME`,`MISFIRE_INSTR`,`NEXT_FIRE_TIME`,`TRIGGER_GROUP`,`TRIGGER_STATE`),
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `QRTZ_JOB_DETAILS` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QRTZ_TRIGGERS`
--

LOCK TABLES `QRTZ_TRIGGERS` WRITE;
/*!40000 ALTER TABLE `QRTZ_TRIGGERS` DISABLE KEYS */;
INSERT INTO `QRTZ_TRIGGERS` VALUES ('RenrenScheduler','TASK_1','DEFAULT','TASK_1','DEFAULT',NULL,1492930800000,1492929000000,5,'WAITING','CRON',1491192976000,0,NULL,2,'�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYt\0�{\"beanName\":\"testTask\",\"createTime\":1480605406000,\"cronExpression\":\"0 0/30 * * * ?\",\"jobId\":1,\"methodName\":\"test\",\"params\":\"renren\",\"remark\":\"有参数测试\",\"status\":0}x\0'),('RenrenScheduler','TASK_2','DEFAULT','TASK_2','DEFAULT',NULL,1491193800000,-1,5,'PAUSED','CRON',1491192976000,0,NULL,2,'�\�\0sr\0org.quartz.JobDataMap���迩�\�\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�\�\��\�](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap\�.�(v\n\�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap\��\�`\�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0\rJOB_PARAM_KEYt\0�{\"beanName\":\"testTask\",\"createTime\":1480748156000,\"cronExpression\":\"0 0/30 * * * ?\",\"jobId\":2,\"methodName\":\"test2\",\"remark\":\"无参数测试\",\"status\":1}x\0');
/*!40000 ALTER TABLE `QRTZ_TRIGGERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_account`
--

DROP TABLE IF EXISTS `ctd_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_account` (
  `ACCOUNT_ID` varchar(40) NOT NULL COMMENT '账户ID',
  `CLOUD_ID` varchar(40) DEFAULT NULL COMMENT '云提供商ID',
  `name` varchar(45) NOT NULL COMMENT '账户名称',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `OPERATE_USER_ID` varchar(40) DEFAULT NULL COMMENT '经办ID',
  `validate` varchar(1) DEFAULT NULL COMMENT '状态',
  `root_account_id` varchar(50) NOT NULL COMMENT '付款账户ID',
  `root_account_name` varchar(50) DEFAULT NULL COMMENT '付款账户名称',
  `cloud_type` int(11) DEFAULT NULL,
  `is_assume_role` tinyint(1) DEFAULT NULL,
  `last_month_invoice_size` decimal(16,6) DEFAULT NULL COMMENT '上月账单大小',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '绑定云账号时间',
  PRIMARY KEY (`ACCOUNT_ID`),
  KEY `FK_Relationship_92` (`CLOUD_ID`),
  CONSTRAINT `FK_Relationship_92` FOREIGN KEY (`CLOUD_ID`) REFERENCES `ctd_cloud_type` (`CLOUD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_account`
--

LOCK TABLES `ctd_account` WRITE;
/*!40000 ALTER TABLE `ctd_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_account_linkaccount`
--

DROP TABLE IF EXISTS `ctd_account_linkaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_account_linkaccount` (
  `account_link_id` varchar(32) NOT NULL COMMENT '关联ID',
  `pay_account_id` varchar(45) NOT NULL COMMENT '主账户ID',
  `pay_account_name` varchar(45) DEFAULT NULL COMMENT '主账户名称',
  `link_account_id` varchar(45) DEFAULT NULL COMMENT '关联账户Id',
  `link_account_name` varchar(45) DEFAULT NULL COMMENT '关联账户名称',
  `link_access_key` varchar(100) DEFAULT NULL COMMENT '关联账户AK',
  `link_secret_key` varchar(200) DEFAULT NULL COMMENT '关联账户SK',
  `reserved_status` varchar(1) DEFAULT NULL COMMENT '预留实例状态',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`account_link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='云账户与关联账户的关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_account_linkaccount`
--

LOCK TABLES `ctd_account_linkaccount` WRITE;
/*!40000 ALTER TABLE `ctd_account_linkaccount` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_account_linkaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_aws_account`
--

DROP TABLE IF EXISTS `ctd_aws_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_aws_account` (
  `ACCOUNT_ID` varchar(40) DEFAULT NULL,
  `region` varchar(45) DEFAULT NULL,
  `aws_user_id` varchar(100) DEFAULT NULL,
  `access_key_id` varchar(100) NOT NULL,
  `secret_key` varchar(200) NOT NULL,
  `bucket_name` varchar(50) DEFAULT NULL COMMENT 'Aws bucket_name',
  `aws_arn` varchar(200) DEFAULT NULL,
  KEY `FK_Relationship_43` (`ACCOUNT_ID`),
  CONSTRAINT `FK_Relationship_43` FOREIGN KEY (`ACCOUNT_ID`) REFERENCES `ctd_account` (`ACCOUNT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_aws_account`
--

LOCK TABLES `ctd_aws_account` WRITE;
/*!40000 ALTER TABLE `ctd_aws_account` DISABLE KEYS */;
INSERT INTO `ctd_aws_account` VALUES (NULL,'ef','sef','sdf','sdf','sdf','sdf');
/*!40000 ALTER TABLE `ctd_aws_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_cloud_type`
--

DROP TABLE IF EXISTS `ctd_cloud_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_cloud_type` (
  `CLOUD_ID` varchar(40) NOT NULL COMMENT '云提供商ID',
  `CLOUD_NAME` varchar(80) DEFAULT NULL COMMENT '云提供商名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `URL` varchar(200) DEFAULT NULL COMMENT '官网链接',
  `ORDERS` int(11) DEFAULT NULL COMMENT '订单状态',
  `DESCRIPTION` varchar(2000) DEFAULT NULL COMMENT '描述',
  `DATA_STATE` int(11) DEFAULT NULL COMMENT '数据状态：0-删除 1-正常',
  PRIMARY KEY (`CLOUD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_cloud_type`
--

LOCK TABLES `ctd_cloud_type` WRITE;
/*!40000 ALTER TABLE `ctd_cloud_type` DISABLE KEYS */;
INSERT INTO `ctd_cloud_type` VALUES ('1000','AWS',1,'http://www.amazonaws.cn',1,NULL,1),('2000','阿里云',1,'http://www.aliyun.com',2,NULL,1);
/*!40000 ALTER TABLE `ctd_cloud_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_cost_tag`
--

DROP TABLE IF EXISTS `ctd_cost_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_cost_tag` (
  `TAG_ID` varchar(40) NOT NULL COMMENT '标签ID',
  `PAY_ACCOUNT_ID` varchar(40) DEFAULT NULL COMMENT '付费账户ID',
  `CLOUD_ID` varchar(40) NOT NULL COMMENT '云提供商ID',
  `TAG_NAME` varchar(200) DEFAULT NULL COMMENT '标签名称',
  `TAG_VALUE` varchar(2000) DEFAULT NULL COMMENT '标签值',
  `TAG_ORDER` int(11) DEFAULT NULL COMMENT '标签顺序',
  `DATA_STATE` int(11) DEFAULT NULL COMMENT '数据状态：0-删除 1-正常',
  PRIMARY KEY (`TAG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_cost_tag`
--

LOCK TABLES `ctd_cost_tag` WRITE;
/*!40000 ALTER TABLE `ctd_cost_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_cost_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_download_invoice_log`
--

DROP TABLE IF EXISTS `ctd_download_invoice_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_download_invoice_log` (
  `LOG_ID` varchar(40) NOT NULL COMMENT '日志ID',
  `ACCOUNT_ID` varchar(32) NOT NULL COMMENT '账户ID',
  `USER_ID` varchar(40) DEFAULT '' COMMENT '用户ID',
  `REQUEST_TYPE` varchar(40) DEFAULT NULL COMMENT '请求类型',
  `syn_id` varchar(32) NOT NULL COMMENT '同步ID',
  `SYNC_MONTH` varchar(10) DEFAULT NULL COMMENT '同步月份',
  `REQUEST_CONTENT` varchar(2000) DEFAULT NULL COMMENT '请求内容',
  `DEAL_FLAG` int(11) DEFAULT NULL COMMENT '处理标志',
  `SYNC_TIME` timestamp NULL DEFAULT NULL COMMENT '同步时间',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_download_invoice_log`
--

LOCK TABLES `ctd_download_invoice_log` WRITE;
/*!40000 ALTER TABLE `ctd_download_invoice_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_download_invoice_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_invoice_account_desc`
--

DROP TABLE IF EXISTS `ctd_invoice_account_desc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_invoice_account_desc` (
  `invoice_account_id` varchar(32) NOT NULL COMMENT '发票账户ID',
  `aws_account_id` varchar(45) NOT NULL COMMENT 'AWS账户ID',
  `aws_account_name` varchar(45) DEFAULT NULL COMMENT 'AWS账户名称',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `total_cost` decimal(16,6) DEFAULT NULL COMMENT '总花费',
  `payer_account_id` varchar(40) DEFAULT NULL COMMENT '付费主账户ID',
  `month` varchar(40) DEFAULT NULL COMMENT '出账月份',
  `support_cost` decimal(16,6) DEFAULT NULL COMMENT '支持费用',
  PRIMARY KEY (`invoice_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_invoice_account_desc`
--

LOCK TABLES `ctd_invoice_account_desc` WRITE;
/*!40000 ALTER TABLE `ctd_invoice_account_desc` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_invoice_account_desc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_invoice_detail`
--

DROP TABLE IF EXISTS `ctd_invoice_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_invoice_detail` (
  `invoice_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '出账ID',
  `payer_account_id` varchar(12) DEFAULT NULL COMMENT '主账户ID',
  `linked_account_id` varchar(12) DEFAULT NULL COMMENT '链接账户ID',
  `record_type` varchar(20) DEFAULT NULL COMMENT '记录类型',
  `invoice_day` int(11) DEFAULT NULL COMMENT '出账日期',
  `subscription_id` varchar(45) DEFAULT NULL COMMENT '订阅ID',
  `product_name` varchar(40) DEFAULT NULL COMMENT '产品名称',
  `usage_type` varchar(45) DEFAULT NULL COMMENT '使用类型',
  `operation` varchar(40) DEFAULT NULL COMMENT '操作',
  `reserved_instance` varchar(1) DEFAULT NULL COMMENT '预留标志',
  `item_description` varchar(250) DEFAULT NULL COMMENT '栏目名称',
  `tag_name` varchar(300) DEFAULT NULL COMMENT '标签名称',
  `tag_value` varchar(300) DEFAULT NULL COMMENT '标签值',
  `tax_amount` float DEFAULT NULL COMMENT '税额',
  `total_cost` float DEFAULT NULL COMMENT '总金额',
  `resource_id` varchar(255) DEFAULT NULL COMMENT '资源ID',
  `usage_quantity` float DEFAULT NULL COMMENT '使用量',
  `update_time` date DEFAULT NULL COMMENT '修改时间',
  `AZ` varchar(40) DEFAULT NULL COMMENT '可用区',
  `platform` varchar(80) DEFAULT NULL COMMENT '平台',
  `ri_id` varchar(80) DEFAULT NULL COMMENT '预留实例ID',
  PRIMARY KEY (`invoice_id`),
  KEY `invoice_detail_index` (`payer_account_id`,`invoice_day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_invoice_detail`
--

LOCK TABLES `ctd_invoice_detail` WRITE;
/*!40000 ALTER TABLE `ctd_invoice_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_invoice_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_invoice_detail_adjust_filter`
--

DROP TABLE IF EXISTS `ctd_invoice_detail_adjust_filter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_invoice_detail_adjust_filter` (
  `adjust_id` varchar(32) NOT NULL COMMENT '调账iD',
  `user_id` varchar(45) NOT NULL COMMENT '用户ID',
  `account_id` varchar(45) NOT NULL COMMENT '账户ID',
  `bucket_name` varchar(255) DEFAULT NULL COMMENT 'Bucket桶名',
  `payer_account_id` varchar(45) DEFAULT NULL COMMENT '主账户ID',
  `invoice_month` int(11) DEFAULT NULL COMMENT '账单月份',
  `adjust_resource_id` varchar(200) DEFAULT NULL COMMENT '调账资源ID',
  `adjust_resource_type` varchar(45) DEFAULT NULL COMMENT '调账资源类型',
  `adjust_start_time` varchar(30) DEFAULT NULL COMMENT '调账起始时间',
  `adjust_end_time` varchar(30) DEFAULT NULL COMMENT '调账结束时间',
  `adjust_tag` varchar(50) DEFAULT NULL COMMENT '调账标签',
  `adjust_resvered` varchar(45) DEFAULT NULL COMMENT '调账预留',
  `adjust_exchange_id` varchar(50) DEFAULT NULL,
  `adjust_money` varchar(50) DEFAULT NULL COMMENT '调账金额',
  `adjust_time` varchar(30) DEFAULT NULL COMMENT '调账时间',
  PRIMARY KEY (`adjust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_invoice_detail_adjust_filter`
--

LOCK TABLES `ctd_invoice_detail_adjust_filter` WRITE;
/*!40000 ALTER TABLE `ctd_invoice_detail_adjust_filter` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_invoice_detail_adjust_filter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_invoice_detail_adjust_log`
--

DROP TABLE IF EXISTS `ctd_invoice_detail_adjust_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_invoice_detail_adjust_log` (
  `adjust_log_id` varchar(32) NOT NULL,
  `user_id` varchar(45) NOT NULL COMMENT '用户ID',
  `account_id` varchar(45) NOT NULL COMMENT '账户ID',
  `bucket_name` varchar(255) DEFAULT NULL COMMENT '账单存储桶S3的Bucket名称',
  `payer_account_id` varchar(45) DEFAULT NULL COMMENT '当月开始时间',
  `invoice_month` int(11) DEFAULT NULL COMMENT '账单月份',
  `adjust_resource_id` varchar(200) DEFAULT NULL,
  `adjust_resource_type` varchar(45) DEFAULT NULL,
  `adjust_start_time` varchar(30) DEFAULT NULL,
  `adjust_end_time` varchar(30) DEFAULT NULL,
  `adjust_tag` varchar(50) DEFAULT NULL,
  `adjust_resvered` varchar(45) DEFAULT NULL,
  `adjust_exchange_id` varchar(50) DEFAULT NULL,
  `adjust_money` varchar(50) DEFAULT NULL,
  `adjust_time` varchar(30) DEFAULT NULL,
  `adjust_result_id` varchar(45) DEFAULT NULL,
  `adjust_remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`adjust_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_invoice_detail_adjust_log`
--

LOCK TABLES `ctd_invoice_detail_adjust_log` WRITE;
/*!40000 ALTER TABLE `ctd_invoice_detail_adjust_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_invoice_detail_adjust_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_invoice_detail_adjust_reserved`
--

DROP TABLE IF EXISTS `ctd_invoice_detail_adjust_reserved`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_invoice_detail_adjust_reserved` (
  `adjust_id` varchar(32) NOT NULL,
  `user_id` varchar(45) NOT NULL COMMENT '用户ID',
  `account_id` varchar(45) NOT NULL COMMENT '账户ID',
  `bucket_name` varchar(255) DEFAULT NULL COMMENT '账单存储桶S3的Bucket名称',
  `payer_account_id` varchar(45) DEFAULT NULL COMMENT '当月开始时间',
  `invoice_month` int(11) DEFAULT NULL COMMENT '账单月份',
  `adjust_reserved_instance_id` varchar(200) DEFAULT NULL,
  `adjust_tag` varchar(50) DEFAULT NULL,
  `adjust_time` varchar(30) DEFAULT NULL,
  `product_type` varchar(45) DEFAULT NULL,
  `instance_region` varchar(45) DEFAULT NULL,
  `availability_zone` varchar(50) DEFAULT NULL,
  `instance_type` varchar(50) DEFAULT NULL,
  `plantform_type` varchar(50) DEFAULT NULL,
  `start_time` varchar(50) DEFAULT NULL,
  `duration_year` varchar(50) DEFAULT NULL,
  `offering_price` varchar(50) DEFAULT NULL,
  `recharge_price` varchar(50) DEFAULT NULL,
  `offering_type` varchar(50) DEFAULT NULL,
  `instance_count` varchar(50) DEFAULT NULL,
  `end_time` varchar(50) DEFAULT NULL,
  `is_mutizone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`adjust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_invoice_detail_adjust_reserved`
--

LOCK TABLES `ctd_invoice_detail_adjust_reserved` WRITE;
/*!40000 ALTER TABLE `ctd_invoice_detail_adjust_reserved` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_invoice_detail_adjust_reserved` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_invoice_detail_adjust_result`
--

DROP TABLE IF EXISTS `ctd_invoice_detail_adjust_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_invoice_detail_adjust_result` (
  `adjust_id` varchar(32) NOT NULL,
  `user_id` varchar(45) NOT NULL COMMENT '用户ID',
  `account_id` varchar(45) NOT NULL COMMENT '账户ID',
  `bucket_name` varchar(255) DEFAULT NULL COMMENT '账单存储桶S3的Bucket名称',
  `payer_account_id` varchar(45) DEFAULT NULL COMMENT '当月开始时间',
  `invoice_month` int(11) DEFAULT NULL COMMENT '账单月份',
  `adjust_result` text,
  `adjust_time` varchar(30) DEFAULT NULL,
  `adjust_title` varchar(50) DEFAULT NULL,
  `bill_time` varchar(30) DEFAULT NULL,
  `tag_name` varchar(40) DEFAULT NULL COMMENT '调账维度',
  PRIMARY KEY (`adjust_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_invoice_detail_adjust_result`
--

LOCK TABLES `ctd_invoice_detail_adjust_result` WRITE;
/*!40000 ALTER TABLE `ctd_invoice_detail_adjust_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_invoice_detail_adjust_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_invoice_detail_desc`
--

DROP TABLE IF EXISTS `ctd_invoice_detail_desc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_invoice_detail_desc` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `payer_account_id` varchar(45) NOT NULL COMMENT '主账户ID',
  `month` int(11) NOT NULL COMMENT '月份',
  `sync_time` varchar(60) DEFAULT NULL COMMENT '同步时间',
  `tag_title` varchar(50) DEFAULT '3' COMMENT '标签头',
  `tag_column` varchar(50) DEFAULT NULL COMMENT '标签列',
  `bill_time` varchar(30) DEFAULT NULL COMMENT '账单时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_invoice_detail_desc`
--

LOCK TABLES `ctd_invoice_detail_desc` WRITE;
/*!40000 ALTER TABLE `ctd_invoice_detail_desc` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_invoice_detail_desc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_invoice_detail_reserved`
--

DROP TABLE IF EXISTS `ctd_invoice_detail_reserved`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_invoice_detail_reserved` (
  `reserved_desc_id` varchar(45) NOT NULL,
  `payer_account_id` varchar(45) NOT NULL COMMENT '主账户ID',
  `invoice_month` int(11) NOT NULL COMMENT '账单月份',
  `reserved_instance_id` varchar(45) DEFAULT NULL,
  `product_type` varchar(45) DEFAULT NULL COMMENT '产品类型',
  `instance_region` varchar(45) DEFAULT NULL COMMENT '所属区域',
  `availability_zone` varchar(50) DEFAULT NULL COMMENT '可用区',
  `instance_type` varchar(50) DEFAULT NULL COMMENT '实例类型',
  `plantform_type` varchar(50) DEFAULT NULL COMMENT '平台类型',
  `start_time` varchar(50) DEFAULT NULL COMMENT '开始时间',
  `duration_year` varchar(50) DEFAULT NULL COMMENT '预留年份',
  `offering_price` varchar(50) DEFAULT NULL COMMENT '优惠价格',
  `recharge_price` varchar(50) DEFAULT NULL COMMENT '续价',
  `offering_type` varchar(50) DEFAULT NULL COMMENT '优惠类型',
  `instance_count` varchar(50) DEFAULT NULL,
  `end_time` varchar(50) DEFAULT NULL COMMENT '结束时间',
  `is_mutizone` varchar(10) DEFAULT NULL COMMENT '多区标志',
  PRIMARY KEY (`reserved_desc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账单数据基本控件表，根据用户，用户绑定的账户，BucketName，时间区间展现不同的数据集合';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_invoice_detail_reserved`
--

LOCK TABLES `ctd_invoice_detail_reserved` WRITE;
/*!40000 ALTER TABLE `ctd_invoice_detail_reserved` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_invoice_detail_reserved` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_month_cost_stat`
--

DROP TABLE IF EXISTS `ctd_month_cost_stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_month_cost_stat` (
  `STAT_ID` varchar(40) NOT NULL COMMENT '月总花费统计ID',
  `PAY_ACCOUNT_ID` varchar(40) DEFAULT NULL COMMENT '付费账户ID',
  `CLOUD_ID` varchar(40) NOT NULL COMMENT '云提供商ID',
  `STAT_MONTH` varchar(10) DEFAULT NULL COMMENT '精确到月份',
  `THIS_MONTH_COST` decimal(16,6) DEFAULT NULL COMMENT '本月实际花费',
  `THIS_MONTH_EXPECT_COST` decimal(16,6) DEFAULT NULL COMMENT '本月预计花费',
  `LAST_MONTH_COST` decimal(16,6) DEFAULT NULL COMMENT '上月总花费',
  `AVERAGE_COST_3` decimal(16,6) DEFAULT NULL COMMENT '前三月月均花费',
  `DATA_STATE` int(11) DEFAULT NULL COMMENT '数据状态：0-删除 1-正常',
  `LINKED_ACCOUNT_ID` varchar(40) DEFAULT NULL COMMENT '关联账户ID',
  `MONTH_DEDUCTED_COST` decimal(16,6) DEFAULT NULL COMMENT '抵扣花费',
  PRIMARY KEY (`STAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_month_cost_stat`
--

LOCK TABLES `ctd_month_cost_stat` WRITE;
/*!40000 ALTER TABLE `ctd_month_cost_stat` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_month_cost_stat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_service_def`
--

DROP TABLE IF EXISTS `ctd_service_def`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_service_def` (
  `SERVICE_ID` varchar(40) NOT NULL COMMENT '服务ID',
  `CLOUD_ID` varchar(40) DEFAULT NULL COMMENT '云提供商ID',
  `SERVICE_NAME` varchar(80) DEFAULT NULL COMMENT '服务名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `PRICE_INTRO_URL` varchar(200) DEFAULT NULL COMMENT '定价单链接',
  `ORDERS` int(11) DEFAULT NULL COMMENT '订单额',
  `DESCRIPTION` varchar(2000) DEFAULT NULL COMMENT '描述',
  `DATA_STATE` int(11) DEFAULT NULL COMMENT '数据状态',
  `SERVICE_CODE` varchar(40) DEFAULT NULL COMMENT '服务编码',
  PRIMARY KEY (`SERVICE_ID`),
  KEY `FK_Relationship_1` (`CLOUD_ID`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`CLOUD_ID`) REFERENCES `ctd_cloud_type` (`CLOUD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_service_def`
--

LOCK TABLES `ctd_service_def` WRITE;
/*!40000 ALTER TABLE `ctd_service_def` DISABLE KEYS */;
INSERT INTO `ctd_service_def` VALUES ('1001','1000','EC2(服务器实例)',1,'http://aws.amazon.com/cn/ec2/pricing/',1,NULL,1,'Amazon Elastic Compute Cloud'),('1002','1000','EBS(存储)',1,'http://aws.amazon.com/cn/ebs/pricing/',2,NULL,0,NULL),('1003','1000','S3(存储)',1,'http://aws.amazon.com/cn/s3/pricing/',3,NULL,1,'Amazon Simple Storage Service'),('1004','1000','RDS(关系型数据库)',1,'http://aws.amazon.com/cn/rds/pricing/',4,NULL,1,'Amazon RDS Service'),('1007','1000','弹性IP',1,'http://aws.amazon.com/cn/ec2/pricing/',7,NULL,0,NULL),('1008','1000','负载均衡',1,'http://aws.amazon.com/cn/ec2/pricing/',8,'elb',0,NULL),('1009','1000','CloudFront',1,NULL,9,NULL,1,'Amazon CloudFront'),('1010','1000','Route 53',1,NULL,10,NULL,1,'Amazon Route 53'),('1011','1000','WAF',1,NULL,11,NULL,1,'AWS WAF'),('1012','1000','Data Pipeline',1,NULL,12,NULL,1,'AWS Data Pipeline'),('1013','1000','DynamoDB',1,NULL,13,NULL,1,'Amazon DynamoDB'),('1014','1000','Redshift',1,NULL,14,NULL,1,'Amazon Redshift'),('1015','1000','Simple Queue Service',1,NULL,15,NULL,1,'Amazon Simple Queue Service'),('1016','1000','Key Management Service',1,NULL,16,NULL,1,'AWS Key Management Service'),('1017','1000','Simple Notification Service',1,NULL,17,NULL,1,'Amazon Simple Notification Service'),('1018','1000','ElastiCache',1,NULL,18,NULL,1,'Amazon ElasticCache'),('2001','2000','ECS(服务器实例)',1,'http://help.aliyun.com/document_detail/ecs/shopping-guide/buy-instance/price.html',1,NULL,1,NULL),('2002','2000','磁盘',1,'http://help.aliyun.com/document_detail/ecs/shopping-guide/buy-disk/price.html',2,NULL,1,NULL),('2003','2000','OSS(存储)',1,'http://help.aliyun.com/knowledge_detail/5974488.html',3,NULL,1,NULL),('2004','2000','网络',1,'http://help.aliyun.com/document_detail/ecs/shopping-guide/buy-network/price.html',4,'aliyun\'s networking, 网络',1,NULL),('2005','2000','RDS(关系型数据库)',1,'http://help.aliyun.com/knowledge_detail/5975111.html',5,NULL,1,NULL),('2006','2000','CDN(内容分发网络)',1,'http://help.aliyun.com/knowledge_detail/5975217.html',6,NULL,1,NULL),('2007','2000','OCS(在线缓存服务)',1,'http://help.aliyun.com/knowledge_detail/5974155.html',7,NULL,1,NULL);
/*!40000 ALTER TABLE `ctd_service_def` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctd_tag_day_cost_stat`
--

DROP TABLE IF EXISTS `ctd_tag_day_cost_stat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ctd_tag_day_cost_stat` (
  `STAT_ID` varchar(40) NOT NULL COMMENT '标签统计ID',
  `PAY_ACCOUNT_ID` varchar(40) DEFAULT NULL COMMENT '付费账户ID',
  `CLOUD_ID` varchar(40) NOT NULL COMMENT '云提供商ID',
  `STAT_DATE` varchar(10) DEFAULT NULL COMMENT '统计日期，精确到日',
  `TAG_NAME` varchar(80) DEFAULT NULL COMMENT '标签名称',
  `TAG_VALUE` varchar(80) DEFAULT NULL COMMENT '标签值',
  `DAY_COST` decimal(16,6) DEFAULT NULL COMMENT '日花费',
  `DATA_STATE` int(11) DEFAULT NULL COMMENT '数据状态',
  `LINKED_ACCOUNT_ID` varchar(40) DEFAULT NULL COMMENT '关联账户ID',
  PRIMARY KEY (`STAT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctd_tag_day_cost_stat`
--

LOCK TABLES `ctd_tag_day_cost_stat` WRITE;
/*!40000 ALTER TABLE `ctd_tag_day_cost_stat` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctd_tag_day_cost_stat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_job`
--

DROP TABLE IF EXISTS `schedule_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `cron_expression` varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  `status` tinyint(4) DEFAULT NULL COMMENT '任务状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='定时任务';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_job`
--

LOCK TABLES `schedule_job` WRITE;
/*!40000 ALTER TABLE `schedule_job` DISABLE KEYS */;
INSERT INTO `schedule_job` VALUES (1,'testTask','test','renren','0 0/30 * * * ?',0,'有参数测试','2016-12-01 23:16:46'),(2,'testTask','test2',NULL,'0 0/30 * * * ?',1,'无参数测试','2016-12-03 14:55:56');
/*!40000 ALTER TABLE `schedule_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_job_log`
--

DROP TABLE IF EXISTS `schedule_job_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_job_log` (
  `log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志id',
  `job_id` bigint(20) NOT NULL COMMENT '任务id',
  `bean_name` varchar(200) DEFAULT NULL COMMENT 'spring bean名称',
  `method_name` varchar(100) DEFAULT NULL COMMENT '方法名',
  `params` varchar(2000) DEFAULT NULL COMMENT '参数',
  `status` tinyint(4) NOT NULL COMMENT '任务状态    0：成功    1：失败',
  `error` varchar(2000) DEFAULT NULL COMMENT '失败信息',
  `times` int(11) NOT NULL COMMENT '耗时(单位：毫秒)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`log_id`),
  KEY `job_id` (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='定时任务日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_job_log`
--

LOCK TABLES `schedule_job_log` WRITE;
/*!40000 ALTER TABLE `schedule_job_log` DISABLE KEYS */;
INSERT INTO `schedule_job_log` VALUES (1,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',3,'2017-04-03 12:30:00'),(2,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',2,'2017-04-04 18:00:00'),(3,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',1,'2017-04-04 18:30:00'),(4,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',0,'2017-04-04 19:00:00'),(5,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',0,'2017-04-04 19:30:00'),(6,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',0,'2017-04-04 20:00:00'),(7,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',1,'2017-04-04 20:30:00'),(8,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',2,'2017-04-04 21:00:00'),(9,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',7,'2017-04-08 12:00:00'),(10,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',2,'2017-04-08 12:30:00'),(11,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',2,'2017-04-08 13:00:00'),(12,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',2,'2017-04-08 13:30:00'),(13,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',1,'2017-04-08 14:00:00'),(14,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',0,'2017-04-08 14:30:00'),(15,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',3,'2017-04-08 15:00:00'),(16,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',2,'2017-04-08 15:30:00'),(17,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',4,'2017-04-08 17:00:00'),(18,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',3,'2017-04-08 17:30:00'),(19,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',7,'2017-04-08 18:30:00'),(20,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',1,'2017-04-08 19:00:00'),(21,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',1,'2017-04-08 19:30:00'),(22,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',0,'2017-04-08 20:00:00'),(23,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',2,'2017-04-08 20:30:00'),(24,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',2,'2017-04-08 21:00:00'),(25,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',5,'2017-04-16 09:00:00'),(26,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',4,'2017-04-16 09:30:00'),(27,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',1,'2017-04-16 10:00:00'),(28,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',1,'2017-04-16 10:30:00'),(29,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',1,'2017-04-16 11:00:00'),(30,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',3,'2017-04-16 11:30:00'),(31,1,'testTask','test','renren',0,NULL,1078,'2017-04-16 20:00:00'),(32,1,'testTask','test','renren',1,'org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named \'testTask\' available',3,'2017-04-16 21:00:00'),(33,1,'testTask','test','renren',0,NULL,1015,'2017-04-22 08:00:00'),(34,1,'testTask','test','renren',0,NULL,1002,'2017-04-22 22:30:00'),(35,1,'testTask','test','renren',0,NULL,1025,'2017-04-23 09:00:00'),(36,1,'testTask','test','renren',0,NULL,1020,'2017-04-23 10:00:00'),(37,1,'testTask','test','renren',0,NULL,1012,'2017-04-23 10:30:00'),(38,1,'testTask','test','renren',0,NULL,1015,'2017-04-23 11:00:00'),(39,1,'testTask','test','renren',0,NULL,1029,'2017-04-23 13:00:00'),(40,1,'testTask','test','renren',0,NULL,1010,'2017-04-23 13:30:00'),(41,1,'testTask','test','renren',0,NULL,1011,'2017-04-23 14:30:00');
/*!40000 ALTER TABLE `schedule_job_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(2000) DEFAULT NULL COMMENT 'value',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态   0：隐藏   1：显示',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统配置信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'CLOUD_STORAGE_CONFIG_KEY','{\"aliyunAccessKeyId\":\"\",\"aliyunAccessKeySecret\":\"\",\"aliyunBucketName\":\"\",\"aliyunDomain\":\"\",\"aliyunEndPoint\":\"\",\"aliyunPrefix\":\"\",\"qcloudBucketName\":\"\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudSecretKey\":\"\",\"qiniuAccessKey\":\"NrgMfABZxWLo5B-YYSjoE8-AZ1EISdi1Z3ubLOeZ\",\"qiniuBucketName\":\"ios-app\",\"qiniuDomain\":\"http://7xqbwh.dl1.z0.glb.clouddn.com\",\"qiniuPrefix\":\"upload\",\"qiniuSecretKey\":\"uIwJHevMRWU0VLxFvgy0tAcOdGqasdtVlJkdy6vV\",\"type\":1}',0,'云存储配置信息');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8 COMMENT='系统日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (1,'admin','保存用户','io.renren.controller.SysUserController.save()','{\"email\":\"rechen@qq.com\",\"mobile\":\"18938961900\",\"roleIdList\":[],\"status\":1,\"username\":\"rechen\"}','127.0.0.1','2017-04-03 12:20:16'),(2,'admin','保存角色','io.renren.controller.SysRoleController.save()','{\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28],\"roleName\":\"平台管理员\"}','127.0.0.1','2017-04-03 12:20:48'),(3,'admin','修改用户','io.renren.controller.SysUserController.update()','{\"createTime\":1491193216000,\"createUserId\":1,\"email\":\"rechen@qq.com\",\"mobile\":\"18938961900\",\"roleIdList\":[1],\"status\":1,\"userId\":2,\"username\":\"rechen\"}','127.0.0.1','2017-04-03 12:20:56'),(4,'admin','生成代码','io.renren.controller.SysGeneratorController.code()','\"[&quot;ctd_cloud_type&quot;]\"','127.0.0.1','2017-04-04 17:30:24'),(5,'admin','生成代码','io.renren.controller.SysGeneratorController.code()','\"[&quot;ctd_account&quot;]\"','127.0.0.1','2017-04-04 17:31:04'),(6,'admin','保存菜单','io.renren.controller.SysMenuController.save()','{\"name\":\"AWS云费用\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','127.0.0.1','2017-04-04 17:38:05'),(7,'admin','修改用户','io.renren.controller.SysUserController.update()','{\"createTime\":1478833871000,\"email\":\"root@renren.io\",\"mobile\":\"13612345678\",\"roleIdList\":[1],\"status\":1,\"userId\":1,\"username\":\"admin\"}','127.0.0.1','2017-04-04 17:38:25'),(8,'admin','修改角色','io.renren.controller.SysRoleController.update()','{\"createTime\":1491193248000,\"createUserId\":1,\"menuIdList\":[1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28,31],\"roleId\":1,\"roleName\":\"平台管理员\"}','127.0.0.1','2017-04-04 17:38:34'),(9,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-cog\",\"menuId\":1,\"name\":\"系统管理\",\"orderNum\":1,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','127.0.0.1','2017-04-04 17:39:21'),(10,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"menuId\":31,\"name\":\"后台参数\",\"orderNum\":0,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','127.0.0.1','2017-04-08 14:59:59'),(11,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":32,\"name\":\"云供应商\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"adm/cloudtype.html\"}','127.0.0.1','2017-04-08 16:36:51'),(12,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":32,\"name\":\"云供应商\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"admin/cloudtype.html\"}','127.0.0.1','2017-04-08 18:28:20'),(13,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":32,\"name\":\"云供应商\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"adm/cloudtype.html\"}','127.0.0.1','2017-04-09 08:06:01'),(14,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":32,\"name\":\"云供应商\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"sys/cloudtype.html\"}','127.0.0.1','2017-04-09 08:16:49'),(15,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":32,\"name\":\"云供应商\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"adm/cloudtype.html\"}','127.0.0.1','2017-04-09 08:41:24'),(16,'admin','删除菜单','io.renren.controller.SysMenuController.delete()','[38]','127.0.0.1','2017-04-09 09:02:37'),(17,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":37,\"name\":\"云服务清单\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"adm/servicedef.html\"}','127.0.0.1','2017-04-09 09:02:54'),(18,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":32,\"name\":\"云供应商\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"generator/cloudtype.html\"}','127.0.0.1','2017-04-15 21:46:09'),(19,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":37,\"name\":\"云服务清单\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"generator/servicedef.html\"}','127.0.0.1','2017-04-15 21:46:22'),(20,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":32,\"name\":\"云供应商\",\"orderNum\":2,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"generator/cloudtype.html\"}','127.0.0.1','2017-04-16 17:14:13'),(21,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":43,\"name\":\"云账户\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"generator/account.html\"}','127.0.0.1','2017-04-16 20:56:38'),(22,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":48,\"name\":\"云账户-AWS\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"generator/awsaccount.html\"}','127.0.0.1','2017-04-16 20:57:06'),(23,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":53,\"name\":\"云账户-关联账户关系\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"generator/accountlinkaccount.html\"}','127.0.0.1','2017-04-16 20:57:26'),(24,'admin','保存菜单','io.renren.controller.SysMenuController.save()','{\"name\":\"账单管理\",\"orderNum\":1,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','127.0.0.1','2017-04-16 20:58:02'),(25,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-cog\",\"menuId\":1,\"name\":\"系统管理\",\"orderNum\":9,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','127.0.0.1','2017-04-16 20:58:30'),(26,'admin','保存菜单','io.renren.controller.SysMenuController.save()','{\"name\":\"成本分析\",\"orderNum\":2,\"parentId\":0,\"parentName\":\"一级菜单\",\"type\":0}','127.0.0.1','2017-04-16 20:59:22'),(27,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":58,\"name\":\"标签\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/costtag.html\"}','127.0.0.1','2017-04-16 20:59:58'),(28,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":58,\"name\":\"成本标签\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/costtag.html\"}','127.0.0.1','2017-04-16 21:00:15'),(29,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":63,\"name\":\"下载日志\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/downloadinvoicelog.html\"}','127.0.0.1','2017-04-16 21:00:37'),(30,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":68,\"name\":\"账单详情\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoicedetail.html\"}','127.0.0.1','2017-04-16 21:01:14'),(31,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":73,\"name\":\"调账日志\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoicedetailadjustlog.html\"}','127.0.0.1','2017-04-16 21:01:49'),(32,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":78,\"name\":\"调账数据\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoicedetailadjustfilter.html\"}','127.0.0.1','2017-04-16 21:02:22'),(33,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":83,\"name\":\"月账单\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoiceaccountdesc.html\"}','127.0.0.1','2017-04-16 21:02:49'),(34,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":88,\"name\":\"标签日统计\",\"orderNum\":6,\"parentId\":119,\"parentName\":\"成本分析\",\"type\":1,\"url\":\"generator/tagdaycoststat.html\"}','127.0.0.1','2017-04-16 21:03:32'),(35,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":93,\"name\":\"按月统计\",\"orderNum\":6,\"parentId\":119,\"parentName\":\"成本分析\",\"type\":1,\"url\":\"generator/monthcoststat.html\"}','127.0.0.1','2017-04-16 21:03:58'),(36,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":98,\"name\":\"账单预留详情\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoicedetailreserved.html\"}','127.0.0.1','2017-04-16 21:05:07'),(37,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":83,\"name\":\"账户月账单\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoiceaccountdesc.html\"}','127.0.0.1','2017-04-16 21:05:35'),(38,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":103,\"name\":\"账单详情\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoicedetaildesc.html\"}','127.0.0.1','2017-04-16 21:05:54'),(39,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":108,\"name\":\"账单调账结果\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoicedetailadjustresult.html\"}','127.0.0.1','2017-04-16 21:06:15'),(40,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":113,\"name\":\"账单预留调账数据\",\"orderNum\":6,\"parentId\":1,\"parentName\":\"系统管理\",\"type\":1,\"url\":\"generator/invoicedetailadjustreserved.html\"}','127.0.0.1','2017-04-16 21:07:35'),(41,'admin','修改菜单','io.renren.controller.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":113,\"name\":\"账单预留调账数据\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"generator/invoicedetailadjustreserved.html\"}','127.0.0.1','2017-04-16 21:07:42'),(42,'admin','修改角色','io.renren.admin.SysRoleController.update()','{\"createTime\":1491193248000,\"createUserId\":1,\"menuIdList\":[31,32,33,34,35,36,37,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,118,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,119,88,89,90,91,92,93,94,95,96,97,1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28],\"roleId\":1,\"roleName\":\"平台管理员\"}','127.0.0.1','2017-04-23 09:02:39'),(43,'admin','修改用户','io.renren.admin.SysUserController.update()','{\"createTime\":1478833871000,\"email\":\"root@renren.io\",\"mobile\":\"13612345678\",\"roleIdList\":[1],\"status\":1,\"userId\":1,\"username\":\"admin\"}','127.0.0.1','2017-04-23 09:03:08'),(44,'admin','修改用户','io.renren.admin.SysUserController.update()','{\"createTime\":1491193216000,\"createUserId\":1,\"email\":\"rechen@qq.com\",\"mobile\":\"18938961900\",\"roleIdList\":[1],\"status\":1,\"userId\":2,\"username\":\"rechen\"}','127.0.0.1','2017-04-23 09:03:12'),(45,'admin','修改角色','io.renren.admin.SysRoleController.update()','{\"createTime\":1491193248000,\"createUserId\":1,\"menuIdList\":[31,32,33,34,35,36,37,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,118,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,119,88,89,90,91,92,93,94,95,96,97,1,2,15,16,17,18,3,19,20,21,22,4,23,24,25,26,5,6,7,8,9,10,11,12,13,14,27,30,29,28],\"roleId\":1,\"roleName\":\"平台管理员\"}','127.0.0.1','2017-04-23 09:03:25'),(46,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":37,\"name\":\"云服务清单\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"ncu/servicedef.html\"}','127.0.0.1','2017-04-23 10:54:32'),(47,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":32,\"name\":\"云供应商\",\"orderNum\":2,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"ncu/cloudtype.html\"}','127.0.0.1','2017-04-23 14:13:45'),(48,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":43,\"name\":\"云账户\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"ncu/account.html\"}','127.0.0.1','2017-04-23 14:14:04'),(49,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":48,\"name\":\"云账户-AWS\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"ncu/awsaccount.html\"}','127.0.0.1','2017-04-23 14:14:16'),(50,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":53,\"name\":\"云账户-关联账户关系\",\"orderNum\":6,\"parentId\":31,\"parentName\":\"后台参数\",\"type\":1,\"url\":\"ncu/accountlinkaccount.html\"}','127.0.0.1','2017-04-23 14:14:27'),(51,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":58,\"name\":\"成本标签\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/costtag.html\"}','127.0.0.1','2017-04-23 14:14:36'),(52,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":63,\"name\":\"下载日志\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/downloadinvoicelog.html\"}','127.0.0.1','2017-04-23 14:14:54'),(53,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":68,\"name\":\"账单详情\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/invoicedetail.html\"}','127.0.0.1','2017-04-23 14:15:04'),(54,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":73,\"name\":\"调账日志\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/invoicedetailadjustlog.html\"}','127.0.0.1','2017-04-23 14:15:17'),(55,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":78,\"name\":\"调账数据\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/invoicedetailadjustfilter.html\"}','127.0.0.1','2017-04-23 14:15:26'),(56,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":83,\"name\":\"账户月账单\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/invoiceaccountdesc.html\"}','127.0.0.1','2017-04-23 14:15:38'),(57,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":88,\"name\":\"标签日统计\",\"orderNum\":6,\"parentId\":119,\"parentName\":\"成本分析\",\"type\":1,\"url\":\"ncu/tagdaycoststat.html\"}','127.0.0.1','2017-04-23 14:15:50'),(58,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":93,\"name\":\"按月统计\",\"orderNum\":6,\"parentId\":119,\"parentName\":\"成本分析\",\"type\":1,\"url\":\"ncu/monthcoststat.html\"}','127.0.0.1','2017-04-23 14:16:01'),(59,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":98,\"name\":\"账单预留详情\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/invoicedetailreserved.html\"}','127.0.0.1','2017-04-23 14:16:13'),(60,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":103,\"name\":\"账单详情\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/invoicedetaildesc.html\"}','127.0.0.1','2017-04-23 14:16:32'),(61,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":108,\"name\":\"账单调账结果\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/invoicedetailadjustresult.html\"}','127.0.0.1','2017-04-23 14:17:23'),(62,'admin','修改菜单','io.renren.admin.SysMenuController.update()','{\"icon\":\"fa fa-file-code-o\",\"menuId\":113,\"name\":\"账单预留调账数据\",\"orderNum\":6,\"parentId\":118,\"parentName\":\"账单管理\",\"type\":1,\"url\":\"ncu/invoicedetailadjustreserved.html\"}','127.0.0.1','2017-04-23 14:17:34');
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8 COMMENT='菜单管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,0,'系统管理',NULL,NULL,0,'fa fa-cog',9),(2,1,'管理员列表','sys/user.html',NULL,1,'fa fa-user',1),(3,1,'角色管理','sys/role.html',NULL,1,'fa fa-user-secret',2),(4,1,'菜单管理','sys/menu.html',NULL,1,'fa fa-th-list',3),(5,1,'SQL监控','druid/sql.html',NULL,1,'fa fa-bug',4),(6,1,'定时任务','sys/schedule.html',NULL,1,'fa fa-tasks',5),(7,6,'查看',NULL,'sys:schedule:list,sys:schedule:info',2,NULL,0),(8,6,'新增',NULL,'sys:schedule:save',2,NULL,0),(9,6,'修改',NULL,'sys:schedule:update',2,NULL,0),(10,6,'删除',NULL,'sys:schedule:delete',2,NULL,0),(11,6,'暂停',NULL,'sys:schedule:pause',2,NULL,0),(12,6,'恢复',NULL,'sys:schedule:resume',2,NULL,0),(13,6,'立即执行',NULL,'sys:schedule:run',2,NULL,0),(14,6,'日志列表',NULL,'sys:schedule:log',2,NULL,0),(15,2,'查看',NULL,'sys:user:list,sys:user:info',2,NULL,0),(16,2,'新增',NULL,'sys:user:save,sys:role:select',2,NULL,0),(17,2,'修改',NULL,'sys:user:update,sys:role:select',2,NULL,0),(18,2,'删除',NULL,'sys:user:delete',2,NULL,0),(19,3,'查看',NULL,'sys:role:list,sys:role:info',2,NULL,0),(20,3,'新增',NULL,'sys:role:save,sys:menu:perms',2,NULL,0),(21,3,'修改',NULL,'sys:role:update,sys:menu:perms',2,NULL,0),(22,3,'删除',NULL,'sys:role:delete',2,NULL,0),(23,4,'查看',NULL,'sys:menu:list,sys:menu:info',2,NULL,0),(24,4,'新增',NULL,'sys:menu:save,sys:menu:select',2,NULL,0),(25,4,'修改',NULL,'sys:menu:update,sys:menu:select',2,NULL,0),(26,4,'删除',NULL,'sys:menu:delete',2,NULL,0),(27,1,'参数管理','sys/config.html','sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete',1,'fa fa-sun-o',6),(28,1,'代码生成器','sys/generator.html','sys:generator:list,sys:generator:code',1,'fa fa-rocket',8),(29,1,'系统日志','sys/log.html','sys:log:list',1,'fa fa-file-text-o',7),(30,1,'文件上传','sys/oss.html','sys:oss:all',1,'fa fa-file-image-o',6),(31,0,'后台参数',NULL,NULL,0,NULL,0),(32,31,'云供应商','ncu/cloudtype.html',NULL,1,'fa fa-file-code-o',2),(33,32,'查看',NULL,'cloudtype:list,cloudtype:info',2,NULL,6),(34,32,'新增',NULL,'cloudtype:save',2,NULL,6),(35,32,'修改',NULL,'cloudtype:update',2,NULL,6),(36,32,'删除',NULL,'cloudtype:delete',2,NULL,6),(37,31,'云服务清单','ncu/servicedef.html',NULL,1,'fa fa-file-code-o',6),(39,37,'查看',NULL,'servicedef:list,servicedef:info',2,NULL,6),(40,37,'新增',NULL,'servicedef:save',2,NULL,6),(41,37,'修改',NULL,'servicedef:update',2,NULL,6),(42,37,'删除',NULL,'servicedef:delete',2,NULL,6),(43,31,'云账户','ncu/account.html',NULL,1,'fa fa-file-code-o',6),(44,43,'查看',NULL,'account:list,account:info',2,NULL,6),(45,43,'新增',NULL,'account:save',2,NULL,6),(46,43,'修改',NULL,'account:update',2,NULL,6),(47,43,'删除',NULL,'account:delete',2,NULL,6),(48,31,'云账户-AWS','ncu/awsaccount.html',NULL,1,'fa fa-file-code-o',6),(49,48,'查看',NULL,'awsaccount:list,awsaccount:info',2,NULL,6),(50,48,'新增',NULL,'awsaccount:save',2,NULL,6),(51,48,'修改',NULL,'awsaccount:update',2,NULL,6),(52,48,'删除',NULL,'awsaccount:delete',2,NULL,6),(53,31,'云账户-关联账户关系','ncu/accountlinkaccount.html',NULL,1,'fa fa-file-code-o',6),(54,53,'查看',NULL,'accountlinkaccount:list,accountlinkaccount:info',2,NULL,6),(55,53,'新增',NULL,'accountlinkaccount:save',2,NULL,6),(56,53,'修改',NULL,'accountlinkaccount:update',2,NULL,6),(57,53,'删除',NULL,'accountlinkaccount:delete',2,NULL,6),(58,118,'成本标签','ncu/costtag.html',NULL,1,'fa fa-file-code-o',6),(59,58,'查看',NULL,'costtag:list,costtag:info',2,NULL,6),(60,58,'新增',NULL,'costtag:save',2,NULL,6),(61,58,'修改',NULL,'costtag:update',2,NULL,6),(62,58,'删除',NULL,'costtag:delete',2,NULL,6),(63,118,'下载日志','ncu/downloadinvoicelog.html',NULL,1,'fa fa-file-code-o',6),(64,63,'查看',NULL,'downloadinvoicelog:list,downloadinvoicelog:info',2,NULL,6),(65,63,'新增',NULL,'downloadinvoicelog:save',2,NULL,6),(66,63,'修改',NULL,'downloadinvoicelog:update',2,NULL,6),(67,63,'删除',NULL,'downloadinvoicelog:delete',2,NULL,6),(68,118,'账单详情','ncu/invoicedetail.html',NULL,1,'fa fa-file-code-o',6),(69,68,'查看',NULL,'invoicedetail:list,invoicedetail:info',2,NULL,6),(70,68,'新增',NULL,'invoicedetail:save',2,NULL,6),(71,68,'修改',NULL,'invoicedetail:update',2,NULL,6),(72,68,'删除',NULL,'invoicedetail:delete',2,NULL,6),(73,118,'调账日志','ncu/invoicedetailadjustlog.html',NULL,1,'fa fa-file-code-o',6),(74,73,'查看',NULL,'invoicedetailadjustlog:list,invoicedetailadjustlog:info',2,NULL,6),(75,73,'新增',NULL,'invoicedetailadjustlog:save',2,NULL,6),(76,73,'修改',NULL,'invoicedetailadjustlog:update',2,NULL,6),(77,73,'删除',NULL,'invoicedetailadjustlog:delete',2,NULL,6),(78,118,'调账数据','ncu/invoicedetailadjustfilter.html',NULL,1,'fa fa-file-code-o',6),(79,78,'查看',NULL,'invoicedetailadjustfilter:list,invoicedetailadjustfilter:info',2,NULL,6),(80,78,'新增',NULL,'invoicedetailadjustfilter:save',2,NULL,6),(81,78,'修改',NULL,'invoicedetailadjustfilter:update',2,NULL,6),(82,78,'删除',NULL,'invoicedetailadjustfilter:delete',2,NULL,6),(83,118,'账户月账单','ncu/invoiceaccountdesc.html',NULL,1,'fa fa-file-code-o',6),(84,83,'查看',NULL,'invoiceaccountdesc:list,invoiceaccountdesc:info',2,NULL,6),(85,83,'新增',NULL,'invoiceaccountdesc:save',2,NULL,6),(86,83,'修改',NULL,'invoiceaccountdesc:update',2,NULL,6),(87,83,'删除',NULL,'invoiceaccountdesc:delete',2,NULL,6),(88,119,'标签日统计','ncu/tagdaycoststat.html',NULL,1,'fa fa-file-code-o',6),(89,88,'查看',NULL,'tagdaycoststat:list,tagdaycoststat:info',2,NULL,6),(90,88,'新增',NULL,'tagdaycoststat:save',2,NULL,6),(91,88,'修改',NULL,'tagdaycoststat:update',2,NULL,6),(92,88,'删除',NULL,'tagdaycoststat:delete',2,NULL,6),(93,119,'按月统计','ncu/monthcoststat.html',NULL,1,'fa fa-file-code-o',6),(94,93,'查看',NULL,'monthcoststat:list,monthcoststat:info',2,NULL,6),(95,93,'新增',NULL,'monthcoststat:save',2,NULL,6),(96,93,'修改',NULL,'monthcoststat:update',2,NULL,6),(97,93,'删除',NULL,'monthcoststat:delete',2,NULL,6),(98,118,'账单预留详情','ncu/invoicedetailreserved.html',NULL,1,'fa fa-file-code-o',6),(99,98,'查看',NULL,'invoicedetailreserved:list,invoicedetailreserved:info',2,NULL,6),(100,98,'新增',NULL,'invoicedetailreserved:save',2,NULL,6),(101,98,'修改',NULL,'invoicedetailreserved:update',2,NULL,6),(102,98,'删除',NULL,'invoicedetailreserved:delete',2,NULL,6),(103,118,'账单详情','ncu/invoicedetaildesc.html',NULL,1,'fa fa-file-code-o',6),(104,103,'查看',NULL,'invoicedetaildesc:list,invoicedetaildesc:info',2,NULL,6),(105,103,'新增',NULL,'invoicedetaildesc:save',2,NULL,6),(106,103,'修改',NULL,'invoicedetaildesc:update',2,NULL,6),(107,103,'删除',NULL,'invoicedetaildesc:delete',2,NULL,6),(108,118,'账单调账结果','ncu/invoicedetailadjustresult.html',NULL,1,'fa fa-file-code-o',6),(109,108,'查看',NULL,'invoicedetailadjustresult:list,invoicedetailadjustresult:info',2,NULL,6),(110,108,'新增',NULL,'invoicedetailadjustresult:save',2,NULL,6),(111,108,'修改',NULL,'invoicedetailadjustresult:update',2,NULL,6),(112,108,'删除',NULL,'invoicedetailadjustresult:delete',2,NULL,6),(113,118,'账单预留调账数据','ncu/invoicedetailadjustreserved.html',NULL,1,'fa fa-file-code-o',6),(114,113,'查看',NULL,'invoicedetailadjustreserved:list,invoicedetailadjustreserved:info',2,NULL,6),(115,113,'新增',NULL,'invoicedetailadjustreserved:save',2,NULL,6),(116,113,'修改',NULL,'invoicedetailadjustreserved:update',2,NULL,6),(117,113,'删除',NULL,'invoicedetailadjustreserved:delete',2,NULL,6),(118,0,'账单管理',NULL,NULL,0,NULL,1),(119,0,'成本分析',NULL,NULL,0,NULL,2);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oss`
--

DROP TABLE IF EXISTS `sys_oss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) DEFAULT NULL COMMENT 'URL地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='文件上传';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oss`
--

LOCK TABLES `sys_oss` WRITE;
/*!40000 ALTER TABLE `sys_oss` DISABLE KEYS */;
INSERT INTO `sys_oss` VALUES (1,'http://7xqbwh.dl1.z0.glb.clouddn.com/upload/20170408/80204a8bd2ee46889e7c59a7f8748f8b','2017-04-08 16:46:54');
/*!40000 ALTER TABLE `sys_oss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'平台管理员',NULL,1,'2017-04-03 12:20:48');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=298 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (180,1,31),(181,1,32),(182,1,33),(183,1,34),(184,1,35),(185,1,36),(186,1,37),(187,1,39),(188,1,40),(189,1,41),(190,1,42),(191,1,43),(192,1,44),(193,1,45),(194,1,46),(195,1,47),(196,1,48),(197,1,49),(198,1,50),(199,1,51),(200,1,52),(201,1,53),(202,1,54),(203,1,55),(204,1,56),(205,1,57),(206,1,118),(207,1,58),(208,1,59),(209,1,60),(210,1,61),(211,1,62),(212,1,63),(213,1,64),(214,1,65),(215,1,66),(216,1,67),(217,1,68),(218,1,69),(219,1,70),(220,1,71),(221,1,72),(222,1,73),(223,1,74),(224,1,75),(225,1,76),(226,1,77),(227,1,78),(228,1,79),(229,1,80),(230,1,81),(231,1,82),(232,1,83),(233,1,84),(234,1,85),(235,1,86),(236,1,87),(237,1,98),(238,1,99),(239,1,100),(240,1,101),(241,1,102),(242,1,103),(243,1,104),(244,1,105),(245,1,106),(246,1,107),(247,1,108),(248,1,109),(249,1,110),(250,1,111),(251,1,112),(252,1,113),(253,1,114),(254,1,115),(255,1,116),(256,1,117),(257,1,119),(258,1,88),(259,1,89),(260,1,90),(261,1,91),(262,1,92),(263,1,93),(264,1,94),(265,1,95),(266,1,96),(267,1,97),(268,1,1),(269,1,2),(270,1,15),(271,1,16),(272,1,17),(273,1,18),(274,1,3),(275,1,19),(276,1,20),(277,1,21),(278,1,22),(279,1,4),(280,1,23),(281,1,24),(282,1,25),(283,1,26),(284,1,5),(285,1,6),(286,1,7),(287,1,8),(288,1,9),(289,1,10),(290,1,11),(291,1,12),(292,1,13),(293,1,14),(294,1,27),(295,1,30),(296,1,29),(297,1,28);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建者ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,'admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','root@renren.io','13612345678',1,NULL,'2016-11-11 11:11:11'),(2,'rechen','d84ce7ea0838f6397ec588875f96822f73f8e9e63b7a79b255ca74070855650d','rechen@qq.com','18938961900',1,1,'2017-04-03 12:20:16');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (3,1,1),(4,2,1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_token`
--

DROP TABLE IF EXISTS `tb_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_token`
--

LOCK TABLES `tb_token` WRITE;
/*!40000 ALTER TABLE `tb_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'mark','13612345678','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918','2017-03-23 22:37:41');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-23 15:09:39
