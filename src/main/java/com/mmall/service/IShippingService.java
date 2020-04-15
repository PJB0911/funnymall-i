package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

/**收货地址管理模块Service
 * @author PJB
 * @date 2020/4/14
 */
public interface IShippingService {
    /**
     * 新建地址
     * @param userId 用户id
     * @param shipping 收货地址
     * @return 新建地址是否成功的信息
     */
    ServerResponse add(Integer userId, Shipping shipping);

    /**
     * 删除地址
     * @param userId 用户id
     * @param shippingId 地址id
     * @return 删除地址是否成功的信息
     */
    ServerResponse<String> del(Integer userId, Integer shippingId);
    /**
     * 更新地址
     * @param userId 用户id
     * @param shipping 收货地址
     * @return 更新地址是否成功的信息
     */
    ServerResponse update(Integer userId, Shipping shipping);
    /**
     * 查看选中地址
     * @param userId 用户id
     * @param shippingId 地址id
     * @return 地址信息
     */
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    /**
     * 查看地址列表
     * @param userId 用户id
     * @param pageNum 页码
     * @param pageSize 每页的数量
     * @return 地址列表
     */
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);
}
