import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class Tom implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return getServletConfig() ;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //reading from the client
        String FirstName = request.getParameter("FirstName");
        String LastName = request.getParameter("lastName");
        String Email = request.getParameter("email");

        //write data to the database
        String url="jdbc:mysql://localhost:3306/csj25";
        String username="root";
        String password="Java@123";
        String query = "insert into student( FirstName, LastName, Email) values(?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1,1);
            preparedStatement.setString(1,FirstName);
            preparedStatement.setString(2,LastName);
            preparedStatement.setString(3,Email);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //writing back to the client
        PrintWriter writer = response.getWriter();
        writer.println("Successfully registered " + FirstName + "\t" + LastName + "\t" + Email);

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}