package com.union.aimei.pc.api.system;

import com.union.aimei.aop.logs.WebLog;
import com.union.aimei.aop.logs.WebLogService;
import com.union.aimei.aop.logs.WebLogVo;
import com.union.aimei.common.feign.pc.system.WebLogFeign;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * WebLogController
 *
 * @author liufeihua
 * @date 2018/4/11 11:46
 */
@Api(tags = "日志", description = "api")
@RestController
@RequestMapping("/webLogs")
public class WebLogController {

    @Autowired
    WebLogFeign logService;

    @ApiOperation("查询日志表")
    @RequestMapping(value = "/selectListByConditions", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseMessage<WebLogVo> findAll(@ApiParam(value = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "0") Integer pageNo,
                                             @ApiParam(value = "每页数量", defaultValue = "10") @RequestParam(defaultValue = "10") Integer pageSize,
                                             @RequestBody WebLog record) {
        return logService.findList(pageNo, pageSize, record);
    }
}
