package travel.web.servlet;

import travel.domain.PageBean;
import travel.domain.Route;
import travel.domain.User;
import travel.service.FavoriteService;
import travel.service.RouteService;
import travel.service.impl.FavoriteServiceImpl;
import travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * 关于分页管理的servlet
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 20:39
 */
@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService=new FavoriteServiceImpl();

    /**
     * 分页列出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void queryPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        String cidStr = request.getParameter("cid");
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String rname = request.getParameter("rname");
        //rname编码转换
        rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        rname = URLDecoder.decode(rname, "utf-8");

        //处理数据
        int cid=0;
        if(cidStr != null && cidStr.length()>0&&!"null".equals(cidStr)){
            cid = Integer.parseInt(cidStr);
        }
        int currentPage = 0;
        if (currentPageStr != null && currentPageStr.length() > 0) {
            currentPage = Integer.parseInt(currentPageStr.trim());
        } else {
            currentPage = 1;
        }
        int pageSize = 0;
        if (pageSizeStr != null && pageSizeStr.length() > 0) {
            pageSize = Integer.parseInt(pageSizeStr);
        } else {
            pageSize = 5;
        }

        PageBean<Route> pageBean = routeService.pageQuery(cid, currentPage, pageSize, rname);
        WriteValue(pageBean, response);
    }

    /**
     * 出巡一条旅游的信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收rid，旅游路线的id
        String rid = request.getParameter("rid");

        //调用servic方法查找并返回对象
        Route route = routeService.find(Integer.parseInt(rid));
        //写回json并传回前台页面接收
        WriteValue(route, response);
    }

    /**
     * 判断是否收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid=Integer.parseInt(request.getParameter("rid"));
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户的id
        if(user==null){
            //用户未登陆
            uid=0;
        }else {
            //用户登陆
            uid=user.getUid();
        }
        //调用service方法查看
        Boolean flag = favoriteService.isFavorite(uid, rid);
        WriteValue(flag, response);
    }

    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int rid=Integer.parseInt(request.getParameter("rid"));
        User user = (User) request.getSession().getAttribute("user");
        int uid;//用户的id
        if(user==null){
            //用户未登陆
            return ;
        }else {
            //用户登陆
            uid=user.getUid();
        }
        //调用service方法查看
        favoriteService.addFavorite(rid, uid);
    }
}
