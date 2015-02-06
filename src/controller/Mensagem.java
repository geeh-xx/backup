package controller;

import javax.swing.JTextPane;

public class Mensagem {

	private String mensagem;
	private JTextPane textPane;
	
	
	Mensagem(JTextPane textPane){
		this.textPane = textPane;
	}
	
	public void exibeMensagem(){
		textPane.setText(mensagem);
		textPane.setVisible(true);
		textPane.setBounds(10, 487, 418, 79);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}
