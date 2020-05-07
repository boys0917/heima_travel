package travel.dao;

import travel.domain.Seller;

/**
 * 卖家数据层
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 16:43
 */
public interface SellerDao {
    /**
     * 通过id查找卖家信息
     * @param rid
     * @return
     */
    public Seller findById(int rid);
}
