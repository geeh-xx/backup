package componente;

import javax.swing.JTextPane;

public class Mensagem {

	private JTextPane textPane;
	
	
	public Mensagem(JTextPane textPane){
		this.textPane = textPane;
	}
	
	public void exibeMensagem(String mensagem){
		textPane.setText(mensagem);
		textPane.setVisible(true);
		textPane.setBounds(10, 487, 418, 79);
	}


}
