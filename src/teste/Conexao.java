package teste;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class Conexao {

	static Logger logger = Logger.getLogger(Conexao.class);  

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//    	try {
//    		
//    		BasicConfigurator.configure();
//    		 logger.setLevel(Level.INFO); 
//    		 
//            JSch jsch = new JSch();
//
//            String user = "ubuntu";
//            String host = "www.angawrap.com.br";
//            int port = 22;
//            String privateKey = "C:\\Users\\rangel.souza\\Downloads\\magentoSaoPaulo.pem";
//
//            jsch.addIdentity(privateKey);
//            System.out.println("identity added ");
//
//            Session session = jsch.getSession(user, host, port);
//            System.out.println("session created.");
//
//            java.util.Properties config = new java.util.Properties();
//            config.put("StrictHostKeyChecking", "no");
//            session.setConfig(config);
//
//            session.connect();
//            System.out.println("session connected.....");
//
////            Channel channel = session.openChannel("sftp");
////            channel.setInputStream(System.in);
////            channel.setOutputStream(System.out);
////            channel.connect();
////            System.out.println("shell channel connected....");
////
////            ChannelSftp c = (ChannelSftp) channel;
////
////            String fileName = "test.txt";
////            c.put(fileName, "./in/");
////            c.exit();
////            System.out.println("done");
//            
//          
//            ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
//            channelExec.setCommand("ls");
//            channelExec.connect();
//            
//            logger.info("teste");
//            
//            channelExec.disconnect();
//            session.disconnect();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//    }
}
