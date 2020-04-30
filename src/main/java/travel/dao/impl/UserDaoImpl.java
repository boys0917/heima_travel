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
        String sql = "insert into tab_user(username,password,name,birthday,sex,telephone,email,status,code) values" +
                "(?,?,?,?,?,?,?,?,?)";
        template.update(sql, user.getUsername(), user.getPassword(),
                user.getName(), user.getBirthday(),
                user.getSex(), user.getTelephone(),
                user.getEmail(),user.getStatus(),
                user.getCode());
    }

    @Override
    public User findByCode(String code) {
        String sql = "select * from tab_user where code = ?";

        User user = null;
        try{
            //查询无结果会报错，这里直接返回null
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),code);
        }catch (Exception e){
            return null;
        }
        return user;
    }

    @Override
    public void updateStatus(User user) {
        String sql = "update tab_user set status='Y' where uid = ?";
        template.update(sql,user.getUid());
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "select * from tab_user where username = ? and password = ?";
        User user = null;
        try{
            //查询无结果会报错，这里直接返回null
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),username,password);
        }catch (Exception e){
            return null;
        }
        return user;
    }
}
