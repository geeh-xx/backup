package view;

import model.Banco;
import model.Usuario;
import controller.Bacukp;
import controller.Conexao;

public class Uso {

	public static void main(String[] args) {
		Bacukp bacukp = new Bacukp();
		Usuario usuario = new Usuario();
		usuario.setChave("C:\\Users\\rangel.souza\\Downloads\\magentoSaoPaulo.pem");
		usuario.setHost("54.94.195.160");
		usuario.setSenha(null);
		usuario.setUsuario("ubuntu");
		
		Banco banco = new Banco();
		banco.setBanco(null);
		banco.setDatabase("bitnami_magento");
		banco.setHost("localhost");
		banco.setOperacao(null);
		banco.setSenha("bitnami1");
		banco.setUsuario("root");
		
		Conexao conexao = new Conexao(usuario);
		conexao.conectar();
		bacukp.mySql(banco);
		conexao.desconectar();
		
	}
}