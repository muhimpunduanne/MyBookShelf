package org.example.mybookshef.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String regNo;
    private String email;
    private String password;
    private String confirmPassword;

}
