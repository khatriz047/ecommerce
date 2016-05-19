import com.ecommerce.client.dataloader.DataLoader;
import com.ecommerce.client.userconfig.LoginController;
import com.ecommerce.client.userconfig.RoleType;
import com.ecommerce.client.userconfig.User;
import com.ecommerce.framework.cart.*;
import com.ecommerce.framework.context.Ecommerce;
import com.ecommerce.framework.payment.*;
import com.ecommerce.framework.product.Product;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Admin on 5/18/2016.
 */
public class Main extends Ecommerce {
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public static void printLine() {
        System.out.println("=======================================");
    }

    public static void printInlineMessage(String message) {
        System.out.print(message);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    protected void start() {
        DataLoader loader = new DataLoader(repository);
        loader.saveDefaultUsers();

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
        LoginController loginController = new LoginController(loginService);
        boolean isLoggedIn = loginController.login(user);
        if(isLoggedIn) {
            loader.loadDefaultProducts();
            System.out.println("Add Products to the Shopping Cart");
            String input = "";
            Scanner scan = new Scanner(System.in);
            ShoppingCart shoppingCart = new ShoppingCart(user);
            while (!input.equalsIgnoreCase("proceed")) {
                System.out.println("Add To Shopping Cart::Enter Product Id: ");

                input = scan.nextLine();
                Product product = repository.getProduct(input);
                ICommand command = new AddToCart(shoppingCart, product);
                ShoppingCartOperator operator = new ShoppingCartOperator(command);
                operator.addToCart();
            }

            Order order = shoppingCart.createOrder();

            System.out.println(order);
            System.out.println("Proceed To make Payment");

            PaymentContext paymentContext = new PaymentContext();
            Date expiryDate = getCardExpiryDate();
            System.out.println("Please Choose Payment Method:");
            System.out.println("C for Credit Card:: D for Debit Card ");
            String paymentType = scan.nextLine();
            String name, cardNumber, date;
            System.out.println("Enter Name: ");
            name = scan.nextLine();
            System.out.println("Enter Card Number: ");
            cardNumber = scan.nextLine();
            System.out.println("Enter Expiration Date : ");
            date = scan.nextLine();

            switch (paymentType.toLowerCase()) {

                case "d":
                    System.out.println("Making Payment through Debit Card ");
                    paymentContext.setPaymentMethod(new DebitCard(name, cardNumber, expiryDate));
                    break;
                case "c":
                    System.out.println("Making Payment through Credit Card ");
                    paymentContext.setPaymentMethod(new CreditCard(name, cardNumber, expiryDate));
                    break;

            }


//        paymentContext.setPaymentMethod(new DebitCard("American Express", "1234234534564567", expiryDate));
//        /*Later, replace by shoppingCart.calculateCost()*/
            paymentContext.makePayment(order.getTotalPrice());
        }else{
            System.out.println("Invalid Username and Password");
            //System.exit(-1);
        }

    }


    private static Date getCardExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2015, Calendar.JANUARY, 21);
        return cal.getTime();
    }
}
