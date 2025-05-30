package com.ji.jichat.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ji.jichat.mybatis.core.dataobject.BaseDO;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
* <p>
    * 手机验证码
    * </p>
*
* @author jisl
* @since 2024-11-08
*/
@EqualsAndHashCode(callSuper = true)
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@TableName("system_sms_code")
@Schema( description = "手机验证码")
public class SystemSmsCode extends BaseDO {


    @Schema(description = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "验证码")
    private String code;

    @Schema(description = "创建 IP")
    private String createIp;

    @Schema(description = "发送场景")
    private Integer scene;

    @Schema(description = "今日发送的第几条")
    private Integer todayIndex;

    @Schema(description = "是否使用")
    private Integer used;

    @Schema(description = "使用时间")
    private Date usedTime;

    @Schema(description = "使用 IP")
    private String usedIp;


}
