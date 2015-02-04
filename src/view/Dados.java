package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Banco;
import model.Usuario;
import controller.Bacukp;
import controller.Conexao;
import controller.Download;
import javax.swing.JProgressBar;

public class Dados {

	public static JFrame frmBackup;
	private JTextField fielServerHost;
	private JTextField fieldServerUser;
	private JLabel lblDadosDoServidor;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPasswordField fieldServerPassword;
	private JTextField fieldServerPorta;
	private JLabel label;
	private JTextField fieldBdHost;
	private JLabel label_1;
	private JTextField fieldBdUser;
	private JLabel label_2;
	private JPasswordField fieldBdPassword;
	private JTextField fieldBdBase;
	private JTextField fieldServerKayPar;
	private JTextField FieldBdDownload;
	Bacukp bacukp;
	Usuario usuario;
	Banco banco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dados window = new Dados();
					window.frmBackup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBackup = new JFrame();
		frmBackup
				.setIconImage(Toolkit
						.getDefaultToolkit()
						.getImage(
								Dados.class
										.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		frmBackup.setResizable(false);
		frmBackup.setTitle("Backup 1.0");
		frmBackup.setBounds(100, 100, 444, 560);
		frmBackup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBackup.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setBounds(10, 74, 56, 21);
		frmBackup.getContentPane().add(lblNewLabel);

		fielServerHost = new JTextField();
		fielServerHost.setBounds(73, 44, 86, 20);
		frmBackup.getContentPane().add(fielServerHost);
		fielServerHost.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha:");
		lblNewLabel_1.setBounds(10, 106, 56, 20);
		frmBackup.getContentPane().add(lblNewLabel_1);

		fieldServerUser = new JTextField();
		fieldServerUser.setBounds(73, 76, 86, 20);
		frmBackup.getContentPane().add(fieldServerUser);
		fieldServerUser.setColumns(10);

		lblDadosDoServidor = new JLabel("Dados do Servidor");
		lblDadosDoServidor.setBounds(117, 11, 194, 22);
		frmBackup.getContentPane().add(lblDadosDoServidor);

		lblNewLabel_2 = new JLabel("Porta:");
		lblNewLabel_2.setBounds(10, 169, 46, 14);
		frmBackup.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Keypar:");
		lblNewLabel_3.setBounds(10, 137, 46, 21);
		frmBackup.getContentPane().add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 223, 428, 14);
		frmBackup.getContentPane().add(separator);

		JLabel lblDadosDoBanco = new JLabel("Dados do Banco");
		lblDadosDoBanco.setBounds(117, 223, 194, 33);
		frmBackup.getContentPane().add(lblDadosDoBanco);

		fieldServerPassword = new JPasswordField();
		fieldServerPassword.setBounds(73, 107, 86, 20);
		frmBackup.getContentPane().add(fieldServerPassword);

		JLabel lblNewLabel_4 = new JLabel("Host:");
		lblNewLabel_4.setBounds(10, 43, 46, 18);
		frmBackup.getContentPane().add(lblNewLabel_4);

		fieldServerPorta = new JTextField();
		fieldServerPorta.setText("22");
		fieldServerPorta.setColumns(10);
		fieldServerPorta.setBounds(73, 167, 86, 20);
		frmBackup.getContentPane().add(fieldServerPorta);

		label = new JLabel("Host:");
		label.setBounds(10, 267, 46, 18);
		frmBackup.getContentPane().add(label);

		fieldBdHost = new JTextField();
		fieldBdHost.setColumns(10);
		fieldBdHost.setBounds(70, 267, 86, 20);
		frmBackup.getContentPane().add(fieldBdHost);

		label_1 = new JLabel("Usu\u00E1rio:");
		label_1.setBounds(10, 298, 56, 21);
		frmBackup.getContentPane().add(label_1);

		fieldBdUser = new JTextField();
		fieldBdUser.setColumns(10);
		fieldBdUser.setBounds(70, 299, 86, 20);
		frmBackup.getContentPane().add(fieldBdUser);

		label_2 = new JLabel("Senha:");
		label_2.setBounds(10, 330, 56, 20);
		frmBackup.getContentPane().add(label_2);

		fieldBdPassword = new JPasswordField();
		fieldBdPassword.setBounds(70, 330, 86, 20);
		frmBackup.getContentPane().add(fieldBdPassword);

		fieldServerKayPar = new JTextField();
		fieldServerKayPar.setColumns(10);
		fieldServerKayPar.setBounds(73, 137, 86, 20);
		frmBackup.getContentPane().add(fieldServerKayPar);

		FieldBdDownload = new JTextField();
		FieldBdDownload.setColumns(10);
		FieldBdDownload.setBounds(135, 393, 86, 20);
		frmBackup.getContentPane().add(FieldBdDownload);
		
		
		final JLabel labelDownload = new JLabel("Status do Donwload");
		labelDownload.setBounds(20, 431, 155, 14);
		labelDownload.setVisible(false);
		frmBackup.getContentPane().add(labelDownload);
		
		JButton btnGo = new JButton("Let's Go!");
		btnGo.addActionListener(new ActionListener() {

			@SuppressWarnings({ "static-access", "deprecation" })
			public void actionPerformed(ActionEvent arg0) {
				usuario = new Usuario();
				banco = new Banco();
				bacukp = new Bacukp();
				// usuario.setChave("C:\\Users\\rangel.souza\\Downloads\\magentoSaoPaulo.pem");
				// usuario.setHost("angawrap.com.br");
				// usuario.setSenha(null);
				// usuario.setUsuario("ubuntu");
				//
				// banco.setBanco(null);
				// banco.setDatabase("bitnami_magento");
				// banco.setHost("localhost");
				// banco.setOperacao(null);
				// banco.setSenha("bitnami1");
				// banco.setUsuario("root");

				usuario.setHost(fielServerHost.getText());
				usuario.setChave(fieldServerKayPar.getText());
				usuario.setSenha(null);
				usuario.setUsuario(fieldServerUser.getText());

				banco.setBanco(null);
				banco.setDatabase(fieldBdBase.getText());
				banco.setHost(fieldBdHost.getText());
				banco.setPorta(Integer.parseInt(fieldServerPorta.getText()));
				banco.setOperacao(null);
				banco.setSenha(fieldBdPassword.getText());
				banco.setUsuario(fieldBdUser.getText());

				Conexao conexao = new Conexao(usuario);
				conexao.conectar("shell");
				bacukp.mySql(banco);
				conexao.desconectar();
				
				Conexao conexao2 = new Conexao(usuario);
				conexao2.conectar("sftp");
				Download download = new Download();
				labelDownload.setVisible(true);
				download.dowloadBackup(conexao2.channelSftp,FieldBdDownload.getText());
				conexao2.desconectar();
			}
		});
		
		
		btnGo.setBounds(329, 456, 89, 23);
		frmBackup.getContentPane().add(btnGo);

		JLabel lblBase = new JLabel("Base:");
		lblBase.setBounds(10, 361, 38, 20);
		frmBackup.getContentPane().add(lblBase);

		JLabel lblLocalParaDownload = new JLabel("Local para download:");
		lblLocalParaDownload.setBounds(10, 392, 149, 20);
		frmBackup.getContentPane().add(lblLocalParaDownload);

		fieldBdBase = new JTextField();
		fieldBdBase.setColumns(10);
		fieldBdBase.setBounds(70, 361, 86, 20);
		frmBackup.getContentPane().add(fieldBdBase);

		JButton btnSelecionar = new JButton("...");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int i = file.showSaveDialog(null);
				if (i == 1) {
					FieldBdDownload.setText("");
				} else {
					File arquivo = file.getSelectedFile();
					FieldBdDownload.setText(arquivo.getAbsolutePath());
				}
			}
		});
		btnSelecionar.setBounds(226, 392, 14, 20);
		frmBackup.getContentPane().add(btnSelecionar);

		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser file = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter(".pem", "pem");
				file.setFileSelectionMode(JFileChooser.FILES_ONLY);
				file.setFileFilter(filter);
				int i = file.showSaveDialog(null);
				if (i == 1) {
					fieldServerKayPar.setText("");
				} else {
					File arquivo = file.getSelectedFile();
					fieldServerKayPar.setText(arquivo.getAbsolutePath());
				}
			}
		});
		button.setBounds(161, 137, 14, 19);
		frmBackup.getContentPane().add(button);

		
	}
}
