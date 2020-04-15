package com.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * 定义系统中各种常量
 *
 * @author PJB
 * @date 2020/4/11
 */
public class Const {
    /**
     *  当前用户
     */
    public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";         //用户检验字段的类型
    public static final String USERNAME = "username";   //用户检验字段的类型
    /**
     * Product排序参数：asc |  desc
     */
    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price_desc", "price_asc");
    }
    /**
     * 角色分类：普通用户、管理员
     */
    public interface Role {
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }

    /**
     * 1. 购物车中商品选中状态：CHECKED、UNCHECKED
     * 2. 返回给前端购物车中数量是否超过该商品库存数量
     */
    public interface Cart {
        int CHECKED = 1;    //即购物车选中状态
        int UN_CHECKED = 0; //购物车中未选中状态

        String LIMIT_NUM_FAIL = "LIMIT_NUM_FAIL";  //库存数量小于等于购物车中数量
        String LIMIT_NUM_SUCCESS = "LIMIT_NUM_SUCCESS"; //库存数量大于等于购物车中数量
    }

    /**
     * 商品的状态：在售-1、下架-2、删除-3
     */
    public enum ProductStatus {
        ON_SALE(1, "在售"),
        OFF_SALE(2, "下架"),
        DELETED(3, "删除");
        private String value;
        private int code;

        ProductStatus(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }

    /**
     * 订单状态
     */
    public enum OrderStatus {
        CANCELED(0, "已取消"),
        NO_PAY(10, "未支付"),
        PAID(20, "已付款"),
        SHIPPED(40, "已发货"),
        ORDER_SUCCESS(50, "订单完成"),
        ORDER_CLOSE(60, "订单关闭");


        OrderStatus(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
        /**
         * 根据订单状态的code寻找对应的订单状态枚举类
         *
         * @param code 待查找的订单状态枚举类的code
         * @return 查找成功返回对应订单状态枚举类，查找失败抛出RuntimeException
         */
        public static OrderStatus codeOf(int code) {
            for (OrderStatus orderStatus : values()) {
                if (orderStatus.getCode() == code) {
                    return orderStatus;
                }
            }
            throw new RuntimeException("未有找到对应的枚举");
        }
    }
    /**
     * Alipay的回调常量
     */
    public interface AlipayCallback {
        String TRADE_STATUS_WAIT_BUYER_PAY = "WAIT_BUYER_PAY"; //等待付款
        String TRADE_STATUS_TRADE_SUCCESS = "TRADE_SUCCESS"; //交易成功
        String TRADE_STATUS_TRADE_FINISHED ="TRADE_FINISHED"; //交易完成

        String RESPONSE_SUCCESS = "success";
        String RESPONSE_FAILED = "failed";
    }

    /**
     * 支付平台：支付宝-1 微信支付-2
     */
    public enum PayPlatform {
        ALIPAY(1, "支付宝"),
        WECHATPAY(2, "微信支付");

        PayPlatform(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        /**
         * 根据code查找对应的支付平台枚举类
         *
         * @param code 待查找支付平台枚举类的code
         * @return 查找成功返回对应的支付平台枚举类，查找失败抛出RuntimeException
         */
        public static PayPlatform codeOf(int code) {
            for (PayPlatform payPlatform : values()) {
                if (payPlatform.getCode() == code) {
                    return payPlatform;
                }
            }
            throw new RuntimeException("没有找到对应枚举类");
        }
    }
    /**
     * 支付类型
     */
    public enum PaymentType {
        ONLINE_PAY(1, "在线支付"),
        CASH_PAY(2, "现金支付");
        PaymentType(int code, String value) {
            this.code = code;
            this.value = value;
        }

        private String value;
        private int code;

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }

        /**
         *  根据支付类型码code返回对应的支付类型枚举类
         * @param code 查找的支付类型枚举类的code
         * @return 查找成功返回对应支付类型枚举类，查找失败抛出RuntimeException
         */
        public static PaymentType codeOf(int code) {
            for (PaymentType paymentType : values()) {
                if (paymentType.getCode() == code) {
                    return paymentType;
                }
            }
            throw new RuntimeException("未找到对应的枚举");
        }

    }


}
