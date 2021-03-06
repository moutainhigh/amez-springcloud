package com.union.aimei.common.vo.im.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 文件消息内容
 *
 * @author liurenkai
 * @time 2017/11/30 16:54
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "文件消息内容")
public class MsgContentFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("消息类型")
    private String type = "file";
    @ApiModelProperty("成功上传文件返回的UUID")
    private String url;
    @ApiModelProperty("指定一个文件名")
    private String fileName;
    @ApiModelProperty("成功上传文件后返回的secret")
    private String secret;
}