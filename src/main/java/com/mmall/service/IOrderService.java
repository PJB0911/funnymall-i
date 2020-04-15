package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderVo;

import java.util.Map;

/**订单管理模块Service
 * @author PJB
 * @date 2020/4/14
 */
public interface IOrderService {
    //门户订单管理

    /**
     * 订单支付
     * @param orderNo 订单号
     * @param userId 用户id
     * @param path 上传路径
     * @return  订单二维码地址和订单号
     */
    ServerResponse pay(Long orderNo, Integer userId, String path);

    /**
     *校验支付宝支付后的回调结果
     * @param params 支付结果的参数map
     * @return 支付是否成功
     */
    ServerResponse aliCallback(Map<String,String> params);
    /**
     * 查询订单支付状态
     * @param orderNo 订单号
     * @param userId 用户id
     * @return 订单是否交易成功
     */
    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);

    /**
     * 创建订单
     * @param userId 用户id
     * @param shippingId 收货地址id
     * @return 订单信息
     */
    ServerResponse createOrder(Integer userId,Integer shippingId);

    /**
     * 取消订单
     * @param userId 用户id
     * @param orderNo 订单号
     * @return 订单是否取消成功的信息
     */
    ServerResponse<String> cancel(Integer userId, Long orderNo);
    /**
     * 获取订单的商品信息
     * @param userId 用户id
     * @return 订单的商品信息
     */
    ServerResponse getOrderCartProduct(Integer userId);
    /**
     * 获取订单详情
     * @param userId 用户id
     * @param orderNo 订单号
     * @return 订单详情
     */
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);
    /**
     * 获取用户的订单列表
     * @param userId 用户id
     * @param pageNum 页码
     * @param pageSize 每页的数量
     * @return 订单列表
     */
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);



    //后台订单管理
    /**
     * 后台获取所有订单列表
     * @param pageNum 页码
     * @param pageSize 每页的数量
     * @return 订单列表
     */
    ServerResponse<PageInfo> manageList(int pageNum,int pageSize);
    /**
     * 后台获取订单详情
     * @param orderNo 订单号
     * @return 订单详情
     */
    ServerResponse<OrderVo> manageDetail(Long orderNo);
    /**
     * 后台按订单号查找订单
     * @param orderNo 订单号
     * @param pageNum 页码
     * @param pageSize 每页的数量
     * @return 订单列表
     */
    ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);
    /**
     * 后台管理订单发货时间
     * @param orderNo 订单号
     * @return 订单列表
     */
    ServerResponse<String> manageSendGoods(Long orderNo);
}
