package travel.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import travel.dao.FavoriteDao;
import travel.domain.Favorite;
import travel.util.JDBCUtils;

import java.util.Date;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 16:54
 */
public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * user id and route id
     * @param uid
     * @param rid
     * @return
     */
    @Override
    public Favorite findByUidAndRid(int uid, int rid) {
        String sql = "select * from tab_favorite where uid = ? and rid = ?";
        Favorite favorite = null;
        try{
            favorite = template.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class),uid,rid);
        }catch (DataAccessException e){

        }
        return favorite;
    }

    @Override
    public int findCountByRid(int rid) {
        String sql = " select count(*) from tab_favorite where id = ?";
        return template.queryForObject(sql, Integer.class, rid);
    }

    @Override
    public void addFavorite(int rid, int uid) {
        String sql = "insert into tab_favorite (rid, uid) values(?,?,?)";
        template.update(sql,rid,new Date(),uid);
    }
}
