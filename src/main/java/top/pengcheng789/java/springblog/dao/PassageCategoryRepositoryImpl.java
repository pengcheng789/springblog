package top.pengcheng789.java.springblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import top.pengcheng789.java.springblog.model.PassageCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * PassageCategoryRepository 实现类
 *
 * CreateDate:2017-08-11
 *
 * @author pen
 */
@Repository
public class PassageCategoryRepositoryImpl implements PassageCategoryRepository {

    private JdbcOperations jdbcOperations;

    @Autowired
    public PassageCategoryRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<PassageCategory> findAll() {
        return jdbcOperations.query(SELECT_CATEGORY_ALL, new CategoryRowMapper());
    }

    @Override
    public PassageCategory findById(int id) {
        return jdbcOperations.queryForObject(
                SELECT_CATEGORY_BY_ID, new CategoryRowMapper(), id);
    }

    @Override
    public PassageCategory findByName(String name) {
        return jdbcOperations.queryForObject(
                SELECT_CATEGORY_BY_NAME, new CategoryRowMapper(), name);
    }

    @Override
    public void updateName(int id, String name) {
        jdbcOperations.update(UPDATE_CATEGORY_NAME, name, id);
    }

    @Override
    public void insert(String name) {
        jdbcOperations.update(INSERT_CATEGORY, name);
    }

    @Override
    public void delete(int id) {
        jdbcOperations.update(DELETE_CATEGORY, id);
    }

    private static final class CategoryRowMapper
            implements RowMapper<PassageCategory> {

        @Override
        public PassageCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
            PassageCategory category = new PassageCategory();

            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));

            return category;
        }
    }
}
