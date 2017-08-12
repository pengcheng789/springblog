package top.pengcheng789.java.springblog.model;

import javax.validation.constraints.Size;

/**
 * 文章的目录的模型
 *
 * CreateDate:2017-08-11
 *
 * @author pen
 */
public class PassageCategory {

    private int id;

    @Size(min = 1, max = 255, message = "类别的长度不能少于{min}个字符，不能多于{max}个字符")
    private String name;

    private int passageNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassageNum() {
        return passageNum;
    }

    public void setPassageNum(int passageNum) {
        this.passageNum = passageNum;
    }
}
