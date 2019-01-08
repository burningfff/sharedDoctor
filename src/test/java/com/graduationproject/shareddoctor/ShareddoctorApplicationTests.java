package com.graduationproject.shareddoctor;

import com.graduationproject.shareddoctor.Entity.User;
import com.graduationproject.shareddoctor.respository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShareddoctorApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Test
    public void contextLoads() {
        Optional<User> user=userRepository.findById("150410315");
        System.out.println(user);

    }
}

