package cc.fxea.test.controller;

import cc.fxea.test.domain.UserInfoEntity;
import cc.fxea.test.service.IUserInfoService;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className UserInfoController
 * @description
 * @date 6/5/2020 20:32
 **/
@RestController
@RequestMapping("/api/user-info")
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    @Qualifier(value = "threadPool")
    private ExecutorService threadPool;

    @GetMapping("/findAll")
    public List<UserInfoEntity> findAll() {
        return userInfoService.findAll();
    }

    @GetMapping("/findAllMaster")
    public List<UserInfoEntity> findAllMaster() {
        return userInfoService.findAllMaster();
    }

    @GetMapping("/findById/{id}")
    public UserInfoEntity findById(@PathVariable("id") Long id) {
        return userInfoService.findById(id);
    }

    @RequestMapping("/bathInsert/{num}")
    public String bathInsert(@PathVariable("num") Integer num) {
        List<Integer> nums = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            nums.add(i);
        }
        List<List<Integer>> partition = ListUtils.partition(nums, 100);
        for (List<Integer> objects : partition) {
            threadPool.execute(() -> {
                ArrayList<UserInfoEntity> list = new ArrayList<>();
                for (int j = 0; j < objects.size(); j++) {
                    list.add(generateUserInfo());
                }
                userInfoService.saveAll(list);
            });
        }
        return "OK";
    }

    private UserInfoEntity generateUserInfo() {
        Random random = new Random();
        int nextInt = random.nextInt(Integer.MAX_VALUE);
        String[] address = {"BJ", "SH", "GZ", "SZ", "WH"};
        // String[] address = {"北京", "上海", "广州", "深圳", "武汉"};
        String[] deptCode = {"W00001", "W00002", "W00003", "W00004", "W00005"};
        double index = Math.floor((Math.random() * address.length));
        return new UserInfoEntity("Mock" + nextInt, String.valueOf(random.nextInt(100)), String.valueOf(nextInt), address[(int) index], deptCode[(int) index], new Date(), new Date());

    }

    @RequestMapping("/insertOne")
    public UserInfoEntity insertOne() {
        UserInfoEntity userInfoEntity = userInfoService.save(generateUserInfo());
        return userInfoEntity;
    }

}
