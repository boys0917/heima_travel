package travel.service;

import travel.domain.Category;

import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 12:51
 */
public interface CategoryService {
    /**
     * 查找所有categories
     * @return
     */
    public List<Category> findAll();
}
