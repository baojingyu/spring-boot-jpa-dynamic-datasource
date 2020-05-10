package cc.fxea.test.config;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className DynamicRoutingDataSourceContext
 * @description
 * @date 7/5/2020 20:16
 **/
public class DynamicRoutingDataSourceContext {

    public static final String MASTER = "master";

    public static final String SLAVE = "slave";

    private static final ThreadLocal<Object> threadLocalDataSource = new ThreadLocal<>();


    public static void setRoutingDataSource(Object dataSource) {
        if (dataSource == null) {
            throw new NullPointerException();
        }
        threadLocalDataSource.set(dataSource);
        // System.err.println(Thread.currentThread().getName()+" set RoutingDataSource : " + dataSource);
    }

    public static Object getRoutingDataSource() {
        Object dataSourceType = threadLocalDataSource.get();
        if (dataSourceType == null) {
            threadLocalDataSource.set(DynamicRoutingDataSourceContext.MASTER);
            return getRoutingDataSource();
        }
        // System.err.println(Thread.currentThread().getName()+" get RoutingDataSource : " + dataSourceType);
        return dataSourceType;
    }

    public static void removeRoutingDataSource() {
        threadLocalDataSource.remove();
        // System.err.println(Thread.currentThread().getName()+" remove RoutingDataSource");
    }
}
