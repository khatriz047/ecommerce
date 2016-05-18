package com.ecommerce.framework.offer;
/**
 * @author Anup Khatri
 */

import com.ecommerce.framework.userconfig.IUser;

import java.util.ArrayList;

/*Concrete Subject*/
public class SendOfferDetails implements SendOffer {
    private ArrayList<IUser> users = new ArrayList<IUser>();
    private String message;
    private String offererName;
    public SendOfferDetails(String message) {
        super();
        this.message = message;
    }

    public ArrayList<IUser> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<IUser> users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void setOffererName(String name) {
        this.offererName=name;

    }
    @Override
    public String getOffererName() {
        return offererName;
    }

    @Override
    public void registerCustomer(IUser userObserver) {
        users.add(userObserver);
    }

    @Override
    public void removeCustomer(IUser userObserver) {
        users.remove(userObserver);
    }

    @Override
    public void notifyCustomers(String name) {
        System.out.println("Sending Notification by  "+name);
        System.out.println("------------------------------");
        for (IUser user : users) {
            user.update(message);
        }
        System.out.println("------------------------------");

    }
}
