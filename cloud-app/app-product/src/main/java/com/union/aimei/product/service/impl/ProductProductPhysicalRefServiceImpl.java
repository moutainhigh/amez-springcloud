package com.union.aimei.product.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.union.aimei.common.constant.product.ProductConstant;
import com.union.aimei.common.model.product.ProductProductPhysicalRef;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByBatchVo;
import com.union.aimei.common.vo.product.app.ProductProductPhysicalRefByProductIdReturnVo;
import com.union.aimei.product.mapper.ProductProductPhysicalRefMapper;
import com.union.aimei.product.service.ProductProductPhysicalRefService;
import com.union.common.utils.CollectionUtils;
import com.union.common.utils.ResponseException;
import com.union.common.utils.ResponseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 项目-产品-关联
 *
 * @author liurenkai
 * @time 2018/2/28 15:53
 */
@Service("productProductPhysicalRefService")
public class ProductProductPhysicalRefServiceImpl implements ProductProductPhysicalRefService {
    @Resource
    private ProductProductPhysicalRefMapper productProductPhysicalRefMapper;

    @Override
    public PageInfo<ProductProductPhysicalRef> findByPageForFront(Integer pageNo, Integer pageSize, ProductProductPhysicalRef productProductPhysicalRef) {
        PageHelper.startPage(pageNo, pageSize);
        List<ProductProductPhysicalRef> list = this.productProductPhysicalRefMapper.selectListByConditions(productProductPhysicalRef);
        PageInfo<ProductProductPhysicalRef> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 添加项目-产品-关联
     *
     * @param productProductPhysicalRef
     * @return
     */
    @Override
    public int addObj(ProductProductPhysicalRef productProductPhysicalRef) {
        return this.productProductPhysicalRefMapper.insertSelective(productProductPhysicalRef);
    }

    /**
     * 删除项目-产品-关联
     *
     * @param id
     * @return
     */
    @Override
    public int deleteObjById(int id) {
        return this.productProductPhysicalRefMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改项目-产品-关联
     *
     * @param productProductPhysicalRef
     * @return
     */
    @Override
    public int modifyObj(ProductProductPhysicalRef productProductPhysicalRef) {
        return this.productProductPhysicalRefMapper.updateByPrimaryKeySelective(productProductPhysicalRef);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @returnproductProductPhysicalRef
     */
    @Override
    public ProductProductPhysicalRef queryObjById(int id) {
        ProductProductPhysicalRef model = this.productProductPhysicalRefMapper.selectByPrimaryKey(id);
        return model;
    }

    @Override
    public ResponseMessage deleteByProductId(int productId) {
        ResponseMessage responseMessage = new ResponseMessage();
        int number = this.productProductPhysicalRefMapper.deleteByProductId(productId);
        responseMessage.setData(number);
        return responseMessage;
    }

    @Override
    public ResponseMessage addBatch(ProductProductPhysicalRefByBatchVo productProductPhysicalRefByBatchVo) {
        ResponseMessage responseMessage = new ResponseMessage();
        this.productProductPhysicalRefMapper.addBatch(productProductPhysicalRefByBatchVo);
        return responseMessage;
    }

    @Override
    public ResponseMessage<List<ProductProductPhysicalRefByProductIdReturnVo>> findListByProductId(int productId) {
        ResponseMessage<List<ProductProductPhysicalRefByProductIdReturnVo>> responseMessage = new ResponseMessage<>();
        List<ProductProductPhysicalRefByProductIdReturnVo> productProductPhysicalRefList = this.productProductPhysicalRefMapper.selectListByProductIdForOrder(productId);
        if (CollectionUtils.isEmpty(productProductPhysicalRefList)) {
            responseMessage.setCode(ProductConstant.Query.EMPTY);
            responseMessage.setMessage(ProductConstant.Query.EMPTY_MSG);
            return responseMessage;
        }
        responseMessage.setData(productProductPhysicalRefList);
        return responseMessage;
    }

    @Override
    public ResponseMessage<ProductProductPhysicalRef> getByProductIdV111(int productId) {
        ResponseMessage<ProductProductPhysicalRef> responseMessage = new ResponseMessage<>();
        ProductProductPhysicalRef productProductPhysicalRef = this.productProductPhysicalRefMapper.getByProductId(productId);
        if (null == productProductPhysicalRef) {
            throw new ResponseException(ProductConstant.Query.PHYSICAL_PRODUCT_NULL, ProductConstant.Query.PHYSICAL_PRODUCT_NULL_MSG);
        }
        responseMessage.setData(productProductPhysicalRef);
        return responseMessage;
    }

}