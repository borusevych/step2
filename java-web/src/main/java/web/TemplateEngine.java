package web;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TemplateEngine {

  private final Configuration cfg;
  private final HashMap<String, Object> empty = new HashMap<>();

  public TemplateEngine(String rootFolder) {
    cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_33);
    try {
      cfg.setDirectoryForTemplateLoading(new File(
        ResourcesOps.dirUnsafe(rootFolder)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void render(String templateName, Map<String, Object> data, HttpServletResponse rs) {
    try (Writer w = rs.getWriter()) {
      cfg.getTemplate(templateName)
        .process(data, w);
    } catch (TemplateException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void render(String templateName, HttpServletResponse rs) {
    render(templateName, empty, rs);
  }


}
