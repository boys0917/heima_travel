package travel.service;

import travel.domain.User;

/**
 * @Author J
 * @Email jlc_game123@163.com
 * @Date 2020/4/29
 * @Time 10:56
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    public Boolean regist(User user);

    /**
     * 验证激活码
     * @param code
     * @return
     */
    public Boolean active(String code);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);
}
