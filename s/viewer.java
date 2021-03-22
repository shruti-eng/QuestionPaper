import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class viewer {

    viewer(String temp[] ) {

        JFrame view = new JFrame();
        view.getContentPane().setBackground(Color.decode("#BCF96E"));
        view.setForeground(Color.WHITE);

        JLabel la = new JLabel("--- QUESTIONS ---");    // creating label for View Questions
        la.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 20));
        la.setBounds(250,50,400,40);    // x axis, y axis, width , height


                JPanel middlePanel = new JPanel ();
                middlePanel.setBorder ( new TitledBorder( new EtchedBorder(), "ALL QUESTIONS" ) );
                middlePanel.setBounds(40,100,600,600);
                String str = "";
                for(int i=0;i<temp.length; i++){
                    str += i+1 +")  "+ temp[i]+"\n";

                }

                JTextArea display = new JTextArea ( 38, 58 );
                display.setText(str);
                display.setEditable ( false ); // set textArea non-editable
                JScrollPane scroll = new JScrollPane ( display );
                scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

                //Add Textarea in to middle panel
                middlePanel.add ( scroll );
                view.add ( middlePanel );
               // view.pack ();
                view.setLocationRelativeTo ( null );
                view.setResizable(false);

        view.add(la);
        view.setSize(700, 1000);
        view.setLayout(null);
        view.setVisible(true);

    }

}
