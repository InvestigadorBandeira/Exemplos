package br.com.sistema.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class ParcelaView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JMenuBar menuBar;
    private JMenu mnArquivo;
    private JMenuItem mntmSair;
    private JPanel pnContas;
    private JMenuItem mntmRemove;
    private JMenuItem mntmAdiciona;
    private JSeparator separator;
    private JPanel pnBarraFerramentas;
    private JButton button;
    private JPanel pnTelas;

    public ParcelaView() {
	setMinimumSize(new Dimension(620, 420));
	initComponents();
	montaPanelContas();
    }

    private void initComponents() {
	setTitle("MyMoney - Sistema Financeiro Pessoal");
	setBounds(100, 100, 620, 420);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	pnContas = new JPanel();
	pnContas.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));

	pnBarraFerramentas = new JPanel();
	pnBarraFerramentas.setBorder(new TitledBorder(null, "",
		TitledBorder.LEADING, TitledBorder.TOP, null, null));

	pnTelas = new JPanel();
	pnTelas.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));

	GroupLayout groupLayout = new GroupLayout(getContentPane());
	groupLayout.setHorizontalGroup(groupLayout
		.createParallelGroup(Alignment.LEADING)
		.addComponent(pnBarraFerramentas, GroupLayout.DEFAULT_SIZE,
			600, Short.MAX_VALUE)
		.addGroup(
			groupLayout
				.createSequentialGroup()
				.addGap(10)
				.addComponent(pnContas,
					GroupLayout.PREFERRED_SIZE, 200,
					GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(pnTelas,
					GroupLayout.DEFAULT_SIZE, 374,
					Short.MAX_VALUE).addContainerGap()));
	groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
		Alignment.LEADING).addGroup(
		groupLayout
			.createSequentialGroup()
			.addComponent(pnBarraFerramentas,
				GroupLayout.PREFERRED_SIZE, 68,
				GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(
				groupLayout
					.createParallelGroup(Alignment.LEADING)
					.addComponent(pnTelas,
						GroupLayout.DEFAULT_SIZE, 277,
						Short.MAX_VALUE)
					.addComponent(pnContas,
						GroupLayout.DEFAULT_SIZE, 277,
						Short.MAX_VALUE))
			.addContainerGap()));
	pnTelas.setLayout(null);
	pnBarraFerramentas.setLayout(null);

	button = new JButton("");
	button.setBounds(10, 11, 56, 42);
	pnBarraFerramentas.add(button);
	getContentPane().setLayout(groupLayout);

	menuBar = new JMenuBar();
	setJMenuBar(menuBar);

	mnArquivo = new JMenu("Arquivo");
	menuBar.add(mnArquivo);

	mntmRemove = new JMenuItem("Remove");
	mntmRemove.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		mntmRemoveActionPerformed(e);
	    }
	});
	mnArquivo.add(mntmRemove);

	mntmAdiciona = new JMenuItem("Adiciona");
	mntmAdiciona.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		mntmAdicionaActionPerformed(e);
	    }
	});
	mnArquivo.add(mntmAdiciona);

	separator = new JSeparator();
	mnArquivo.add(separator);

	mntmSair = new JMenuItem("Sair");
	mnArquivo.add(mntmSair);
    }

    private void montaPanelContas() {
	pnContas.setLayout(new MigLayout("", "[200px]",
		"[40px][1px][40px][40px][40px]"));

	pnContas.add(new PanelSaldoContas("Saldo Global", "R$ 2.487,98"),
		"cell 0 0,grow");
	pnContas.add(new JPanel(), "cell 0 1,grow");
	pnContas.add(new PanelSaldoContas("Santander", "R$ 2.000,00"),
		"cell 0 2,grow");
	pnContas.add(new PanelSaldoContas("Banco do Brasil", "R$ 487,98"),
		"cell 0 3,grow");
	pnContas.add(new PanelSaldoContas("Dinheiro", "R$ 0,00"),
		"cell 0 4,grow");

    }

    protected void mntmRemoveActionPerformed(ActionEvent e) {
	pnContas.removeAll();
	pnContas.updateUI();
    }

    protected void mntmAdicionaActionPerformed(ActionEvent e) {
	TituloView view = new TituloView();
	pnTelas.removeAll();
	pnTelas.updateUI();
	pnTelas.add(view);
	view.setVisible(true);

	pnContas.removeAll();
	montaPanelContas();
	pnContas.updateUI();
    }
}
