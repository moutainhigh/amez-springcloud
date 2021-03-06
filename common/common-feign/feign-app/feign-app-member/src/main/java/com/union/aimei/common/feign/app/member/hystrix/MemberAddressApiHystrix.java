package com.union.aimei.common.feign.app.member.hystrix;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.member.MemberAddressFeign;
import com.union.aimei.common.model.member.MemberAddress;
import org.springframework.stereotype.Component;

/**
 * @author GaoWei
 * @describe
 * @time 2017/12/8,10:38
 */
@Component(value = "app-MemberAddressFeign")
public class MemberAddressApiHystrix implements MemberAddressFeign {

    /**
     * 前端分页查询会员地址
     *
     * @param pageNo        分页索引
     * @param pageSize      每页显示数量
     * @param memberAddress 查询条件
     * @return
     */
    @Override
    public PageInfo<MemberAddress> findByPageForFront(Integer pageNo, Integer pageSize, MemberAddress memberAddress) {
        return null;
    }

    /**
     * 添加会员地址
     *
     * @param memberAddress
     * @return
     */
    @Override
    public int insert(MemberAddress memberAddress) {
        return 0;
    }

    /**
     * 删除会员地址
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改会员地址
     *
     * @param memberAddress
     * @return
     */
    @Override
    public int edit(MemberAddress memberAddress) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnmemberAddress
     */
    @Override
    public MemberAddress queryById(int id) {
        return null;
    }

    @Override
    public int setDefaultAddress(MemberAddress memberAddress) {
        return 0;
    }
}