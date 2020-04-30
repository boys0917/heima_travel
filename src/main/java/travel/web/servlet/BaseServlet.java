package travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 抽取servlet，分发任务
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/4/28
 * @Time 22:37
 */

public class BaseServlet extends HttpServlet {
    /**
     * 重写HttpServlet的service进行任务的分发
     * 根据当前的访问路径进行分发
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取访问的路径
        String uri = request.getRequestURI();

        //获取方法名，一般为../页面/方法名
        String methodName = uri.substring(uri.lastIndexOf('/') + 1);
        //利用this来调用类方法，谁调用，this就是谁，虽然BaseServlet是父类
        Method method = null;
        try {
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将对象传入并以json写回客户端
     * 如果传入的是json的字符串，那么出去的也是字符串
     * @param obj
     * @param response
     * @throws IOException
     */
    public void WriteValue(Object obj, HttpServletResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(), obj);
    }

    /**
     * 将对象转化为json格式（字符串）
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public String WriteAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
