

import com.ecommerce.client.dataloader.DataLoader;
import com.ecommerce.client.userconfig.LoginController;
import com.ecommerce.client.userconfig.RoleType;
import com.ecommerce.client.userconfig.User;
import com.ecommerce.framework.cart.*;
import com.ecommerce.framework.context.Ecommerce;
import com.ecommerce.framework.offer.SendOffer;
import com.ecommerce.framework.offer.SendOfferDetails;
import com.ecommerce.framework.payment.*;
import com.ecommerce.framework.product.Product;
import com.ecommerce.framework.shipment.IShipOrder;
import com.ecommerce.framework.shipment.IShippingFactory;
import com.ecommerce.framework.shipment.ShippingFactory;
import com.ecommerce.framework.userconfig.IUser;


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

        User user = new User(username, password);
        LoginController loginController = new LoginController(loginService);
        boolean isLoggedIn = loginController.login(user);
        if (isLoggedIn) {
            User loadedUser = (User) repository.getUserFromUserName(user.getUsername());
            if (loadedUser.getRoleType().equals(RoleType.CUSTOMER)) {
                proceedForClientOperation(loadedUser);
            } else {
                proceedForAdminOperation(loadedUser);
            }
        }
        System.exit(-1);

    }

    public void proceedForAdminOperation(User user) {
        printLine();
        System.out.println("ADMIN SECTION");
        printLine();
        SendOffer details = new SendOfferDetails("New offer!!!!!!");
        for (IUser customer : repository.getListOfUser()) {
            details.registerCustomer(customer);
        }

        details.notifyCustomers();
    }


    public void proceedForClientOperation(User user) {
        printLine();
        System.out.println("CUSTOMER SECTION");
        printLine();
        DataLoader loader = new DataLoader(repository);
        loader.loadDefaultProducts();
        printLine();
        System.out.println("*****Start Shopping**********");
        System.out.println("Adding To ShoppingCart::Enter product id");
        System.out.println("For Checkout:: checkout");
        printLine();
        String input = "";
        Scanner scan = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart(user);
        while (!input.equalsIgnoreCase("checkout")) {
            System.out.println("Enter Product Id OR type checkout ");

            input = scan.nextLine();
            Product product = repository.getProduct(input);
            ICommand command = new AddToCart(shoppingCart, product);
            ShoppingCartOperator operator = new ShoppingCartOperator(command);
            operator.addToCart();
        }

        Order order = shoppingCart.createOrder();
        printLine();
        System.out.println("********Checkout Order**********");
        printLine();
        System.out.println("Shopping Cart:");
        System.out.println(order);
        printLine();
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
        paymentContext.makePayment(order.getTotalPrice());
        System.out.println("Enter Shipping Details");
        System.out.println("For Fedex:: fedex");
        System.out.println("For UPS:: ups");
        input = scan.nextLine();
        IShippingFactory shippingFactory = new ShippingFactory();
        IShipOrder shipOrder = shippingFactory.getShippingAddress(input);
        shipOrder.shipOrder(order);

    }


    private static Date getCardExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2015, Calendar.JANUARY, 21);
        return cal.getTime();
    }
}
