package com.mk;



import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.HttpPutFormContentFilter;

@Component
public class AddPutFilter  {
    @Bean
    public HttpPutFormContentFilter getIt() {
            return new HttpPutFormContentFilter();
    }

}