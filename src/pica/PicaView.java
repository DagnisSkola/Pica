package pica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PicaView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void View() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PicaView frame = new PicaView();
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
	public PicaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);	
		contentPane.setLayout(null);
		
		ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/noteBack.png"));
	    JLabel lblBackground = new JLabel(backgroundImageIcon);
	    lblBackground.setLayout(new BorderLayout());
	    lblBackground.setBounds(0, 0, 1045, 778);
	    contentPane.add(lblBackground);
		
		ArrayList<Object> Picas = PicaPasutijums.Picas;
		StringBuilder str = new StringBuilder();
		int y = 90;
		for (Object o : Picas) {
		    JLabel pizzaLabel = new JLabel(((Pica) o).displayDetails());
		    pizzaLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
		    pizzaLabel.setVerticalAlignment(SwingConstants.TOP);
		    pizzaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		    pizzaLabel.setBounds(44, y, 931, 30); // Adjust the bounds as needed
		    contentPane.add(pizzaLabel);
		    y += 30;
		}
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setText(str.toString());
		lblNewLabel.setBounds(44, 114, 658, 251);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setOpaque(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaFrame.main(null);
				PicaView.this.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Ink Free", Font.BOLD, 30));
		btnBack.setBounds(440, 383, 111, 53);
		contentPane.add(btnBack);
		
		JLabel lblOrders = new JLabel("Orders :");
		lblOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrders.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblOrders.setBounds(274, 23, 451, 69);
		contentPane.add(lblOrders);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setOpaque(false);
		comboBox.setFont(new Font("Ink Free", Font.BOLD, 15));
	    comboBox.setBounds(735, 132, 155, 40);
	    for (Object o : Picas) {
	        comboBox.addItem("Order "+((Pica) o).getPasNr());
	    }
	    contentPane.add(comboBox);
		
		JLabel lblRemove = new JLabel("Remove :");
		lblRemove.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove.setFont(new Font("Ink Free", Font.BOLD, 25));
		lblRemove.setBounds(761, 77, 196, 69);
		contentPane.add(lblRemove);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setOpaque(false);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedItem = (String) comboBox.getSelectedItem();
		        if (selectedItem != null) {
		            for (Object o : Picas) {
		                if (("Order "+((Pica) o).getPasNr()).equals(selectedItem)) {
		                    Picas.remove(o);
		                    break;
		                }
		            }
		            comboBox.removeItem(selectedItem);
		        }
		        PicaView.this.setVisible(false);
		        PicaView.View();
		    }
		});
		btnDelete.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnDelete.setBounds(891, 132, 103, 40);
		contentPane.add(btnDelete);
		
		contentPane.setComponentZOrder(lblBackground, contentPane.getComponentCount() - 1);
	}
}