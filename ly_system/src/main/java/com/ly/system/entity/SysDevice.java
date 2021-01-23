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
 * 设备表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysDevice对象", description="设备表")
public class SysDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备id")
    @TableId(value = "device_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long deviceId;

    @ApiModelProperty(value = "设备名称")
    private String deviceName;

    @ApiModelProperty(value = "SN")
    private String deviceSn;

    @ApiModelProperty(value = "所属项目名称")
    private String deviceProject;

    @ApiModelProperty(value = "分组")
    private String deviceGrouping;

    @ApiModelProperty(value = "地址")
    private String deviceAddress;

    @ApiModelProperty(value = "标签")
    private String deviceLabel;

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
