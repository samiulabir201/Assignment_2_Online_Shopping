import java.util.ArrayList;
import java.util.List;

class shoppingCartModel {
    int productID;
    int userID;
    String productName;
    double productPrice;
    int productQuantity;
    String imageSrc;
    public static List<shoppingCartModel> shoppingCartList = new ArrayList<shoppingCartModel>();

    public shoppingCartModel() {
    }
    public shoppingCartModel(int productID, int userID, String productName, double productPrice, int productQuantity, String imageSrc) {
        this.productID = productID;
        this.userID = userID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.imageSrc = imageSrc;
    }
}