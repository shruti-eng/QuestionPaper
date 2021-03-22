import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LoginUI extends JFrame implements ActionListener{

     public LoginUI(){      // constructor of LoginUI page

        JFrame log = new JFrame("Login");
        log.getContentPane().setBackground( Color.decode("#BCF96E") );
        JLabel l1 = new JLabel("LOGIN ");     // creating an instance of JLabel for heading
        l1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 30));    //set font style, name, size 
        l1.setBounds(250,100,400,40);     // x axis, y axis, width , height

        JLabel l2 = new JLabel("Username");     // creating a label for username
        l2.setBounds(120,200,150,30);           // x axis, y axis, width , height
        l2.setFont(l2.getFont().deriveFont(15.0f));     //set font style, name, size
        JTextField text = new JTextField();   // creating instance of JTextField 
        text.setBounds(320,200,150,30);     // x axis, y axis, width , height

        JLabel l3 = new JLabel("Password");
        l3.setBounds(120,260,150,30);       // x axis, y axis, width , height
        l3.setFont(l3.getFont().deriveFont(15.0f)); //set font style, name, size

        JPasswordField p1 = new JPasswordField();  //creating instance of JPasswordField
        p1.setBounds(320,260,150,30);  // x axis, y axis, width , height

        JCheckBox showpassword = new JCheckBox("Show Password");    //creating instance of JCheckBox
        showpassword.setBounds(300,300,150,30);    // x axis, y axis, width , height

        JButton b = new JButton("Submit");    //creating instance of JButton
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,350,100,30);    // x axis, y axis, width , height
        b.addActionListener(new ActionListener(){                             //adding action listener to button
           public void actionPerformed(ActionEvent event){

              String fileName = new String(text.getText()+".txt");
              String fileName2 = new String(text.getText()+"pass.txt");

              File f1 = new File(fileName);
              Scanner s = null;
              try {
                 s = new Scanner(f1);
              } catch (FileNotFoundException e) {
                 e.printStackTrace();
              }
              String name = s.next();
              s.close();

              File f2 = new File(fileName2);
              Scanner s1 = null;
              try {
                 s1 = new Scanner(f1);
              } catch (FileNotFoundException e) {
                 e.printStackTrace();
              }
              String pass = s1.next();
              s1.close();


              if(f1.exists() || f2.exists()) {
                 String password = new String(p1.getPassword());
                 String namee = new String(text.getText());

                 if (password.equals(pass) || namee.equals(name)) {
                    JOptionPane.showMessageDialog(null,"Login Successfull");
                    new afterlogin();
                    log.dispose();


                 }
              }
              else {
                 JOptionPane.showMessageDialog(null,"Fill all the fields");    // creating instance of msg box
              }

           }

         
        });


        log.add(l1);log.add(l2);log.add(l3);log.add(text);log.add(p1);log.add(b);log.add(showpassword);    // adding components to the frame
       
        
        log.setVisible(true);   // making the frame visible
        log.setLayout(null);    // using no layout manager
        log.setSize(650,650);    // set size of the frame
     }

      /*  public static void main(String args[]){
            new LoginUI();
        }*/


   @Override
   public void actionPerformed(ActionEvent e) {

   }
}
