package cc.fxea.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className UserInfoEntity
 * @description
 * @date 6/5/2020 20:11
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
public class DemoApplication {
    @Value("${fxea.threadPool.maxThreadNum}")
    private int maxthreadNum;

    @Value("${fxea.threadPool.coreThreadNum}")
    private int coreThreadNum;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.err.println("-------- start success --------");
    }

    @Bean(name = "threadPool")
    public ExecutorService threadPool() {
        return new ThreadPoolExecutor(coreThreadNum, maxthreadNum,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

}

