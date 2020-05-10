package cc.fxea.test.service;

import cc.fxea.test.domain.UserInfoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className UserInfoRepositoryTest
 * @description
 * @date 6/5/2020 20:26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserInfoServiceTest {

    @Autowired
    private IUserInfoService userInfoService;

    @Test
    public void testFindAll() {
        List<UserInfoEntity> all = userInfoService.findAll();
        System.out.println(all.toString());
    }

    @Test
    public void testFindById() {
        UserInfoEntity userInfoEntity = userInfoService.findById(1L);
        System.out.println(userInfoEntity.toString());
    }

    @Test
    public void findAllMaster() {
        List<UserInfoEntity> all = userInfoService.findAllMaster();
        System.out.println(all.toString());
    }


    @Test
    public void testInsertOne() {
        Random random = new Random();
        int nextInt = random.nextInt(Integer.MAX_VALUE);
        String[] address = {"BJ", "SH", "GZ", "SZ", "WH"};
        // String[] address = {"北京", "上海", "广州", "深圳", "武汉"};
        String[] deptCode = {"W00001", "W00002", "W00003", "W00004", "W00005"};
        double index = Math.floor((Math.random() * address.length));
        UserInfoEntity userInfoEntity = userInfoService.save(new UserInfoEntity("Mock" + nextInt, String.valueOf(random.nextInt(100)), String.valueOf(nextInt), address[(int) index], deptCode[(int) index], new Date(), new Date()));
        System.out.println(userInfoEntity.toString());
    }
}
