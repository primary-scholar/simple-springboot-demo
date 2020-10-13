package com.mimu.springboot.demo.config.customizer.servlet;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 * 与 tomcat servlet 容器 紧耦合 需依赖 tomcat-starter
 */
/*public class AppTomcatServletCustomer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.addEngineValves(new AppTomcatValveCustomer());
    }
}*/
