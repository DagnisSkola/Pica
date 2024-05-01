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

		setContentPane(contentPane);	
		contentPane.setLayout(null);
		
		ArrayList<Object> Picas = PicaPasutijums.Picas;
		StringBuilder str = new StringBuilder();
		int y = 23;
		for (Object obj : Picas) {
		    if (obj instanceof Pica) {
		        Pica pica = (Pica) obj;
		        System.out.println(pica.displayDetails());
		    }
		}
		for (Object o : Picas) {
		    JLabel pizzaLabel = new JLabel(((Pica) o).displayDetails());
		    pizzaLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
		    pizzaLabel.setVerticalAlignment(SwingConstants.TOP);
		    pizzaLabel.setHorizontalAlignment(SwingConstants.LEFT);
		    pizzaLabel.setBounds(44, y, 931, 20); // Adjust the bounds as needed
		    contentPane.add(pizzaLabel);
		    y += 20; // Increment y-coordinate for the next JLabel
		}
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setText(str.toString());
		lblNewLabel.setBounds(44, 23, 931, 342);
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
	}
}