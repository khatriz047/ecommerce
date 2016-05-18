import com.ecommerce.client.DataLoader.DataLoader;
import com.ecommerce.client.userconfig.LoginController;
import com.ecommerce.client.userconfig.RoleType;
import com.ecommerce.client.userconfig.User;
import com.ecommerce.framework.cart.ShoppingCart;
import com.ecommerce.framework.context.Ecommerce;
import com.ecommerce.framework.repository.Repository;
import com.ecommerce.framework.userconfig.ILoginService;
import com.ecommerce.framework.userconfig.LoginService;

import java.util.Scanner;

/**
 * Created by Admin on 5/18/2016.
 */
public class Main extends Ecommerce {
    public static void main(String[] args){
        Main main = new Main();
        main.start();
    }

    public static void printLine(){
        System.out.println("=======================================");
    }

    public static void printInlineMessage(String message){
        System.out.print(message);
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    @Override
    protected void start() {
        LoginController loginController = new LoginController(loginService);

        printLine();
        printMessage("Welcome to Online Shopping System ");
        printLine();

        Scanner scanner = new Scanner(System.in);
        printInlineMessage("Enter Username:");
        String username = scanner.nextLine();

        scanner = new Scanner(System.in);
        printInlineMessage("Enter Password:");
        String password = scanner.nextLine();

        User user = new User(username, password, RoleType.CUSTOMER);
//        try {
//            loginController.login(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        printMessage(username);
        printMessage(password);

        /**
         * Display all the products
         * */
        try {
            DataLoader loader = new DataLoader(repository);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Add Products to the Shopping Cart");
        String input="";

        while (input.equalsIgnoreCase("1")){
            printInlineMessage("Add To Shopping Cart::Enter Product Id: ");
            input = scanner.nextLine();
            repository.getProduct(input);
        }











    }
}
