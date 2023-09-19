package hello.login.web.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

    public LoginForm() {
    }

    public LoginForm(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
}
