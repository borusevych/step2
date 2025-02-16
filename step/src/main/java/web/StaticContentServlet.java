package web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StaticContentServlet extends HttpServlet {

  private final String prefix;

  public StaticContentServlet(String prefix) {
    this.prefix = ResourcesOps.dirUnsafe(prefix);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String fileName = req.getPathInfo();
    String fullName = prefix + fileName;

    System.out.println(fileName);
    System.out.println(fullName);

    if (!new File(fullName).exists()) {
      resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
    } else try (ServletOutputStream os = resp.getOutputStream()) {
      Path in = Paths.get(fullName);
      Files.copy(in, os);
    }
  }
}
