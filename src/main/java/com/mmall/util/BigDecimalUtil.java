package com.mmall.util;

import java.math.BigDecimal;

/**
 * 数值处理工具类
 *
 * @author PJB
 * @date 2020/4/11
 */

public class BigDecimalUtil {

    private BigDecimalUtil() {

    }

    /**
     * 两数相加
     * @param v1 数值1
     * @param v2 数值2
     * @return 结果 v1+v2
     */
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2);
    }
    /**
     * 两数相减
     * @param v1 数值1
     * @param v2 数值2
     * @return 结果v1-v2
     */
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }


    /**
     * 两数相乘
     * @param v1 数值1
     * @param v2 数值2
     * @return 结果v1 * v2
     */
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    /**
     * 两数相除
     * @param v1 被除数
     * @param v2 除数
     * @return 结果 v1 / v2
     */
    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP); //四舍五入,保留2位小数

        //除不尽的情况
    }


}
