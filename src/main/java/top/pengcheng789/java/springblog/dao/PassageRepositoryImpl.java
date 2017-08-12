package top.pengcheng789.java.springblog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import top.pengcheng789.java.springblog.model.Passage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Passage Repository 实现类
 *
 * CreateDate:2017-08-12
 *
 * @author pen
 */
@Repository
public class PassageRepositoryImpl implements PassageRepository{

    private JdbcOperations jdbcOperations;

    @Autowired
    public PassageRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public List<Passage> findAll() {
        return jdbcOperations.query(SELECT_PASSAGE_ALL, new PassageRowMapper());
    }

    @Override
    public List<Passage> findByCategoryId(int id) {
        return jdbcOperations.query(SELECT_PASSAGE_BY_CATRGORY_ID,
                new PassageRowMapper(), id);
    }

    private static final class PassageRowMapper implements RowMapper<Passage> {

        @Override
        public Passage mapRow(ResultSet rs, int rowNum) throws SQLException {
            Passage passage = new Passage();

            passage.setId(rs.getString("id"));
            passage.setAuthor_id(rs.getString("author_id"));
            passage.setTitle(rs.getString("title"));
            passage.setCategory_id(rs.getInt("category_id"));
            passage.setCreateDate(rs.getDate("create_date"));
            passage.setUpdateDate(rs.getDate("update_date"));
            passage.setContent(rs.getString("content"));

            return passage;
        }
    }
}
