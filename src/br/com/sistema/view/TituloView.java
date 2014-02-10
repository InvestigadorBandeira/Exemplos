package br.com.sistema.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.vga.mymoney.view.tables.ParcelaTable;

public class TituloView extends JInternalFrame {
    private JLabel lblConta;
    private JLabel lblValor;
    private JLabel lblData;
    private JComboBox comboBox;
    private JTextField txtData;
    private JTextField txtValor;
    private JScrollPane scrollPane;
    private JLabel lblObservacao;
    private JTextField txtObservacao;
    private ParcelaTable parcelaTable;
    private JButton btnAdicionarTtulo;

    public TituloView() {

	initComponents();
    }

    private void initComponents() {
	setMaximizable(true);
	setClosable(true);
	setTitle("Cadastro de T\u00EDtulos");
	setBounds(100, 100, 570, 421);
	setLocation(30, 30);
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

	comboBox = new JComboBox();
	comboBox.setBounds(150, 12, 225, 25);
	getContentPane().add(comboBox);

	txtData = new JTextField();
	txtData.setHorizontalAlignment(SwingConstants.CENTER);
	txtData.setFont(new Font("Tahoma", Font.BOLD, 12));
	txtData.setText("25/01/2014");
	txtData.setBounds(150, 50, 100, 25);
	getContentPane().add(txtData);
	txtData.setColumns(10);

	txtValor = new JTextField();
	txtValor.setText("0,00");
	txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
	txtValor.setFont(new Font("Tahoma", Font.BOLD, 12));
	txtValor.setColumns(10);
	txtValor.setBounds(150, 86, 100, 25);
	getContentPane().add(txtValor);

	scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 191, 534, 120);
	getContentPane().add(scrollPane);

	parcelaTable = new ParcelaTable();
	scrollPane.setViewportView(parcelaTable);

	lblObservacao = new JLabel("Observa\u00E7\u00E3o");
	lblObservacao.setFont(new Font("Tahoma", Font.BOLD, 12));
	lblObservacao.setBounds(10, 119, 130, 25);
	getContentPane().add(lblObservacao);

	txtObservacao = new JTextField();
	txtObservacao.setText("Observacao");
	txtObservacao.setHorizontalAlignment(SwingConstants.LEFT);
	txtObservacao.setFont(new Font("Tahoma", Font.BOLD, 12));
	txtObservacao.setColumns(10);
	txtObservacao.setBounds(150, 122, 394, 25);
	getContentPane().add(txtObservacao);

	btnAdicionarTtulo = new JButton("Adicionar T\u00EDtulo");
	btnAdicionarTtulo.setBounds(10, 155, 140, 25);
	getContentPane().add(btnAdicionarTtulo);
    }
}
