import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.Lists.UserList;

@WebServlet(name = "purchaseServlet", value = "/purchaseServlet")
public class purchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserList.userCart = 0;
        shoppingCartModel.shoppingCartList.removeIf(item->item.userID==UserList.userID);
    }
}
