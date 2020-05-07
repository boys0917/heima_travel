package travel.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import travel.dao.SellerDao;
import travel.domain.RouteImg;
import travel.domain.Seller;
import travel.util.JDBCUtils;

import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 19:35
 */
public class SellerDaoImpl implements SellerDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Seller findById(int rid) {
        String sql = "select * from tab_seller where rid = ?";
        Seller seller = null;
        try{
            seller = template.queryForObject(sql, new BeanPropertyRowMapper<Seller>(Seller.class), rid);
        }catch (DataAccessException e){

        }

        return seller;
    }
}
