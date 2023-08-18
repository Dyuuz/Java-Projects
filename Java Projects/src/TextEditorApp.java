import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditorApp {

	public static void main(String[] args) {
		
//		Java swing component initialization and definition
		JFrame Frame = new JFrame();
		String s = "*Untitled";
		Frame.setTitle(s + " - Text Editor App");
		JMenuBar Menu = new JMenuBar();
		Menu.setBounds(0, 0,100,100);
		JMenu File = new JMenu("File");
		JMenu Edit = new JMenu("Edit");
		JMenu About = new JMenu("About");
		JMenuItem New = new JMenuItem(" New");
		JMenuItem Open = new JMenuItem(" Open");
		JMenuItem Save = new JMenuItem(" Save");
		JMenuItem Print = new JMenuItem(" Print");
		JMenuItem Save_Sub  = new JMenuItem(" Save and Submit");
		JMenuItem Cut = new JMenuItem("Cut");
		JMenuItem Copy = new JMenuItem("Copy");
		JMenuItem Paste = new JMenuItem("Paste");
		JMenuItem SelectAll = new JMenuItem("SelectAll");
		JMenuItem Find = new JMenuItem("Find");
		JMenuItem AboutApp = new JMenuItem("About App");
		JPopupMenu Popup = new JPopupMenu("Edit");
		JMenuItem Cutt = new JMenuItem("Cut");
		JMenuItem Copyy = new JMenuItem("Copy");
		JMenuItem Pastee = new JMenuItem("Paste");
//		File selFile = new File("C:\\");
		JFileChooser file = new JFileChooser();
		JEditorPane editpane = new JEditorPane();
		editpane.setFont(new Font ("ComicSans", 0 ,13));
		editpane.setContentType("text/plain");
//		editpane.setFont(new Font(null, Font.PLAIN, 12));
		Frame.setContentPane(editpane);
//		Frame.getContentPane().add(new JScrollPane(editpane), BorderLayout.NORTH);
		
//		Invoking/Calling swing functions
		Frame.add(Menu);
		Frame.add(Popup);
		Menu.add(File);
		Menu.add(Edit);
		Menu.add(About);
		File.add(New);
		File.add(Open);
		File.add(Save);
		File.add(Print);
		File.addSeparator();
		File.add(Save_Sub);
		Edit.add(Cut);
		Edit.add(Copy);
		Edit.add(Paste);
		Edit.add(Find);
		Edit.add(SelectAll);
		About.add(AboutApp);
		Popup.add(Cutt);
		Popup.add(Copyy);
		Popup.add(Pastee);
		
		
		Popup.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				Popup.show(Frame, e.getX(),e.getY());
				
			}
		});
//		Invoking Frame Methods
		Frame.setJMenuBar(Menu);
		Frame.setSize( 800, 800);
		Frame.setLayout(null);
		Frame.setVisible(true);
		Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
//		Defining a Tool tip for the registered MenuItems
		New.setToolTipText("Start a new text document");
		Open.setToolTipText("Import a text document");
		Save.setToolTipText("Save text document to file");
		Print.setToolTipText("Print texts");
		Save_Sub.setToolTipText("Save file and auto close app");
		
		Cut.setToolTipText("Remove currently selected text");
		Copy.setToolTipText("Duplicate currently selected text");
		Find.setToolTipText("Find a specific word in the file");
		Paste.setToolTipText("Paste recently extracted text to file");
		SelectAll.setToolTipText("Select all text on the page");
		
		AboutApp.setToolTipText("Explore About App");
		
//		Defining Pop up functionalities
		Cutt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
			try {
				editpane.cut();
			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(Frame , e1 , 
						"Cut Function Error" ,JOptionPane.WARNING_MESSAGE);
			}
				
			}
		});
		Copyy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
				try {
				editpane.copy();
			}
				catch(Exception e2){
					JOptionPane.showMessageDialog(Frame , e2 , 
							"Copy Function Error" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		Paste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
				try {
				editpane.paste();
			}
				catch(Exception e3){
					JOptionPane.showMessageDialog(Frame , e3 ,
							"Paste Function Error" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
//		Defining File Menu items functionalities
		New.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent File) {
					try {
						editpane.setText("");
						Frame.setTitle(s + " - Text Editor App");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(Frame , e1 , 
								"New File Function Error" ,JOptionPane.WARNING_MESSAGE);
					}
				}
			});
		Open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent File) {
				file.setDialogTitle("Open a text file");
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int openfile = file.showOpenDialog(Frame);
				if (openfile == file.APPROVE_OPTION) {
					try {
						File selFile = file.getSelectedFile();
						Frame.setTitle(selFile.getName()+ " - Text Editor");
						FileReader reader = new FileReader(selFile);
						BufferedReader buff = new BufferedReader(reader);
						editpane.read(buff, null);
						buff.close();
						editpane.requestFocus();
						
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(Frame , e1 , 
								"Open File Function Error" ,JOptionPane.WARNING_MESSAGE);
					}
				}
				}
			});
		Save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent File) {
				file.setDialogTitle("Save text file");
				int openfile = file.showSaveDialog(Frame);
				if (openfile == file.APPROVE_OPTION) {
					try {
						File selFile = file.getSelectedFile();
						FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Doc", "txt");
						file.setFileFilter(filter);
						selFile.createNewFile();
						FileWriter merge = new FileWriter(selFile.getAbsolutePath());
						String str = editpane.getText();
						merge.write(str);
						merge.close();
						Frame.setTitle(selFile.getName()+ " - Text Editor");
//						JOptionPane.showMessageDialog(Frame, selFile.getAbsolutePath() );
						
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(Frame , e1 , 
								"Save File Function Error" ,JOptionPane.WARNING_MESSAGE);
					}
				}
				}
			});
		
		
//		Defining Edit Menu items functionalities
		Cut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
			try {
				editpane.cut();
			}
			catch(Exception e1){
				JOptionPane.showMessageDialog(Frame , e1 , 
						"Cut Function Error" ,JOptionPane.WARNING_MESSAGE);
			}
				
			}
		});
		Copy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
				try {
				editpane.copy();
			}
				catch(Exception e2){
					JOptionPane.showMessageDialog(Frame , e2 , 
							"Copy Function Error" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		Paste.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
				try {
				editpane.paste();
			}
				catch(Exception e3){
					JOptionPane.showMessageDialog(Frame , e3 ,
							"Paste Function Error" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		SelectAll.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
				try {
				editpane.selectAll();
			}
				catch(Exception e4){
					JOptionPane.showMessageDialog(Frame , e4 , 
							"SelectAll Function Error" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		Find.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
				try {
				editpane.findComponentAt(null);
			}
				catch(Exception e5){
					JOptionPane.showMessageDialog(Frame , e5 ,
							"Find Function Error" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
//		Defining About App Menu item functionality
		AboutApp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent about) {
				try {
					String AboutAppText = "Text Editor app is multi functional app";
					Object [] options = {"Send Feedback","Close"};
					int opt = JOptionPane.showOptionDialog(Frame , AboutAppText ,
							"About App",JOptionPane.YES_NO_OPTION ,JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
					if (opt == JOptionPane.YES_OPTION ) {
						
					}
					else{
						
					}
				}
					
				catch(Exception e6){
					JOptionPane.showMessageDialog(Frame , e6 ,
							"About Function Error" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
	}

}
