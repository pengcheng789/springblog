package top.pengcheng789.java.springblog.model;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Passage 模型
 *
 * CreateDate:2017-08-12
 *
 * @author pen
 */
public class Passage {

    private String id;

    @Size(min = 1, message = "1")
    private String title;

    private String authorId;

    private int categoryId;

    private Date createDate;

    private Date updateDate;

    @Size(min = 1, message = "2")
    private String content;

    @Size(min = 1, message = "3")
    private String originContent;

    private PassageCategory passageCategory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOriginContent() {
        return originContent;
    }

    public void setOriginContent(String originContent) {
        this.originContent = originContent;
    }

    public PassageCategory getPassageCategory() {
        return passageCategory;
    }

    public void setPassageCategory(PassageCategory passageCategory) {
        this.passageCategory = passageCategory;
    }
}
