package com.xl.jiojionoclass.common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;
@Component
public class CommonRestTemplateBuilder {
    @Autowired
    private RestTemplateBuilder builder;
    //使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
        builder.setConnectTimeout(Duration.ofDays(60 * 1000))
                .setReadTimeout(Duration.ofDays(60 * 1000));
        return builder.build();
    }
}
