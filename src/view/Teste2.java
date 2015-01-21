package view;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class Teste2 {

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
             
            Channel channel=session.openChannel("shell");
            OutputStream ops = channel.getOutputStream();
            PrintStream ps = new PrintStream(ops, true);

             channel.connect();
             ps.println("mysqldump -h localhost -u root -p -R --opt bitnami_magento > backup/backup5.sql");
             if (channel.getExitStatus() == -1) {
            	 try{Thread.sleep(1000);}catch(Exception ee){}
            	 
			}
             ps.println("bitnami1");
     //give commands to be executed inside println.and can have any no of commands sent.
                          ps.close();

             InputStream in=channel.getInputStream();
             byte[] bt=new byte[1024];


             while(true)
             {

             while(in.available()>0)
             {
             int i=in.read(bt, 0, 1024);
             if(i<0)
              break;
                String str=new String(bt, 0, i);
              //displays the output of the command executed.
                System.out.print(str);


             }
             if(channel.isClosed())
             {

                 break;
            }
             Thread.sleep(1000);
             channel.disconnect();
             session.disconnect();   
             }
            
            
            
 
    }catch(Exception e){
        e.printStackTrace();
    }
	
	
}
	
}
