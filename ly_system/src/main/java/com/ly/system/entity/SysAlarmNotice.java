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
 * 报警通知
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysAlarmNotice对象", description="报警通知")
public class SysAlarmNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "通知id")
    @TableId(value = "notice_id", type = IdType.ID_WORKER)
    @JsonFormat(shape = JsonFormat.Shape.STRING)


    private Long noticeId;

    @ApiModelProperty(value = "通知名称")
    private String noticeName;

    @ApiModelProperty(value = "设备SN")
    private String deviceSn;

    @ApiModelProperty(value = "推送间隔 分钟")
    private Double noticeInterval;

    @ApiModelProperty(value = "推送方式 0：短信 1 微信 2 邮件 3 语音 多个用 “,” 隔开")
    private String noticeTheway;

    @ApiModelProperty(value = "推送人的id，多个用“,” 隔开")
    private String noticePeople;

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
