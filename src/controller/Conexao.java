package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JTextPane;

import model.Usuario;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Conexao {

	public static PrintStream ps = null;
	private JSch jsch = null;
	private java.util.Properties config = null;
	private Session session = null;
	private Channel channel = null;
	private OutputStream ops = null;
	public static ChannelSftp channelSftp = null;
	private String host;
    private String user;
    private String privateKey ;
	public static final int PORTA = 22;
	private JTextPane textPane;
    
	
	public Conexao(Usuario usuario){
		this.host = usuario.getHost();
		this.user = usuario.getUsuario();
		this.privateKey = usuario.getChave();
	}
	
	public Conexao(Usuario usuario,JTextPane textPane){
		this.host = usuario.getHost();
		this.user = usuario.getUsuario();
		this.privateKey = usuario.getChave();
		this.textPane = textPane;
	}
	
	public void conectar(String tipo){
		try {
			config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			jsch = new JSch();
			jsch.addIdentity(privateKey);
			session=jsch.getSession(user, host, PORTA);
			session.setConfig(config);
			session.connect();
			channel=session.openChannel(tipo);
			ops = channel.getOutputStream();
			ps = new PrintStream(ops, true);
			channel.connect();
			Mensagem mensagem = new Mensagem(textPane);
			if (tipo.equals("sftp")) {
				channelSftp = (ChannelSftp)channel;
			}
			mensagem.exibeMensagem("Conectando...\n"+
			                        "Connectado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			Mensagem mensagem = new Mensagem(textPane);
			mensagem.exibeMensagem("Erro ao conectar");
		}
	}
	
	public void desconectar(){
		try {
		  ps.close();
          InputStream in;
          in = channel.getInputStream();
          byte[] bt=new byte[1024];
          while(true){
        	  while(in.available()>0){
        		  int i=in.read(bt, 0, 1024);
        		  if(i<0)
        			  break;
        		  String str=new String(bt, 0, i);
        		  //displays the output of the command executed.
        		  System.out.print(str);


        	  }
        	  if(channel.isClosed()){
        		  break;
        	  }
        	  try {
        		  Thread.sleep(1000);
        	  }catch (InterruptedException e) {
        		  // TODO Auto-generated catch block
        		  e.printStackTrace();
        	  }
        	  channel.disconnect();
        	  session.disconnect();   
          }
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}
	
	
}
