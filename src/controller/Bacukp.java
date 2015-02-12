package controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JTextPane;

import componente.Mensagem;
import model.Banco;
import util.Log;
import util.Util;

public class Bacukp {
	
	private JTextPane textPane;
	
	public Bacukp(){
		
	}
	
	public Bacukp(JTextPane textPane){
		this.textPane =textPane;
	}
	
	
	public void mySql(Banco banco){
		try {
	        Conexao.ps.println("mysqldump -h "+banco.getHost()+" --user="+banco.getUsuario()+" --password="+banco.getSenha().toString()+" -R --opt "+banco.getDatabase()+"> ./"+Util.DataDeHoje()+".sql");
	        Mensagem mensagem = new Mensagem(textPane);
	        mensagem.exibeMensagem("Realizando Backup...Aguarde por favor...");
	        try{
	        	//Thread.sleep(1000);
	      		Thread.sleep(4*60*1000);
	      	 	}catch(Exception ee){
	      	 		ee.printStackTrace();
	      	 }	 
        }catch (Exception ex) {
  	      try {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				pw.close();
				sw.close();
				Mensagem mensagem = new Mensagem(textPane);
				mensagem.exibeMensagem(sw.getBuffer().toString());
				ex.printStackTrace(new Log());
				
			} catch (Throwable e) {
				
				e.printStackTrace();
				Util.alerta("Erro ao gerar arquivo de log", Util.ERRO);
			}
  	    Util.alerta("Erro ao realizar Backup...\n"
					+"Favor,verifique os dados e a internet e tente novamente", Util.ERRO);
  	      ex.printStackTrace();
		}
	}
	
}
