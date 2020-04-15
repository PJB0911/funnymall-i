package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Mapper
 *
 * @author PJB
 * @date 2020/4/19
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增用户
     *
     * @param record 用户信息
     * @return 添加的行数
     */
    int insert(User record);

    int insertSelective(User record);

    /**
     * 检索用户
     *
     * @param id 用户id
     * @return 用户信息
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 更新用户不为空的字段
     *
     * @param record 用户
     * @return 更新的行数
     */
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名检索用户是否存在
     *
     * @param username 用户名
     * @return 返回的行数
     */
    int checkUsername(String username);

    /**
     * 根据邮箱检索用户是否存在
     *
     * @param email 邮箱
     * @return 返回的行数
     */
    int checkEmail(String email);

    /**
     * 用于用户登陆
     * 根据用户名和密码检索用户是否存在
     *
     * @param username 用户名
     * @param password 密码
     * @return 检索到的用户对象
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询密保问题
     *
     * @param username 用户名
     * @return 密保问题
     */
    String selectQuestionByUsername(String username);

    /**
     * 检验用户密保问题
     *
     * @param username 用户名
     * @param question 密保问题
     * @param answer   答案
     * @return 行数
     */
    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    /**
     * 更新密码
     *
     * @param username    用户名
     * @param passwordNew 新密码
     * @return 行数
     */
    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);

    /**
     * 根据用户id检索密码
     *
     * @param password 密码
     * @param userId   用户id
     * @return 行数
     */
    int checkPassword(@Param("password") String password, @Param("userId") Integer userId);

    /**
     * 根据用户id检索邮箱
     *
     * @param email  邮箱
     * @param userId 用户id
     * @return 行数
     */
    int checkEmailByUserId(@Param("email") String email, @Param(value = "userId") Integer userId);
}