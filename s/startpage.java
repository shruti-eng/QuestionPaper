import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class startpage  {
    startpage(){      // constructor of startpage()
    JFrame frame1 = new JFrame();  // creating an instance of JFrame 
    frame1.setSize(650,650);       // to set the size of the frame
    frame1.setLayout(null);        //to set layout of the frame as null
    JLabel label1 = new JLabel("WELCOME TO QUESTION PAPER GENERATOR");   //creating instance of JLabel for heading
    label1.setBounds(100,100,450,60);    // x axis, y axis, width, height of the label (coordinates of label)
    label1.setFont(new Font("Arial Black", Font.BOLD,15));   //font style, type, font size

    JButton login = new JButton("Login");   //creating instance of JButton
    login.setBounds(250,250,100,40);        // x axis, y axis, width, height of the label
    login.addActionListener(new ActionListener(){       // add ActionListener to the button

        public void actionPerformed(ActionEvent e){
            if(e.getSource()==login){   // if the button Login is clicked the action to be performed
                new LoginUI();   // creating instance of LoginUI
                frame1.dispose();  // dispose the startingpage() page( because no more in use)
             }
            
        }
    });

    JButton register = new JButton("Register");   // creating instance of JButton named 'Register'
    register.setBounds(250,350,100,40);   // x axis, y axis, width, height of the label

    register.addActionListener(new ActionListener(){       // add ActionListener to button
        public void actionPerformed(ActionEvent ev){
            if(ev.getSource()==register){   // action to be performed if this button is clicked
               new RegisterUI();      // creating instance of RegisterUI
                frame1.dispose();  // disposal of previous frame
            }
        }
    });

    //for Background of the frame
    JLabel background=new JLabel(new ImageIcon("C:\\Users\\shrub\\Desktop\\SE project\\s\\paper1.jpg"));   // creating instance of JLabel and including an image in the label
    background.setBounds(0,10,650,650);    // x axis, y axis, width, height of the label
    background.setLayout(null);    // use no layout managers
    frame1.setLayout(new BorderLayout());  // set layout of frame
    frame1.add(background);      //add the components to frame

    background.add(label1);    // add components to label 
    background.add(login);
    background.add(register);
    frame1.setVisible(true);  // making the Frame visible
    }
       
    /* public static void main(String args[]){  // main() method of startpage()

        new startpage();
    } */


}


