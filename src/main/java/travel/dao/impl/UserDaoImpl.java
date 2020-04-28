package travel.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import travel.dao.UserDao;
import travel.domain.User;
import travel.util.JDBCUtils;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/4/28
 * @Time 22:13
 */
public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        String sql = "select * from tab_user where username = ?";

        User user = null;
        try{
            //查询无结果会报错，这里直接返回null
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username);
        }catch (Exception e){
            return null;
        }
        return user;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByCode(String code) {
        return null;
    }

    @Override
    public void updateStatus(User user) {

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return null;
    }
}
