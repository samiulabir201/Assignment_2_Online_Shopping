import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginSuccessfulServlet", value = "/LoginSuccessfulServlet")
public class LoginSuccessfulServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = null;
        Cookie[] cookies = request.getCookies();
        /*String user= null;
        if(cookies==null){
            response.sendRedirect("login.html");
        }else {
            for(Cookie c:cookies){
                if(c.getName().equals("currentUser")){
                    user = c.getValue();
                }
            }
        }*/
        String jSessionId = null;
        HttpSession session = request.getSession();
        if (session.getAttribute("currentUser") == null) {
            response.sendRedirect("/login.html");
        } else {
            user = session.getAttribute("currentUser").toString();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    jSessionId = cookie.getValue();
                }
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<h1> Welcome " + user + "</h1>");
        out.println("<h3>Click 'Product Page' to go to product page</h3>");

        out.println("<a href='ProductList.jsp'>Product Page</a> <form method = \"post\" action = \"LogOutServlet\"> <input type=\"submit\" value=\"Log out\">  </form> ");
    }
}
