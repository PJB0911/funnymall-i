package com.mmall.dao;

import com.mmall.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单详情Mapper
 *
 * @author PJB
 * @date 2020/4/9
 */
public interface OrderItemMapper {
    /**
     * 删除订单详情
     * @param id 订单详情id
     * @return  删除的行数
     */
    int deleteByPrimaryKey(Integer id);
    /**
     * 增加订单详情
     * @param record 订单详情id
     * @return  增加的行数
     */
    int insert(OrderItem record);

    int insertSelective(OrderItem record);
    /**
     * 根据订单id查询订单详情
     * @param id 订单id
     * @return 订单详情列表
     */
    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    /**
     * 根据用户id 和订单号查询订单详情
     * @param orderNo 订单号
     * @param userId 用户id
     * @return 订单详情列表
     */
    List<OrderItem> getByOrderNoUserId(@Param("orderNo")Long orderNo, @Param("userId")Integer userId);
    /**
     * 根据订单号查询订单详情
     * @param orderNo 订单号
     * @return 订单详情列表
     */
    List<OrderItem> getByOrderNo(@Param("orderNo")Long orderNo);


    /**
     * 批量增加订单详情
     * @param orderItemList 订单详情列表
     */
    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);
}