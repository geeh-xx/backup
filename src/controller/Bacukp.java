package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jcraft.jsch.ChannelSftp;

import model.Banco;

public class Bacukp {
	
	public static final String DataDeHoje(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);	
	}
	
	public void mySql(Banco banco){
		
        Conexao.ps.println("mysqldump -h "+banco.getHost()+" --user="+banco.getUsuario()+" --password="+banco.getSenha().toString()+" -R --opt "+banco.getDatabase()+"> ./"+DataDeHoje()+".sql");
        System.out.println("realizando Backup...");
//        try{
//   		 Thread.sleep(1000);
//   	 	}catch(Exception ee){
//   	 		ee.printStackTrace();
//   	 	}
//        Conexao.ps.println(banco.getSenha());
        try{
        	//Thread.sleep(1000);
      		Thread.sleep(4*60*1000);
      	 	}catch(Exception ee){
      	 		ee.printStackTrace();
      	 }	 
        System.out.println("Backup realizado com sucesso!");
	}
	
}
