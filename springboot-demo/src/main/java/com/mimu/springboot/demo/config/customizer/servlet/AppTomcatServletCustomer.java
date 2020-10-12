package com.mimu.springboot.demo.config.customizer.servlet;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

public class AppTomcatServletCustomer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addEngineValves(new AppTomcatValveCustomer());
    }
}
