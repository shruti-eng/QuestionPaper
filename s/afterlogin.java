import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class afterlogin {

    public afterlogin(){ // constructor
    JFrame fr = new JFrame(); // creating instance of JFrame
        fr.getContentPane().setBackground( Color.decode("#BCF96E") );
    JButton b3 = new JButton("View Questions");    // creating a button  b3 named view questions
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
    b3.setBounds(150,150,300,50);     // x axis, y axis, width , height
    b3.addActionListener(new ActionListener(){        // adding action listener to button b3
        public void actionPerformed(ActionEvent e1){
            new viewquestions();
            fr.dispose();
        }
    });

    JButton b4 = new JButton("Add Questions");   // creating a button b4 for Add Questions
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
    b4.setBounds(150,250,300,50);                      // x axis, y axis, width , height
    b4.addActionListener(new ActionListener(){         // adding action listener to button b4
        public void actionPerformed(ActionEvent e2){
            new addquestions();                   // creating instance of addquestions page
            fr.dispose();
        }

    });


    JButton b5 = new JButton("Generate Question Paper");   // creating a button b5 for Generate Question Paper
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
    b5.setBounds(150,350,300,50);                          // x axis, y axis, width , height
    b5.addActionListener(new ActionListener(){             // adding action listener to b5
        public void actionPerformed(ActionEvent e3){
            new generate();                  // creating intance for generate page
            fr.dispose();
        }

    });

    fr.add(b3);fr.add(b4); fr.add(b5);        // adding components to frame 
 
    fr.setSize(650,650);           // to set size of the frame
    fr.setLayout(null);            // to set layout of frame as null
    fr.setVisible(true);           // to make frame visible 
    }

    /*public static void main(String args[]){

        new afterlogin();


    }*/


}
