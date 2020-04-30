package travel.service.impl;

import travel.dao.UserDao;
import travel.dao.impl.UserDaoImpl;
import travel.domain.User;
import travel.service.UserService;
import travel.util.MailUtils;
import travel.util.UuidUtil;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/4/29
 * @Time 10:58
 */
public class UserServiceImpl implements UserService {
   private UserDao dao = new UserDaoImpl();

    @Override
    public Boolean regist(User user) {
        User u= dao.findByUsername(user.getUsername());
        if (u != null){
            return false;
        }

        //UUID很小概率重复
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        String context="<a href='http://localhost/travel/user/active?code="+user.getCode()+"'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(), context, "激活邮件");
        dao.save(user);
        return true;
    }

    @Override
    public Boolean active(String code) {
        //根据激活码查询用户是否存在
        User user=dao.findByCode(code);
        //设置状态为激活
        if(user!=null) {
            dao.updateStatus(user);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        return dao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
