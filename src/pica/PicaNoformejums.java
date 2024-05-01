package pica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PicaNoformejums extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Noformejums() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicaNoformejums frame = new PicaNoformejums();
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
	public PicaNoformejums() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReceipt = new JLabel("Receipt :");
		lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceipt.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblReceipt.setBounds(50, 25, 451, 69);
		contentPane.add(lblReceipt);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaFrame.main(null);
				PicaNoformejums.this.setVisible(false);
			}
		});
		btnContinue.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnContinue.setBounds(212, 372, 111, 53);
		contentPane.add(btnContinue);
		
		JLabel lblToppings = new JLabel("Toppings: "+Pica.getTopping()+"0€");
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblToppings.setBounds(60, 113, 402, 45);
		contentPane.add(lblToppings);
		
		JLabel lblSize = new JLabel("Size: "+Pica.getSize()+"€");
		lblSize.setHorizontalAlignment(SwingConstants.LEFT);
		lblSize.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblSize.setBounds(60, 156, 430, 45);
		contentPane.add(lblSize);	
		
		double Delivery = 0;
		if(Pica.getDeliver())
			Delivery = 2.49;
		JLabel lblDelivery = new JLabel("Delivery: "+Delivery+"€");
		lblDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lblDelivery.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblDelivery.setBounds(60, 200, 407, 45);
		contentPane.add(lblDelivery);
		
		JLabel lblTotal = new JLabel("Total: "+String.format("%.2f",(Pica.getTopping()+Pica.getSize()+Delivery))+"€");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("Ink Free", Font.BOLD, 30));
		lblTotal.setBounds(60, 283, 402, 45);
		contentPane.add(lblTotal);
	}
	
	
}
