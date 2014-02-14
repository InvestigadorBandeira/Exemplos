package br.com.sistema.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import net.java.balloontip.BalloonTip;
import net.java.balloontip.positioners.BalloonTipPositioner;
import net.java.balloontip.positioners.BasicBalloonTipPositioner;
import net.java.balloontip.positioners.LeftAbovePositioner;
import net.java.balloontip.styles.EdgedBalloonStyle;
import net.java.balloontip.styles.ModernBalloonStyle;
import net.java.balloontip.utils.TimingUtils;
import br.com.vga.mymoney.entity.Conta;
import br.com.vga.mymoney.view.tables.ParcelaTable;

public class ParcelaPanelView extends JPanel {
    private JLabel label;
    private JComboBox<Conta> cbConta;
    private JLabel label_1;
    private JTextField textField;
    private JLabel label_2;
    private JTextField txtValor;
    private JScrollPane scrollPane;
    private JLabel label_3;
    private JTextField txtObservacao;
    private JButton btnAdicionar;
    private ParcelaTable parcelaTable;

    public ParcelaPanelView() {
	setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));

	initComponents();
	setBounds(30, 30, 560, 360);
    }

    private void initComponents() {
	setLayout(null);

	label = new JLabel("Conta");
	label.setFont(new Font("Tahoma", Font.BOLD, 12));
	label.setBounds(10, 11, 130, 25);
	add(label);

	cbConta = new JComboBox<>();
	cbConta.setBounds(150, 12, 225, 25);
	add(cbConta);

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

	txtValor = new JTextField();
	txtValor.setText("0,00");
	txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
	txtValor.setFont(new Font("Tahoma", Font.BOLD, 12));
	txtValor.setColumns(10);
	txtValor.setBounds(150, 86, 100, 25);
	add(txtValor);

	label_3 = new JLabel("Observa\u00E7\u00E3o");
	label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
	label_3.setBounds(10, 119, 130, 25);
	add(label_3);

	txtObservacao = new JTextField();
	txtObservacao.setText("Observacao");
	txtObservacao.setHorizontalAlignment(SwingConstants.LEFT);
	txtObservacao.setFont(new Font("Tahoma", Font.BOLD, 12));
	txtObservacao.setColumns(10);
	txtObservacao.setBounds(150, 122, 394, 25);
	add(txtObservacao);

	scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 191, 534, 120);
	add(scrollPane);

	parcelaTable = new ParcelaTable();
	scrollPane.setViewportView(parcelaTable);

	btnAdicionar = new JButton("Adicionar T\u00EDtulo");
	btnAdicionar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnAdicionarActionPerformed(e);
	    }
	});
	btnAdicionar.setBounds(10, 155, 140, 25);
	add(btnAdicionar);
    }

    protected void btnAdicionarActionPerformed(ActionEvent e) {
	EdgedBalloonStyle edgeStyle = new EdgedBalloonStyle(new Color(255, 253,
		245), new Color(64, 64, 64));

	ModernBalloonStyle modernStyle = new ModernBalloonStyle(10, 10,
		new Color(255, 253, 245), new Color(255, 253, 245), new Color(
			64, 64, 64));
	modernStyle.setBorderThickness(3);
	modernStyle.enableAntiAliasing(true);

	BalloonTipPositioner positioner = new LeftAbovePositioner(0, 0);

	String texto = " O título 'Compras do Mês' foi salvo com sucesso.";

	BalloonTip tip = new BalloonTip(this, texto, modernStyle, false);

	// BalloonTip tip2 = new BalloonTip(this, texto, modernStyle, null,
	// null,
	// 0, 0, false);

	tip.setPadding(10);
	tip.setPositioner(positioner);

	((BasicBalloonTipPositioner) tip.getPositioner()).setAttachLocation(
		0.5f, 1.0f);
	tip.refreshLocation();

	TimingUtils.showTimedBalloon(tip, 2000);
    }
}
