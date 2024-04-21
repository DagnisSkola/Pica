package pica;

import javax.swing.JOptionPane;

public class pica {
	public static void main(String[] args) {
		String[] darbibas = {"u", "lu", "Apturēt programmu"};
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
			}
		}while(!izvele.equals("Apturēt programu"));
	}
}
