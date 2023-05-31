package in.gmsk.repository;

import in.gmsk.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM USERINFO",
                new BeanPropertyRowMapper<>(User.class));
    }

    public User findById(int id) {
        return jdbcTemplate
                .queryForObject("SELECT * FROM USERINFO WHERE id = ?",
                        new Object[]{id},
                        new BeanPropertyRowMapper<>(User.class));
    }
    public User findByName(String name) {
        return jdbcTemplate
                .queryForObject("SELECT * FROM USERINFO WHERE name = ?",
                        new Object[]{name},
                        new BeanPropertyRowMapper<>(User.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate
                .update("DELETE FROM USERINFO WHERE id = ?", id);
    }

    public int insert(User user) {
        return jdbcTemplate
                .update("insert into userinfo (id,name ,location, mailid)" +
                        " values(?, ?, ?, ?);",
                new Object[] {
                        user.getId(), user.getName(), user.getLocation(),
                        user.getMailId()}
                );
    }

    public int update(User user) {
        return jdbcTemplate
                .update("update userinfo set name = ?,location = ?, mailid = ?" +
                                " where id = ?;",
                        new Object[] {
                                user.getName(), user.getLocation(),
                                user.getMailId(), user.getId()}
                );
    }
}
