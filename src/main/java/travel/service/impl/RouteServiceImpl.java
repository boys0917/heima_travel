package travel.service.impl;

import travel.dao.FavoriteDao;
import travel.dao.RouteDao;
import travel.dao.RouteImgDao;
import travel.dao.SellerDao;
import travel.dao.impl.FavoriteDaoImpl;
import travel.dao.impl.RouteDaoImpl;
import travel.dao.impl.RouteImgDaoImpl;
import travel.dao.impl.SellerDaoImpl;
import travel.domain.PageBean;
import travel.domain.Route;
import travel.domain.RouteImg;
import travel.domain.Seller;
import travel.service.RouteService;

import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 20:21
 */
public class RouteServiceImpl implements RouteService {
    private RouteDao dao=new RouteDaoImpl();
    private RouteImgDao imgDao=new RouteImgDaoImpl();
    private SellerDao sellerDao=new SellerDaoImpl();
    private FavoriteDao favoriteDao=new FavoriteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pageBean = new PageBean<>();

        int totalCount=dao.findTotalCount(cid,rname);
        pageBean.setTotalCount(totalCount);

        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        int totalPage = (totalCount%pageSize==0)?totalCount/pageSize:totalCount/pageSize+1;
        pageBean.setTotalPage(totalPage);

        //从start开始查询
        int start = (currentPage-1)*pageSize;
        List<Route> list = dao.findByPage(cid, currentPage, pageSize, rname);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public Route find(int rid) {
        //查找route对象
        Route route=dao.findByRid(rid);
        //查找旅游路线的图片
        List<RouteImg> routeImgeList=imgDao.findByRid(rid);
        //查找旅游路线的卖家信息
        Seller seller=sellerDao.findById(route.getSid());

        route.setRouteImgList(routeImgeList);
        route.setSeller(seller);
        //查找收藏的次数
        int count=favoriteDao.findCountByRid(rid);
        route.setCount(count);
        return route;
    }
}
