package com.gle.mp.test;

import org.junit.Test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class TestMP_MySQL {
	/**
	 * 	代码生成示例代码
	 * 	更多配置见：
	 * 	https://mp.baomidou.com/guide/generator.html#%E4%BD%BF%E7%94%A8%E6%95%99%E7%A8%8B
	 */
	@Test
	public void testGenerator() {
		//1.全局配置
		GlobalConfig glConfig = new GlobalConfig();
		glConfig.setActiveRecord(true) // 是否支持AR模式
			.setAuthor("zz") // 作者
			.setOutputDir("D:\\workspace\\mp03\\src\\main\\java") // 生成路径
			.setFileOverride(true)  // 文件覆盖
			.setIdType(IdType.UUID) // 主键策略(自增)
			.setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I(默认是有I，加%sService之后就没有I了)
			.setBaseResultMap(true)//生成映射文件中的基本结果映射
			.setBaseColumnList(true);//生成基本的SQL片段
		//2.数据源配置:MySQL
		DataSourceConfig  dsConfig  = new DataSourceConfig();
		dsConfig
			.setDbType(DbType.MYSQL)  // 设置数据库类型
			.setDriverName("com.mysql.jdbc.Driver")
			//.setUrl("jdbc:mysql://192.168.2.5:3366/train_db")
			.setUrl("jdbc:mysql://192.168.2.95:3366/train_bj8h")
			.setUsername("root")
			.setPassword("root");
		//3.策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) //全局大写命名
				.setDbColumnUnderline(true)  // 指定表名 字段名是否使用过下划线
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略(下划线转驼峰)
				.setTablePrefix("")//表名的前缀，通过这个找到具体的表名
				.setInclude("equipment_quality_problem_zero");  // 利用代码生成器时使用的表
		//4.包名策略配置
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("com.bettem.training.module.equipment")
				.setMapper("dao")
				.setService("service")
				.setController("controller")
				.setEntity("model")
				.setXml("dao.mapper");
		//5.整合配置
		AutoGenerator  ag = new AutoGenerator();
		ag.setGlobalConfig(glConfig)
			.setDataSource(dsConfig)
			.setStrategy(stConfig)
			.setPackageInfo(pkConfig);
		//6.执行
		ag.execute();
		
	}
}