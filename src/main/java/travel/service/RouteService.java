package travel.service;

import travel.domain.PageBean;
import travel.domain.Route;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 19:39
 */
public interface RouteService {
    /**
     * 查询记录分页
     * @param cid
     * @param currentPage
     * @param pageSize
     * @param rname
     * @return
     */
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname);

    public Route find(int rid);
}
