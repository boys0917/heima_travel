package travel.web.servlet;

import travel.domain.Category;
import travel.domain.ResultInfo;
import travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 12:30
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询数据
        CategoryServiceImpl service = new CategoryServiceImpl();
        List<Category> list = service.findAll();
        //封装返回
        WriteValue(list,response);

    }


}
