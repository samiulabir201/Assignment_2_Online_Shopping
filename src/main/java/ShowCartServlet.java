import com.Lists.UserList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//This servlet is used for showing the shopping cart page

@WebServlet(name = "ShowCartServlet", value = "/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double totalPrice = 0;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<html>\n" +
                "<head>\n" +
                "    <title>Shopping Cart</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "\n" +
                "<div>"+
                "<a href=\"ProductList.jsp\">Back</a>"+
                "<a href=\"login.html\">Log Out</a></div>"+
                "    <div>\n" +
                "        <span>Item</span>\n" +
                "        <span>Price(BDT)</span>\n" +
                "        <span>Quantity</span>\n" +
                "    </div>\n" );

        for(shoppingCartModel shoppingCartModel: shoppingCartModel.shoppingCartList) {
            if (shoppingCartModel.userID == UserList.userID) {
                totalPrice += shoppingCartModel.productPrice * shoppingCartModel.productQuantity;
                out.println("    <div>\n" +
                        "        <div>\n" +
                        "            <img class=\"\" src=" + shoppingCartModel.imageSrc + " width=\"50\" height=\"50\">\n" +
                        "            <span>" + shoppingCartModel.productName + "</span>\n" +
                        "        </div>\n" +
                        "        <span>\n" +
                        "            " + shoppingCartModel.productPrice + "\n" +
                        "        </span>\n" +
                        "        <div>\n" +
                        "            <input id=\"quantity" + shoppingCartModel.productID + "\"size=\"4\" maxlength=\"4\" type=\"number\" onchange=\"updateQuantity(this.id)\" class=\"rounded-3\" value=\"" + shoppingCartModel.productQuantity + "\">\n" +
                        "            <button id=\"" + shoppingCartModel.productID + "\" class=\"btn btn-danger\" onclick=removeItem(this.id)>Remove</button>\n" +
                        "        </div>\n" +
                        "    </div>\n");
            }
        }
        out.println(
                "    <div>\n" +
                        "            <strong>Total</strong>\n" +
                        "            <span>" + totalPrice + " BDT</span>\n" +
                        "    </div>\n" +
                        "<div><button onclick=purchase()>Check Out</button></div>" +
                        "</div>\n" +
                        "<script>\n" +
                        "    function removeItem(clickedID) {\n" +
                        "        var xhttp = new XMLHttpRequest()\n" +
                        "        var parameter;\n" +
                        " console.log(clickedID);" +
                        "        parameter =\"id=\".concat(clickedID);\n" +
                        "        xhttp.open(\"POST\",\"deleteCartServlet\",true);\n" +
                        "        xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n" +
                        "        xhttp.send(parameter);\n" +
                        "window.location.reload();" +
                        "    }\n" +
                        "function updateQuantity(clickedID)\n" +
                        "    {\n" +
                        "        var id = clickedID.substring(8,10);\n" +
                        "        var xhttp = new XMLHttpRequest()\n" +
                        "        var parameter;\n" +
                        "        var newValue = document.getElementById(clickedID).value;\n" +
                        "if(newValue ==\"0\"){" +
                        "removeItem(id);" +
                        "}else{"+
                        "        parameter =\"id=\".concat(id);\n" +
                        "        parameter = parameter.concat(\"&value=\");\n" +
                        "        parameter = parameter.concat(newValue);\n" +
                        "        xhttp.open(\"POST\",\"updateQuantityServlet\",true);\n" +
                        "        xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n" +
                        "        xhttp.send(parameter);\n" +
                        "        window.location.reload();\n" +
                        "    }" +
                        "}\n" +
                        "function purchase(){\n" +
                        "        var xhttp = new XMLHttpRequest();\n" +
                        "        xhttp.open(\"POST\",\"purchaseServlet\",true);\n" +
                        "        xhttp.setRequestHeader(\"Content-type\", \"application/x-www-form-urlencoded\");\n" +
                        "        xhttp.send();\n" +
                        "window.location.reload();"+
                        "    }"+
                        "</script>" +
                        "</body>\n" +
                        "</html>\n");
    }
}
