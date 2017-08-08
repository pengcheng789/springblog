package top.pengcheng789.java.springblog.model;

import javax.validation.constraints.Size;

/**
 * 更新昵称表单的模型
 *
 * CreateDate:2017-08-08
 *
 * @author pen
 */
public class UpdateNicknameForm {

    @Size(min = 1, max = 255, message = "昵称的长度不能少于{min}个字符，不能多于{max}个字符")
    private String nickname;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
