/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package com.mycompany.tellerapplication;

import java.util.ArrayList;

/**
 *
 * @author Binay
 */
public class AccountHandler {

    ArrayList<Accounts> acc = new ArrayList<>();

    public boolean addAccount(int accNo, String accName, int balance) {
        Accounts ac = new Accounts(accNo, accName, balance);
        if (findAccount(accNo) == null) {
            this.acc.add(ac);
            return true;
        }
        return false;
    }

    public Accounts findAccount(int accNo) {
        for (Accounts ac : acc) {
            if (ac.getAccNumber() == accNo) {
                return ac;
            }
        }
        return null;
    }

    public Accounts checkAmount(int accNo) {
        if (findAccount(accNo) != null) {
            Accounts ac = findAccount(accNo);
            System.out.println("The balance is " + ac.getAccBalance());
        } else {
            System.out.println("Enter valid account number.");
        }
        return null;
    }

    public Accounts depositAmount(int accNo, int amount) {
        if (findAccount(accNo) != null) {
            Accounts ac = findAccount(accNo);
            ac.setAccBalance(ac.getAccBalance() + amount);
            System.out.println("Your balance is deposited and new balance is " + ac.getAccBalance());
        } else {
            System.out.println("Enter valid account number.");
        }
        return null;
    }

    public int withdrawAmount(int accNo, int withdrawBalance) {
        if (findAccount(accNo) != null) {
            Accounts ac = findAccount(accNo);
            if (ac.getAccBalance() >= withdrawBalance) {
                ac.setAccBalance(ac.getAccBalance() - withdrawBalance);
                System.out.println("Your balance  " + withdrawBalance + " is withdrawn and remaining balance is " + ac.getAccBalance());
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public int transferAmount(int accNo1, int accNo2, int transferAmount) {
        if ((findAccount(accNo1) != null) && (findAccount(accNo2) != null)) {
            Accounts ac1 = findAccount(accNo1);
            Accounts ac2 = findAccount(accNo2);
            if (ac1.getAccBalance() >= transferAmount) {
                ac1.setAccBalance(ac1.getAccBalance() - transferAmount);
                ac2.setAccBalance(ac2.getAccBalance() + transferAmount);
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public int deleteAccount(int accNo) {
        if (findAccount(accNo) != null) {
            Accounts ac = findAccount(accNo);
            this.acc.remove(ac);
            return 1;
        }
        return 0;
    }

    public ArrayList<Accounts> listAccount() {
        if (acc != null) {
            for (Accounts ac : acc) {
                System.out.println("*********************************");
                System.out.println("Account Name: "+ac.getAccName());
                System.out.println("Account Number: "+ac.getAccNumber());
                System.out.println("Account Balance: "+ac.getAccBalance());
                System.out.println("********************************");
            }
            return null;
        }
        System.out.println("There are no accounts.");
        return null;
    }
}
