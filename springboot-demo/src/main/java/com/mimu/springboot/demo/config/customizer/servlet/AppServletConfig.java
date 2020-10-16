package com.mimu.springboot.demo.config.customizer.servlet;

import org.apache.commons.lang3.StringUtils;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.slf4j.MDC;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import java.util.Optional;
import java.util.UUID;


/**
 * 在spring boot 中 添加 Filter,Servlet,Listener 共有两种方式
 * 1.使用spring 注解方式
 * 1.1 @ServletComponentScan, @WebFilter, @WebServlet, @webListener
 * 2.使用 RegistrationBean 进行 bean 的 注入 @Bean
 * <p>
 * author: mimu
 * date: 2020/2/5
 */

/**
 * 第一种方式 添加注解
 */
//@ServletComponentScan
@Configuration
@EnableHystrix
@EnableHystrixDashboard
public class AppServletConfig {

    /**
     * 第二种方式 通过 registrationBean的方式添加
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<ServletRequestListener> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new AppServletRequestListener());
        return registrationBean;
    }

    /*@Bean
    public ServletRegistrationBean hystrixMetricsServlet() {
        HystrixMetricsStreamServlet metricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(metricsStreamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }*/

    /*@Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new CustomFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("name", "userDataFilter");
        filterRegistrationBean.setName("userDataFilter");
        filterRegistrationBean.setOrder(10);
        return filterRegistrationBean;
    }*/

    /*@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>();
        CustomServlet servlet = new CustomServlet();
        registrationBean.setServlet(servlet);
        registrationBean.setName(servlet.getClass().getSimpleName());
        registrationBean.setUrlMappings(Collections.singleton("/customServlet"));
        registrationBean.setLoadOnStartup(2);
        return registrationBean;
    }*/

    /**
     * 第一种方式 添加注解
     */
    //@WebServlet(name = "customServlet" ,urlPatterns = "/customServlet")
    /*static class CustomServlet extends HttpServlet {
        private static final Logger logger = LoggerFactory.getLogger(CustomServlet.class);

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            logger.info("customServlet deal url={}", req.getServletPath());
            PrintWriter writer = resp.getWriter();
            writer.write("customServlet deal request");
            writer.flush();
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }

        @Override
        public void init(ServletConfig config) throws ServletException {
            logger.info("customServlet init");
        }
    }*/


    /**
     * 第一种方式 添加注解
     */
    //@WebFilter(filterName = "customFilter", urlPatterns = "/*")
    /*static class CustomFilter implements Filter {
        private static final Logger logger = LoggerFactory.getLogger(CustomFilter.class);

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            logger.info("requestInfo={}", request.getParameterMap().toString());
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {

        }
    }*/

    /**
     * 第一种方式 添加注解
     */
    //@WebListener
    class AppServletRequestListener implements ServletRequestListener {
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
            traceId = String.join("", traceId, ",", flag);
            MDC.put(traceKey, traceId);
        }
    }


}
