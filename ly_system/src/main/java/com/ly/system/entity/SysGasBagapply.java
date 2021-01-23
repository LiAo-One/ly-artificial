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
 * 加油包申请表
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysGasBagapply对象", description="加油包申请表")
public class SysGasBagapply implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表申请Id")
    @TableId(value = "gas_bag_apply_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long gasBagApplyId;

    @ApiModelProperty(value = "续期申请卡号")
    private String cardNum;

    @ApiModelProperty(value = "ICCID")
    private String cardIccid;

    @ApiModelProperty(value = "运营商")
    private String cardOperator;

    @ApiModelProperty(value = "当前套餐")
    private String renewSetmeal;

    @ApiModelProperty(value = "状态")
    private Integer student;

    @ApiModelProperty(value = "续期申请套餐类别")
    private Integer mealType;

    @ApiModelProperty(value = "剩余流量")
    private Double mealLastflow;

    @ApiModelProperty(value = "到期时间")
    private Date expireDate;

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
