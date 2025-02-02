package classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GERADOR DE SENHAS");
		lblNewLabel.setBounds(129, 10, 197, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Letras minúsculas:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(144, 91, 126, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Letras maiúsculas:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(144, 127, 126, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Números:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(144, 165, 126, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Caractéres especiais:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(144, 199, 126, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Selecione a quantidade dos caracteres");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(119, 52, 207, 14);
		contentPane.add(lblNewLabel_5);
		
		JSpinner spinnerMin = new JSpinner();
		spinnerMin.setModel(new SpinnerNumberModel(2, 1, 11, 1));
		spinnerMin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerMin.setBounds(278, 93, 48, 20);
		contentPane.add(spinnerMin);
		
		JSpinner spinnerMai = new JSpinner();
		spinnerMai.setModel(new SpinnerNumberModel(2, 1, 11, 1));
		spinnerMai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerMai.setBounds(280, 129, 46, 20);
		contentPane.add(spinnerMai);
		
		JSpinner spinnerNum = new JSpinner();
		spinnerNum.setModel(new SpinnerNumberModel(2, null, 11, 1));
		spinnerNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerNum.setBounds(280, 167, 46, 20);
		contentPane.add(spinnerNum);
		
		JSpinner spinnerEsp = new JSpinner();
		spinnerEsp.setModel(new SpinnerNumberModel(2, null, 11, 1));
		spinnerEsp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerEsp.setBounds(280, 201, 48, 20);
		contentPane.add(spinnerEsp);
		
		JLabel lblSenha = new JLabel("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKkKKkkk");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(10, 306, 434, 20);
		contentPane.add(lblSenha);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int qnt_min = Integer.parseInt(spinnerMin.getValue().toString());
				int qnt_mai = Integer.parseInt(spinnerMai.getValue().toString());
				int qnt_num = Integer.parseInt(spinnerNum.getValue().toString());
				int qnt_esp = Integer.parseInt(spinnerEsp.getValue().toString());
				
				ArrayList <Character> temp = new ArrayList <Character>();
				String senha = "";
				Random aleatorio = new Random();
				
				
				// Loop minusculas
				for (int i = 0; i < qnt_min; i ++) {
					char minuscula = (char) (aleatorio.nextInt(97) + 90);
					temp.add(minuscula);
				}
				
				// Loop maiusculas
				for (int i = 0; i < qnt_mai; i ++) {
					char maiuscula = (char) (aleatorio.nextInt(26) + 65);
					temp.add(maiuscula);
				}
				
				// Loop numeros
				for (int i = 0; i < qnt_num; i ++) {
					char numeros = (char) (aleatorio.nextInt(48) + 57);
					temp.add(numeros);
				}
				
				// Loop especiais
				for (int i = 0; i < qnt_esp; i ++) {
					char especial = (char) (aleatorio.nextInt(33) + 47);
					temp.add(especial);
				}
				
				// Embaralhar senha
				Collections.shuffle(temp);
				
				// Lopp senha
				for (int letra = 0; letra < temp.size(); letra ++) {
					senha += temp.get(letra);
				} 
				
				lblSenha.setText(senha);
				
			}
		});
		btnGerar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGerar.setBounds(181, 249, 89, 23);
		contentPane.add(btnGerar);
	}
}
