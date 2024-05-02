package pica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PicaNoPica extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	//Launch the application.
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

	//Create the frame.
	public PicaNoPica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPDeliver = new JLabel("");
		Image imgD = new ImageIcon(this.getClass().getResource("/sad.png")).getImage();
		lblPDeliver.setIcon(new ImageIcon(imgD));
		lblPDeliver.setBounds(120, 80, 191, 150);
		contentPane.add(lblPDeliver);
		
		ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/noteBack.png"));
	    JLabel lblBackground = new JLabel(backgroundImageIcon);
	    lblBackground.setLayout(new BorderLayout());
	    lblBackground.setBounds(0, 0, 1045, 778);
	    contentPane.add(lblBackground);
		
		JButton btnBack = new JButton("Back");
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaFrame.main(null);
				PicaNoPica.this.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Ink Free", Font.BOLD, 30));
		btnBack.setBounds(161, 230, 111, 53);
		contentPane.add(btnBack);
		
		JLabel lblNoPicas = new JLabel("NO PIZZA...");
		lblNoPicas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoPicas.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblNoPicas.setBounds(58, 23, 307, 69);
		contentPane.add(lblNoPicas);
		
		contentPane.setComponentZOrder(lblBackground, contentPane.getComponentCount() - 1);
	}
}
