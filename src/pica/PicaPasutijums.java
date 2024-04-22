package pica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class PicaPasutijums extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create an order :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 30));
		lblNewLabel.setBounds(93, 30, 451, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblToppings = new JLabel("Toppings :");
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblToppings.setBounds(23, 121, 111, 47);
		contentPane.add(lblToppings);
		
		JLabel lblSize = new JLabel("Size :");
		lblSize.setHorizontalAlignment(SwingConstants.LEFT);
		lblSize.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblSize.setBounds(196, 121, 111, 47);
		contentPane.add(lblSize);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Cheese");
		chckbxNewCheckBox.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxNewCheckBox.setBounds(34, 170, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxSauce = new JCheckBox("Sauce");
		chckbxSauce.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxSauce.setBounds(34, 198, 97, 23);
		contentPane.add(chckbxSauce);
		
		JCheckBox chckbxPepperoni = new JCheckBox("Pepperoni");
		chckbxPepperoni.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxPepperoni.setBounds(34, 224, 97, 23);
		contentPane.add(chckbxPepperoni);
		
		JCheckBox chckbxSausage = new JCheckBox("Sausage");
		chckbxSausage.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxSausage.setBounds(34, 250, 97, 23);
		contentPane.add(chckbxSausage);
		
		JCheckBox chckbxHam = new JCheckBox("Ham");
		chckbxHam.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxHam.setBounds(34, 276, 97, 23);
		contentPane.add(chckbxHam);
		
		JCheckBox chckbxMushrooms = new JCheckBox("Mushrooms");
		chckbxMushrooms.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxMushrooms.setBounds(34, 302, 101, 23);
		contentPane.add(chckbxMushrooms);
		
		JCheckBox chckbxGreenPeppers = new JCheckBox("Green Peppers");
		chckbxGreenPeppers.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxGreenPeppers.setBounds(34, 328, 131, 23);
		contentPane.add(chckbxGreenPeppers);
		
		JCheckBox chckbxPineapple = new JCheckBox("Pineapple");
		chckbxPineapple.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxPineapple.setBounds(34, 354, 131, 23);
		contentPane.add(chckbxPineapple);
		
		JCheckBox chckbxBlackOlives = new JCheckBox("Black Olives");
		chckbxBlackOlives.setFont(new Font("Ink Free", Font.BOLD, 15));
		chckbxBlackOlives.setBounds(34, 380, 131, 23);
		contentPane.add(chckbxBlackOlives);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("20 cm");
		rdbtnNewRadioButton.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtnNewRadioButton.setBounds(211, 171, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("30 cm");
		rdbtnNewRadioButton_1.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtnNewRadioButton_1.setBounds(211, 211, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("50 cm");
		rdbtnNewRadioButton_1_1.setFont(new Font("Ink Free", Font.BOLD, 15));
		rdbtnNewRadioButton_1_1.setBounds(211, 250, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1_1);
	}
}
