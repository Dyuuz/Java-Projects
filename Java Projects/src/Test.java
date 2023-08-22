// Java Program to create a
// simple progress bar
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
public class Test extends JFrame {

    // create a frame
    static JFrame f;
    static JFrame f2;
    static JProgressBar b;
    static JOptionPane jOptionPane;

    public static void main(String []args)
    {

        // create a frame
        f = new JFrame("ProgressBar demo");
        JPanel p = new JPanel();
        p.setSize(400,400);
        b = new JProgressBar();
        b.setBounds(400,400, 400,400);
        JTextField btn = new JTextField("Yes");
        b.setValue(0);
        b.setStringPainted(true);
        f.setContentPane(p);
        p.add(b);
      
        
        jOptionPane = new JOptionPane();
//		jOptionPane.add(b);

        f.setSize(800, 800);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        fill();
        JOptionPane.showMessageDialog(f, p);
    }

    // function to increase progress
    public static void fill()
    {
        int i = 0;
        int n = 20;
        Random rand = new Random();
        try {
            while (i <= 100) {
                
                b.setValue(i + 10);

                // delay the thread
                Thread.sleep(300);
                n = 1+rand.nextInt(0,20);
                i += n;
 
            }
        }
        catch (Exception e) {
        }
        b.setVisible(true);
        
        
    }
}