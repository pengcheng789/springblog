package top.pengcheng789.java.springblog.model;

/**
 * 在线用户模型
 *
 * CreateDate:2017-08-10
 *
 * @author pen
 */
public class CurrentUser {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
