package com.mimu.springboot.demo.config.customizer.servlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.Optional;
import java.util.UUID;

@WebListener
public class AppServletRequestListener implements ServletRequestListener {
    private static final Logger logger = LoggerFactory.getLogger(AppServletRequestListener.class);
    private static final String traceKey = "RTK";

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        MDC.clear();
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        String flag = Optional.of(sre).map(servletRequestEvent -> servletRequestEvent.getServletRequest().getParameter("flag")).orElse(null);
        String traceId = TraceContext.traceId();
        if (StringUtils.isBlank(traceId)) {
            traceId = StringUtils.replace(String.valueOf(UUID.randomUUID()), "-", "");
        }
        traceId = String.join("", "##", traceId);
        MDC.put(traceKey, traceId);
    }
}
