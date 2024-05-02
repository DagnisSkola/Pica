package pica;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PicaFrame.main(null);
				PicaView.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnNewButton.setBounds(440, 383, 111, 53);
		contentPane.add(btnNewButton);
		
		JLabel lblOrders = new JLabel("Orders :");
		lblOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrders.setFont(new Font("Ink Free", Font.BOLD, 35));
		lblOrders.setBounds(274, 23, 451, 69);
		contentPane.add(lblOrders);
		
		JComboBox comboBox = new JComboBox();
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
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setFont(new Font("Ink Free", Font.BOLD, 20));
		btnNewButton_1.setBounds(891, 132, 103, 40);
		contentPane.add(btnNewButton_1);
	}
}