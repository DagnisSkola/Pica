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

	private static final long serialVersionUID = 1L;
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
		setBounds(100, 100, 722, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReceipt = new JLabel("Receipt :");
		lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceipt.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblReceipt.setBounds(119, 25, 451, 69);
		contentPane.add(lblReceipt);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaPasutijums.Pasutijums();
				PicaNoformejums.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnNewButton.setBounds(225, 372, 111, 53);
		contentPane.add(btnNewButton);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaFrame.main(null);
				PicaNoformejums.this.setVisible(false);
			}
		});
		btnContinue.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnContinue.setBounds(346, 372, 111, 53);
		contentPane.add(btnContinue);
		
		JLabel lblToppings = new JLabel("Toppings: ");
		lblToppings.setHorizontalAlignment(SwingConstants.LEFT);
		lblToppings.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblToppings.setBounds(147, 105, 134, 45);
		contentPane.add(lblToppings);
		
		JLabel lblSize = new JLabel("Size: ");
		lblSize.setHorizontalAlignment(SwingConstants.LEFT);
		lblSize.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblSize.setBounds(147, 148, 134, 45);
		contentPane.add(lblSize);
		
		JLabel lblDelivery = new JLabel("Delivery: ");
		lblDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lblDelivery.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblDelivery.setBounds(147, 192, 134, 45);
		contentPane.add(lblDelivery);
		
		JLabel lblTotal = new JLabel("Total: ");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("Ink Free", Font.BOLD, 30));
		lblTotal.setBounds(147, 275, 134, 45);
		contentPane.add(lblTotal);
	}
}
