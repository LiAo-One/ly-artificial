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
 * 报警记录
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysAlarmRecord对象", description="报警记录")
public class SysAlarmRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备id")
    @TableId(value = "record_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long recordId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "从机名称")
    private String slaveName;

    @ApiModelProperty(value = "变量名称")
    private String variableName;

    @ApiModelProperty(value = "当前值")
    private Double currentValuet;

    @ApiModelProperty(value = "触发条件")
    private String currentSpark;

    @ApiModelProperty(value = "当前状态 0正常 1异常")
    private Integer student;

    @ApiModelProperty(value = "是否处理 0处理 1 未处理")
    private Integer isProcess;

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
