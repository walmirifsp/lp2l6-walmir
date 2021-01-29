/*ALUNOS: 
	walmir santos feitoza junior 	cb1640623	
*/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.google.gson.Gson;
import com.sun.tools.javac.util.Convert;

public class AppAcademy extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtObjetivo;
	
	private Gson gson;
	private AlunoAcademia alunoAcademia;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppAcademy frame = new AppAcademy();
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
	public AppAcademy() {
		gson = new Gson();
		
		setTitle("TP Final - Sistema de Academia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNome.setBounds(57, 60, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblIdade.setBounds(55, 89, 49, 14);
		contentPane.add(lblIdade);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblPeso.setBounds(60, 123, 43, 14);
		contentPane.add(lblPeso);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblAltura.setBounds(57, 160, 46, 14);
		contentPane.add(lblAltura);
		
		JLabel lblObjetivo = new JLabel("Objetivo");
		lblObjetivo.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblObjetivo.setBounds(49, 192, 54, 14);
		contentPane.add(lblObjetivo);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtNome.setBounds(114, 57, 248, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtIdade.setColumns(10);
		txtIdade.setBounds(114, 87, 248, 20);
		contentPane.add(txtIdade);
		
		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtPeso.setColumns(10);
		txtPeso.setBounds(114, 120, 248, 20);
		contentPane.add(txtPeso);
		
		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtAltura.setColumns(10);
		txtAltura.setBounds(113, 157, 248, 20);
		contentPane.add(txtAltura);
		
		txtObjetivo = new JTextField();
		txtObjetivo.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtObjetivo.setColumns(10);
		txtObjetivo.setBounds(114, 189, 248, 20);
		contentPane.add(txtObjetivo);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIncluir.setForeground(Color.WHITE);
		btnIncluir.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnIncluir.setBackground(new Color(60, 179, 113));
		btnIncluir.setBounds(22, 248, 91, 30);
		btnIncluir.addActionListener(this);
		contentPane.add(btnIncluir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLimpar.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnLimpar.setBackground(Color.RED);
		btnLimpar.setBounds(123, 248, 91, 30);
		btnLimpar.addActionListener(this);
		contentPane.add(btnLimpar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setForeground(Color.WHITE);
		btnMostrar.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnMostrar.setBackground(Color.ORANGE);
		btnMostrar.setBounds(224, 248, 91, 30);
		btnMostrar.addActionListener(this);
		contentPane.add(btnMostrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnSair.setBackground(Color.BLUE);
		btnSair.setBounds(325, 248, 91, 30);
		btnSair.addActionListener(this);
		contentPane.add(btnSair);
		
		JLabel lblTitulo = new JLabel("Cadastre-se na academia");
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 18));
		lblTitulo.setBounds(10, 11, 236, 20);
		contentPane.add(lblTitulo);
	}
	
	public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnIncluir){
            
        	String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            float altura = Float.parseFloat(txtAltura.getText());
            String objetivo = txtObjetivo.getText();
            
            alunoAcademia = new AlunoAcademia(nome, idade, peso, altura, objetivo);
        }
        
        if(e.getSource() == btnLimpar){
        	txtNome.setText("");
        	txtIdade.setText("");
        	txtPeso.setText("");
        	txtAltura.setText("");
        	txtObjetivo.setText("");
        }
        
        if(e.getSource() == btnMostrar){
        	//JOptionPane.showMessageDialog(null, "Aluno" , "Dados do aluno: " + gson.toJson(alunoAcademia), JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(e.getSource() == btnSair){
            System.exit(0);
        }
    }
}
