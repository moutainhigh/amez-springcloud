package com.union.aimei.system.service;

import com.aliyuncs.exceptions.ClientException;
import com.union.aimei.common.vo.system.SmsMessageVo;

import java.util.List;

/**
 * SmsService
 *
 * @author liufeihua
 * @date 2018/1/18 13:55
 */
public interface SmsService {

    /**
     * 发送短信
     * @param smsMessageVo
     * @return
     * @throws ClientException
     */
    String sendSmsCode(SmsMessageVo smsMessageVo) throws ClientException;

    /**
     * 发送短信
     * @param list
     * @throws ClientException
     */
    void sendSmsCodeList(List<SmsMessageVo> list) throws ClientException;
}
