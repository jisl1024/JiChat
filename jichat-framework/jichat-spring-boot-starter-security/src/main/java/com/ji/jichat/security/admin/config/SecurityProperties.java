package com.ji.jichat.security.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("security.admin")
public class SecurityProperties {

    private static final String[] DEFAULT_IGNORE_PATHS = new String[]{
            // Swagger 相关
            "/doc.html", "/swagger-resources/**", "/webjars/**","/v3/api-docs/**","/swagger-ui","/swagger-ui/**"
            // Actuator 相关
    };

    /**
     * 演示模式 - 默认值（关闭）
     */
    private static final Boolean DEFAULT_DEMO = false;

    /**
     * 自定义忽略 Path
     */
    private String[] ignorePaths = new String[0];
    /**
     * 默认忽略 Path
     */
    private String[] defaultIgnorePaths = DEFAULT_IGNORE_PATHS;
    /**
     * 是否开启演示模式
     */
    private Boolean demo = DEFAULT_DEMO;

    public String[] getIgnorePaths() {
        return ignorePaths;
    }

    public SecurityProperties setIgnorePaths(String[] ignorePaths) {
        this.ignorePaths = ignorePaths;
        return this;
    }

    public String[] getDefaultIgnorePaths() {
        return defaultIgnorePaths;
    }

    public SecurityProperties setDefaultIgnorePaths(String[] defaultIgnorePaths) {
        this.defaultIgnorePaths = defaultIgnorePaths;
        return this;
    }

    public Boolean getDemo() {
        return demo;
    }

    public SecurityProperties setDemo(Boolean demo) {
        this.demo = demo;
        return this;
    }

}
