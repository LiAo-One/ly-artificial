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
 * 套餐变更记录
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysMealRecode对象", description="套餐变更记录")
public class SysMealRecode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单号")
    @TableId(value = "meal_change_recode_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long mealChangeRecodeId;

    @ApiModelProperty(value = "卡号")
    private String cardNum;

    @ApiModelProperty(value = "ICCID")
    private String cardIccid;

    @ApiModelProperty(value = "运营商")
    private String cardOpear;

    @ApiModelProperty(value = "状态")
    private Integer state;

    @ApiModelProperty(value = "老套餐名")
    private String oldMealName;

    @ApiModelProperty(value = "新套餐名")
    private String newMealName;

    @ApiModelProperty(value = "单价格")
    private Double unitPrice;

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
