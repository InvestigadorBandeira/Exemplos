package br.com.sistema.view;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import br.com.vga.mymoney.entity.Conta;

public class TransferenciaView extends JTabbedPane {
    private JPanel pnInclusao;
    private JPanel pnListagem;
    private JLabel label;
    private JComboBox<Conta> comboBox;
    private JLabel label_1;
    private JTextField textField;
    private JLabel label_2;
    private JTextField textField_1;
    private JLabel label_3;
    private JTextField textField_2;

    public TransferenciaView() {
	initComponents();
	setBounds(30, 30, 560, 360);
    }

    private void initComponents() {
	setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));
	pnInclusao = new JPanel();
	pnInclusao.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));
	addTab("Inclus\u00E3o", null, pnInclusao, null);
	pnInclusao.setLayout(null);

	label = new JLabel("Conta");
	label.setFont(new Font("Tahoma", Font.BOLD, 12));
	label.setBounds(10, 11, 130, 25);
	pnInclusao.add(label);

	comboBox = new JComboBox<Conta>();
	comboBox.setBounds(150, 12, 225, 25);
	pnInclusao.add(comboBox);

	label_1 = new JLabel("Data");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	label_1.setBounds(10, 47, 130, 25);
	pnInclusao.add(label_1);

	textField = new JTextField();
	textField.setText("25/01/2014");
	textField.setHorizontalAlignment(SwingConstants.CENTER);
	textField.setFont(new Font("Tahoma", Font.BOLD, 12));
	textField.setColumns(10);
	textField.setBounds(150, 50, 100, 25);
	pnInclusao.add(textField);

	label_2 = new JLabel("Valor");
	label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	label_2.setBounds(10, 83, 130, 25);
	pnInclusao.add(label_2);

	textField_1 = new JTextField();
	textField_1.setText("0,00");
	textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
	textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	textField_1.setColumns(10);
	textField_1.setBounds(150, 86, 100, 25);
	pnInclusao.add(textField_1);

	label_3 = new JLabel("Observa\u00E7\u00E3o");
	label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	label_3.setBounds(10, 119, 130, 25);
	pnInclusao.add(label_3);

	textField_2 = new JTextField();
	textField_2.setText("Observacao");
	textField_2.setHorizontalAlignment(SwingConstants.LEFT);
	textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	textField_2.setColumns(10);
	textField_2.setBounds(150, 122, 394, 25);
	pnInclusao.add(textField_2);
	pnListagem = new JPanel();
	addTab("Listagem", null, pnListagem, null);
    }

}
