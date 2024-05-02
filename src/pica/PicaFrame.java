package pica;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class PicaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static boolean counter=false;

	//Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicaFrame frame = new PicaFrame();
					frame.setVisible(true);
					if(counter==false) {
						PicaPasutijums.ielasit("Pizza.txt");
						counter=true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 //Create the frame.
	public PicaFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 668);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(232, 233, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/PizzaBackground2.png"));
	    JLabel lblBackground = new JLabel(backgroundImageIcon);
	    lblBackground.setLayout(new BorderLayout());
	    lblBackground.setBounds(-30, -76, 690, 778);
	    contentPane.add(lblBackground);
        
		JLabel lblLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/PizzaLogo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(-59, 11, 554, 200);
		contentPane.add(lblLogo);
		
		JButton btnOrder = new JButton("Create Order");
		btnOrder.setBackground(new Color(255, 220, 185));
		btnOrder.setForeground(new Color(128, 0, 0));
		btnOrder.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnOrder.setToolTipText("");
		ImageIcon buttonIcon = new ImageIcon(getClass().getResource("/create.png"));
		btnOrder.setIcon(buttonIcon);
		btnOrder.setOpaque(false);
		btnOrder.setContentAreaFilled(false);
		btnOrder.setBorderPainted(false);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaPasutijums.Pasutijums();
				PicaFrame.this.setVisible(false);	
			}
		});
		btnOrder.setBounds(60, 195, 355, 126);
		contentPane.add(btnOrder);
		
		JButton btnView = new JButton("View Orders");
		btnView.setBackground(new Color(255, 220, 185));
		btnView.setForeground(new Color(128, 0, 0));
		ImageIcon buttonIcon1 = new ImageIcon(getClass().getResource("/view.png"));
		btnView.setIcon(buttonIcon1);
		btnView.setOpaque(false);
		btnView.setContentAreaFilled(false);
		btnView.setBorderPainted(false);
		btnView.addActionListener(new ActionListener() {
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
		btnView.setToolTipText("");
		btnView.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnView.setBounds(60, 319, 348, 115);
		contentPane.add(btnView);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(255, 220, 185));
		btnExit.setForeground(new Color(128, 0, 0));
		ImageIcon buttonIcon2 = new ImageIcon(getClass().getResource("/exit.png"));
		btnExit.setIcon(buttonIcon2);
		btnExit.setOpaque(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setToolTipText("");
		btnExit.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnExit.setBounds(36, 442, 379, 115);
		contentPane.add(btnExit);
		
		contentPane.setComponentZOrder(lblBackground, contentPane.getComponentCount() - 1); //lblBackground
	}
}
