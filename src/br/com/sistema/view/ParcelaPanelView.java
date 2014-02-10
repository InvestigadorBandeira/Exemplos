package br.com.sistema.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.vga.mymoney.view.tables.ParcelaTable;

public class ParcelaPanelView extends JPanel {
    private JLabel label;
    private JComboBox comboBox;
    private JLabel label_1;
    private JTextField textField;
    private JLabel label_2;
    private JTextField textField_1;
    private JScrollPane scrollPane;
    private JLabel label_3;
    private JTextField textField_2;
    private JButton button;
    private ParcelaTable parcelaTable;

    public ParcelaPanelView() {

	initComponents();
    }

    private void initComponents() {
	setLayout(null);

	label = new JLabel("Conta");
	label.setFont(new Font("Tahoma", Font.BOLD, 12));
	label.setBounds(10, 11, 130, 25);
	add(label);

	comboBox = new JComboBox();
	comboBox.setBounds(150, 12, 225, 25);
	add(comboBox);

	label_1 = new JLabel("Data");
	label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	label_1.setBounds(10, 47, 130, 25);
	add(label_1);

	textField = new JTextField();
	textField.setText("25/01/2014");
	textField.setHorizontalAlignment(SwingConstants.CENTER);
	textField.setFont(new Font("Tahoma", Font.BOLD, 12));
	textField.setColumns(10);
	textField.setBounds(150, 50, 100, 25);
	add(textField);

	label_2 = new JLabel("Valor");
	label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	label_2.setBounds(10, 83, 130, 25);
	add(label_2);

	textField_1 = new JTextField();
	textField_1.setText("0,00");
	textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
	textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
	textField_1.setColumns(10);
	textField_1.setBounds(150, 86, 100, 25);
	add(textField_1);

	scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 191, 534, 120);
	add(scrollPane);

	parcelaTable = new ParcelaTable();
	scrollPane.setViewportView(parcelaTable);

	label_3 = new JLabel("Observa\u00E7\u00E3o");
	label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	label_3.setBounds(10, 119, 130, 25);
	add(label_3);

	textField_2 = new JTextField();
	textField_2.setText("Observacao");
	textField_2.setHorizontalAlignment(SwingConstants.LEFT);
	textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	textField_2.setColumns(10);
	textField_2.setBounds(150, 122, 394, 25);
	add(textField_2);

	button = new JButton("Adicionar T\u00EDtulo");
	button.setBounds(10, 155, 140, 25);
	add(button);
    }
}
