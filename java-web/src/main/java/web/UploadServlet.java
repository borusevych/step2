package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

public class UploadServlet extends HttpServlet {

  private final TemplateEngine te;

  public UploadServlet(TemplateEngine te) {
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
    te.render("upload_form.ftl", rs);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    for (Part part : req.getParts()) {
      String submittedFileName = part.getSubmittedFileName();
      InputStream is = part.getInputStream();

      try (
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        Writer w = resp.getWriter()
      ) {
        StringBuilder stringBuilder = new StringBuilder("Contents uploaded:\n");
        stringBuilder.append("------------\n");
        String line;
        while ((line = reader.readLine()) != null) {
          stringBuilder.append(line).append("\n");
        }
        stringBuilder.append("\n------------");
        w.write(stringBuilder.toString());
      }
    }
  }
}
