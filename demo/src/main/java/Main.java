import com.ecommerce.client.userconfig.LoginController;
import com.ecommerce.client.userconfig.RoleType;
import com.ecommerce.client.userconfig.User;
import com.ecommerce.framework.userconfig.ILoginService;
import com.ecommerce.framework.userconfig.LoginService;

import java.util.Scanner;

/**
 * Created by Admin on 5/18/2016.
 */
public class Main {
    public static void main(String[] args){
        //LoginController loginController = new LoginController(loginService);
        printLine();
        printMessage("Welcome to Online Shopping System ");
        printLine();

        Scanner scanner = new Scanner(System.in);
        printMessage("Enter Username:");
        String username = scanner.nextLine();

        scanner = new Scanner(System.in);
        printMessage("Enter Password:");
        String password = scanner.nextLine();

        User user = new User(username, password, RoleType.CUSTOMER);
//        try {
//            loginController.login(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        printMessage(username);
        printMessage(password);

    }

    public static void printLine(){
        System.out.println("=======================================");
    }

    public static void printMessage(String message){
        System.out.println(message);
    }
}
