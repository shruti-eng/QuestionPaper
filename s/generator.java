import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class generator {

    generator(String temp[] , int question[]) {

        JFrame g = new JFrame();
        g.getContentPane().setBackground( Color.decode("#BCF96E") );

        JLabel la = new JLabel("Questions");
        la.setFont(new Font("Arial Black", Font.CENTER_BASELINE, 20));
        la.setBounds(250, 50, 400, 40);    // x axis, y axis, width , height


        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "ALL QUESTIONS"));
        middlePanel.setBounds(40, 100, 600, 500);
        String str = "";
        for (int i = 0; i < question.length; i++) {
            str += i + 1 + ")  " + temp[question[i]] + "\n";

        }


        JTextArea display = new JTextArea(30, 58);
        display.setFont(new Font("Arial Black", Font.PLAIN, 10));

        display.setText(str);
        display.setEditable(false); // set textArea non-editable
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Add Textarea in to middle panel
        middlePanel.add(scroll);
        g.add(middlePanel);

        JButton b = new JButton("Generate Pdf ");
        b.setBounds(200,640,250,30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String stri = "";
                for (int i = 0; i < question.length; i++) {
                    stri += i + 1 + ")  " + temp[question[i]] + "\n";

                }


                Document document = new Document();
                PdfWriter writer = null;


                try {
                    writer = PdfWriter.getInstance(document, new FileOutputStream("QuestionPaper.pdf"));
                } catch (DocumentException documentException) {
                    documentException.printStackTrace();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                document.open();
                try {
                    document.add(new Paragraph( "                              Mid Semester Examination"+ "\n" + "                               Spring Semester"+"\n"));
                } catch (DocumentException documentException) {
                    documentException.printStackTrace();
                }

                try {
                    document.add( new Paragraph(stri));
                } catch (DocumentException documentException) {
                    documentException.printStackTrace();
                }
                document.close();
                writer.close();
            }
        });

        g.setLocationRelativeTo(null);
        g.setResizable(false);

        g.add(la); g.add(b);
        g.setSize(700, 1000);
        g.setLayout(null);
        g.setVisible(true);

    }

}
