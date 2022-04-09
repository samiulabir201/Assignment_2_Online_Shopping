<%--
  Created by IntelliJ IDEA.
  User: samiu
  Date: 4/9/2022
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.Lists.ProductList"%>
<%@ page import="com.Lists.UserList" %>
<%! int i=0;%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <h1>Available Product</h1>
        <a href="LogOutServlet">Log Out</a>
        <a href="ShowCartServlet"  id="cart">Shopping Cart</a>
        <p id="shoppingcartValue"><%=UserList.userCart%></p>

    <div >
        <% for(i=0; ProductList.productLists.size() > i; i++){%>
        <div>
            <div class="product-top">
                <img src="<%=ProductList.productLists.get(i).imageSrc%>" width="225px" height="225px">
            </div>
            <div class="product-bottom text-center">
                <h3><%=ProductList.productLists.get(i).productName%></h3>
                <h5><%=ProductList.productLists.get(i).productPrice%> Taka</h5>
                <button id="<%=ProductList.productLists.get(i).productID%>" onclick='buyProduct(this.id)' type="button" >Buy Now</button>
            </div>
        </div>
        <%}%>
    </div>
</div>

<script>
    function buyProduct(clickedID) {
        var xhttp = new XMLHttpRequest();
        var parameter;
        var value = document.getElementById("shoppingcartValue").innerHTML;
        value++;
        document.getElementById("shoppingcartValue").innerHTML = value;
        parameter ="id=".concat(clickedID);
        xhttp.open("POST","ShoppingCartServlet",true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send(parameter);
        window.location.reload();

    }


</script>
</body>
</html>

