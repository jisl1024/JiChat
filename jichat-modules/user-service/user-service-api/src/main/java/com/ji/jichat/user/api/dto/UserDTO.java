package com.ji.jichat.user.api.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 用户表DTO
 * </p>
 *
 * @author jisl
 * @since 2024-01-24
 */
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "用户表DTO")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema( description = "id主键")
    private Long id;

    @Schema( description = "用户名")
    private String username;

    @Schema( description = "密码")
    private String password;

    @Schema( description = "用户昵称")
    private String nickname;

    @Schema( description = "手机号")
    private String mobile;

    @Schema( description = "帐号状态（0停用 1正常）")
    private Integer status;

    @Schema( description = "在线状态（0离线 1在线）")
    private Integer onlineStatus;

    @Schema( description = "最后登录IP")
    private String loginIp;

    @Schema( description = "最后登录时间")
    private Date loginDate;

    @Schema( description = "是否删除(0存在 null删除,解决唯一索引冲突)")
    private Integer delFlag;


}
