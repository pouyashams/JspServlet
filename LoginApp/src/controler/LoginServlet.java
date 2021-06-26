package controler;

import dto.UserDetailsDTO;
import service.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        LoginService service = new LoginService();
        Boolean isAuthenticated = service.authenticate(user, password);
        if (isAuthenticated) {
            UserDetailsDTO userDetails = service.createUserInfo(user);
//            request.getSession().setAttribute("user", userDetails);
            request.setAttribute("user", userDetails);
//            response.sendRedirect("SuccessPage.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessPage.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("LoginPage.jsp");
        }
    }
}
