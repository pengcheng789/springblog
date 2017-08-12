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

    String SELECT_PASSAGE_ALL = "SELECT * FROM passage";
    String SELECT_PASSAGE_BY_CATRGORY_ID = "SELECT * FROM passage WHERE category_id = ?";

    List<Passage> findAll();

    List<Passage> findByCategoryId(int categoryId);
}
