
	
package view;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuSuperior extends JPanel {
    public JLabel nome;
    public JTextField tecnico;
    public JButton iniciar;
    public BotaoRelatorio relatorio;
    public BotaoSair sair;

    public MenuSuperior() {
        this.setBackground(new Color(171, 179, 242));
        setLayout(new FlowLayout());
        nome = new JLabel("tecnico de palco");
        tecnico = new JTextField(25);
        iniciar = new JButton("iniciar");
        relatorio = new BotaoRelatorio();
        sair = new BotaoSair();

        add(nome);
        add(tecnico);
        add(iniciar);
        add(relatorio);
        add(sair);
    }
}

