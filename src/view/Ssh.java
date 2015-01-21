package view;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Ssh {

	
	 private Session session;
	    private String user;
	    private String hostname;
	    private String password;
	    private int porta;

	    public Ssh(String hostname, String user, String password, int porta) throws JSchException {
	        this.hostname = hostname;
	        this.user = user;
	        this.password = password;
	        this.porta = porta;
	        this.iniciaConexao();        
	    }
	    public Ssh(String hostname, int porta) throws JSchException {
	        this.hostname = hostname;
	        this.porta = porta;
	        
	        this.user = "USUARIO";
	        this.password = "SENHA";
	        
	        this.iniciaConexao();        
	    }

	    public void iniciaConexao() throws JSchException {
	        JSch jsch = new JSch();
	        session = jsch.getSession(user, hostname, porta);
	        jsch.setKnownHosts("/home/gomes/.ssh/known_hosts");
	        jsch.addIdentity("/home/gomes/.ssh/id_rsa");
	        session.setPassword(password);
	        session.connect();
	    }
	    
	    public void finalizarConexao(){
	        session.disconnect();
	    }
}
