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
 * 加油包记录表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysFuelbagannal对象", description="加油包记录表")
public class SysFuelbagannal implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "记录id")
    @TableId(value = "annal_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long annalId;

    @ApiModelProperty(value = "卡号")
    private String annalCardnum;

    @ApiModelProperty(value = "ICCID")
    private String annalIccid;

    @ApiModelProperty(value = "卡状态")
    private String annalState;

    @ApiModelProperty(value = "运营商")
    private String destOperators;

    @ApiModelProperty(value = "套餐类型")
    private Integer dextRecodeType;

    @ApiModelProperty(value = "加油信息")
    private String refuelNews;

    @ApiModelProperty(value = "单价")
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
