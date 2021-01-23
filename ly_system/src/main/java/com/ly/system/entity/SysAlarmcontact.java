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
 * 报警联系人
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysAlarmcontact对象", description="报警联系人")
public class SysAlarmcontact implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "联系人id")
    @TableId(value = "contact_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long contactId;

    @ApiModelProperty(value = "联系人姓名")
    private String contactNaem;

    @ApiModelProperty(value = "联系人手机")
    private String contactPhon;

    @ApiModelProperty(value = "邮箱")
    private String contactEmail;

    @ApiModelProperty(value = "微信")
    private String contactWachat;

    @ApiModelProperty(value = "所属项目")
    private String contactProject;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "乐观锁")
    @TableField(select = false)
    @Version
    private Integer version;

    @ApiModelProperty(value = "逻辑删除")
    @TableField(select = false)
    @TableLogic
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
