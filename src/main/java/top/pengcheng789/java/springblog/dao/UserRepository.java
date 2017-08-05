package top.pengcheng789.java.springblog.dao;

import top.pengcheng789.java.springblog.model.User;

import java.util.List;

/**
 * 为其它服务提供用户数据的接口
 *
 * CreateDate:2017-08-05
 *
 * @author pen
 */
public interface UserRepository {

    String SELECT_USER_ALL = "SELECT * FROM user";
    String SELECT_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
    String SELECT_USER_BY_MAIL = "SELECT * FROM user WHERE mail = ?";
    String INSERT_USER = "INSERT INTO user (id, mail, sex, create_date, nickname, password) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    String UPDATE_USER_HEAD_IMAGE = "UPDATE user SET head_image = ? WHERE id = ?";
    String UPDATE_USER_SEX = "UPDATE user SET sex = ? WHERE id = ?";
    String UPDATE_USER_NICKNAME = "UPDATE user SET nickname = ? WHERE id = ?";
    String UPDATE_USER_PASSWORD = "UPDATE user SET password = ? WHERE id = ?";
    String UPDATE_USER_ACTIVE_STATUS = "UPDATE user SET is_active = ? WHERE id = ?";
    String UPDATE_USER_ADMIN_STATUS = "UPDATE user SET is_admin = ? WHERE id = ?";
    String DELETE_USER = "DELETE FROM user WHERE id = ?";

    List<User> findUsers();

    User findUserById(String id);

    User findUserByMail(String mail);

    void addUser(User user);

    void updateUserHeadImage(User user);

    void updateUserSex(User user);

    void updateUserNickname(User user);

    void updateUserPassword(User user);

    void updateUserActiveStatus(User user);

    void updateUserAdminStatus(User user);

    void deleteUser(User user);
}
