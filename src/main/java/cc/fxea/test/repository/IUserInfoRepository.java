package cc.fxea.test.repository;

import cc.fxea.test.domain.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jingyu.bao
 * @version 1.0
 * @className UserInfoRepository
 * @description
 * @date 6/5/2020 20:18
 **/
public interface IUserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

}
