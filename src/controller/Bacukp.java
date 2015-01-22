package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Banco;

public class Bacukp {
	
	public String DataDeHoje(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		return dateFormat.format(date);	
	}
	
	public void mySql(Banco banco){
		
        Conexao.ps.println("mysqldump -h "+banco.getHost()+" -u "+banco.getUsuario()+" -p -R --opt "+banco.getDatabase()+"> backup/"+DataDeHoje()+".sql");
        try{
   		 Thread.sleep(1000);
   	 	}catch(Exception ee){
   		 
   	 	}
        Conexao.ps.println(banco.getSenha());
	}
	
}
