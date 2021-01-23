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
 * 续期记录表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysRenewalrecord对象", description="续期记录表")
public class SysRenewalrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "续期记录id")
    @TableId(value = "renewalrecord_id", type = IdType.ID_WORKER)
    private Long renewalrecordId;

    @ApiModelProperty(value = "续期申请卡号")
    private String cardNum;

    @ApiModelProperty(value = "ICCID")
    private String cardIccid;

    @ApiModelProperty(value = "运营商")
    private String cardOperator;

    @ApiModelProperty(value = "状态")
    private Integer student;

    @ApiModelProperty(value = "续期申请套餐类别")
    private Integer mealType;

    @ApiModelProperty(value = "套餐单价")
    private Double mealUnitprice;

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
