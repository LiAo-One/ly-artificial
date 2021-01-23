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
 * 维保计划表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysPlanMaintain对象", description="维保计划表")
public class SysPlanMaintain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "维保计划id")
    @TableId(value = "plan_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long planId;

    @ApiModelProperty(value = "维保计划名称")
    private String planName;

    @ApiModelProperty(value = "所属项目")
    private String planProject;

    @ApiModelProperty(value = "维保设备SN")
    private String planDeviceSn;

    @ApiModelProperty(value = "计划状态0 待处理 1 已派单 2 执行中 3 已经结束")
    private Integer planStudent;

    @ApiModelProperty(value = "计划类型 0保内维保")
    private Integer planType;

    @ApiModelProperty(value = "下次维保时间")
    private Date nextTime;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
