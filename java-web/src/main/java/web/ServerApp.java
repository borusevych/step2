package web;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {

  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(HelloServlet.class, "/hello");

    CalcService calcService = new CalcService();
    CalculatorServlet calculatorServlet = new CalculatorServlet(calcService);
    handler.addServlet(new ServletHolder(calculatorServlet), "/calc");
    handler.addServlet(WhateverElseServlet.class, "/*");

    server.setHandler(handler);

    server.start();
    server.join();
  }

}
