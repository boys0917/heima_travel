package travel.service.impl;

import org.springframework.dao.DataAccessException;
import travel.dao.FavoriteDao;
import travel.dao.impl.FavoriteDaoImpl;
import travel.domain.Favorite;
import travel.service.FavoriteService;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/5/7
 * @Time 20:21
 */
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao dao = new FavoriteDaoImpl();
    @Override
    public Boolean isFavorite(int uid, int rid) {
        Favorite favorite = null;
        try {
            favorite = dao.findByUidAndRid(uid, rid);
        }catch (DataAccessException e){

        }
        return favorite != null;
    }

    @Override
    public void addFavorite(int rid, int uid) {
        try {
            dao.addFavorite(rid,uid);
        }catch (DataAccessException e){
            System.out.println(e);
        }
    }
}
