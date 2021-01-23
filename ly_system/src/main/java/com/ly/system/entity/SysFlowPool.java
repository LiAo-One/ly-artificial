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
 * 流量池表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysFlowPool对象", description="流量池表")
public class SysFlowPool implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流量池主键")
    @TableId(value = "pool_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long poolId;

    @ApiModelProperty(value = "流量池编码")
    private String poolCode;

    @ApiModelProperty(value = "套餐信息")
    private String setmealInfo;

    @ApiModelProperty(value = "运营商")
    private String destOperators;

    @ApiModelProperty(value = "APN 名称")
    private String destApn;

    @ApiModelProperty(value = "年流量")
    private Double poolTitFlow;

    @ApiModelProperty(value = "已使用")
    private Double poolUsedFlow;

    @ApiModelProperty(value = "剩余流量")
    private Double poolHaveFlow;

    @ApiModelProperty(value = "扩容包已用流量")
    private Double poolSpreadFlow;

    @ApiModelProperty(value = "是否自动扩容 0否 1是")
    private Integer poolAutomatic;

    @ApiModelProperty(value = "成员数量")
    private Integer memberAmount;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

}
