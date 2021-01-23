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
@ApiModel(value="SysSimrealname对象", description="解绑卡机表")
public class SysSimrealname implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "实名认证id")
    @TableId(value = "simrealname_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long simrealnameId;

    @ApiModelProperty(value = "卡号")
    private String annalCardnum;

    @ApiModelProperty(value = "ICCID")
    private String annalIccid;

    @ApiModelProperty(value = "运营商")
    private String destOperators;

    @ApiModelProperty(value = "状态（0: 已实名 1: 未实名）")
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
