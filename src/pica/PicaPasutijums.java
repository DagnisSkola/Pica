package pica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class PicaPasutijums extends JFrame {	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int pasNr=0;
	public double topping = 0, deliver = 1, size = 0, totCost;
	private String telNr;
	private boolean deliveryStatus;
	static ArrayList<Object> Picas = new ArrayList<>();
	private JTextField txtTelNr;	
	
	static ArrayList<Object> ielasit(String failaVards) {
	    try {
	        File fails = new File(failaVards);
	        Scanner lasitajs = new Scanner(fails);

	        while (lasitajs.hasNextLine()) {
	            String rinda = lasitajs.nextLine();
	            String[] parts = rinda.split(", ");

	            int pasNrF = Integer.parseInt(parts[0].split(" ")[1]);
	            double totCost = Double.parseDouble(parts[1].split(" ")[1].replace("€", ""));
	            String telNr = parts[2].split(" ")[1];
	            boolean deliver = parts[3].equals("With delivery");
	            System.out.println(pasNrF+" "+totCost+" "+telNr+" "+deliver);

	            double topping = 0.0;
	            double size = 0.0;

	            Picas.add(new Pica(topping, size, telNr, deliver, pasNrF, totCost));
	            
	            for (Object o : Picas) {
	                Pica pica = (Pica) o;
	                System.out.println(pica.displayDetails());
	            }
	            dzest("Pizza.txt");
	        }
	        lasitajs.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("Fails " + failaVards + " netika atrasts!");
	    } catch (Exception e) {
	        System.out.println("Radās kļūda ielasot failu!");
	    }
	    return Picas;
	}
	
	static void saglabat(ArrayList<Object> Picas) {
	    try {
	        // Delete the existing file
	        dzest("Pizza.txt");

	        // Create a new FileWriter with append mode set to false
	        FileWriter fw = new FileWriter("Pizza.txt", false);
	        PrintWriter pw = new PrintWriter(fw);

	        // Write new data to the file
	        for (Object o : Picas) {
	            Pica pica = (Pica) o;
	            pw.println(pica.displayDetails());
	        }

	        // Close the PrintWriter
	        pw.close();

	        System.out.println("Skaitļi saglabāti failā Pizza.txt");
	    } catch (IOException e) {
	        System.out.println("Radās kļūda saglabājot failā!");
	    }
	}

	    static void dzest(String failaVards) {
	        try {
	            File fails = new File(failaVards);
	            if (fails.exists() && fails.delete()) {
	                System.out.println("Fails " + failaVards + " ir dzēsts!");
	            } else {
	                System.out.println("Fails " + failaVards + " netika atrasts vai nevarēja tikt dzēsts!");
	            }
	        } catch (Exception e) {
	            System.out.println("Radās kļūda dzēšot failu!");
	        }
	    }
	
	/**
	 * Launch the application.
	 */
	public static void Pasutijums() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicaPasutijums frame = new PicaPasutijums();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public PicaPasutijums() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPDeliver = new JLabel("");
		Image imgD = new ImageIcon(this.getClass().getResource("/bike.png")).getImage();
		lblPDeliver.setIcon(new ImageIcon(imgD));
		lblPDeliver.setBounds(461, 203, 111, 108);
		contentPane.add(lblPDeliver);
		
		JLabel lblPizza = new JLabel("");
		Image imgP = new ImageIcon(this.getClass().getResource("/pizza.png")).getImage();
		lblPizza.setIcon(new ImageIcon(imgP));
		lblPizza.setBounds(90, 11, 111, 108);
		contentPane.add(lblPizza);
		JLabel lblPizza2 = new JLabel("");
		lblPizza2.setIcon(new ImageIcon(imgP));
		lblPizza2.setBounds(461, 11, 111, 108);
		contentPane.add(lblPizza2);
		
		ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/noteBack.png"));
	    JLabel lblBackground = new JLabel(backgroundImageIcon);
	    lblBackground.setLayout(new BorderLayout());
	    lblBackground.setBounds(-20, -20, 690, 778);
	    contentPane.add(lblBackground);
	    
		JLabel lblNewLabel = new JLabel("Create an order :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblNewLabel.setBounds(93, 30, 451, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblToppings = new JLabel("Toppings :");
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblToppings.setBounds(20, 133, 111, 23);
		contentPane.add(lblToppings);
		
		JLabel lblSize = new JLabel("Size :");
		lblSize.setHorizontalAlignment(SwingConstants.LEFT);
		lblSize.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblSize.setBounds(196, 121, 111, 47);
		contentPane.add(lblSize);
		
		JLabel lblTotalCost = new JLabel("Total cost: 0.00€");
		
		JCheckBox chckbxCheese = new JCheckBox("Cheese ");
		chckbxCheese.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxCheese.setBounds(34, 170, 119, 23);
		contentPane.add(chckbxCheese);
		chckbxCheese.setOpaque(false);
		chckbxCheese.setContentAreaFilled(false);
		chckbxCheese.setBorderPainted(false);
		chckbxCheese.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxCheese.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
		        lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JCheckBox chckbxSauce = new JCheckBox("Sauce");
		chckbxSauce.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxSauce.setBounds(34, 198, 119, 23);
		contentPane.add(chckbxSauce);
		chckbxSauce.setOpaque(false);
		chckbxSauce.setContentAreaFilled(false);
		chckbxSauce.setBorderPainted(false);
		chckbxSauce.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxSauce.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
		        lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JCheckBox chckbxPepperoni = new JCheckBox("Pepperoni");
		chckbxPepperoni.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxPepperoni.setBounds(34, 224, 97, 23);
		contentPane.add(chckbxPepperoni);
		chckbxPepperoni.setOpaque(false);
		chckbxPepperoni.setContentAreaFilled(false);
		chckbxPepperoni.setBorderPainted(false);
		chckbxPepperoni.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxPepperoni.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JCheckBox chckbxSausage = new JCheckBox("Sausage");
		chckbxSausage.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxSausage.setBounds(34, 250, 97, 23);
		contentPane.add(chckbxSausage);
		chckbxSausage.setOpaque(false);
		chckbxSausage.setContentAreaFilled(false);
		chckbxSausage.setBorderPainted(false);
		chckbxSausage.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxSausage.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JCheckBox chckbxHam = new JCheckBox("Ham");
		chckbxHam.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxHam.setBounds(34, 276, 97, 23);
		contentPane.add(chckbxHam);
		chckbxHam.setOpaque(false);
		chckbxHam.setContentAreaFilled(false);
		chckbxHam.setBorderPainted(false);
		chckbxHam.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxHam.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JCheckBox chckbxMushrooms = new JCheckBox("Mushrooms");
		chckbxMushrooms.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxMushrooms.setBounds(34, 302, 101, 23);
		contentPane.add(chckbxMushrooms);
		chckbxMushrooms.setOpaque(false);
		chckbxMushrooms.setContentAreaFilled(false);
		chckbxMushrooms.setBorderPainted(false);
		chckbxMushrooms.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxMushrooms.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JCheckBox chckbxGreenPeppers = new JCheckBox("Green Peppers");
		chckbxGreenPeppers.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxGreenPeppers.setBounds(34, 328, 131, 23);
		contentPane.add(chckbxGreenPeppers);
		chckbxGreenPeppers.setOpaque(false);
		chckbxGreenPeppers.setContentAreaFilled(false);
		chckbxGreenPeppers.setBorderPainted(false);
		chckbxGreenPeppers.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxGreenPeppers.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JCheckBox chckbxPineapple = new JCheckBox("Pineapple");
		chckbxPineapple.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxPineapple.setBounds(34, 354, 131, 23);
		contentPane.add(chckbxPineapple);
		chckbxPineapple.setOpaque(false);
		chckbxPineapple.setContentAreaFilled(false);
		chckbxPineapple.setBorderPainted(false);
		chckbxPineapple.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxPineapple.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JCheckBox chckbxBlackOlives = new JCheckBox("Black Olives");
		chckbxBlackOlives.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxBlackOlives.setBounds(34, 380, 131, 23);
		contentPane.add(chckbxBlackOlives);
		chckbxBlackOlives.setOpaque(false);
		chckbxBlackOlives.setContentAreaFilled(false);
		chckbxBlackOlives.setBorderPainted(false);
		chckbxBlackOlives.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (chckbxBlackOlives.isSelected()) {
		            topping=topping+0.50;
		        } else {
		            topping=topping-0.50;
		        }
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		        System.out.println(topping);
		    }
		});
		
		JRadioButton rdbtn20cm = new JRadioButton("20 cm 7.99€");
		rdbtn20cm.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtn20cm.setBounds(211, 171, 119, 23);
		contentPane.add(rdbtn20cm);
		rdbtn20cm.setOpaque(false);
		rdbtn20cm.setContentAreaFilled(false);
		rdbtn20cm.setBorderPainted(false);
		rdbtn20cm.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtn20cm.isSelected())
		            size=7.99;
		        System.out.println(size);
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		    }
		});
		
		JRadioButton rdbtn30cm = new JRadioButton("30 cm 14.99€");
		rdbtn30cm.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtn30cm.setBounds(211, 198, 119, 23);
		contentPane.add(rdbtn30cm);
		rdbtn30cm.setOpaque(false);
		rdbtn30cm.setContentAreaFilled(false);
		rdbtn30cm.setBorderPainted(false);
		rdbtn30cm.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtn30cm.isSelected())
		            size=14.99;
		        System.out.println(size);
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		    }
		});
		
		JRadioButton rdbtn50cm = new JRadioButton("50 cm 20.99€");
		rdbtn50cm.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtn50cm.setBounds(211, 224, 119, 23);
		contentPane.add(rdbtn50cm);
		rdbtn50cm.setOpaque(false);
		rdbtn50cm.setContentAreaFilled(false);
		rdbtn50cm.setBorderPainted(false);
		rdbtn50cm.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtn50cm.isSelected())
		            size=20.99;
		        System.out.println(size);
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		    }
		});
		
		ButtonGroup sizeGroup = new ButtonGroup();
		sizeGroup.add(rdbtn20cm);
		sizeGroup.add(rdbtn30cm);
		sizeGroup.add(rdbtn50cm);
		
		JButton btnBack = new JButton("Back");
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaFrame.main(null);
				PicaPasutijums.this.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Ink Free", Font.BOLD, 30));
		btnBack.setBounds(167, 439, 111, 53);
		contentPane.add(btnBack);
		
		txtTelNr = new JTextField();
		txtTelNr.setText("+371");
		telNr = txtTelNr.getText();
		txtTelNr.setBounds(439, 135, 150, 23);
		txtTelNr.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
		    public void changedUpdate(DocumentEvent e) {
		        updateTelNr();
		    }
		    public void removeUpdate(DocumentEvent e) {
		        updateTelNr();
		    }
		    public void insertUpdate(DocumentEvent e) {
		        updateTelNr();
		    }

		    private void updateTelNr() {
		        telNr = txtTelNr.getText();
		        System.out.println(telNr);
		    }
		});
		contentPane.add(txtTelNr);
		System.out.println(telNr);
		
		JLabel lblTel = new JLabel("Tel. :");
		lblTel.setHorizontalAlignment(SwingConstants.LEFT);
		lblTel.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblTel.setBounds(386, 121, 111, 47);
		contentPane.add(lblTel);
		
		JLabel lblDeliver = new JLabel("Deliver :");
		lblDeliver.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeliver.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblDeliver.setBounds(386, 157, 82, 47);
		contentPane.add(lblDeliver);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setOpaque(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setBorderPainted(false);
		btnContinue.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(size>0){
		    		lblSize.setForeground(Color.BLACK);
		    		if(telNr.length()==12){
		    			lblTel.setForeground(Color.BLACK);
		    			if(deliver==0.00||deliver==2.99){
		    				lblDeliver.setForeground(Color.BLACK);
		    				boolean currentDeliveryStatus;
		    				if(deliver==0.00) {
		    					currentDeliveryStatus = false;
		    				}else {
		    					currentDeliveryStatus = true;
		    				}
				            int currentPasNr = (Pica.getTPasNr() == 0) ? 1 : (Pica.getTPasNr() + 1);
				            System.out.println("delStat: "+currentDeliveryStatus);
				            Picas.add(new Pica(topping, size, telNr, currentDeliveryStatus, currentPasNr, totCost));
				            dzest("Pizza.txt");
				            for (Object o : Picas) {
				                Pica pica = (Pica) o;
				                System.out.println(pica.displayDetails());
				            }
				            saglabat(Picas);
				            PicaNoformejums.Noformejums();
				            PicaPasutijums.this.setVisible(false);
		    			}else {
		    				lblDeliver.setForeground(Color.RED);
		    			}
		    		}else {
		    			lblTel.setForeground(Color.RED);
		    		}
		    	}else {
		    		lblSize.setForeground(Color.RED);
		    	}
		    }
		});
		btnContinue.setFont(new Font("Ink Free", Font.BOLD, 30));
		btnContinue.setBounds(302, 439, 181, 53);
		contentPane.add(btnContinue);
		
		lblTotalCost.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalCost.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblTotalCost.setBounds(287, 338, 354, 50);
		contentPane.add(lblTotalCost);
		
		JLabel lblTopCost = new JLabel("0.50€ each");
		lblTopCost.setFont(new Font("Ink Free", Font.BOLD, 13));
		lblTopCost.setBounds(30, 154, 66, 14);
		contentPane.add(lblTopCost);
		
		JRadioButton rbtnYes = new JRadioButton("Yes 2.99€");
		rbtnYes.setFont(new Font("Ink Free", Font.BOLD, 15));
		rbtnYes.setBounds(461, 169, 97, 24);
		contentPane.add(rbtnYes);
		rbtnYes.setOpaque(false);
		rbtnYes.setContentAreaFilled(false);
		rbtnYes.setBorderPainted(false);
		rbtnYes.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rbtnYes.isSelected())
		            deliver=2.99;
		        System.out.println(deliver);
		        totCost=topping+size+deliver;
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(totCost))+"€");
		    }
		});
		
		JRadioButton rbtnNo = new JRadioButton("No 0.00€");
		rbtnNo.setFont(new Font("Ink Free", Font.BOLD, 15));
		rbtnNo.setBounds(461, 197, 88, 24);
		contentPane.add(rbtnNo);
		rbtnNo.setOpaque(false);
		rbtnNo.setContentAreaFilled(false);
		rbtnNo.setBorderPainted(false);
		rbtnNo.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rbtnNo.isSelected())
		            deliver=0.00;
		        System.out.println(deliver);
		        totCost=topping+size+deliver;
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(totCost))+"€");
		    }
		});
		
		ButtonGroup deliverGroup = new ButtonGroup();
		deliverGroup.add(rbtnYes);
		deliverGroup.add(rbtnNo);
		
		contentPane.setComponentZOrder(lblBackground, contentPane.getComponentCount() - 1);
	}
}
