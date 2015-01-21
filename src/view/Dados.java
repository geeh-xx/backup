package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

public class Dados {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblDadosDoServidor;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dados window = new Dados();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 43, 56, 22);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(76, 44, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(10, 74, 56, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(76, 75, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblDadosDoServidor = new JLabel("Dados do Servidor");
		lblDadosDoServidor.setBounds(117, 11, 194, 33);
		frame.getContentPane().add(lblDadosDoServidor);
		
		lblNewLabel_2 = new JLabel("Porta");
		lblNewLabel_2.setBounds(10, 107, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Keypar");
		lblNewLabel_3.setBounds(10, 140, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setText("22");
		textField_2.setColumns(10);
		textField_2.setBounds(76, 106, 86, 20);
		frame.getContentPane().add(textField_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 165, 428, 14);
		frame.getContentPane().add(separator);
		
		JLabel lblDadosDoBanco = new JLabel("Dados do Banco");
		lblDadosDoBanco.setBounds(117, 165, 194, 33);
		frame.getContentPane().add(lblDadosDoBanco);
	}
}
