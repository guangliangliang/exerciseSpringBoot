package com.testkshdata.dci.testdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CoreConfig {

    /***
     *
     * 跨域请 求处理方式
     * @return
     */
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration cft = new CorsConfiguration();

        //允许写的域，不写
        cft.addAllowedOrigin("http://0.0.0.0:*");
        cft.addAllowedOrigin("http://localhost:*");
        // 本地的请求

        //发送Cookie信息
        cft.setAllowCredentials(true);

        //请求的方式
        cft.addAllowedMethod("GET");
        cft.addAllowedMethod("POST");
        cft.addAllowedMethod("PUT");
        cft.addAllowedMethod("DELETE");
        cft.addAllowedMethod("PATCH");

        //允许头的信息
        cft.addAllowedHeader("*");

        //那些请求将会被拦截
        UrlBasedCorsConfigurationSource configcore = new UrlBasedCorsConfigurationSource();
        configcore.registerCorsConfiguration("**",cft);
        return new CorsFilter(configcore);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*/**");
            }
        };
    }


}
