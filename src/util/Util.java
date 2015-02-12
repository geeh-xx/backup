package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Util {
	
	public static final int ERRO = JOptionPane.ERROR_MESSAGE;
	public static final int ALERTA = JOptionPane.WARNING_MESSAGE;
	public static boolean verifica = true;
	
	public static final String DataDeHoje(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);	
	}
	
	public static final void alerta(String mensagem,int tipo){
		
		JOptionPane.showMessageDialog(null,mensagem,"Atenção",tipo);
		
	}
}
