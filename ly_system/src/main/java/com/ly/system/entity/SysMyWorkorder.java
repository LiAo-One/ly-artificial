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
 * 我的工单
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysMyWorkorder对象", description="我的工单")
public class SysMyWorkorder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "workorder_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long workorderId;

    @ApiModelProperty(value = "工单编号")
    private Long repairId;

    @ApiModelProperty(value = "所属项目")
    private String workorderProject;

    @ApiModelProperty(value = "维保设备SN")
    private String workorderDeviceSn;

    @ApiModelProperty(value = "故障描述")
    private String workorderDescribe;

    @ApiModelProperty(value = "报修人邮箱")
    private String workorderEmail;

    @ApiModelProperty(value = "工单状态 0进行中 1已结单")
    private Integer workorderStudent;

    @ApiModelProperty(value = "工单类型0 常规维保 1 故障维保")
    private Integer workorderType;

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
