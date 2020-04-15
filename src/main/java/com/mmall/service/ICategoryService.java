package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**产品分类管理模块Service
 * @author PJB
 * @date 2020/4/12
 */
public interface ICategoryService {
    /**
     * 增加产品种类
     * @param categoryName 产品种类名字
     * @param parentId 父产品种类id
     * @return 分类是否增加成功的信息
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     *  更新产品种类
     * @param categoryId  产品种类id
     * @param categoryName 产品新种类
     * @return 分类是否更新成功的信息
     */
    ServerResponse updateCategoryName(Integer categoryId,String categoryName);


    /**
     * 查询产品的子种类的信息
     * @param categoryId 产品种类id
     * @return 该分类下的子分类列表
     */
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);
    /**
     * 递归查询本类产品的id及子类产品的id（包括子分类、孙子分类及以下等）
     * @param categoryId  产品种类id
     * @return 该分类下的所有子分类id（包括子分类、孙子分类及以下等）
     */
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
