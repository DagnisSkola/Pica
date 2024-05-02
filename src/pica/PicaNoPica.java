package pica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PicaNoPica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void NoPizza() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicaNoPica frame = new PicaNoPica();
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
	public PicaNoPica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaFrame.main(null);
				PicaNoPica.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnNewButton.setBounds(157, 197, 111, 53);
		contentPane.add(btnNewButton);
		
		JLabel lblNoPicas = new JLabel("NO PIZZA!");
		lblNoPicas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoPicas.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblNoPicas.setBounds(54, 45, 307, 69);
		contentPane.add(lblNoPicas);
		
		JLabel lblNoPicas_1 = new JLabel(":(");
		lblNoPicas_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoPicas_1.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblNoPicas_1.setBounds(54, 103, 307, 69);
		contentPane.add(lblNoPicas_1);
	}
}
