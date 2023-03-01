package com.facoiti.transperfectchallange.user;

import com.facoiti.transperfectchallange.enums.Education;
import com.facoiti.transperfectchallange.enums.WorkExperience;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserService underTest;

    @Test
    void shouldCheckIfUserExistsByEmailAddress() {
        //given
        User user = User.build(0L, "Test Name", "abdo@gmail.com", "hellothisIsApAssWord123#", Education.BACHELORS_DEGREE_IN_COMPUTER_SCIENCE, WorkExperience.SOFTWARE_ENGINEER_AT_XYZ_2015_2020);
        //when
        UserRequestValidation userRequestValidation = new UserRequestValidation(user.getName(), user.getEmail(), user.getPassword(), user.getEducation(), user.getWorkExperience());
        underTest.addUser(userRequestValidation);
        //then
        boolean exists = underTest.findUserByEmail(user.getEmail());
        assertTrue(exists);
    }


}

