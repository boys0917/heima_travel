package travel.dao;

import travel.domain.Route;

import java.util.List;

/**
 * 路线数据层
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 16:43
 */
public interface RouteDao {
    /**
     * 通过id查找总记录数
     * @param cid
     * @param rname
     * @return
     */
    public int findTotalCount(int  cid, String rname);

    /**
     * 根据id和刚开始的查找的数量返回集合数据
     * @param cid
     * @param start
     * @param pageSize
     * @param rname
     * @return
     */
    public List<Route> findByPage(int cid,int start,int pageSize,String rname);

    /**
     * 通过rid查找route对象里的数据
     * @param rid
     * @return
     */
    public Route findByRid(int rid);
}
