package top.pengcheng789.java.springblog.dao;

import top.pengcheng789.java.springblog.model.Passage;

import java.util.List;

/**
 * Passage 数据操作相关接口
 *
 * CreateDate:2017-08-12
 *
 * @author pen
 */
public interface PassageRepository {

    String SELECT_PASSAGE_ALL = "SELECT * FROM passage ORDER BY update_date DESC";
    String SELECT_PASSAGE_BY_CATEGORY_ID = "SELECT * FROM passage WHERE category_id = ? ORDER BY update_date DESC";
    String SELECT_PASSAGE_BY_ID = "SELECT * FROM passage WHERE id = ? ORDER BY update_date DESC";
    String DELETE_PASSAGE = "DELETE FROM passage WHERE id = ?";
    String INSERT_PASSAGE = "INSERT INTO passage (id, title, author_id, category_id," +
            "create_date, update_date, content, origin_content) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_PASSAGE = "UPDATE passage SET title = ?, update_date = ?, " +
            "content = ?, origin_content = ? WHERE id = ?";

    List<Passage> findAll();

    List<Passage> findByCategoryId(int categoryId);

    Passage findById(String passageId);

    void delete(String passageId);

    void add(Passage passage);

    void update(Passage passage);
}
