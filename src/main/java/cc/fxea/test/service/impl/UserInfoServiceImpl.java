package cc.fxea.test.service.impl;

import cc.fxea.test.annotation.TargetDateSource;
import cc.fxea.test.domain.UserInfoEntity;
import cc.fxea.test.repository.IUserInfoRepository;
import cc.fxea.test.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className UserServiceImpl
 * @description
 * @date 7/5/2020 21:39
 **/
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoRepository userInfoRepository;

    @TargetDateSource(value = "slave")
    @Override
    public List<UserInfoEntity> findAll() {
        return userInfoRepository.findAll();
    }

    @Transactional
    @Override
    public UserInfoEntity save(UserInfoEntity userInfoEntity) {
        return userInfoRepository.save(userInfoEntity);
    }

    @TargetDateSource(value = "slave")
    @Override
    public UserInfoEntity findById(Long id) {
        Optional<UserInfoEntity> userInfoEntity = userInfoRepository.findById(id);
        return userInfoEntity.isPresent() ? userInfoEntity.get() : null;
    }

    @Override
    public List<UserInfoEntity> findAllMaster() {
        return userInfoRepository.findAll();
    }

    @Transactional
    @Override
    public void saveAll(ArrayList<UserInfoEntity> list) {
        userInfoRepository.saveAll(list);
    }
}
