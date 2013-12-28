package com.mk;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.HttpPutFormContentFilter;

@Component
public class ServerCustomisation  {
	//private static final String DOC_ROOT = ".";
	
    @Bean
    public HttpPutFormContentFilter enablePutMethod() {
            return new HttpPutFormContentFilter();
    }

/*    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(9000);
        factory.setDocumentRoot(new File(DOC_ROOT));
        factory.setSessionTimeout(10, TimeUnit.MINUTES);
        return factory;
    }*/
}