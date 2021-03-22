import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class RegisterUI extends JFrame implements ActionListener {
 
    public RegisterUI(){               //constructor of RegisterUI() class
        JFrame reg = new JFrame("Register");  // creating a frame named 'Register'
        reg.getContentPane().setBackground( Color.decode("#BCF96E") ); // to set the background color of frame
    
    JLabel l1 = new JLabel("Registration Page");       //creating instance of JLabel
    l1.setBounds(150,100,450,40);                        // x axis, y axis, width , height
    l1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 30));   // font style, type, size

    JLabel l2 = new JLabel("Name");       ///creating a label for name
    l2.setBounds(100,180,150,30);             // x axis, y axis, width , height
    l2.setFont(l2.getFont().deriveFont(15.0f));   // font style, type, size
    

    JLabel l3 = new JLabel("Email");         // creating a label for email
    l3.setBounds(100,230,150,30);          // x axis, y axis, width , height
    l3.setFont(l3.getFont().deriveFont(15.0f));  // font style, type, size

    JLabel l4 = new JLabel("Phone no");    // creating a label for phone number
    l4.setBounds(100,280,150,30);      // x axis, y axis, width , height
    l4.setFont(l4.getFont().deriveFont(15.0f));     // font style, type, size


    JLabel l5 = new JLabel("Username");    //creating a label for username
    l5.setBounds(100,330,150,30);          // x axis, y axis, width , height
    l5.setFont(l5.getFont().deriveFont(15.0f));       // font style, type, size

    JLabel l6 = new JLabel("Password");       // creating a label for Password
    l6.setBounds(100,380,150,30);               // x axis, y axis, width , height
    l6.setFont(l6.getFont().deriveFont(15.0f));       // font style, type, size


    JTextField t1 = new JTextField();    //creating instance of JTextField
    t1.setBounds(250,180,200,30);          // x axis, y axis, width , height

    JTextField t2 = new JTextField();   //creating instance of JTextField
    t2.setBounds(250,230,200,30);   // x axis, y axis, width , height

    JTextField t3 = new JTextField();    //creating instance of JTextField
    t3.setBounds(250,280,200,30);       // x axis, y axis, width , height

    JTextField t4 = new JTextField();    //creating instance of JTextField
    t4.setBounds(250,330,200,30);       // x axis, y axis, width , height

    JPasswordField t5 = new JPasswordField();            //creating an instance of password field
    t5.setBounds(250,380,200,30);                  // x axis, y axis, width , height
 
    JButton b1 = new JButton("SUBMIT");          //creating a button for SUBMIT
        b1.setBackground(Color.BLACK);     // to set background color of button
        b1.setForeground(Color.WHITE);     // to set text color of button
    b1.setBounds(150,500,100,30);                 // x axis, y axis, width , height
    b1.addActionListener(new ActionListener(){           // add action listener to submit button
        
        public void actionPerformed(ActionEvent e1){       // action to be performed when b1 button is clicked

            if(!t4.getText().isEmpty() || !t5.getText().isEmpty()  ){

                String s1 = new String(t4.getText());    // to store the text entered in textfield t4 into a string
                String s2 = new String(t5.getPassword());  // to store the text entered in textfield t5 into a string
                String ss = new String(t1.getText());    // to store the text entered in textfield t1 into a string
                String fileName = new String(t4.getText()+".txt");  // to store the filename for usernames into a string
                String fileName2 = new String(t4.getText()+"pass.txt");    // to store the filename for passwords into a string
                
                try{
                    File f1 = new File(fileName);     // make a file
                    FileWriter writer1 = new FileWriter(f1); // create a file writer
                    writer1.write(s1);   // write in the file
                    writer1.close();      // closing of file
                    File f2 = new File(fileName2);   // make another file
                    FileWriter writer2 = new FileWriter(f2);  // create another file writer
                    writer2.write(s2);    // write in the file
                    writer2.close();   // close the file

                } catch (IOException e) {
                    e.printStackTrace();   // in case if any exception is encountered
                }

                JOptionPane.showMessageDialog(null, "Registration Successful", "Set Color", JOptionPane.INFORMATION_MESSAGE); //display msg a message using message box

                new LoginUI();  // creating instance of LoginUI()
                reg.dispose();  // disposal of previous frame


            }

            else   // else condition
            {

                JOptionPane.showMessageDialog(null, "Fill all the fields ");// to display a msg using message box
            }

        }
    });

    JButton b2 = new JButton("RESET");         // creating a button for RESET
    b2.setBounds(300,500,100,30);                // x axis, y axis, width , height
        b2.setBackground(Color.BLACK);  // to set the background color of button
        b2.setForeground(Color.WHITE);   // to set the text color of button
     
    
    b2.addActionListener(new ActionListener(){             //adding action listener to button b2

        public void actionPerformed(ActionEvent e2){

            t1.setText(null); t2.setText(null); t3.setText(null); t4.setText(null); t5.setText(null);   // set all the text field as null
        }


    });


    reg.add(l1);  // adding components to the frame
    reg.add(l2);
    reg.add(l3);
    reg.add(l4);
    reg.add(l5);
    reg.add(l6);
    reg.add(t1);
    reg.add(t2);
    reg.add(t3);
    reg.add(t4);
    reg.add(t5);
    reg.add(b1);
    reg.add(b2);
    
    reg.setLayout(null);        // using no layout manager
    reg.setSize(650,650);     // to set size of the frame
    reg.setVisible(true);      // to make frame visible
    }
   
   /* public static void main(String args[]){
        new RegisterUI();
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
