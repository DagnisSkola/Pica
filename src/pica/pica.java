package pica;

import javax.swing.JOptionPane;

public class pica {
	public static void main(String[] args) {
		String[] darbibas = {"Pasūtīt picu", "Nolasīt failu", "Apturēt programmu"};
		String izvele;
		
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele==null)
				izvele="Apturēt programu";
			
			switch(izvele) {
			case "Ierakstīt failā":
				break;
				
			case "Nolasīt failu":
				break;
				
			case "Apturēt programmu":
				JOptionPane.showMessageDialog(null, "Programma apturēta!","Paziņojums", JOptionPane.WARNING_MESSAGE);
			}
		}while(!izvele.equals("Apturēt programu"));
	}
}
