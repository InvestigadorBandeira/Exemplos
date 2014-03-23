package br.com.sistema.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXMonthView;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.border.DropShadowBorder;

import br.com.vga.mymoney.entity.Conta;
import br.com.vga.mymoney.entity.Titulo;

public class SwingXView extends JFrame {
    private final JXPanel fundoMenu;
    private JXTaskPaneContainer menuLateral;
    private final JPanel pnGrupos;
    private final JLabel lblSaldoGlobal;
    private final JPanel pnBancos;
    private final JPanel pnBancosContas;

    public SwingXView() {
	setBounds(100, 100, 760, 443);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getContentPane().setLayout(null);

	fundoMenu = new JXPanel();
	fundoMenu.setAlpha(0.9f);
	fundoMenu.setBounds(0, 0, 261, 409);

	menuLateral();

	fundoMenu.add(menuLateral);
	getContentPane().add(fundoMenu);

	JPanel pnMenu = new JPanel();
	pnMenu.setBounds(271, 11, 200, 411);
	getContentPane().add(pnMenu);
	pnMenu.setLayout(new MigLayout("", "[200px]",
		"[40px][5px][40px][40px][40px]"));

	pnMenu.add(new PanelSaldoContas("Saldo Global", "R$ 2.487,98"),
		"cell 0 0,grow");
	pnMenu.add(new JPanel(), "cell 0 1,grow");
	pnMenu.add(new PanelSaldoContas("Santander", "R$ 2.000,00"),
		"cell 0 2,grow");
	pnMenu.add(new PanelSaldoContas("Banco do Brasil", "R$ 487,98"),
		"cell 0 3,grow");
	pnMenu.add(new PanelSaldoContas("Dinheiro", "R$ 0,00"), "cell 0 4,grow");

	pnGrupos = new JPanel();
	pnGrupos.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
		TitledBorder.TOP, null, null));
	pnGrupos.setBounds(481, 11, 200, 383);
	getContentPane().add(pnGrupos);
	pnGrupos.setLayout(new MigLayout("", "[200px,grow]",
		"[40px][5px][140px][40px]"));

	lblSaldoGlobal = new JLabel(" Saldo Global");
	lblSaldoGlobal.setFont(new Font("Tahoma", Font.BOLD, 12));

	pnGrupos.add(new PanelSaldoContas("Saldo Global", "R$ 2.487,98"),
		"cell 0 0,grow");

	pnBancos = new JPanel();
	pnGrupos.add(pnBancos, "cell 0 2,grow");
	pnBancos.setLayout(new BorderLayout(0, 0));

	pnBancos.add(new PanelSaldoContas(" BANCOS", "R$ 2.487,98"),
		BorderLayout.CENTER);

	pnBancosContas = new JPanel();
	pnBancosContas.setLayout(new MigLayout("", "[200px]", "[40px][40px]"));

	pnBancosContas.add(new PanelSaldoContas("Santander", "R$ 2.000,00"),
		"cell 0 0,grow");
	pnBancosContas.add(
		new PanelSaldoContas("Banco do Brasil", "R$ 487,98"),
		"cell 0 1,grow");

	pnBancos.add(pnBancosContas, BorderLayout.SOUTH);

	Conta conta = new Conta();
	conta.setNome("Santander");
	Titulo t1, t2, t3;
	t1 = new Titulo();
	t1.setConta(conta);
	t1.setData(Calendar.getInstance());
	t1.setDescricao("descrição");
	t1.setValor(new BigDecimal("0.0"));

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
