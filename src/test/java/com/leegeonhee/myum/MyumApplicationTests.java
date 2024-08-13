package com.leegeonhee.myum;

import com.leegeonhee.myum.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyumApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserRepository userJpaRepository;


}
