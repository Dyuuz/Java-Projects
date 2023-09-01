import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.io.*;
import java.text.AttributedString;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor {

	public static void main(String[] args) throws PrinterException {
		
//		Java swing component initialization and definition
		String default_titile = "*Untitled";
		String FramTi = default_titile + " - Text Editor App" ;
		JFrame Frame = new JFrame(FramTi);
		Image icn = Toolkit.getDefaultToolkit().getImage("logo3.png");
		Frame.setIconImage(icn);
		Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
		JMenuBar Menu = new JMenuBar();
		Menu.setBounds(0, 0,100,100);
		JMenu File = new JMenu("File");
		JMenu Edit = new JMenu("Edit");
		JMenu About = new JMenu("About");
		JMenuItem New = new JMenuItem(" New");
		JMenuItem Open = new JMenuItem(" Open");
		JMenuItem Save = new JMenuItem(" Save");
		JMenuItem Print = new JMenuItem(" Print");
		JMenuItem Save_Close  = new JMenuItem(" Exit App");
		JMenuItem Cut = new JMenuItem("Cut");
		JMenuItem Copy = new JMenuItem("Copy");
		JMenuItem Paste = new JMenuItem("Paste");
		JMenuItem SelectAll = new JMenuItem("SelectAll");
		JMenuItem AboutApp = new JMenuItem("About App");
		JPopupMenu Popup = new JPopupMenu("Edit");
		JMenuItem Cutt = new JMenuItem("Cut");
		JMenuItem Copyy = new JMenuItem("Copy");
		JMenuItem Pastee = new JMenuItem("Paste");
		JMenuItem Selectall = new JMenuItem("SelectAll");
		JFileChooser file = new JFileChooser();
		JEditorPane editpane = new JEditorPane();
		editpane.setEditable(true);
		editpane.setFont(new Font ("ComicSans", 0 ,14));
		editpane.setContentType("text/plain");
		JScrollPane scrollpane = new JScrollPane(editpane);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
//		Defining swing functions
		Frame.add(scrollpane);
		Menu.add(File);
		Menu.add(Edit);
		Menu.add(About);
		File.add(New);
		File.add(Open);
		File.add(Save);
		File.add(Print);
		File.addSeparator();
		File.add(Save_Close);
		Edit.add(Cut);
		Edit.add(Copy);
		Edit.add(Paste);
		Edit.add(SelectAll);
		About.add(AboutApp);
		Popup.add(Cutt);
		Popup.add(Copyy);
		Popup.add(Pastee);
		Popup.addSeparator();
		Popup.add(Selectall);
		
//		Defining Frame Methods
		Frame.setJMenuBar(Menu);
		Frame.setSize( 800, 800);
		Frame.setLocationRelativeTo(null);
		Frame.setVisible(true);

//		Defining a Tool tip for the registered MenuItems
		New.setToolTipText("Start a new text document");
		Open.setToolTipText("Import a text document");
		Save.setToolTipText("Save text document to file");
		Print.setToolTipText("Prints text document with a printer");
		Save_Close.setToolTipText("Save file and auto close app");
		
		Cut.setToolTipText("Remove currently selected text");
		Copy.setToolTipText("Duplicate currently selected text");
		Paste.setToolTipText("Paste recently extracted text to file");
		SelectAll.setToolTipText("Select all text on the page");
		
//		Defining a Tool tip for Pop up MenuItems
		Cutt.setToolTipText("Remove currently selected text");
		Copyy.setToolTipText("Duplicate currently selected text");
		Pastee.setToolTipText("Paste recently extracted text to file");
		
		AboutApp.setToolTipText("Explore About App");
		
//		Pop up Menu function
		editpane.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()) {
					Popup.show(e.getComponent(), e.getX(), e.getY());
				}
				
			}
		});
		
//		Defining Pop up menu items functionalities
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
		Pastee.addActionListener(new ActionListener(){
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
		Selectall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent edit) {
				try {
				editpane.selectAll();
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
				if(!editpane.getText().isEmpty() ) {
					try {
					String saVerr = "Do you want to save changes to a new or existing file?";
					Object [] optNew = {"Save","Don't save", "Cancel"};
					int opt = JOptionPane.showOptionDialog(Frame , saVerr,"Open a new text document", 
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, optNew, optNew[1]);
					if (opt == JOptionPane.YES_OPTION ) {
						if(!editpane.getText().isEmpty() && Frame.getTitle().equals(FramTi)) {
							file.setDialogTitle("Save text file");
							FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Text Documents (*.txt)", ".txt");
							file.getAcceptAllFileFilter();
							file.setAcceptAllFileFilterUsed(true);
							
							int openfile = file.showSaveDialog(Frame);
							
								if (openfile == file.APPROVE_OPTION) {
								try {
									File selFile = file.getSelectedFile();
									selFile = new File(selFile + ".txt");
									selFile.createNewFile();
									
									FileWriter merge = new FileWriter(selFile.getAbsolutePath());
									String str = editpane.getText();
									merge.write(str);
									merge.close();
									editpane.setText("");
									Frame.setTitle(selFile.getName()+ " - Text Editor");
									JOptionPane.showMessageDialog(Frame, selFile+"\nFile successfully saved to directory");
									
								}
								catch(Exception e1){
									JOptionPane.showMessageDialog(Frame , e1 , 
											"Save File Function Error" ,JOptionPane.WARNING_MESSAGE);
								}
								}
					}
						else if (!editpane.getText().isEmpty() && Frame.getTitle() != FramTi ) {
							file.setDialogTitle("Save text file");
							FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Text Documents (*.txt)", ".txt");
							file.getAcceptAllFileFilter();
							file.setAcceptAllFileFilterUsed(true);
							
							int openfile = file.showSaveDialog(Frame);
							
								if (openfile == file.APPROVE_OPTION) {
								try {
									File selFile = file.getSelectedFile();
									selFile.createNewFile();
									
									FileWriter merge = new FileWriter(selFile.getAbsolutePath());
									String str = editpane.getText();
									merge.write(str);
									merge.close();
									editpane.setText("");
									Frame.setTitle(selFile.getName()+ " - Text Editor");
									JOptionPane.showMessageDialog(Frame, selFile+"\nFile successfully saved to directory");
									
								}
								catch(Exception e1){
									JOptionPane.showMessageDialog(Frame , e1 , 
											"Save File Function Error" ,JOptionPane.WARNING_MESSAGE);
								}
								}
						}
						else {
							
						}
					}
					else if(opt == JOptionPane.NO_OPTION) {
						editpane.setText("");
						Frame.setTitle(default_titile + " - Text Editor App");
					}
					else{
						Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
					}
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(Frame , e1 , 
								"New File Function Error" ,JOptionPane.WARNING_MESSAGE);
					}
				}
				
				else {
					try {
						editpane.setText("");
						Frame.setTitle(default_titile + " - Text Editor App");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(Frame , e1 , 
								"New File Function Error" ,JOptionPane.WARNING_MESSAGE);
					}
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
				String FramTi = default_titile + " - Text Editor App" ;
				if(!editpane.getText().isEmpty() && Frame.getTitle().equals(FramTi)) {
						file.setDialogTitle("Save text file");
						FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Text Documents (*.txt)", ".txt");
						file.getAcceptAllFileFilter();
						file.setAcceptAllFileFilterUsed(true);
						
						int openfile = file.showSaveDialog(Frame);
						
							if (openfile == file.APPROVE_OPTION) {
							try {
								File selFile = file.getSelectedFile();
								selFile = new File(selFile + ".txt");
								selFile.createNewFile();
								
								FileWriter merge = new FileWriter(selFile.getAbsolutePath());
								String str = editpane.getText();
								merge.write(str);
								merge.close();
								Frame.setTitle(selFile.getName()+ " - Text Editor");
								JOptionPane.showMessageDialog(Frame, selFile+"\nFile successfully saved to directory");
								
							}
							catch(Exception e1){
								JOptionPane.showMessageDialog(Frame , e1 , 
										"Save File Function Error" ,JOptionPane.WARNING_MESSAGE);
							}
							}
				}
				else if (!editpane.getText().isEmpty() && Frame.getTitle() != FramTi ) {
					file.setDialogTitle("Save text file");
					FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Text Documents (*.txt)", ".txt");
					file.getAcceptAllFileFilter();
					file.setAcceptAllFileFilterUsed(true);
					
					int openfile = file.showSaveDialog(Frame);
					
						if (openfile == file.APPROVE_OPTION) {
						try {
							File selFile = file.getSelectedFile();
							selFile.createNewFile();
							
							FileWriter merge = new FileWriter(selFile.getAbsolutePath());
							String str = editpane.getText();
							merge.write(str);
							merge.close();
							Frame.setTitle(selFile.getName()+ " - Text Editor");
							JOptionPane.showMessageDialog(Frame, selFile+"\nFile successfully saved to directory");
							
						}
						catch(Exception e1){
							JOptionPane.showMessageDialog(Frame , e1 , 
									"Save File Function Error" ,JOptionPane.WARNING_MESSAGE);
						}
						}
				}
				else {
					String saVerr = "You cannot save an empty file!";
					JOptionPane.showMessageDialog(Frame , saVerr , 
							"Save File Error" ,JOptionPane.WARNING_MESSAGE);
					}
					}
			});
		Print.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent File) {
				if(!editpane.getText().isEmpty() ) {
					editpane.setBackground(Color.white);
					boolean show = true;
						try {
							editpane.print(null, null,show,null,null,show);
						}
						catch(Exception e1){
							JOptionPane.showMessageDialog(Frame , e1 , 
									"Print Function Error" ,JOptionPane.WARNING_MESSAGE);
						}
					}
				else {
					String printErr = "You cannot print an empty file!";
					JOptionPane.showMessageDialog(Frame , printErr , 
							"Save File Error" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		Save_Close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent File) {
				if(!editpane.getText().isEmpty() ) {
					try {
					String saVerr = "Do you want to save changes before closing App?";
					Object [] optNew = {"Save","Don't save", "Cancel"};
					int opt = JOptionPane.showOptionDialog(Frame , saVerr,"Exit App", 
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, optNew, optNew[1]);
					if (opt == JOptionPane.YES_OPTION ) {
						if(!editpane.getText().isEmpty() && Frame.getTitle().equals(FramTi)) {
							file.setDialogTitle("Save text file");
							FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Text Documents (*.txt)", ".txt");
							file.getAcceptAllFileFilter();
							file.setAcceptAllFileFilterUsed(true);
							
							int openfile = file.showSaveDialog(Frame);
							
								if (openfile == file.APPROVE_OPTION) {
								try {
									File selFile = file.getSelectedFile();
									selFile = new File(selFile + ".txt");
									selFile.createNewFile();
									
									FileWriter merge = new FileWriter(selFile.getAbsolutePath());
									String str = editpane.getText();
									merge.write(str);
									merge.close();
									Frame.setTitle(selFile.getName()+ " - Text Editor");
									JOptionPane.showMessageDialog(Frame, selFile+"\nFile successfully saved to directory");
									System.exit(0);
									
								}
								catch(Exception e1){
									JOptionPane.showMessageDialog(Frame , e1 , 
											"Save File Function Error" ,JOptionPane.WARNING_MESSAGE);
								}
								}
					}
					else if (!editpane.getText().isEmpty() && Frame.getTitle() != FramTi ) {
						file.setDialogTitle("Save text file");
						FileNameExtensionFilter filter1 = new FileNameExtensionFilter("Text Documents (*.txt)", ".txt");
						file.getAcceptAllFileFilter();
						file.setAcceptAllFileFilterUsed(true);
						
						int openfile = file.showSaveDialog(Frame);
						
							if (openfile == file.APPROVE_OPTION) {
							try {
								File selFile = file.getSelectedFile();
								selFile.createNewFile();
								
								FileWriter merge = new FileWriter(selFile.getAbsolutePath());
								String str = editpane.getText();
								merge.write(str);
								merge.close();
								Frame.setTitle(selFile.getName()+ " - Text Editor");
								JOptionPane.showMessageDialog(Frame, selFile+"\nFile successfully saved to directory");
								System.exit(0);
								
							}
							catch(Exception e1){
								JOptionPane.showMessageDialog(Frame , e1 , 
										"Save File Function Error" ,JOptionPane.WARNING_MESSAGE);
							}
							}
					}
					}
					else if(opt == JOptionPane.NO_OPTION) {
						System.exit(0);
					}
					else{
						Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
					}
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(Frame , e1 , 
								"New File Function Error" ,JOptionPane.WARNING_MESSAGE);
					}
				}
				
				else {
					try {
						System.exit(0);
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(Frame , e1 , 
								"New File Function Error" ,JOptionPane.WARNING_MESSAGE);
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
		
//		Defining About App Menu item functionality
		AboutApp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent about) {
				try {
					ImageIcon img = new ImageIcon("logo3.png");
					Image image = img.getImage();
					Image scaledImg = image.getScaledInstance(200, 200, image.SCALE_DEFAULT);
					Icon scaledIcon = new ImageIcon(scaledImg);
					img.setImage(scaledImg);
					Font font = new Font("Arial", Font.BOLD, 19);
					String AboutApp = "TEXT EDITOR";
					AttributedString atString = new AttributedString(AboutApp);
					atString.addAttribute(TextAttribute.FONT, font);
	
					String version = "1.0.12v";
					
					String AboutAppText = "Text Editor app is a free and minimal app for writing which offers a clean\n"
							 		   +  "workspace and an open field for creativity. It provides basic features\n"
							 		   +  "and modifications of existing text files.";
					Object [] options = {"Close"};
					int opt = JOptionPane.showOptionDialog(Frame , AboutApp +"\n"+ version
							+ "\n" +AboutAppText ,"About App", 
							JOptionPane.INFORMATION_MESSAGE, 0, scaledIcon, options, options[0]);
					if (opt == JOptionPane.YES_OPTION ) {
						Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
					else{
						Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
