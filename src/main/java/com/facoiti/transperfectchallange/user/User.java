package com.facoiti.transperfectchallange.user;

import com.facoiti.transperfectchallange.enums.Education;
import com.facoiti.transperfectchallange.enums.WorkExperience;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    String email;
    String password;
    private Education education;
    private WorkExperience workExperience;

}
