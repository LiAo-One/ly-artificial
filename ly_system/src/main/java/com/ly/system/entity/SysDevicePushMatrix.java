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
 * 设备推送矩阵记录
 * </p>
 *
 * @author LiAo
 * @since 2021-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysDevicePushMatrix对象", description="设备推送矩阵记录")
public class SysDevicePushMatrix implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备推送id")
    @TableId(value = "dpm_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dpmId;

    @ApiModelProperty(value = "设备表id")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dpmDevice;

    @ApiModelProperty(value = "网关编号")
    private String dpmGate;

    @ApiModelProperty(value = "片区编号")
    private String dpmArea;

    @ApiModelProperty(value = "设备编号")
    private String dpmDeviceId;

    @ApiModelProperty(value = "设备名称")
    private String dpmDeviceName;

    @ApiModelProperty(value = "项目推送识别码 表示向哪个项目推送数据")
    private String dpmProjectId;

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
