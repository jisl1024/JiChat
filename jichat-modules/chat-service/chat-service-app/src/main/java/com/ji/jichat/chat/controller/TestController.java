package com.ji.jichat.chat.controller;


import com.ji.jichat.chat.mq.producer.ChatMessageProducer;
import com.ji.jichat.common.pojo.CommonResult;
import com.ji.jichat.user.api.UserRpc;
import com.ji.jichat.user.api.vo.LoginUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@Tag(name = "测试Controller ")
@RequestMapping("/test")
public class TestController {

    @Resource
    private ChatMessageProducer chatMessageProducer;

    @Resource
    private UserRpc userRpc;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    @Operation(summary = "test")
    public CommonResult<String> test() {
        return CommonResult.success("成功");
    }


    @GetMapping("/sendMessage")
    @Operation(summary = "sendMessage")
    public CommonResult<String> sendMessage(String message) {
        chatMessageProducer.sendMessage(message, "122222");
        return CommonResult.success("成功");
    }

    @GetMapping("/rpcTest")
    @Operation(summary = "rpcTest")
    public CommonResult<LoginUser> rpcTest(String loginKey) {
        final CommonResult<LoginUser> loginUserCommonResult = userRpc.getLoginUserByLoginKey(loginKey);
        loginUserCommonResult.checkError();
        return CommonResult.success(loginUserCommonResult.getData());
    }


    @GetMapping("/getRedisCache")
    @Operation(summary = "getRedisCache")
    public CommonResult<Object> getRedisCache(String key) {
        final Object o = redisTemplate.opsForValue().get(key);
        return CommonResult.success(o);
    }


    @GetMapping("/getKeysWithPrefix")
    @Operation(summary = "getKeysWithPrefix")
    public List<String> getKeysWithPrefix(String prefix) {
        final Set keys = redisTemplate.keys(prefix + "*");
        final ArrayList<String> list = new ArrayList<>();
        for (Object key : keys) {
            final Object o = redisTemplate.opsForValue().get(key);
            list.add(key + "============" + (o != null ? o.toString() : null));
        }
        return list;
    }


}
