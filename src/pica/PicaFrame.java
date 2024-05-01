package pica;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PicaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicaFrame frame = new PicaFrame();
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
	public PicaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 233, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/pizza.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(79, 11, 334, 200);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Create Order");
		btnNewButton.setBackground(new Color(255, 220, 185));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnNewButton.setToolTipText("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaPasutijums.Pasutijums();
				PicaFrame.this.setVisible(false);	
			}
		});
		btnNewButton.setBounds(126, 222, 229, 77);
		contentPane.add(btnNewButton);
		
		JButton btnApskattPastijumus = new JButton("View Orders");
		btnApskattPastijumus.setBackground(new Color(255, 220, 185));
		btnApskattPastijumus.setForeground(new Color(128, 0, 0));
		btnApskattPastijumus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Object> Picas = PicaPasutijums.Picas;
				if (!Picas.isEmpty()) {
					PicaView.View();
					PicaFrame.this.setVisible(false);	
				} else {
					PicaNoPica.NoPizza();
					PicaFrame.this.setVisible(false);	
				}
			}
		});
		btnApskattPastijumus.setToolTipText("");
		btnApskattPastijumus.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnApskattPastijumus.setBounds(126, 332, 229, 77);
		contentPane.add(btnApskattPastijumus);
		
		JButton btnIziet = new JButton("Exit");
		btnIziet.setBackground(new Color(255, 220, 185));
		btnIziet.setForeground(new Color(128, 0, 0));
		btnIziet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnIziet.setToolTipText("");
		btnIziet.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnIziet.setBounds(126, 442, 229, 77);
		contentPane.add(btnIziet);
	}
}
