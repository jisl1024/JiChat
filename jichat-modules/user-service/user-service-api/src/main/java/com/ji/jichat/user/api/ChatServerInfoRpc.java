package com.ji.jichat.user.api;


import com.ji.jichat.common.annotions.RequiresNone;
import com.ji.jichat.common.constants.ServiceNameConstants;
import com.ji.jichat.common.pojo.CommonResult;
import com.ji.jichat.user.api.vo.ChatServerInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.v3.oas.annotations.Operation;
/**
 * ChatServerInfoRpc 接口
 */
@FeignClient(path = "/user-api/chatServerInfo", value = ServiceNameConstants.USER_SERVICE)
public interface ChatServerInfoRpc {

    @GetMapping("/getByIpAndPort")
    @RequiresNone
    @Operation(summary ="获取服务信息")
    CommonResult<ChatServerInfoVO> getByIpAndPort(@RequestParam String innerIp, @RequestParam int httpPort);


}
