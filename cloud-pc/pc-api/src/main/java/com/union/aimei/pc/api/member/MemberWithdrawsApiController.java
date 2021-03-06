package com.union.aimei.pc.api.member;


import com.github.pagehelper.PageInfo;
import com.union.aimei.common.feign.pc.member.MemberWithdrawsFeign;
import com.union.aimei.common.model.member.MemberWithdraws;
import com.union.aimei.common.vo.member.MemberWithdrawsVo;
import com.union.common.utils.AssertUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.constant.ResponseContants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author houji
 */
@Api(tags="会员提现申请表")
@RestController
@RequestMapping(value="memberWithdraws")
public class MemberWithdrawsApiController {
       @Resource
       private MemberWithdrawsFeign memberWithdrawsFeign;

       /**
     * 分页查询
     * @param pageNo  分页索引
     * @param pageSize  每页显示数量
     * @param memberWithdraws 查询条件
     * @return ResponseMessage<MemberWithdraws>
     */
       @ApiOperation(httpMethod="POST", value="前端分页查询会员提现申请表")
       @PostMapping("/front/findByPage")
       public ResponseMessage<MemberWithdraws> findByPageForFront(@ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")
	 Integer pageNo, @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")
	 Integer pageSize, @ApiParam(value="查询条件") @RequestBody MemberWithdraws memberWithdraws) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberWithdraws> page=memberWithdrawsFeign.findByPageForFront(pageNo, pageSize,memberWithdraws);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 添加MemberWithdraws
        * @param memberWithdraws
        * @return
        */
       @ApiOperation(httpMethod="POST", value="添加会员提现申请表")
       @PostMapping("/insert")
       public ResponseMessage insert(@RequestBody MemberWithdraws memberWithdraws) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberWithdrawsFeign.insert(memberWithdraws);
              AssertUtil.numberGtZero(res,ResponseContants.ADD_MESSAGE,ResponseContants.ADD);
              return result;
       }

       /**
        * 删除MemberWithdraws
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="DELETE", value="删除会员提现申请表")
       @DeleteMapping("/deleteById/{id}")
       public ResponseMessage deleteById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberWithdrawsFeign.deleteById(id);
              AssertUtil.numberGtZero(res,ResponseContants.DELETE_MESSAGE,ResponseContants.DELETE);
              return result;
       }

       /** 
        * 修改MemberWithdraws
        * @param memberWithdraws
        * @return
        */
       @ApiOperation(httpMethod="PUT", value="编辑会员提现申请表")
       @PutMapping("/edit")
       public ResponseMessage edit(@RequestBody MemberWithdraws memberWithdraws) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              int res=this.memberWithdrawsFeign.edit(memberWithdraws);
              AssertUtil.numberGtZero(res,ResponseContants.EDIT_MESSAGE,ResponseContants.EDIT);
              return result;
       }

       /**
        * 根据ID查询MemberWithdraws
        * @param id
        * @returnmemberWithdraws
        */
       @ApiOperation(httpMethod="GET", value="通过ID查询会员提现申请表")
       @GetMapping("/queryById/{id}")
       public ResponseMessage<MemberWithdraws> queryById(@PathVariable (value="id") int id) {
              ResponseMessage result = ResponseMessageFactory.newInstance();
              MemberWithdraws model=this.memberWithdrawsFeign.queryById(id);
              AssertUtil.notNull(model,ResponseContants.QUERY_EMPTY_MESSAGE,ResponseContants.QUERY_EMPTY);
              result.setData(model);
              return result;
       }

       /**
        * 会员(美容师或店长)的提现管理
        * @return
        */
       @ApiOperation(httpMethod = "POST",value = "会员(美容师或店长)的提现管理")
       @PostMapping("/withdrawalsManager")
       public ResponseMessage withdrawalsManager(
               @ApiParam(value="分页索引",defaultValue="0")  @RequestParam(value="pageNo",defaultValue="0")Integer pageNo,
               @ApiParam(value="每页数量",defaultValue="10")  @RequestParam(value="pageSize",defaultValue="10")Integer pageSize,
               @ApiParam(value="查询条件") @RequestBody MemberWithdrawsVo memberWithdrawsVo){
              ResponseMessage result = ResponseMessageFactory.newInstance();
              PageInfo<MemberWithdraws> page=memberWithdrawsFeign.findByPageManager(pageNo, pageSize,memberWithdrawsVo);
              if(page!=null){
                     result.setData(page);
              }else{
                     result.setCode(ResponseContants.QUERY_EMPTY);
                     result.setMessage(ResponseContants.QUERY_EMPTY_MESSAGE);
              }
              return result;
       }

       /**
        * 批量处理会员申请提款
        * @param id
        * @return
        */
       @ApiOperation(httpMethod="POST", value="批量打款(批量处理会员申请提现打款操作)")
       @PostMapping("/updateBatch")
       public void updateBatch(@RequestBody List<Integer> id) {
              this.memberWithdrawsFeign.updateBatch(id);
       }
}