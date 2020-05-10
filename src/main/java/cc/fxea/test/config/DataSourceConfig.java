package cc.fxea.test.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className DataSourceConfig
 * @description
 * @date 7/5/2020 20:09
 **/
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    @Value("${fxea.druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "fxea.datasources.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "fxea.datasources.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Primary
    @Bean(name = "dataSource")
    public DynamicRoutingDataSource dataSource(@Qualifier(value = "masterDataSource") DataSource masterDataSource, @Qualifier(value = "slaveDataSource") DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DynamicRoutingDataSourceContext.MASTER, masterDataSource);
        targetDataSources.put(DynamicRoutingDataSourceContext.SLAVE, slaveDataSource);
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        //设置数据源
        dynamicRoutingDataSource.setTargetDataSources(targetDataSources);
        //设置默认选择的数据源
        dynamicRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        dynamicRoutingDataSource.afterPropertiesSet();
        return dynamicRoutingDataSource;
    }


}
