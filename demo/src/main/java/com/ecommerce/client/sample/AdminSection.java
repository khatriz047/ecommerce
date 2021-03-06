package com.ecommerce.client.sample;

import com.ecommerce.framework.offer.SendOffer;
import com.ecommerce.framework.offer.SendOfferDetails;
import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.userconfig.IUser;

import java.util.Scanner;

/**
 * Created by Admin on 5/18/2016.
 */
public class AdminSection {
    private IRepository repository;

    public AdminSection(IRepository repository){
        this.repository = repository;
    }

    public void proceedForAdminOperation(User user) {
        System.out.println("ADMIN SECTION");
        Scanner scanner = new Scanner(System.in);
        Utility.printLine();
        Utility.printInlineMessage("Please Enter Offer:");
        String message = scanner.nextLine();
        SendOffer details = new SendOfferDetails(message);
        for (IUser customer : repository.getListOfUser()) {
            details.registerCustomer(customer);
        }
        details.notifyCustomers();
    }
}
