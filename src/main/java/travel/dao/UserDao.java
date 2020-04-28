package travel.dao;

import travel.domain.User;

/**
 * 用户数据层操作
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/4/28
 * @Time 22:01
 */
public interface UserDao {
    /**
     * 通过用户名查找
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 保存用户
     * @param user
     */
    public void save(User user);

    /**
     * 通过激活码查询用户
     * @param code
     * @return
     */
    public User findByCode(String code);

    /**
     * 更新激活状态
     * @param user
     */
    public void updateStatus(User user);

    /**
     * 通过用户名和密码进行查找
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username,String password);

}
