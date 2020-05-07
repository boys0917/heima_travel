package travel.service.impl;

import travel.dao.impl.CategoryDaoImpl;
import travel.domain.Category;
import travel.service.CategoryService;

import java.util.List;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 12:52
 */
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        CategoryDaoImpl dao = new CategoryDaoImpl();
        return dao.findAll();
    }
}
