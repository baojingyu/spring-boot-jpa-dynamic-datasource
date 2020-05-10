package cc.fxea.test.controller;

import com.sun.istack.logging.Logger;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className UserInfoControllerTest
 * @description
 * @date 9/5/2020 17:21
 **/
class UserInfoControllerTest {
    private static Logger Log = Logger.getLogger(UserInfoControllerTest.class);

    @Test
    void findAll() {
        String reqUrl = "http://localhost:8080/findAll";
        String result = get(reqUrl);
        System.out.println(result);
    }


    @Test
    void findAllMaster() {
        String reqUrl = "http://localhost:8080/api/user-info/findAllMaster";
        String result = get(reqUrl);
        System.out.println(result);
    }

    @Test
    void findById() {
        String reqUrl = "http://localhost:8080/api/user-info/findById/13";
        String result = get(reqUrl);
        System.out.println(result);
    }

    @Test
    void bathInsert() {
        String reqUrl = "http://localhost:8080/api/user-info/bathInsert/5";
        String result = get(reqUrl);
        System.out.println(result);
    }

    @Test
    void insertOne() {
        String reqUrl = "http://localhost:8080/api/user-info/insertOne";
        String result = get(reqUrl);
        System.out.println(result);
    }

    /**
     * get请求
     *
     * @param reqUrl
     * @return
     */
    private static String get(String reqUrl) {
        Response response = null;
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(reqUrl)
                    .build();//创建Request 对象
            //得到Response 对象
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                Log.info("response.code()==" + response.code());
                Log.info("response.message()==" + response.message());
                Log.info("res==" + response.body());
                return response.body().string();
                //此时的代码执行在子线程，修改UI的操作请使用handler跳转到UI线程。
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}