package com.graduationproject.shareddoctor.respository;

import com.graduationproject.shareddoctor.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: sharedDoctor
 * @author: 杨帆
 * @create: 2019/1/3
 **/

public interface UserRepository extends JpaRepository<User,String> {

    User findUserByUserId(String userId);

    User findUserByUserName(String Username);

    void deleteUserByUserId(String userId);
}