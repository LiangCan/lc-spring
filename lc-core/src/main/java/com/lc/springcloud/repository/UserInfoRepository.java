package com.lc.springcloud.repository;

import com.lc.springcloud.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="t_user_info")
@Qualifier("userInfoRepository")
public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {

}
