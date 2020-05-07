package travel.dao;

import travel.domain.RouteImg;

import java.util.List;

/**
 * 路线图片数据层
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 16:43
 */
public interface RouteImgDao {
    /**
     * 查找旅游路线相关展示图片资源路径
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
