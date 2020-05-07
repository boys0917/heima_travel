package travel.dao;

import travel.domain.Category;

import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 12:40
 */
public interface CategoryDao  {
    /**
     * 返回categories
     * @return
     */
    public List<Category> findAll();
}
