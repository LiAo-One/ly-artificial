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
 * 续期申请表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysRenewal对象", description="续期申请表")
public class SysRenewal implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "续期申请Id")
    @TableId(value = "renewal_apply_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long renewalApplyId;

    @ApiModelProperty(value = "申请卡号")
    private String renewNum;

    @ApiModelProperty(value = "ICCID")
    private String renewIccid;

    @ApiModelProperty(value = "状态")
    private Integer renewStatue;

    @ApiModelProperty(value = "运营商")
    private String renewOperator;

    @ApiModelProperty(value = "卡号类别（1--》 流量卡 、 2 ---电信NB卡）")
    private Integer renewType;

    @ApiModelProperty(value = "当前套餐")
    private String renewSetmeal;

    @ApiModelProperty(value = "剩余流量")
    private Double mealLastflow;

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
