import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogOutServlet", value = "/LogOutServlet")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie [] cookieArray = request.getCookies();
        Cookie tempCookie = null;
        for (Cookie c:cookieArray)
        {
            if (c.getName().equals("currentUser"))
                tempCookie = c;
        }

        if (tempCookie!=null)
        {
            tempCookie.setMaxAge(0); //since cookie does not have any
            // invalidate method like HttpSession object, we need to
            // invalidate it by setting its lifetime to 0.
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body><script>alert('successfully logged out');" +
                "window.location.replace('login.html');" +
                "</script></body></html>");
    }
}