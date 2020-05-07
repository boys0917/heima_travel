package travel.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import travel.dao.RouteImgDao;
import travel.domain.RouteImg;
import travel.util.JDBCUtils;

import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 19:33
 */
public class RouteImgDaoImpl implements RouteImgDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<RouteImg> findByRid(int rid) {
        String sql = "select * from tab_route_img where rid = ?";
        List<RouteImg> list = template.query(sql, new BeanPropertyRowMapper<RouteImg>(RouteImg.class), rid);

        return list;
    }
}
