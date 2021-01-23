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
 * 套餐变更申请
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysMealChangeapply对象", description="套餐变更申请")
public class SysMealChangeapply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "变更申请Id")
    @TableId(value = "meal_change_apply_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mealChangeApplyId;

    @ApiModelProperty(value = "卡号")
    private String cardNum;

    @ApiModelProperty(value = "ICCID")
    private String cardIccid;

    @ApiModelProperty(value = "状态")
    private Integer cardState;

    @ApiModelProperty(value = "运营商")
    private String cardOpear;

    @ApiModelProperty(value = "类型")
    private Integer cardType;

    @ApiModelProperty(value = "当前套餐")
    private String cardCurMeal;

    @ApiModelProperty(value = "剩余流量")
    private Double cardHaveFlow;

    @ApiModelProperty(value = "到期时间")
    private Date cardTimeout;

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
