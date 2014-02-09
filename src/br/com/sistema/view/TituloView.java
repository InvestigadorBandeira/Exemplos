package br.com.sistema.view;

import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class TituloView extends JInternalFrame {
    private JLabel lblConta;
    private JLabel lblValor;
    private JLabel lblData;

    public TituloView() {

	initComponents();
    }

    private void initComponents() {
	setMaximizable(true);
	setTitle("Cadastro de T\u00EDtulos");
	setBounds(100, 100, 450, 300);
	getContentPane().setLayout(null);

	lblConta = new JLabel("Conta");
	lblConta.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblConta.setBounds(10, 11, 130, 25);
	getContentPane().add(lblConta);

	lblData = new JLabel("Data");
	lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblData.setBounds(10, 47, 130, 25);
	getContentPane().add(lblData);

	lblValor = new JLabel("Valor");
	lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblValor.setBounds(10, 83, 130, 25);
	getContentPane().add(lblValor);
    }
}
