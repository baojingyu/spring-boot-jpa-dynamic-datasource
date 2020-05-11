package cc.fxea.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className DataSourceConfig
 * @description
 * @date 7/5/2020 20:09
 **/
@EnableTransactionManagement
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.druid.master.name}")
    private String masterName;

    @Value("${spring.datasource.druid.master.url}")
    private String masterUrl;

    @Value("${spring.datasource.druid.master.username}")
    private String masterUsername;

    @Value("${spring.datasource.druid.master.password}")
    private String masterPassword;

    @Value("${spring.datasource.druid.master.driver-class-name}")
    private String masterDriverClassName;

    @Value("${spring.datasource.druid.slave.name}")
    private String slaveName;

    @Value("${spring.datasource.druid.slave.url}")
    private String slaveUrl;

    @Value("${spring.datasource.druid.slave.username}")
    private String slaveUsername;

    @Value("${spring.datasource.druid.slave.password}")
    private String slavePassword;

    @Value("${spring.datasource.druid.slave.driver-class-name}")
    private String slaveDriverClassName;

    @Value("${spring.datasource.druid.initial-size}")
    private String initialSize;

    @Value("${spring.datasource.druid.min-idle}")
    private String minIdle;

    @Value("${spring.datasource.druid.max-active}")
    private String maxActive;

    @Value("${spring.datasource.druid.max-wait}")
    private String maxWait;

    @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
    private String timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
    private String minEvictableIdleTimeMillis;

    @Value("${spring.datasource.druid.validation-query}")
    private String validationQuery;

    @Value("${spring.datasource.druid.test-while-idle}")
    private String testWhileIdle;

    @Value("${spring.datasource.druid.test-on-borrow}")
    private String testOnBorrow;

    @Value("${spring.datasource.druid.test-on-return}")
    private String testOnReturn;

    @Value("${spring.datasource.druid.filters}")
    private String filters;

    @Value("{spring.datasource.druid.filter.stat.log-slow-sql}")
    private String logSlowSql;

    @Value("{spring.datasource.druid.filter.stat.slow-sql-millis}")
    private String slowSqlMillis;

    @Value("${spring.datasource.druid.type}")
    private String type;

    @Value("${spring.datasource.druid.stat-view-servlet.login-username}")
    private String loginUserName;

    @Value("${spring.datasource.druid.stat-view-servlet.login-password}")
    private String password;

    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(masterUrl);
        datasource.setUsername(masterUsername);
        datasource.setPassword(masterPassword);
        datasource.setDriverClassName(masterDriverClassName);

        //configuration
        if (!StringUtils.isEmpty(initialSize)) {
            datasource.setInitialSize(Integer.parseInt(initialSize));
        }
        if (!StringUtils.isEmpty(minIdle)) {
            datasource.setMinIdle(Integer.parseInt(minIdle));
        }
        if (!StringUtils.isEmpty(maxActive)) {
            datasource.setMaxActive(Integer.parseInt(maxActive));
        }
        if (!StringUtils.isEmpty(maxWait)) {
            datasource.setMaxWait(Integer.parseInt(maxWait));
        }
        if (!StringUtils.isEmpty(timeBetweenEvictionRunsMillis)) {
            datasource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(timeBetweenEvictionRunsMillis));
        }
        if (!StringUtils.isEmpty(minEvictableIdleTimeMillis)) {
            datasource.setMinEvictableIdleTimeMillis(Integer.parseInt(minEvictableIdleTimeMillis));
        }
        if (!StringUtils.isEmpty(validationQuery)) {
            datasource.setValidationQuery(validationQuery);
        }
        if (!StringUtils.isEmpty(testWhileIdle)) {
            datasource.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
        }
        if (!StringUtils.isEmpty(testOnBorrow)) {
            datasource.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
        }
        if (!StringUtils.isEmpty(testOnReturn)) {
            datasource.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
        }

        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }

    @Bean(name = "slaveDataSource")
    public DataSource slaveDataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(masterUrl);
        datasource.setUsername(masterUsername);
        datasource.setPassword(masterPassword);
        datasource.setDriverClassName(masterDriverClassName);

        //configuration
        if (!StringUtils.isEmpty(initialSize)) {
            datasource.setInitialSize(Integer.parseInt(initialSize));
        }
        if (!StringUtils.isEmpty(minIdle)) {
            datasource.setMinIdle(Integer.parseInt(minIdle));
        }
        if (!StringUtils.isEmpty(maxActive)) {
            datasource.setMaxActive(Integer.parseInt(maxActive));
        }
        if (!StringUtils.isEmpty(maxWait)) {
            datasource.setMaxWait(Integer.parseInt(maxWait));
        }
        if (!StringUtils.isEmpty(timeBetweenEvictionRunsMillis)) {
            datasource.setTimeBetweenEvictionRunsMillis(Integer.parseInt(timeBetweenEvictionRunsMillis));
        }
        if (!StringUtils.isEmpty(minEvictableIdleTimeMillis)) {
            datasource.setMinEvictableIdleTimeMillis(Integer.parseInt(minEvictableIdleTimeMillis));
        }
        if (!StringUtils.isEmpty(validationQuery)) {
            datasource.setValidationQuery(validationQuery);
        }
        if (!StringUtils.isEmpty(testWhileIdle)) {
            datasource.setTestWhileIdle(Boolean.parseBoolean(testWhileIdle));
        }
        if (!StringUtils.isEmpty(testOnBorrow)) {
            datasource.setTestOnBorrow(Boolean.parseBoolean(testOnBorrow));
        }
        if (!StringUtils.isEmpty(testOnReturn)) {
            datasource.setTestOnReturn(Boolean.parseBoolean(testOnReturn));
        }

        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }

    @Primary
    @Bean
    public DynamicRoutingDataSource dynamicDataSource(@Qualifier(value = "masterDataSource") DataSource masterDataSource, @Qualifier(value = "slaveDataSource") DataSource slaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
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

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow", "");
        //设置ip黑名单，优先级高于白名单
        servletRegistrationBean.addInitParameter("deny", "");
        //设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", loginUserName);
        servletRegistrationBean.addInitParameter("loginPassword", password);
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
