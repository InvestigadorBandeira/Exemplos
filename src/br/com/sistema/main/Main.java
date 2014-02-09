package br.com.sistema.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;

import br.com.sistema.util.PWSec;
import br.com.sistema.view.ParcelaView;
import br.com.vga.mymoney.entity.Parcela;

public class Main {

    public static void main(String[] args) {

	// SwingXView view = new SwingXView();
	// view.setExtendedState(JFrame.MAXIMIZED_BOTH);
	// view.setVisible(true);

	ParcelaView view = new ParcelaView();
	view.setExtendedState(JFrame.MAXIMIZED_BOTH);
	view.setVisible(true);

	// DecimalFormat df = new DecimalFormat("#,##0.00;-#,##0.00");
	// BigDecimal valor = new BigDecimal("-88700.5");
	// System.out.println("O valor é: " + df.format(valor));

    }

    public static List<Parcela> getParcelas() {
	List<Parcela> parcelas = new ArrayList<>();

	Parcela p = new Parcela();
	p.setDataVencimento(Calendar.getInstance());
	p.setValor(new BigDecimal("65432.1"));
	p.setObservacao("Walmart");

	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);
	parcelas.add(p);

	return parcelas;
    }

    public static void encripta() throws Exception {
	PWSec sec = new PWSec();

	// esta é a tal senha do banco de dados que você quer criptografar
	// 3p6/Lsbp+MIK8zqK
	String password = "Vinicius Gomes de Araújo Lima";

	String encoded = sec.encrypt(password);

	// imprime "4fWCjTdEhMPEluqE2n8ci4FiqWeb+DXc"
	System.out.println("Encripta: " + encoded);

	// imprime "true"
	System.out.println("Iguais? " + sec.decrypt(encoded).equals(password));

	// Vamos alterar um caracter, só para ver o que ocorre
	char[] enc = encoded.toCharArray();
	enc[2] = (char) (enc[2] + 1);
	encoded = new String(enc);

	// imprime "4fXCjTdEhMPEluqE2n8ci4FiqWeb+DXc"
	System.out.println("Encripta: " + encoded);

	// imprime "false"
	System.out.println("Iguais? " + password.equals(sec.decrypt(encoded)));
    }
}
