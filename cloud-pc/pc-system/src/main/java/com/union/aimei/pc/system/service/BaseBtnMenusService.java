package com.union.aimei.pc.system.service;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.model.system.BaseBtnMenus;

/**
 * @author liufeihua
 */

public interface BaseBtnMenusService {

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record
     * @return
     */
    int insertSelective(BaseBtnMenus record);

    /**
     * 查询
     *
     * @param id
     * @return
     */
    BaseBtnMenus selectByPrimaryKey(Integer id);
    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(BaseBtnMenus record);
    /**
     * 查询
     * @param pageNo
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<BaseBtnMenus> selectListByConditions(Integer pageNo, Integer pageSize, BaseBtnMenus record);
}