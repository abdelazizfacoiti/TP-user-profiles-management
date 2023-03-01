package com.facoiti.transperfectchallange;
import static org.assertj.core.api.Assertions.assertThat;

import com.facoiti.transperfectchallange.user.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransperfectChallangeApplicationTests {

    @Autowired
    private UserController controller;
    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
