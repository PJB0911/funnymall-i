package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

/** 用户模块Service
 * @author PJB
 * @date 2020/4/11
 */
public interface IUserService {
    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return  用户的信息
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 用户注册
     * @param user 包含信息用户对象
     * @return 是否注册成功的信息
     */
    ServerResponse<String> register(User user);

    /**
     * 检查用户名是否有效
     * @param str 检查的字段
     * @param type  检查的类型（email or  username）
     * @return 是否校验成功信息
     */
    ServerResponse<String> checkValid(String str,String type);

    /**
     * 查询用户的密保问题
     * @param username 用户名
     * @return 当前用户的密保问题
     */
    ServerResponse selectQuestion(String username);

    /**
     * 检查密保问题答案
     * @param username 用户名
     * @param question 密保问题
     * @param answer 答案
     * @return 校验问题答案是否正确的信息
     */
    ServerResponse<String> checkAnswer(String username,String question,String answer);

    /**
     * 忘记密码后，重置密码
     * @param username  用户名
     * @param passwordNew 新密码
     * @param forgetToken 密保问题Token
     * @return  重置密码是否成功的信息
     */
    ServerResponse<String> forgetResetPassword(String username,String passwordNew,String forgetToken);

    /**
     * 登录状态中的重置用户密码
     * @param passwordOld 旧密码
     * @param passwordNew 新密码
     * @param user  用户信息
     * @return 重置密码是否成功的信息
     */
    ServerResponse<String> resetPassword(String passwordOld,String passwordNew,User user);

    /**
     * 登录状态更新个人信息
     * @param user 用户信息
     * @return 修改后的用户信息
     */
    ServerResponse<User> updateInformation(User user);

    /**
     *获取用户的详细信息
     * @param userId 用户id
     * @return 用户的详细信息
     */
    ServerResponse<User> getInformation(Integer userId);

    /** backend
     * 检查用户的角色（管理员 or 顾客）
     * @param user  用户信息
     * @return  管理员 success,其他角色error
     */
    ServerResponse checkAdminRole(User user);
}
