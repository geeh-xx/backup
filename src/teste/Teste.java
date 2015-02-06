package teste;

import java.io.InputStream;
import java.io.OutputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Teste {

	 public static void main(String[] args) {
	        String host="54.94.195.160";
	        String user="ubuntu";
            String privateKey = "C:\\Users\\rangel.souza\\Downloads\\magentoSaoPaulo.pem";
	        String command1="mysqldump -h localhost -u root -p -R --opt bitnami_magento > backup/backup5.sql";
	        try{
	             
	            java.util.Properties config = new java.util.Properties(); 
	            config.put("StrictHostKeyChecking", "no");
	            JSch jsch = new JSch();
	            jsch.addIdentity(privateKey);
	            Session session=jsch.getSession(user, host, 22);
	            session.setConfig(config);
	            session.connect();
	            System.out.println("Connected");
	             
	            Channel channel=session.openChannel("exec");
	            ((ChannelExec)channel).setCommand(command1);
	            channel.setInputStream(null);
	            ((ChannelExec)channel).setErrStream(System.err);
	            OutputStream out=channel.getOutputStream();

	            InputStream in=channel.getInputStream();
	            channel.connect();
	            
	            out.write(("bitnami1").getBytes());
	            out.flush();

	            byte[] tmp=new byte[1024];
	            while(true){
	              while(in.available()>0){
	                int i=in.read(tmp, 0, 1024);
	                if(i<0)break;
	                System.out.print(new String(tmp, 0, i));
	              }
	              if(channel.isClosed()){
	            	  System.out.println("exit-status: "+channel.getExitStatus()+ ""+"Sessão: "+channel.isClosed());
	                System.out.println("saiu");
	                break;	
	              }else{
		                System.out.println("exit-status: "+channel.getExitStatus()+ ""+"Sessão: "+channel.isClosed());
	            	  System.out.println("não saiu");

	              }
	              try{Thread.sleep(1000);}catch(Exception ee){}
	            }
	            channel.disconnect();
	            session.disconnect();
	            System.out.println("DONE");
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	 
	    }
	
	
}
