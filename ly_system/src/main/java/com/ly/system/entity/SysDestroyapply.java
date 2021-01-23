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
 * 销卡申请表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysDestroyapply对象", description="销卡申请表")
public class SysDestroyapply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "dest_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long destId;

    @ApiModelProperty(value = "卡号")
    private String destCardnum;

    @ApiModelProperty(value = "ICCID")
    private String destIccid;

    @ApiModelProperty(value = "状态")
    private Integer destState;

    @ApiModelProperty(value = "运营商")
    private String destOperators;

    @ApiModelProperty(value = "类型")
    private Integer destType;

    @ApiModelProperty(value = "套餐名称")
    private String destMeal;

    @ApiModelProperty(value = "激活时间")
    private Date destActivationTime;

    @ApiModelProperty(value = "到期时间")
    private Date destTimeout;

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
