package top.pengcheng789.java.springblog.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 更新用户性别的模型
 *
 * CreateDate:2017-08-08
 *
 * @author pen
 */
public class UpdateSexForm {

    @NotNull(message = "请选择性别")
    @Pattern(regexp = "^[\\u7537\\u5973]$", message = "性别只能是“男”或者“女”")
    private String sex;

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
