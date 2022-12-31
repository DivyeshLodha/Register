import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/greet")// mapping of URL with the Servlet
public class Greetingcontroller2 implements Servlet {
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("service");
        PrintWriter writer = response.getWriter();
        writer.println("HELLO WORLD"+ LocalDateTime.now());
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("destroy");
    }
}