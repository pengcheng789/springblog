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

//    @Email(message = "{mail.valid}")
    @Email(message = "请输入有效的邮箱地址")
    private String mail;

//    @Size(min = 20, max = 255, message = "{nickname.size}")
    @Size(min = 1, max = 255, message = "昵称的长度不能少于{min}个字符，不能多于{max}个字符")
    private String nickname;

//    @Size(min = 20, max = 255, message = "{password.size}")
//    @Pattern(regexp = "^\\w+$", message = "{password.valid}")
    @Size(min = 6, max = 255, message = "密码的长度不能少于{min}个字符，不能多于{max}个字符")
    @Pattern(regexp = "^\\w+$", message = "密码只能由0-9、大小写字母或下划线组成")
    private String password;

//    @Pattern(regexp = "^[\u7537\u5973]$", message = "{sex.valid}")
    @NotNull(message = "请选择性别")
    @Pattern(regexp = "^[\\u7537\\u5973]$", message = "性别只能是“男”或者“女”")
    private String sex;

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
