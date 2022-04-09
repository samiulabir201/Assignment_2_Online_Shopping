import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.Lists.UserList;

import static java.lang.System.out;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username-field");
        String pw = request.getParameter("password-field");
        for(UserList UserModel1:UserList.userList) {
            if (username.equals(UserModel1.userName) && pw.equals(UserModel1.password)) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", username);
                session.setMaxInactiveInterval(1800);
/*            Cookie userCookie = new Cookie("currentUser",username);
            userCookie.setMaxAge(1800);
            response.addCookie(userCookie);*/


                RequestDispatcher rd = request.getRequestDispatcher("LoginSuccessfulServlet");
                rd.forward(request, response);

            } else {
                out.println("<html><body><script>alert('Login Credential Does not match');" +
                        "window.location.replace('login.html');" +
                        "</script></body></html>");
                //response.sendRedirect("login.html");
            }
        }
    }
}
