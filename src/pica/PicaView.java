package pica;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Object> Picas = PicaPasutijums.Picas;
		StringBuilder str = new StringBuilder("Pasūtijms Nr. " + Picas.size() + " ");
		for (Object o : Picas) {
			str.append(((Pica) o).displayDetails());
		}
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(str.toString());
		lblNewLabel.setBounds(44, 23, 336, 177);
		contentPane.add(lblNewLabel);
	}
}
