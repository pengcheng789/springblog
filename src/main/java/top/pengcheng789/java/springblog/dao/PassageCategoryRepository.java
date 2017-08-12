package top.pengcheng789.java.springblog.dao;

import top.pengcheng789.java.springblog.model.PassageCategory;

import java.util.List;

/**
 * Passage Category 数据操作相关接口
 *
 * CreateDate:2017-08-11
 *
 * @author pen
 */
public interface PassageCategoryRepository {

    String SELECT_CATEGORY_ALL = "SELECT * FROM passage_category";
    String SELECT_CATEGORY_BY_ID = "SELECT * FROM passage_category WHERE id = ?";
    String SELECT_CATEGORY_BY_NAME = "SELECT * FROM passage_category WHERE name = ?";
    String UPDATE_CATEGORY_NAME = "UPDATE passage_category SET name = ? WHERE id = ?";
    String INSERT_CATEGORY = "INSERT INTO passage_category (name) VALUES (?)";
    String DELETE_CATEGORY = "DELETE FROM passage_category WHERE id = ?";

    List<PassageCategory> findAll();

    PassageCategory findById(int id);

    PassageCategory findByName(String name);

    void updateName(int id, String name);

    void insert(String name);

    void delete(int id);
}
