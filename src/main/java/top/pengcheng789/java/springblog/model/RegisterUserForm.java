package top.pengcheng789.java.springblog.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 注册表单的模型
 *
 * CreateDate:2017-08-06
 *
 * @author pen
 */
public class RegisterUserForm {

    @NotNull
    @Email(message = "{mail.valid}")
    private String mail;

    @NotNull
    @Size(min = 4, max = 255, message = "{nickname.size}")
    private String nickname;

    @NotNull
    @Size(min = 6, max = 255, message = "{password.size}")
    @Pattern(regexp = "^\\w+$", message = "{password.valid}")
    private String password;

    @NotNull
    @Pattern(regexp = "^[男女]$", message = "{sex.valid}")
    private String sex;

    public RegisterUserForm() {}

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }
}
