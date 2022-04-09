import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.Lists.UserList;

// This Servlet is used to remove Item From Shopping Cart

@WebServlet(name = "deleteCartServlet", value = "/deleteCartServlet")
public class deleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserList.userCart--;
        shoppingCartModel.shoppingCartList.removeIf(item->item.productID==id);
    }
}
