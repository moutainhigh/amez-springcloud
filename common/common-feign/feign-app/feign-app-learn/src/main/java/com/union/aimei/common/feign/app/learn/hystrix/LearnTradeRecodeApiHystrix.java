package com.union.aimei.common.feign.app.learn.hystrix;

import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.app.learn.LearnTradeRecodeFeign;
import com.union.aimei.common.model.learn.LearnTradeRecode;
import com.union.aimei.common.vo.learn.app.TradeRecodeCallBackVo;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author houji
 * @date 2018/8/20  10:20
 */
@Component(value = "app-LearnTradeRecodeFeign")
public class LearnTradeRecodeApiHystrix implements LearnTradeRecodeFeign {

    /**
     * 前端分页查询交易记录表
     *
     * @param pageNo           分页索引
     * @param pageSize         每页显示数量
     * @param learnTradeRecode 查询条件
     * @return
     */
    @Override
    public PageInfo<LearnTradeRecode> findByPageForFront(Integer pageNo, Integer pageSize, LearnTradeRecode learnTradeRecode) {
        return null;
    }

    @Override
    public List<LearnTradeRecode> queryTradeRecode(LearnTradeRecode learnTradeRecode) {
        return null;
    }

    @Override
    public ResponseMessage<LearnTradeRecode> queryTradeRecodeByOrderNo(String orderNo) {
        return null;
    }

    @Override
    public ResponseMessage tradeRecodeCallBack(TradeRecodeCallBackVo tradeRecodeBackVo) {
        return null;
    }

    /**
     * 添加交易记录表
     *
     * @param learnTradeRecode
     * @return
     */
    @Override
    public int insert(LearnTradeRecode learnTradeRecode) {
        return 0;
    }

    @Override
    public ResponseMessage<LearnTradeRecode> addObj(LearnTradeRecode learnTradeRecode) {
        return null;
    }

    /**
     * 删除交易记录表
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(int id) {
        return 0;
    }

    /**
     * 修改交易记录表
     *
     * @param learnTradeRecode
     * @return
     */
    @Override
    public int edit(LearnTradeRecode learnTradeRecode) {
        return 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnlearnTradeRecode
     */
    @Override
    public LearnTradeRecode queryById(int id) {
        return null;
    }
}