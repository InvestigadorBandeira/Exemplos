package br.com.sistema.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class PanelSaldoContas extends JPanel {
    private static final long serialVersionUID = 1L;

    private final String conta;
    private final String valor;

    public PanelSaldoContas(String conta, String valor) {
	super();
	this.conta = conta;
	this.valor = valor;

	initComponents();
    }

    private void initComponents() {
	addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		thisMouseClicked(e);
	    }
	});
	setBackground(new Color(214, 223, 247));
	setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));
	setBounds(227, 150, 150, 40);
	setLayout(new BorderLayout(0, 0));

	JLabel lblConta = new JLabel("  " + conta);
	lblConta.setFont(new Font("Tahoma", Font.BOLD, 12));
	add(lblConta, BorderLayout.NORTH);

	JLabel lblValor = new JLabel(valor + "  ");
	lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
	lblValor.setFont(new Font("Tahoma", Font.BOLD, 12));
	add(lblValor, BorderLayout.CENTER);
    }

    protected void thisMouseClicked(MouseEvent e) {
	JOptionPane.showMessageDialog(null, " Conta: " + conta + "\n Valor: "
		+ valor);
    }
}
