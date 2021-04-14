package com.ly.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 设备推送规则
 * </p>
 *
 * @author LiAo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysPushRules对象", description="设备推送规则")
public class SysPushRules implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "推送规则id")
    @TableId(value = "pr_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long prId;

    @ApiModelProperty(value = "项目识别码 唯一")
    private String prProjectId;

    @ApiModelProperty(value = "主机地址")
    private String prHost;

    @ApiModelProperty(value = "端口号 如80=> :80 冒号不可缺省")
    private String prPort;

    @ApiModelProperty(value = "路径地址 如 /test   '/' 不可缺省")
    private String prAddress;

    @ApiModelProperty(value = "推送方式 get post tcp")
    private String prMode;

    @ApiModelProperty(value = "数据格式 k-v  json")
    private String prPushRules;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
