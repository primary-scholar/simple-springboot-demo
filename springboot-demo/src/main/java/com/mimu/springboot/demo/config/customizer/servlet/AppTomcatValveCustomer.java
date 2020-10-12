package com.mimu.springboot.demo.config.customizer.servlet;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import javax.servlet.ServletException;
import java.io.IOException;

public class AppTomcatValveCustomer extends ValveBase {
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
    }
}
