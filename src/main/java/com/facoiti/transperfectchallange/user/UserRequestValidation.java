package com.facoiti.transperfectchallange.user;
import com.facoiti.transperfectchallange.enums.Education;
import com.facoiti.transperfectchallange.enums.WorkExperience;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestValidation {
    // name field , required and must be between 2 and 50 characters
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\\s]{2,50}$", message = "Name must be between 2 and 50 characters")
    private String name;
    @Email
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Email must be valid")
    String email;
    //field is required and must be between 8 and 20 characters long,
    // and must contain at least one uppercase letter, one lowercase letter,
    // one digit, and one special character.
    @NotEmpty
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters long")
    @Pattern.List({
            @Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain at least one uppercase letter"),
            @Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain at least one lowercase letter"),
            @Pattern(regexp = "(?=.*\\d).+", message = "Password must contain at least one digit"),
            @Pattern(regexp = "(?=.*[!@#$%^&*()_+~`\\-={}\\[\\]\\|;:'\",.<>/?]).+", message = "Password must contain at least one special character")
    })
    @NotEmpty
    private String password;
    // education field from enums of education
    private Education education;
    // workExperience field from enums of workExperience
    private WorkExperience workExperience;

}
