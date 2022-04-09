import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import com.Lists.ProductList;
import com.Lists.UserList;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean alreadyAdded = false;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        shoppingCartModel shoppingCartModel = null;
        ProductList productListModel1 = new ProductList();

        for(shoppingCartModel shoppingCartModel1: shoppingCartModel.shoppingCartList)
        {
            if(shoppingCartModel1.productID==id && shoppingCartModel1.userID== UserList.userID)
            {
                shoppingCartModel1.productQuantity += 1;
                alreadyAdded = true;
                break;
            }
        }

        if(!alreadyAdded) {
            UserList.userCart++;
            for(ProductList productListmodel: productListModel1.productLists )
            {

                if(productListmodel.productID == id)
                {
                    shoppingCartModel = new shoppingCartModel(productListmodel.productID, UserList.userID, productListmodel.productName,productListmodel.productPrice,1,productListmodel.imageSrc);
                    break;
                }
            }
            shoppingCartModel.shoppingCartList.add(shoppingCartModel);
        }
    }
}
