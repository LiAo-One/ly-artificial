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
 * 销卡记录表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysPinNumberrecord对象", description="销卡记录表")
public class SysPinNumberrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单号")
    @TableId(value = "pin_number_recode_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long pinNumberRecodeId;

    @ApiModelProperty(value = "卡号")
    private String destCardnum;

    @ApiModelProperty(value = "ICCID")
    private String destIccid;

    @ApiModelProperty(value = "卡状态")
    private String destState;

    @ApiModelProperty(value = "运营商")
    private String destOperators;

    @ApiModelProperty(value = "销号类型")
    private Integer dextRecodeType;

    @ApiModelProperty(value = "提交时间")
    private Date destRecodeCommitTime;

    @ApiModelProperty(value = "完成时间")
    private Date destRecodeOkTime;

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
