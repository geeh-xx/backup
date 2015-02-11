package teste;

import java.util.prefs.BackingStoreException;

import model.Banco;
import componente.Mensagem;
import controller.Bacukp;
import util.Log;

public class TesteLog {

	
	public static void main(String[] args) throws Exception {  
	      
		Banco banco = null;
		Bacukp backup = null;
	    try  {  
	        //a();  
	        backup.mySql(banco);
	    } catch (Exception ex)  {  
	        ex.printStackTrace(new Log());  
	        ex.printStackTrace();
	    }   
	}  
	  
	static void a() {  
	    throw new RuntimeException("Oppps");  
	}  
	
}
