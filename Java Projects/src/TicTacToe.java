import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class TicTacToe {
	public static void main(String []args) {
		JFrame Frame = new JFrame("Frame Test");
		Frame.setTitle("TIC TAC TOE");
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 550, 80);
		panel.setBackground(Color.LIGHT_GRAY);
		JLabel Title = new JLabel();
		Font font = new Font("ComicSans", Font.BOLD, 28);
		Title.setText("TIC TAC TOE");
		Title.setFont(font);
		Title.setBackground(Color.BLUE);
		Title.setBounds(150, 0, 500, 90);
		
		JButton Box1 = new JButton();
		Box1.setBounds(20, 100, 90, 90);
		
		JButton Box2 = new JButton();
		Box2.setBounds(20, 200, 90, 90);
		
		JButton Box3 = new JButton();
		Box3.setBounds(20, 300, 90,90);
		
		JButton Box4 = new JButton();
		Box4.setBounds(120, 100, 90, 90);
		
		JButton Box5 = new JButton();
		Box5.setBounds(120, 200, 90, 90);
		
		JButton Box6 = new JButton();
		Box6.setBounds(120, 300, 90,90);
		
		JButton Box7 = new JButton();
		Box7.setBounds(220, 100, 90, 90);
		
		JButton Box8 = new JButton();
		Box8.setBounds(220, 200, 90, 90);
		
		JButton Box9 = new JButton();
		Box9.setBounds(220, 300, 90,90);
		

		JLabel PlayeroneName = new JLabel();
		PlayeroneName.setText("Player O");
		PlayeroneName.setBounds(370, 150,180,100);
		

		JLabel PlayertwoName = new JLabel();
		PlayertwoName.setText("Player X");
		PlayertwoName.setBounds(370, 200,180,100);
		

		JTextArea PlayeroneScore = new JTextArea("");
		PlayeroneScore.setEditable(false);
		PlayeroneScore.setText("0");
		PlayeroneScore.setBounds(430, 192,40,20);
		

		JTextArea PlayertwoScore = new JTextArea();
		PlayertwoScore.setEditable(false);
		String ts = "0";
		PlayertwoScore.setText(ts);
		PlayertwoScore.setBounds(430, 242,40,20);
		
		JButton Reset = new JButton("Reset");
		Reset.setBounds(370, 300, 100, 40);
		
		ImageIcon img = new ImageIcon("O.png");
		Image image = img.getImage();
		Image scaledImg = image.getScaledInstance(80, 80, image.SCALE_DEFAULT);
		Icon scaledIcon = new ImageIcon(scaledImg);
		
		Frame.add(Title);
		Frame.add(panel);
		panel.add(Title);
		Frame.add(Box1);
		Frame.add(Box2);
		Frame.add(Box3);
		Frame.add(Box4);
		Frame.add(Box5);
		Frame.add(Box6);
		Frame.add(Box7);
		Frame.add(Box8);
		Frame.add(Box9);
		Frame.add(Reset);
		Frame.add(PlayeroneName);
		Frame.add(PlayertwoName);
		Frame.add(PlayeroneScore);
		Frame.add(PlayertwoScore);
		
		
		Frame.setBackground(Color.BLACK);
		Frame.setSize(550, 450);
		Frame.setLayout(null);
		Frame.setVisible(true);
		
		
		
		Box3.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e) {
			 
		 }
		});
		Box1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 
			 }
			});
		Box2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 
			 }
			});
	}
}
