package com.cloud.telemetry.demo;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class CustomizationBean
  implements EmbeddedServletContainerCustomizer {
  
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {        
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
        container.addErrorPages(new ErrorPage("/errorHeaven"));
    }


@RequestMapping("/errorHeaven")
String errorHeaven() {
    return "You have reached the heaven of errors!!!";
}


}