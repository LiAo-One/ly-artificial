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
 * 流量池卡表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysCardFlowpool对象", description="流量池卡表")
public class SysCardFlowpool implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流量池卡主键")
    @TableId(value = "flowpool_card_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long flowpoolCardId;

    @ApiModelProperty(value = "流量池id")
    private Long flowpoolPondId;

    @ApiModelProperty(value = "卡号")
    private String flowpoolNum;

    @ApiModelProperty(value = "ICCID")
    private String flowpoolIccid;

    @ApiModelProperty(value = "运营商")
    private String operators;

    @ApiModelProperty(value = "类别 0：年卡 1：月卡")
    private Integer cardType;

    @ApiModelProperty(value = "状态 0：正常 1：停机")
    private Integer cardState;

    @ApiModelProperty(value = "年流量")
    private Double cardTitFlow;

    @ApiModelProperty(value = "已使用")
    private Double cardUsedFlow;

    @ApiModelProperty(value = "剩余流量")
    private Double cardHaveFlow;

    @ApiModelProperty(value = "激活时间")
    private Date cardActiDate;

    @ApiModelProperty(value = "过期时间")
    private Date cardTimeout;

    @ApiModelProperty(value = "批次号")
    private String cardBatchnum;

    @ApiModelProperty(value = "用户id")
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
