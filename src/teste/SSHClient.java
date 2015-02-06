package teste;

import static net.sf.expectit.matcher.Matchers.contains;
import static net.sf.expectit.matcher.Matchers.regexp;
import static net.sf.expectit.matcher.Matchers.times;

import java.io.OutputStream;
import java.io.PrintStream;

import net.sf.expectit.Expect;
import net.sf.expectit.ExpectBuilder;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class SSHClient {

	 public static void main(String[] args) {
		 try{
	           

	        String privateKey = "C:\\Users\\rangel.souza\\Downloads\\magentoSaoPaulo.pem";
	        String host="54.94.195.160";
	        String user="ubuntu";
	        java.util.Properties config = new java.util.Properties(); 
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            jsch.addIdentity(privateKey);
            Session session=jsch.getSession(user, host, 22);
            
            session.setConfig(config);
            session.connect();
	        Channel channel = session.openChannel("shell");
	        
	        Expect expect = new ExpectBuilder()
            .withOutput(channel.getOutputStream())
            .withInputs(channel.getInputStream(), channel.getExtInputStream())
            .withEchoInput(System.out)
            .withEchoOutput(System.err)
            .withExceptionOnFailure()
            .build();
	        try {
		        channel.connect();
		        expect.expect(contains("$"));
		        expect.sendLine("mysqldump -h localhost -u root -p -R --opt bitnami_magento > backup/backup10.sql");
		        System.out.println(expect.expect(times(2, contains("\n")))
                        .getResults()
                        .get(1)
                        .getBefore());
		        if (channel.getExitStatus() == -1) {
	            	 try{
	            		 Thread.sleep(1000);
	            	 }catch(Exception ee){
	            		 
	            	 }
	            	 
				}
		        expect.sendLine("bitnami1");
		       
	        } finally {
		        channel.disconnect();
		        session.disconnect();
		        expect.close();
	        }
	    }
	catch(Exception e){
	        e.printStackTrace();
	    }
}
}
