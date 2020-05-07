package travel.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import travel.dao.RouteDao;
import travel.domain.Route;
import travel.util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 17:28
 */
public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     *有可能rname不输入值或者cid不输入值
     * @param cid
     * @param rname
     * @return
     */
    @Override
    public int findTotalCount(int cid, String rname) {
        String sql = "select count(*) from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        ArrayList params = new ArrayList();
        if(cid != 0){
            sb.append(" and cid = ?");
            params.add(cid);
        }
        if(rname != null && rname.length()>0 && !"null".equals(rname)){
            sb.append(" and rname like ?");
            params.add("%" + rname + "%");
        }
        sql=sb.toString();

        int count = template.queryForObject(sql,Integer.class,params.toArray());
        return count;
    }

    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
       String sql = "select * from tab_route where 1=1";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList();
        if(cid!=0){
            sb.append(" and cid=?");
            params.add(cid);

        }

        if(rname!=null&&rname.length()>0){
            sb.append(" and rname like ? ");
            params.add("%"+rname+"%");
        }
        sb.append(" limit ?,?");
        params.add(start);
        params.add(pageSize);
        sql=sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
    }

    @Override
    public Route findByRid(int rid) {
        String sql = "select * from tab_route where rid = ?";
        Route route = null;
        try {
            route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class),rid);
        }catch (DataAccessException e){

        }


        return route;
    }
}
