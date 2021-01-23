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
 * 报警日志表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysAlarmlog对象", description="报警日志表")
public class SysAlarmlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志id")
    @TableId(value = "alarmlog_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long alarmlogId;

    @ApiModelProperty(value = "报警类型（0: 流量池-流量不足预警 1: 套餐到期提醒 2：套餐临期预警）")
    private Integer alarmlogType;

    @ApiModelProperty(value = "报警内容")
    private String alarmlogContent;

    @ApiModelProperty(value = "警报关联数量")
    private Integer relationAmount;

    @ApiModelProperty(value = "状态（0: 未查看 1: 已查看）")
    private Integer state;

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
