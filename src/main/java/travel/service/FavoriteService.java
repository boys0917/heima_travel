package travel.service;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 19:39
 */
public interface FavoriteService {
    /**
     * 判断是否收藏
     * @param uid
     * @param rid
     * @return
     */
    public Boolean isFavorite(int uid, int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    public void addFavorite(int rid, int uid);
}
