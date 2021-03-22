import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class addquestions {

    addquestions(){      //constructor
 
        JFrame frame2 = new JFrame();   // creating instance of JFrame
        frame2.getContentPane().setBackground( Color.decode("#BCF96E") );
        
        JLabel la1 = new JLabel("ADD QUESTIONS");      // creating label for Add Questions
        la1.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 30));
        la1.setBounds(180,50,400,40);     // x axis, y axis, width , height
    

        JLabel la2 = new JLabel("Branch");     // creating label for Branch
        la2.setBounds(100,150,150,30);     // x axis, y axis, width , height
        la2.setFont(la2.getFont().deriveFont(15.0f));

        String branch[]= {"Select","CSE","ECE","EEE","Mechanical"};    // string branch[] containing options for branch 
        JComboBox cb1 = new JComboBox(branch);
        cb1.setBackground(Color.WHITE);
       // cb1.setForeground(Color.WHITE);
        cb1.setBounds(250,150,150,30);        // x axis, y axis, width , height

        JLabel la3 = new JLabel("Year");     // creating label for Year
        la3.setBounds(100,200,150,30);        // x axis, y axis, width , height
        la3.setFont(la3.getFont().deriveFont(15.0f));

        String year[] = {"Select","First","Second","Third","Fourth"};   //string year[] containing options for year
        JComboBox cb2 = new JComboBox(year);
        cb2.setBackground(Color.WHITE);
        cb2.setBounds(250,200,150,30);          // x axis, y axis, width , height
        
         
        JLabel la4 = new JLabel("Semester");     // creating label for Semester
        la4.setFont(la4.getFont().deriveFont(15.0f));
        la4.setBounds(100,250,150,30);       // x axis, y axis, width , height

        String semester[] = {"Select","Autumn","Spring"};     // string semester[] containing options for semester
        JComboBox cb3 = new JComboBox(semester);
        cb3.setBackground(Color.WHITE);
        cb3.setBounds(250,250,150,30);        // x axis, y axis, width , height

        JLabel la5 = new JLabel("Course");       // creating label for course
        la5.setFont(la5.getFont().deriveFont(15.0f));
        la5.setBounds(100,300,150,30);         // x axis, y axis, width , height

        String course[] = {"Select","CSB252","ECB257","MAP281","CSB271"};  // string course[] containing options for course
        JComboBox cb4 = new JComboBox(course);
        cb4.setBackground(Color.WHITE);
        cb4.setBounds(250,300,150,30);        // x axis, y axis, width , height

        JLabel la6 = new JLabel("Difficulty Level");
        la6.setFont(la6.getFont().deriveFont(15.0f));
        la6.setBounds(100,350,150,30);

        String level[] = {"Select","Easy","Medium","High"};
        JComboBox cb5 = new JComboBox(level);
        cb5.setBackground(Color.WHITE);
        cb5.setBounds(250,350,150,30);


        JLabel la7 = new JLabel("Question");     // creating label for Question
        la7.setFont(la7.getFont().deriveFont(15.0f));
        la7.setBounds(100,400,150,30);         // x axis, y axis, width , height

        JTextArea ta = new JTextArea();    // creating a text area to enter question
        ta.setBounds(250,400,250,80);          // x axis, y axis, width , height
        ta.setLineWrap(true);              // to enable the line wrap
        JScrollPane scroll = new JScrollPane(ta);     // to enable scrolling to text area
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 


        JLabel la8 = new JLabel("Marks");     // // creating label for Marks
        la8.setFont(la8.getFont().deriveFont(15.0f));
        la8.setBounds(100,500,150,30);       // x axis, y axis, width , height
        
        JTextField marks = new JTextField();     // // creating instance of JTextField for marks
        marks.setBounds(250,500,100,30);        // x axis, y axis, width , height

        JButton button1 = new JButton("Submit");  // // creating label for Submit
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setBounds(220,550,100,30);        // x axis, y axis, width , height
        button1.addActionListener(new ActionListener(){         // add action listener to the button
            
            public void actionPerformed(ActionEvent ee) {


                if ((!cb1.getSelectedItem().equals("Select")) || !(cb2.getSelectedItem().equals("Select")) || !(cb3.getSelectedItem().equals("Select")) ||
                        !(cb4.getSelectedItem().equals("Select")) || !(cb5.getSelectedItem().equals("Select")) || !(ta.getText().isEmpty()) || !(marks.getText().isEmpty())) {
                    String s1 = new String((String) cb1.getSelectedItem());
                    String s2 = new String((String) cb2.getSelectedItem());
                    String s3 = new String((String) cb3.getSelectedItem());
                    String s4 = new String((String) cb4.getSelectedItem());
                    String s5 = new String((String) cb5.getSelectedItem());
                    String q = new String(ta.getText());

                    String fileName = new String(s1 + s2 + s3 + s4 + s5 + ".txt");

                    try {

                        FileWriter writer = new FileWriter(s1 + s2 + s3 + s4 + s5 + ".txt", true);
                        BufferedWriter buffer = new BufferedWriter(writer);
                        buffer.write(q);
                        buffer.write("@");
                        buffer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    JOptionPane.showMessageDialog(null, "Question added to database");
                }


                else {
                   JOptionPane.showMessageDialog(null,"Select items from all the fields");
               }
            }
        });

        JButton b = new JButton("Back");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(400,550,100,30);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ee){
                new afterlogin();
                frame2.dispose();
            }

        });

        JButton bu = new JButton("Add More");
        bu.setBackground(Color.BLACK);
        bu.setForeground(Color.WHITE);
        bu.setBounds(40,550,100,30);
        bu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent eee){

                 ta.setText("");marks.setText("");


            }

        });



         // adding components to the frame
        frame2.add(la1); frame2.add(la2); frame2.add(la3); frame2.add(la4); frame2.add(la5); frame2.add(la6);
        frame2.add(la7); frame2.add(la8);
        frame2.add(button1);frame2.add(cb1);frame2.add(cb2);frame2.add(cb3); frame2.add(cb4); frame2.add(cb5);
        frame2.add(ta);frame2.add(marks);
        frame2.add(scroll); frame2.add(b); frame2.add(bu);


        frame2.setSize(650,650);   // to set the size of frame
        frame2.setLayout(null);    // to set layout as null
        frame2.setVisible(true);    // to make frame visible



    }
    
   /* public static void main(String args[]){

        new addquestions();
    }*/
}
