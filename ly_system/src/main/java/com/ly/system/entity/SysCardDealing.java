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
 * 卡分配表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysCardDealing对象", description="卡分配表")
public class SysCardDealing implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卡分配id")
    @TableId(value = "dealing_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dealingId;

    @ApiModelProperty(value = "用户id")
    private Long dealingUserid;

    @ApiModelProperty(value = "账户")
    private String dealingAccount;

    @ApiModelProperty(value = "ICCID")
    private String dealingIccid;

    @ApiModelProperty(value = "运营商")
    private String operators;

    @ApiModelProperty(value = "计费类型")
    private Integer billingType;

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
