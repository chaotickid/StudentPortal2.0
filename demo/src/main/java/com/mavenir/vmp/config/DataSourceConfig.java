/**
 *
 */
package com.mavenir.vmp.config;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mavenir.vmp.config.EnvironmentProperties.DataSourceProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.web.client.RestTemplate;

/**
 * The Class DataSourceConfig.
 *
 * @author Vlatka, OptimIT
 */
@Configuration
public class DataSourceConfig {

	/**
	 * Data source.
	 *
	 * @param prop the prop
	 * @return the data source
	 */
	@Bean
	public DataSource dataSource(EnvironmentProperties prop) {
		//DataSourceProperties db = prop.getDatabase();
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("org.sqlite.JDBC");
		config.setJdbcUrl("jdbc:sqlite:C:/database/test.db");
		config.setUsername("db.getUser()");
		config.setPassword("db.getPassword()");
		config.setLeakDetectionThreshold(120000);
		config.setMinimumIdle(0);
		config.setIdleTimeout(60000);
		config.setConnectionTestQuery("SELECT 1");
		return new HikariDataSource(config);
	}

	@Bean
	public RestTemplate returnRest(){
		return new RestTemplate();
	}

	@Bean
	public ModelMapper returnModelMapper(){
		return new ModelMapper();
	}

}
