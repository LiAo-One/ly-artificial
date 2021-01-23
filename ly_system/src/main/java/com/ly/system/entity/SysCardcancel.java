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
 * 解绑卡机表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysCardcancel对象", description="解绑卡机表")
public class SysCardcancel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "解绑记录表ID")
    @TableId(value = "cancel_card_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long cancelCardId;

    @ApiModelProperty(value = "卡号")
    private String annalCardnum;

    @ApiModelProperty(value = "ICCID")
    private String annalIccid;

    @ApiModelProperty(value = "状态（0: 成功 1: 失败）")
    private Integer state;

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
