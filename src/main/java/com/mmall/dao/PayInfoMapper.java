package com.mmall.dao;

import com.mmall.pojo.PayInfo;

/**
 * 支付信息Mapper
 *
 * @author PJB
 * @date 2020/4/19
 */
public interface PayInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PayInfo record);

    int insertSelective(PayInfo record);

    PayInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayInfo record);

    int updateByPrimaryKey(PayInfo record);
}