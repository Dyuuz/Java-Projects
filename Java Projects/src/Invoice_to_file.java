import javax.swing.JOptionPane;
import java.awt.Component;
import java.io.FileWriter;

public class Invoice_to_file {
	
	private static final Component frame = null;
	public static void main(String []args) {
//		Welcome info to Invoice-File users 
		String wlcmsg = "Welcome to Invoice to File project";
		Object [] wlc = {"Lauch Project"};
		JOptionPane.showOptionDialog(frame, ""+wlcmsg, "Invoice-File Project", JOptionPane.YES_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, wlc, wlc[0]);
		String appinfo = "This project helps to create an invoice and convert to different file format";
		Object [] aim = {"Proceed"};
		JOptionPane.showOptionDialog(frame, ""+appinfo, "Invoice-File Project", JOptionPane.YES_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, aim, aim[0]);
		String invoice_name = JOptionPane.showInputDialog("Input the Invoice project name");
		JOptionPane.showMessageDialog(null, "Your Invoice name is "+invoice_name);
		
	}

}
