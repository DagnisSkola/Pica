package pica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
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
import javax.swing.JTextField;

public class PicaPasutijums extends JFrame {	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int pasNr=0;
	public double topping = 0, deliver = 0, size = 0, totCost;
	private String telNr;
	private boolean deliveryStatus;
	private static boolean counter=false;
	static ArrayList<Object> Picas = new ArrayList<>();
	private JTextField txtThty;	
	
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
					if(counter==false) {
						ielasit("Pizza.txt");
						counter=true;
					}
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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("20 cm 7.99€");
		rdbtnNewRadioButton.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(211, 171, 119, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtnNewRadioButton.isSelected())
		            size=7.99;
		        System.out.println(size);
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		    }
		});
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("30 cm 14.99€");
		rdbtnNewRadioButton_1.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(211, 198, 119, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtnNewRadioButton_1.isSelected())
		            size=14.99;
		        System.out.println(size);
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		    }
		});
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("50 cm 20.99€");
		rdbtnNewRadioButton_1_1.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtnNewRadioButton_1_1.setBounds(211, 224, 119, 23);
		contentPane.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtnNewRadioButton_1_1.isSelected())
		            size=20.99;
		        System.out.println(size);
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(topping+size+deliver))+"€");
		    }
		});
		
		ButtonGroup sizeGroup = new ButtonGroup();
		sizeGroup.add(rdbtnNewRadioButton);
		sizeGroup.add(rdbtnNewRadioButton_1);
		sizeGroup.add(rdbtnNewRadioButton_1_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaFrame.main(null);
				PicaPasutijums.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnNewButton.setBounds(209, 439, 111, 53);
		contentPane.add(btnNewButton);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(size>0&&telNr.length()==13) {
		    		boolean currentDeliveryStatus = deliveryStatus;
		            if(deliver > 0)
		                currentDeliveryStatus = true;
		            int currentPasNr = (Pica.getTPasNr() == 0) ? 1 : (Pica.getTPasNr() + 1);
		            Picas.add(new Pica(topping, size, telNr, currentDeliveryStatus, currentPasNr, totCost));
		            StringBuilder str = new StringBuilder("Pizza amount: " + Picas.size() + "\n");
		            dzest("Pizza.txt");
		            for (Object o : Picas) {
		                Pica pica = (Pica) o;
		                System.out.println(pica.displayDetails());
		            }
		            saglabat(Picas);
		            PicaNoformejums.Noformejums();
		            PicaPasutijums.this.setVisible(false);
		    	}
		    }
		});
		btnContinue.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnContinue.setBounds(338, 439, 111, 53);
		contentPane.add(btnContinue);
		
		lblTotalCost.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalCost.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblTotalCost.setBounds(287, 338, 354, 50);
		contentPane.add(lblTotalCost);
		
		JLabel lblNewLabel_1 = new JLabel("0.50€ each");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.BOLD, 13));
		lblNewLabel_1.setBounds(30, 154, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		txtThty = new JTextField();
		txtThty.setText("+371 ");
		telNr = txtThty.getText();
		txtThty.setBounds(439, 135, 150, 23);
		txtThty.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
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
		        telNr = txtThty.getText();
		        System.out.println(telNr);
		    }
		});
		contentPane.add(txtThty);
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
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Yes 2.99€");
		rdbtnNewRadioButton_2.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtnNewRadioButton_2.setBounds(461, 169, 97, 24);
		contentPane.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtnNewRadioButton_2.isSelected())
		            deliver=2.99;
		        System.out.println(deliver);
		        totCost=topping+size+deliver;
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(totCost))+"€");
		    }
		});
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("No 0.00€");
		rdbtnNewRadioButton_2_1.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtnNewRadioButton_2_1.setBounds(461, 197, 88, 24);
		contentPane.add(rdbtnNewRadioButton_2_1);
		rdbtnNewRadioButton_2_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (rdbtnNewRadioButton_2_1.isSelected())
		            deliver=0.00;
		        System.out.println(deliver);
		        totCost=topping+size+deliver;
				lblTotalCost.setText("Total cost: " + String.format("%.2f",(totCost))+"€");
		    }
		});
		
		ButtonGroup deliverGroup = new ButtonGroup();
		deliverGroup.add(rdbtnNewRadioButton_2);
		deliverGroup.add(rdbtnNewRadioButton_2_1);
	}
}
