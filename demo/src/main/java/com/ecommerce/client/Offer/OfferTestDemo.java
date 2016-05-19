package com.ecommerce.client.offer;

import com.ecommerce.framework.offer.SendOffer;
import com.ecommerce.framework.offer.SendOfferDetails;
import com.ecommerce.framework.userconfig.IAddress;
import com.ecommerce.framework.userconfig.IUser;
import com.ecommerce.framework.userconfig.User;

/**
 * Created by anup on 5/18/2016.
 */
public class OfferTestDemo {

    public static void main(String[] arg) {
        SendOffer details = new SendOfferDetails("New offer!!!!!!");
        IAddress address = new AddressImpl("1000N 4TH Street", "fairfield", "IA", "52557");

        //create observers

        IUser user1 = new User("anup", "khatri", "Anup", "khatriz047@gmail.com", address, null);
        IUser user2 = new User("anup1", "khatri", "Anup Khatri", "khatriz047@gmail.com", new AddressImpl("1000N 4TH Street", "fairfield", "IA", "52557"), new AddressImpl("1000N 4TH Street", "fairfield", "IA", "52557"));
        IUser user3 = new User("anup2", "khatri", "Anup KC", "khatriz047@gmail.com", new AddressImpl("1000N 4TH Street", "fairfield", "IA", "52557"), new AddressImpl("1000N 4TH Street", "fairfield", "IA", "52557"));

        //register observers to the subject
        details.registerCustomer(user1);
        details.registerCustomer(user2);
        details.registerCustomer(user3);

        details.notifyCustomers();
    }
}
