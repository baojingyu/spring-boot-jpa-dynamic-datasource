package cc.fxea.test.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className DynamicRoutingDataSource
 * @description
 * @date 7/5/2020 21:22
 **/
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        Object lookupKey = DynamicRoutingDataSourceContext.getRoutingDataSource();
        System.err.println(Thread.currentThread().getName() + " determineCurrentLookupKey : " + lookupKey);
        return lookupKey;
    }
}
