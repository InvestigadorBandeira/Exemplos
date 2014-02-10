package br.com.sistema.view;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class TesteView extends JDialog {
    private JPanel pnFundo;
    private ParcelaPanelView panel;

    public TesteView() {

	initComponents();
    }

    private void initComponents() {
	setTitle("Teste View");
	setBounds(100, 100, 530, 593);
	getContentPane().setLayout(null);

	pnFundo = new JPanel();
	pnFundo.setBounds(10, 11, 494, 291);
	getContentPane().add(pnFundo);

	panel = new ParcelaPanelView();
	panel.setBounds(10, 334, 453, 146);
	getContentPane().add(panel);
    }
}
