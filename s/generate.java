import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Random;


public class generate {

    String temp[];
    int question[];
    
    generate(){       // constructor

        JFrame gframe = new JFrame("Generate paper");      // creating instance of JFrame
        gframe.getContentPane().setBackground( Color.decode("#BCF96E") );   // to set background color of jframe

        JLabel la1 = new JLabel("GENERATE QUESTION PAPER");      // creating a label for heading
        la1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 20));     // font style, type, size
        la1.setBounds(180,50,400,40);                              // x axis, y axis, width , height

        JLabel la2 = new JLabel("Branch");   // creating a label for Branch
        la2.setBounds(100,150,150,30);             // x axis, y axis, width , height
        la2.setFont(la2.getFont().deriveFont(15.0f));    // font style, type, size

        String branch[]= {"Select","CSE","ECE","EEE","Mechanical"};   // string containing branch options
        JComboBox cb1 = new JComboBox(branch);               // creating a JCombobox to select items from branch[]
        cb1.setBackground(Color.WHITE);             // to set background color of jcombobox items
        cb1.setBounds(250,150,150,30);      // x axis, y axis, width , height

        
        JLabel la3 = new JLabel("Year");       // creating a label for Year
        la3.setBounds(100,200,150,30);         // x axis, y axis, width , height
        la3.setFont(la3.getFont().deriveFont(15.0f));    // font style, type, size

        String year[] = {"Select","First","Second","Third","Fourth"};  // string containing year options
        JComboBox cb2 = new JComboBox(year);    // creating a JCombobox to select items from  year[]
        cb2.setBackground(Color.WHITE);     // to set background color of jcombobox items
        cb2.setBounds(250,200,150,30);        // x axis, y axis, width , height
        
         
        JLabel la4 = new JLabel("Semester");   // creating label for Semester
        la4.setFont(la4.getFont().deriveFont(15.0f));    // font style, type, size
        la4.setBounds(100,250,150,30);       // x axis, y axis, width , height

        String semester[] = {"Select","Autumn","Spring"};   // string containing options for semester
        JComboBox cb3 = new JComboBox(semester);     // // creating a JCombobox to select items from  semester[]
        cb3.setBackground(Color.WHITE);        // to set background color of jcombobox items
        cb3.setBounds(250,250,150,30);     // x axis, y axis, width , height

        JLabel la5 = new JLabel("Course");           // creating label for Course
        la5.setFont(la5.getFont().deriveFont(15.0f));   // font style, type, size
        la5.setBounds(100,300,150,30);    // x axis, y axis, width , height

        String course[] = {"Select","CSB252","ECB257","MAP281","CSB271"};   // string containing options for course
        JComboBox cb4 = new JComboBox(course);          // creating a JCombobox to select items from course[]
        cb4.setBackground(Color.WHITE);      // to set background color of jcombobox items
        cb4.setBounds(250,300,150,30);               // x axis, y axis, width , height

        JLabel la6 = new JLabel("Difficulty Level");  // creating label for Course
        la6.setFont(la6.getFont().deriveFont(15.0f)); // font style, type, size
        la6.setBounds(100,350,150,30);  // x axis, y axis, width , height

        String level[] = {"Select","Easy","Medium","High"};  // string containing options for difficulty level of questions
        JComboBox cb5 = new JComboBox(level); // creating a JCombobox to select items from level[]
        cb5.setBackground(Color.WHITE); // to set background color of jcombobox items
        cb5.setBounds(250,350,150,30);   // x axis, y axis, width , height
 
        JButton button1 = new JButton("Submit");     // creating a button for submit
        button1.setBackground(Color.BLACK);   // to set background color of button
        button1.setForeground(Color.WHITE);   // to set text color of button
        button1.setBounds(150,450,100,30);   // x axis, y axis, width , height
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {     // action to be performed when button button1 is clicked

                BufferedReader br = null;   // initialising a BufferedReader

                if ((!cb1.getSelectedItem().equals("Select")) || !(cb2.getSelectedItem().equals("Select")) || !(cb3.getSelectedItem().equals("Select")) ||
                        !(cb4.getSelectedItem().equals("Select")) || !(cb5.getSelectedItem().equals("Select"))) {
                    String s1 = new String((String) cb1.getSelectedItem());     // to store item in cb1 into a string
                    String s2 = new String((String) cb2.getSelectedItem());     // to store item in cb2 into a string
                    String s3 = new String((String) cb3.getSelectedItem());     // to store item in cb3 into a string
                    String s4 = new String((String) cb4.getSelectedItem());     // to store item in cb4 into a string
                    String s5 = new String((String) cb5.getSelectedItem());     // to store item in cb5 into a string


                    String fileName = new String(s1 + s2 + s3 + s4 + s5 + ".txt");  // naming of the file

                    try {
                        br = new BufferedReader(new FileReader(fileName));  // new BufferedReader
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                        JOptionPane.showMessageDialog(null,"No questions to display. Pls add questions");  // display a msg using msg box

                    }
                    String line = null;   // initialisation of string to null

                    while (true) {
                        try {
                            if (!((line = br.readLine()) != null)) break;
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                            JOptionPane.showMessageDialog(null,"No questions to display. File Empty");  // display a msg using msg box

                        }
                        temp = line.split("@");
                        for (int i = 0; i < temp.length; i++) {
                            System.out.print(temp[i] + "\n");    // storing all the questions from the above file into a string

                        }
                    }

                    Random random = new Random();  // instance of new Random()
                    question = new int[15];  // array of length 15

                    //to store random numbers into array question[]
                    int i = 0, j, check;
                    while (i < 15) {
                        check = 1;
                        question[i] = random.nextInt((int) 30);
                        j = i;
                        for (int k = 0; k < j; k++) {
                            if (question[k] == question[i])
                                check = 0;
                        }
                        if (check == 1)
                            i++;
                    }

               /* for( j=0; j<question.length; j++) {
                    System.out.print(temp[question[j]] + "\n" );
                } */
                    new generator(temp, question);   // instance of generator() class
                }
                else {
                    JOptionPane.showMessageDialog(null,"Select items from all the fields"); // display a msg using msg box
                }
            }
        });

        JButton b = new JButton("Back");             // creating a button for Back
        b.setBackground(Color.BLACK);  // to set background of button
        b.setForeground(Color.WHITE);  // to set text color of button
        b.setBounds(400,450,100,30);  // x axis, y axis, width , height
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new afterlogin();   // instance of afterlogin() class
                 gframe.dispose();   // disposal of previous frame which is not in use
            }
        });

        gframe.add(la1); gframe.add(la2); gframe.add(la3); gframe.add(la4); gframe.add(la5);         //adding components to frame
        gframe.add(button1);gframe.add(cb1);gframe.add(cb2);gframe.add(cb3); gframe.add(cb4); gframe.add(b);
        gframe.add(cb5); gframe.add(la6);


        gframe.setSize(650,650);   // to set size of the frame
        gframe.setLayout(null);    // to set layout of frame as null
        gframe.setVisible(true);   // to make frame visible

    }

    /*public static void main(String[] args){  // main() method of generate class

        new generate();
    }  */


}
