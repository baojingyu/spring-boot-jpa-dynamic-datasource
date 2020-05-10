package cc.fxea.test.service;

import cc.fxea.test.domain.UserInfoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className IUserInfoService
 * @description
 * @date 7/5/2020 21:38
 **/
public interface IUserInfoService {
    List<UserInfoEntity> findAll();

    UserInfoEntity save(UserInfoEntity userInfoEntity);

    UserInfoEntity findById(Long id);

    List<UserInfoEntity> findAllMaster();

    void saveAll(ArrayList<UserInfoEntity> list);
}
