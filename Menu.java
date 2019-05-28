package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.IOException;
import javafx.application.Application;

// Simple Banking System V 1.5

public abstract class Menu extends Application implements WindowListener, ActionListener
{
    //menu buttons
    private static JButton jb1 = new JButton();
    private static JButton jb2 = new JButton();
    private static JButton jb3 = new JButton();
    private static JButton jb4 = new JButton();
    private static JButton jb5 = new JButton();
    private static JButton jb6 = new JButton();

    /*Initialize the GUI.
    Note: Only exit button works on the GUI.
    I was planning to make a GUI for the program, but due to lack of
    time I was not able to complete it. We will still include
    the look of the GUI in the presentation to make our system look
    better. */

     public static void initGui()
     {

         jb1.setText("Create Account");
         jb2.setText("Deposit");
         jb3.setText("Withdraw");
         jb4.setText("Show Balance");
         jb5.setText("Edit Account");
         jb6.setText("Exit");

         //set bounds of menu buttons
         jb1.setBounds(10,80,80,25);
         jb2.setBounds(30,80,80,25);
         jb3.setBounds(50,80,80,25);
         jb4.setBounds(70,80,80,25);
         jb5.setBounds(90,100,80,25);
         jb6.setBounds(110,120,80,25);

        //create Jframe instance
        JFrame jf = new JFrame("Simple Banking System");
        JPanel jp = new JPanel();
        jf.add(jp);

        //Add menu buttons to frame
         jp.add(new JLabel(new ImageIcon("title.png")));
         jp.add(jb1);
         jp.add(jb2);
         jp.add(jb3);
         jp.add(jb4);
         jp.add(jb5);
         jp.add(jb6);
         jp.add(new JLabel(new ImageIcon("bankimage.png")));
        //Set Frame properties
         jf.setSize(350,200);
         jf.setLocationRelativeTo(null);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jf.setResizable(false);
         jf.setVisible(true);

        //Button Events begin

       jb1.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
           {

           }
        });

         jb2.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {

             }
         });

         jb6.addActionListener(new ActionListener()
         {
             public void actionPerformed(ActionEvent e)
             {
                 acc.exit();
             }
         });
     }
        //Button Events end

    static Account acc;

    public static void main(String[] args) throws IOException {

        initGui();

        //Create Objects
        acc = new Account();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Simple Banking System.\n Please choose from the following options: ");

        Boolean fl = true;

        while (fl) {

            show_menu();

            System.out.println("Would you like to continue? Yes/No: ");

            String choice = scan.next();
            if (choice.equalsIgnoreCase("yes") ||
                    (choice.equalsIgnoreCase("y")))
            {
                fl = true;
            }
            else if (choice.equalsIgnoreCase("no")||
                    (choice.equalsIgnoreCase("n")))
            {
                fl = false;
            }
            else
            {
                System.out.println("Invalid option. ");
            }
        }
    }

    public static void show_menu() throws IOException {


        System.out.println("1\t Create Account");
        System.out.println("2\t Deposit");
        System.out.println("3\t Withdraw");
        System.out.println("4\t Show Balance");
        System.out.println("5\t Edit Account");
        System.out.println("6\t Exit");

        Scanner scan2 = new Scanner(System.in);
        System.out.println("Please enter your choice:");

        int choice2 = scan2.nextInt();
        double amount =0;

        switch (choice2) {
            case 1:
                acc.create_account();
                break;
            case 2:
                Lookup.lookup_account();
                System.out.println("Enter the amount to deposit: " );
                amount=scan2.nextDouble();
                Account.deposit(amount);
                break;
            case 3:
                try
                {
                    Lookup.lookup_account();
                    System.out.println("Enter the amount to withdraw: ");
                    amount = scan2.nextDouble();
                    acc.withdraw(amount);
                }
                catch (WithdrawLimitException e)
                {
                    System.out.println("Sorry. You have attempted to withdraw " + e.showbalance() + "$ more than you have.");
                }
                break;
            case 4:
                acc.show_balance();
                break;
            case 5:
                acc.edit_account();
                break;
            case 6:
                acc.exit();;
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
