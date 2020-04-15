package com.mmall.dao;

import com.mmall.pojo.Category;

import java.util.List;

/**
 * 产品分类Mapper
 *
 * @author PJB
 * @date 2020/4/19
 */
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加产品种类
     *
     * @param record 产品种类
     * @return 增加的行数
     */
    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    /**
     * 更新产品种类
     *
     * @param record 产品种类
     * @return 更新的行数
     */
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    /**
     * 查询子类产品
     *
     * @param parentId 父类产品
     * @return 子类产品list
     */
    List<Category> selectCategoryChildrenByParentId(Integer parentId);
}