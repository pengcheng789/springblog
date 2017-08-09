package top.pengcheng789.java.springblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import top.pengcheng789.java.springblog.dao.UserRepository;
import top.pengcheng789.java.springblog.model.RegisterUserForm;
import top.pengcheng789.java.springblog.model.User;
import top.pengcheng789.java.springblog.util.CodecUtil;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * CreateDate:2017-08-06
 *
 * @author pen
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 查询所有用户
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 查询用户（通过用户 id ）
     */
    public User findById(String id) {
        return userRepository.findById(id);
    }

    /**
     * 添加用户
     */
    public String add(RegisterUserForm form) {
        User user = new User();
        String userId = UUID.randomUUID().toString();

        user.setId(userId);
        user.setMail(form.getMail());
        user.setCreateDate(new Date());
        user.setSex(form.getSex());
        user.setNickname(form.getNickname());
        user.setPassword(CodecUtil.md5(form.getPassword()));

        userRepository.add(user);

        return userId;
    }

    /**
     * 更新用户昵称
     */
    public void updateNickname(String userId, String nickName) {
        User user = findById(userId);
        user.setNickname(nickName);
        userRepository.updateNickname(user);
    }

    /**
     * 更新用户性别
     */
    public void updateSex(String userId, String sex) {
        User user = findById(userId);
        user.setSex(sex);
        userRepository.updateSex(user);
    }

    /**
     * 更新用户头像
     */
    public void updateHeadImage(String userId, String filePath) {
        User user = findById(userId);
        user.setHeadImage(filePath);
        userRepository.updateHeadImage(user);
    }

    /**
     * 删除用户
     */
    public void delete(String userId) {
        User user = findById(userId);

        userRepository.delete(user);
    }


    /**
     * 判断 mail 是否已存在
     */
    public boolean mailIsExist(String mail) {
        try {
            userRepository.findByMail(mail);
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

        return true;
    }

    /**
     * 判断 mail 是否不存在
     */
    public boolean mailIsNotExist(String mail) {
        return !mailIsExist(mail);
    }
}
