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
 * 设备联动记录
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysDeviceLinkage对象", description="设备联动记录")
public class SysDeviceLinkage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "联动记录id")
    @TableId(value = "linkage_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long linkageId;

    @ApiModelProperty(value = "联动名称")
    private String linkageName;

    @ApiModelProperty(value = "联动来源")
    private String linkageSource;

    @ApiModelProperty(value = "联动设备")
    private String linkageeDevice;

    @ApiModelProperty(value = "从机名称")
    private String slaveName;

    @ApiModelProperty(value = "变量名称")
    private String variableName;

    @ApiModelProperty(value = "触发条件")
    private String sparkCondition;

    @ApiModelProperty(value = "触发设备名称")
    private String deviceName;

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
