

import com.ecommerce.client.dataloader.DataLoader;
import com.ecommerce.client.sample.LoginControllerProxy;
import com.ecommerce.client.sample.User;
import com.ecommerce.client.sample.Utility;
import com.ecommerce.framework.context.Ecommerce;
import com.ecommerce.framework.logger.AbstractLogger;


import java.util.Scanner;

/**
 * Created by Admin on 5/18/2016.
 */
public class Main extends Ecommerce {

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    @Override
    protected void start() {
        DataLoader loader = new DataLoader(repository);
        loader.saveDefaultUsers();
        logger.logMessage(AbstractLogger.INFO, "Sample Data Loaded");
        Utility.printLine();
        Utility.printMessage("Welcome to Online Shopping System ");
        Utility.printLine();

        Scanner scanner = new Scanner(System.in);
        Utility.printInlineMessage("Enter Username:");
        String username = scanner.nextLine();

        scanner = new Scanner(System.in);
        Utility.printInlineMessage("Enter Password:");
        String password = scanner.nextLine();

        User user = new User(username, password);
        logger.logMessage(AbstractLogger.INFO, "Authenticating User");
        LoginControllerProxy loginController = new LoginControllerProxy(loginService);
        loginController.login(user);
        System.exit(-1);
    }
}
