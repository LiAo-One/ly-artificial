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
 * 电信NB卡表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysCardDxnb对象", description="电信NB卡表")
public class SysCardDxnb implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "电信NB卡主键")
    @TableId(value = "dxnb_card_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long dxnbCardId;

    @ApiModelProperty(value = "卡号")
    private String dxnbNum;

    @ApiModelProperty(value = "ICCID")
    private String dxnbiccid;

    @ApiModelProperty(value = "运营商")
    private String dxnbOperators;

    @ApiModelProperty(value = "类别 0：年卡 ")
    private Integer cardType;

    @ApiModelProperty(value = "状态 0：正常")
    private Integer cardState;

    @ApiModelProperty(value = "激活时间")
    private Date cardActiDate;

    @ApiModelProperty(value = "过期时间")
    private Date cardTimeout;

    @ApiModelProperty(value = "提醒（0：开启:1：关闭）")
    private Integer cardRemind;

    @ApiModelProperty(value = "pms模式")
    private String cardPms;

    @ApiModelProperty(value = "批次号")
    private String cardBatchnum;

    @ApiModelProperty(value = "标签")
    private String cardLable;

    @ApiModelProperty(value = "备注")
    private String cardNote;

    @ApiModelProperty(value = " 关联（用户）")
    private Long cardRelation1;

    @ApiModelProperty(value = "用户姓名")
    private String cardUserName;

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
