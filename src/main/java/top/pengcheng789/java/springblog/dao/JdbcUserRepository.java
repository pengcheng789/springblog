package top.pengcheng789.java.springblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import top.pengcheng789.java.springblog.model.User;
import top.pengcheng789.java.springblog.util.CastUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用 JDBC Template 实现 UserRepository 接口
 *
 * CreateDate:2017-08-05
 *
 * @author pen
 */
@Repository
public class JdbcUserRepository implements UserRepository{

    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcUserRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<User> findUsers() {
        return jdbcOperations.query(SELECT_USER_ALL, new UserRowMapper());
    }

    @Override
    public User findUserById(String id) {
        return jdbcOperations.queryForObject(SELECT_USER_BY_ID, new UserRowMapper(), id);
    }

    @Override
    public User findUserByMail(String mail) {
        return jdbcOperations.queryForObject(SELECT_USER_BY_MAIL, new UserRowMapper(), mail);
    }

    @Override
    public void addUser(User user) {
        jdbcOperations.update(
                INSERT_USER,
                user.getId(),
                user.getMail(),
                user.getSex(),
                user.getCreateDate(),
                user.getNickname(),
                user.getPassword()
        );
    }

    @Override
    public void updateUserHeadImage(User user) {
        jdbcOperations.update(
                UPDATE_USER_HEAD_IMAGE,
                user.getHeadImage(),
                user.getId()
        );
    }

    @Override
    public void updateUserSex(User user) {
        jdbcOperations.update(
                UPDATE_USER_SEX,
                user.getSex(),
                user.getId()
        );
    }

    @Override
    public void updateUserNickname(User user) {
        jdbcOperations.update(
                UPDATE_USER_NICKNAME,
                user.getNickname(),
                user.getId()
        );
    }

    @Override
    public void updateUserPassword(User user) {
        jdbcOperations.update(
                UPDATE_USER_PASSWORD,
                user.getPassword(),
                user.getId()
        );
    }

    @Override
    public void updateUserActiveStatus(User user) {
        jdbcOperations.update(
                UPDATE_USER_ACTIVE_STATUS,
                CastUtil.booleanToInt(user.isActive()),
                user.getId()
        );
    }

    @Override
    public void updateUserAdminStatus(User user) {
        jdbcOperations.update(
                UPDATE_USER_ADMIN_STATUS,
                CastUtil.booleanToInt(user.isAdmin()),
                user.getId()
        );
    }

    @Override
    public void deleteUser(User user) {
    }

    private static final class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();

            user.setId(rs.getString("id"));
            user.setMail(rs.getString("mail"));
            user.setHeadImage(rs.getString("head_image"));
            user.setSex(rs.getString("sex"));
            user.setCreateDate(rs.getDate("create_date"));
            user.setNickname(rs.getString("nickname"));
            user.setPassword(rs.getString("password"));
            user.setActive(rs.getBoolean("is_active"));
            user.setAdmin(rs.getBoolean("is_admin"));

            return user;
        }
    }
}
