import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.Lists.UserList;

//This servlet is used for increasing and decreasing quantity

@WebServlet(name = "updateQuantityServlet", value = "/updateQuantityServlet")
public class updateQuantityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int value = Integer.parseInt(request.getParameter("value"));
        for(shoppingCartModel shoppingCartModel: shoppingCartModel.shoppingCartList)
        {
            if(shoppingCartModel.productID == id && shoppingCartModel.userID == UserList.userID )
            {
                shoppingCartModel.productQuantity = value;
                break;
            }
        }
    }
}
