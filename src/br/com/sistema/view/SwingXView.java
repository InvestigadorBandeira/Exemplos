package br.com.sistema.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.border.DropShadowBorder;

import br.com.vga.mymoney.entity.Conta;
import br.com.vga.mymoney.entity.Titulo;
import br.com.vga.mymoney.view.components.PanelTitulo;

public class SwingXView extends JFrame {
    private final JXPanel fundoMenu;
    private JXTaskPaneContainer menuLateral;
    private final JScrollPane spTitulos;
    private final JPanel pnTitulos;

    public SwingXView() {
	setBounds(100, 100, 760, 460);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);

	fundoMenu = new JXPanel();
	fundoMenu.setAlpha(0.9f);
	fundoMenu.setBounds(0, 0, 261, 409);

	menuLateral();

	fundoMenu.add(menuLateral);
	getContentPane().add(fundoMenu);

	JPanel menu = new JPanel();
	menu.setBounds(271, 11, 200, 411);
	getContentPane().add(menu);
	menu.setLayout(new MigLayout("", "[200px]",
		"[40px][5px][40px][40px][40px]"));

	menu.add(new PanelSaldoContas("Saldo Global", "R$ 2.487,98"),
		"cell 0 0,grow");
	menu.add(new JPanel(), "cell 0 1,grow");
	menu.add(new PanelSaldoContas("Santander", "R$ 2.000,00"),
		"cell 0 2,grow");
	menu.add(new PanelSaldoContas("Banco do Brasil", "R$ 487,98"),
		"cell 0 3,grow");
	menu.add(new PanelSaldoContas("Dinheiro", "R$ 0,00"), "cell 0 4,grow");

	spTitulos = new JScrollPane();
	spTitulos.setBounds(481, 11, 240, 254);
	getContentPane().add(spTitulos);

	pnTitulos = new JPanel();
	spTitulos.setViewportView(pnTitulos);
	pnTitulos.setLayout(new MigLayout("", "[200px]",
		"[40px][5px][40px][40px][40px]"));

	Conta conta = new Conta();
	conta.setNome("Santander");
	Titulo t1, t2, t3;
	t1 = new Titulo();
	t1.setConta(conta);
	t1.setData(Calendar.getInstance());
	t1.setDescricao("descrição");
	t1.setValor(new BigDecimal("0.0"));

	pnTitulos.add(new PanelTitulo(t1), "cell 0 0,grow");
	pnTitulos.add(new JPanel(), "cell 0 1,grow");
	pnTitulos.add(new PanelSaldoContas("Santander", "R$ 2.000,00"),
		"cell 0 2,grow");
	pnTitulos.add(new PanelSaldoContas("Banco do Brasil", "R$ 487,98"),
		"cell 0 3,grow");
	pnTitulos.add(new PanelSaldoContas("Dinheiro", "R$ 0,00"),
		"cell 0 4,grow");

    }

    private void menuLateral() {
	menuLateral = new JXTaskPaneContainer();
	menuLateral.setEnabled(false);
	menuLateral.setFocusable(false);
	menuLateral.setScrollableTracksViewportWidth(false);
	menuLateral.setBorder(new DropShadowBorder());

	JXTaskPane principal = new JXTaskPane("Contas");
	JXTaskPane calendario = new JXTaskPane("Calendário");

	principal.setAnimated(false);
	// principal.add(new Home());
	principal.add(new PanelSaldoContas("Saldo Global", "R$ 2.487,98"));
	principal.add(new JPanel());
	principal.add(new PanelSaldoContas("Santander", "R$ 2.000,00"));
	principal.add(new PanelSaldoContas("Banco do Brasil", "R$ 487,98"));
	principal.add(new PanelSaldoContas("Dinheiro", "R$ 0,00"));

	menuLateral.add(principal);

	calendario.setAnimated(false);
	calendario.add(new JXMonthView());

	menuLateral.add(calendario);
    }

    private JLabel totalContas() {
	JLabel total = new JLabel("Saldo Global R$ 785.852.456,00");
	total.setFont(new Font("Tahoma", Font.BOLD, 12));
	total.setBounds(10, 16, 130, 25);

	return total;
    }

    private class Home extends AbstractAction {

	public Home() {
	    super();
	    putValue(javax.swing.Action.NAME, "Home");
	    putValue(javax.swing.Action.SHORT_DESCRIPTION,
		    "Ir para a página Home");
	    putValue(javax.swing.Action.ACTION_COMMAND_KEY, "go_home");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    JOptionPane.showMessageDialog(null, e.getActionCommand(), this
		    .getClass().getSimpleName(),
		    JOptionPane.INFORMATION_MESSAGE);
	}
    }
}
