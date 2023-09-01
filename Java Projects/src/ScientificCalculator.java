import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ButtonGroup;

public class ScientificCalculator {

	private JFrame Calcframe;
	private JTextField CalcScreen;
	double firstInput;
	double secondInput;
	double finalRes;
	String opsPerformed;
	String res;
	private final ButtonGroup GroupBtnKey = new ButtonGroup();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					ScientificCalculator window = new ScientificCalculator();
					window.Calcframe.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ScientificCalculator() {
		initialize();
	}

	private void initialize() {
		Calcframe = new JFrame();
		Calcframe.setBounds(100, 100, 331, 537);
		Calcframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Calcframe.setLocationRelativeTo(null);
		Calcframe.getContentPane().setLayout(null);
		
		JLabel CalcHeader = new JLabel("Scientific Calculator");
		CalcHeader.setBackground(Color.RED);
		CalcHeader.setForeground(new Color(0, 0, 102));
		CalcHeader.setFont(new Font("Serif", Font.BOLD, 29));
		CalcHeader.setBounds(10, 10, 297, 37);
		Calcframe.getContentPane().add(CalcHeader);
		
		CalcScreen = new JTextField();
		CalcScreen.setFont(new Font("Serif", Font.BOLD, 13));
		CalcScreen.setBounds(10, 57, 297, 51);
		CalcScreen.setHorizontalAlignment(SwingConstants.RIGHT);
		Calcframe.getContentPane().add(CalcScreen);
		CalcScreen.setColumns(10);
		
		JButton SqrtKey = new JButton("\u221A");
		SqrtKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				double a= Math.sqrt(Double.parseDouble(CalcScreen.getText()));
				CalcScreen.setText("");
				CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Square root function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		SqrtKey.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SqrtKey.setBounds(10, 141, 60, 51);
		Calcframe.getContentPane().add(SqrtKey);
		
		JButton FractKey = new JButton("1/x");
		FractKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double a= 1/(Double.parseDouble(CalcScreen.getText()));
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Fractional function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		FractKey.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FractKey.setBounds(10, 192, 60, 51);
		Calcframe.getContentPane().add(FractKey);
		
		JButton FactorialKey = new JButton("n!");
		FactorialKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						double a = Double.parseDouble(CalcScreen.getText());
						double fact=1;
						while(a!=0){
						fact=fact*a;
						a--;
						}
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+fact);
			}
			
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null , "Syntax Error\n" , 
						"Factorial function error message" ,JOptionPane.WARNING_MESSAGE);
			}
			}
		});
		FactorialKey.setFont(new Font("Tahoma", Font.PLAIN, 21));
		FactorialKey.setBounds(10, 396, 60, 51);
		Calcframe.getContentPane().add(FactorialKey);
		
		JButton PlusMinusKey = new JButton("+/-");
		PlusMinusKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double a = Double.parseDouble(String.valueOf(CalcScreen.getText()));
					a=a*(-1);  
					CalcScreen.setText(String.valueOf(a));
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"PlusMinus function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		PlusMinusKey.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PlusMinusKey.setBounds(10, 447, 60, 51);
		Calcframe.getContentPane().add(PlusMinusKey);
		
		JButton num7 = new JButton("7");
		num7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num7.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1 , 
							"Number 7 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num7.setFont(new Font("Tahoma", Font.BOLD, 22));
		num7.setBounds(70, 294, 60, 51);
		Calcframe.getContentPane().add(num7);
		
		JButton num4 = new JButton("4");
		num4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num4.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Number 4 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num4.setFont(new Font("Tahoma", Font.BOLD, 22));
		num4.setBounds(70, 345, 60, 51);
		Calcframe.getContentPane().add(num4);
		
		JButton num1 = new JButton("1");
		num1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num1.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e2) {
					JOptionPane.showMessageDialog(null , e2  , 
							"Number 1 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num1.setFont(new Font("Tahoma", Font.BOLD, 22));
		num1.setBounds(70, 396, 60, 51);
		Calcframe.getContentPane().add(num1);
		
		JButton SinKey = new JButton("sin");
		SinKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rand = Math.toRadians(Double.parseDouble(CalcScreen.getText()));
					double sinres= Math.sin(rand);
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+sinres);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"PlusMinus function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		SinKey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SinKey.setBounds(130, 141, 60, 51);
		Calcframe.getContentPane().add(SinKey);
		
		JButton num8 = new JButton("8");
		num8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String number=CalcScreen.getText()+num8.getText();
				CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Number 1 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		num8.setFont(new Font("Tahoma", Font.BOLD, 22));
		num8.setBounds(130, 294, 60, 51);
		Calcframe.getContentPane().add(num8);
		
		JButton num5 = new JButton("5");
		num5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num5.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Number 5 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num5.setFont(new Font("Tahoma", Font.BOLD, 22));
		num5.setBounds(130, 345, 60, 51);
		Calcframe.getContentPane().add(num5);
		
		JButton num2 = new JButton("2");
		num2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num2.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Number 2 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num2.setFont(new Font("Tahoma", Font.BOLD, 22));
		num2.setBounds(130, 396, 60, 51);
		Calcframe.getContentPane().add(num2);
		
		JButton num0 = new JButton("0");
		num0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num0.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Number 0 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num0.setFont(new Font("Tahoma", Font.BOLD, 22));
		num0.setBounds(70, 447, 120, 51);
		Calcframe.getContentPane().add(num0);
		
		JButton DeleteKey = new JButton("\uF0E7");
		DeleteKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backSpace=null;
				if(CalcScreen.getText().length()>0)
				{
					try {
						StringBuilder str = new StringBuilder(CalcScreen.getText());
						str.deleteCharAt(CalcScreen.getText().length()-1);
						backSpace= str.toString();
						CalcScreen.setText(backSpace);
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null , e1  , 
								"PlusMinus function error message" ,JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		DeleteKey.setFont(new Font("Wingdings", Font.PLAIN, 22));
		DeleteKey.setBounds(190, 243, 60, 51);
		Calcframe.getContentPane().add(DeleteKey);
		
		JButton num9 = new JButton("9");
		num9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num9.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Number 9 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num9.setFont(new Font("Tahoma", Font.BOLD, 22));
		num9.setBounds(190, 294, 60, 51);
		Calcframe.getContentPane().add(num9);
		
		JButton num6 = new JButton("6");
		num6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num6.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Number 6 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num6.setFont(new Font("Tahoma", Font.BOLD, 22));
		num6.setBounds(190, 345, 60, 51);
		Calcframe.getContentPane().add(num6);
		
		JButton num3 = new JButton("3");
		num3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String number= CalcScreen.getText()+num3.getText();
					CalcScreen.setText(number);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Number 3 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		num3.setFont(new Font("Tahoma", Font.BOLD, 22));
		num3.setBounds(190, 396, 60, 51);
		Calcframe.getContentPane().add(num3);
		
		JButton DotKey = new JButton(".");
		DotKey.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					if(!CalcScreen.getText().isEmpty()) {
						String input = CalcScreen.getText();
						String dot = input +DotKey.getText();
						CalcScreen.setText(dot);
					}
					else {
					JOptionPane.showMessageDialog(null , "You can't start an operation with a dot"  , 
							"Number 3 function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		DotKey.setFont(new Font("Serif", Font.BOLD, 22));
		DotKey.setBounds(190, 447, 60, 51);
		Calcframe.getContentPane().add(DotKey);
		
		JButton EqualKey = new JButton("=");
		EqualKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!CalcScreen.getText().isEmpty()) {
				try {
					secondInput = Double.parseDouble(CalcScreen.getText());
					if(opsPerformed=="+")
					{
						finalRes=firstInput+secondInput;
						res= String.format("%.2f", finalRes);
						CalcScreen.setText(res);
					}
					else if(opsPerformed=="-")
					{
						finalRes=firstInput-secondInput;
						res= String.format("%.2f", finalRes);
						CalcScreen.setText(res);
					}
					else if(opsPerformed=="*")
					{
						finalRes=firstInput*secondInput;
						res= String.format("%.2f", finalRes);
						CalcScreen.setText(res);
					}
					else if(opsPerformed=="/")
					{
						finalRes=firstInput/secondInput;
						res= String.format("%.2f", finalRes);
						CalcScreen.setText(res);
					}
					else if(opsPerformed=="%")
					{
						finalRes=firstInput%secondInput;
						res= String.format("%.2f", finalRes);
						CalcScreen.setText(res);
					}
					else if(opsPerformed=="x^y")
					{
						double finalRest=1;
						for(int i=0;i<secondInput;i++)
						{
							finalRest=firstInput*finalRest;
						}
						res= String.format("%.2f", finalRest);
						CalcScreen.setText(res);
						
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error"  , 
							"Equal function error message" ,JOptionPane.WARNING_MESSAGE);
				}
				}
				else {
					CalcScreen.setText(null);
				}
			}
		});
		EqualKey.setFont(new Font("Tahoma", Font.PLAIN, 22));
		EqualKey.setBounds(250, 447, 60, 51);
		Calcframe.getContentPane().add(EqualKey);
		
		JButton SumKey = new JButton("+");
		SumKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					firstInput=Double.parseDouble(CalcScreen.getText());
					CalcScreen.setText(null);
					opsPerformed="+";
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Sum function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		SumKey.setFont(new Font("Tahoma", Font.PLAIN, 22));
		SumKey.setBounds(250, 243, 60, 51);
		Calcframe.getContentPane().add(SumKey);
		
		JButton MinusKey = new JButton("-");
		MinusKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					firstInput=Double.parseDouble(CalcScreen.getText());
					CalcScreen.setText(null);
					opsPerformed="-";
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Minus function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		MinusKey.setFont(new Font("Tahoma", Font.PLAIN, 22));
		MinusKey.setBounds(250, 294, 60, 51);
		Calcframe.getContentPane().add(MinusKey);
		
		JButton Multiplykey = new JButton("*");
		Multiplykey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					firstInput=Double.parseDouble(CalcScreen.getText());
					CalcScreen.setText(null);
					opsPerformed="*";
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Multiply function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		Multiplykey.setFont(new Font("Tahoma", Font.PLAIN, 22));
		Multiplykey.setBounds(250, 345, 60, 51);
		Calcframe.getContentPane().add(Multiplykey);
		
		JButton DivideKey = new JButton("/");
		DivideKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					firstInput=Double.parseDouble(CalcScreen.getText());
					CalcScreen.setText(null);
					opsPerformed="/";
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Divide function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		DivideKey.setFont(new Font("Tahoma", Font.PLAIN, 22));
		DivideKey.setBounds(250, 396, 60, 51);
		Calcframe.getContentPane().add(DivideKey);
		
		JButton PowerKey = new JButton("x^y");
		PowerKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					firstInput=Double.parseDouble(CalcScreen.getText());
					CalcScreen.setText(null);
					opsPerformed="x^y";
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Power function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		PowerKey.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PowerKey.setBounds(10, 243, 60, 51);
		Calcframe.getContentPane().add(PowerKey);
		
		JButton ModuloKey = new JButton("%");
		ModuloKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					firstInput=Double.parseDouble(CalcScreen.getText());
					CalcScreen.setText(null);
					opsPerformed="%";
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Modulo function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		ModuloKey.setFont(new Font("Tahoma", Font.BOLD, 20));
		ModuloKey.setBounds(70, 243, 60, 51);
		Calcframe.getContentPane().add(ModuloKey);
		
		JButton ClearKey = new JButton("C");
		ClearKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				CalcScreen.setText(null);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , e1  , 
							"Clear function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		ClearKey.setFont(new Font("Tahoma", Font.BOLD, 22));
		ClearKey.setBounds(130, 243, 60, 51);
		Calcframe.getContentPane().add(ClearKey);
		
		JButton ClearKeyube = new JButton("x^3");
		ClearKeyube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double a= (Double.parseDouble(CalcScreen.getText()));
					a=a*a*a;
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Clear function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			
			}
		});
		ClearKeyube.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ClearKeyube.setBounds(10, 294, 60, 51);
		Calcframe.getContentPane().add(ClearKeyube);
		
		JButton SqareKey = new JButton("x^2");
		SqareKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double a= (Double.parseDouble(CalcScreen.getText()));
					a=a*a;
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Square function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		SqareKey.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SqareKey.setBounds(10, 345, 60, 51);
		Calcframe.getContentPane().add(SqareKey);
		
		JButton CosKey = new JButton("cos");
		CosKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rand = Math.toRadians(Double.parseDouble(CalcScreen.getText()));
					double a= Math.cos(rand);
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Cos function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		CosKey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		CosKey.setBounds(190, 141, 60, 51);
		Calcframe.getContentPane().add(CosKey);
		
		JButton TanKey = new JButton("tan");
		TanKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rand = Math.toRadians(Double.parseDouble(CalcScreen.getText()));
					double a= Math.tan(rand);
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Tan function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		TanKey.setFont(new Font("Tahoma", Font.PLAIN, 18));
		TanKey.setBounds(250, 141, 60, 51);
		Calcframe.getContentPane().add(TanKey);
		
		JButton TanhKey = new JButton("tanh");
		TanhKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rand = Math.toRadians(Double.parseDouble(CalcScreen.getText()));
					double a= Math.tanh(rand);
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Tanh function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		TanhKey.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TanhKey.setBounds(250, 192, 60, 51);
		Calcframe.getContentPane().add(TanhKey);
		
		JButton CosKeyh = new JButton("cosh");
		CosKeyh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rand = Math.toRadians(Double.parseDouble(CalcScreen.getText()));
					double a= Math.cosh(rand);
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Cosh function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		CosKeyh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		CosKeyh.setBounds(190, 192, 60, 51);
		Calcframe.getContentPane().add(CosKeyh);
		
		JButton SinhKey = new JButton("sinh");
		SinhKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rand = Math.toRadians(Double.parseDouble(CalcScreen.getText()));
					double a= Math.sinh(rand);
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Sinh function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		SinhKey.setFont(new Font("Tahoma", Font.PLAIN, 14));
		SinhKey.setBounds(130, 192, 60, 51);
		Calcframe.getContentPane().add(SinhKey);
		
		JButton LogarithmKey = new JButton("Log");
		LogarithmKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double rand = Double.parseDouble(CalcScreen.getText());
					double a = Math.log(rand);
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Logarithm function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		LogarithmKey.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LogarithmKey.setBounds(70, 192, 60, 51);
		Calcframe.getContentPane().add(LogarithmKey);
		
		JButton ExpKey = new JButton("e^x");
		ExpKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double a= Math.exp(Double.parseDouble(CalcScreen.getText()));
					CalcScreen.setText("");
					CalcScreen.setText(CalcScreen.getText()+a);
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null , "Syntax Error\n"  , 
							"Exponential function error message" ,JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		ExpKey.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ExpKey.setBounds(70, 141, 60, 51);
		Calcframe.getContentPane().add(ExpKey);
		
		JRadioButton rdbtnOn = new JRadioButton("On");
		rdbtnOn.setSelected(true);
		rdbtnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcScreen.setEditable(true);
				num0.setEnabled(true);
				num1.setEnabled(true);
				num2.setEnabled(true);
				num3.setEnabled(true);
				num4.setEnabled(true);
				num5.setEnabled(true);
				num6.setEnabled(true);
				num7.setEnabled(true);
				num8.setEnabled(true);
				num9.setEnabled(true);
				
				EqualKey.setEnabled(true);
				SumKey.setEnabled(true);
				MinusKey.setEnabled(true);
				Multiplykey.setEnabled(true);
				DivideKey.setEnabled(true);
				ModuloKey.setEnabled(true);
				
				SinKey.setEnabled(true);
				SinhKey.setEnabled(true);
				CosKey.setEnabled(true);
				CosKeyh.setEnabled(true);
				TanKey.setEnabled(true);
				TanhKey.setEnabled(true);
				
				LogarithmKey.setEnabled(true);
				ExpKey.setEnabled(true);
				DeleteKey.setEnabled(true);
				ClearKey.setEnabled(true);
				SqrtKey.setEnabled(true);
				PlusMinusKey.setEnabled(true);
				ClearKeyube.setEnabled(true);
				SqareKey.setEnabled(true);
				PowerKey.setEnabled(true);
				FractKey.setEnabled(true);
				FactorialKey.setEnabled(true);
				DotKey.setEnabled(true);
			}
		});
		GroupBtnKey.add(rdbtnOn);
		rdbtnOn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOn.setBounds(10, 114, 43, 21);
		Calcframe.getContentPane().add(rdbtnOn);
		
		JRadioButton rdbtnOff = new JRadioButton("Off");
		rdbtnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalcScreen.setEditable(false);
				CalcScreen.setText(null);
				num0.setEnabled(false);
				num1.setEnabled(false);
				num2.setEnabled(false);
				num3.setEnabled(false);
				num4.setEnabled(false);
				num5.setEnabled(false);
				num6.setEnabled(false);
				num7.setEnabled(false);
				num8.setEnabled(false);
				num9.setEnabled(false);
				EqualKey.setEnabled(false);
				SumKey.setEnabled(false);
				MinusKey.setEnabled(false);
				Multiplykey.setEnabled(false);
				DivideKey.setEnabled(false);
				ModuloKey.setEnabled(false);
				
				SinKey.setEnabled(false);
				SinhKey.setEnabled(false);
				CosKey.setEnabled(false);
				CosKeyh.setEnabled(false);
				TanKey.setEnabled(false);
				TanhKey.setEnabled(false);
				
				LogarithmKey.setEnabled(false);
				ExpKey.setEnabled(false);
				DeleteKey.setEnabled(false);
				ClearKey.setEnabled(false);
				SqrtKey.setEnabled(false);
				PlusMinusKey.setEnabled(false);
				ClearKeyube.setEnabled(false);
				SqareKey.setEnabled(false);
				PowerKey.setEnabled(false);
				FractKey.setEnabled(false);
				FactorialKey.setEnabled(false);
				DotKey.setEnabled(false);
			}
		});
		GroupBtnKey.add(rdbtnOff);
		rdbtnOff.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnOff.setBounds(70, 114, 51, 21);
		Calcframe.getContentPane().add(rdbtnOff);
	}
}