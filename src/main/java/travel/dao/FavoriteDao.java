package travel.dao;

import travel.domain.Favorite;

/**
 * 收藏数据层
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 16:42
 */
public interface FavoriteDao {
    /**
     * 通过uid和rid查找favorite,查询是否有收藏
     * @param uid
     * @param rid
     * @return
     */
    public Favorite findByUidAndRid(int uid, int rid);

    /**
     * 查找收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    public void addFavorite(int rid,int uid);
}
