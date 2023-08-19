import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test {
  public static void main(String... args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel contentPane = new JPanel();
//    contentPane.setLayout(new BorderLayout(100,100));
    contentPane.setBounds(0, 0, 300, 300);

    JTextArea tArea1 = new JTextArea();
    tArea1.setLineWrap(true);
    JTextArea tArea2 = new JTextArea();
    contentPane.setBounds(0, 0, 300, 300);

//    tArea2.setLineWrap(true);
    tArea1.setText("I got a long long line of text in my JTextArea");
//    tArea2.setText("I got a long long line of text in my JTextArea");
    
    JScrollPane scroller1 = new JScrollPane();
//    JScrollPane scroller2 = new JScrollPane();
    scroller1.setViewportView(tArea1);
//    scroller2.setViewportView(tArea2);

    contentPane.add(scroller1);
//    contentPane.add(scroller2);
    frame.setContentPane(contentPane);
//    frame.setContentPane(contentPane);
    frame.setSize(900, 900);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);

  }
}