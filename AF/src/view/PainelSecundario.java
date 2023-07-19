package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PainelSecundario extends JPanel {
    // Declarar os botões como atributos públicos
    public BotaoRock rock;
    public BotaoReggae reggae;
    public BotaoEletronica eletronica;
    public BotaoForte forte;
    public BotaoFraca fraca;
    public BotaoRapida rapida;
    public BotaoLenta lenta;

    PainelSecundario() {
        this.setBackground(new Color(171, 179, 242));
        this.setLayout(new GridLayout(3, 1));
        this.setPreferredSize(new Dimension(200, 200)); // Definindo a largura e altura desejada
        
        JPanel ritmos = new JPanel();
        ritmos.setLayout(new GridLayout(4, 1));
        ritmos.setBackground(new Color(171, 179, 242));

        // Inicializar os botões
        rock = new BotaoRock();
        reggae = new BotaoReggae();
        eletronica = new BotaoEletronica();
        
        rock.setForeground(Color.WHITE);
        reggae.setForeground(Color.WHITE);
        eletronica.setForeground(Color.WHITE);

        JLabel ritmo = new JLabel("RITMOS");
        ritmo.setHorizontalAlignment(SwingConstants.CENTER); // Centralizar horizontalmente
        ritmos.add(ritmo);
        ritmos.add(rock);
        ritmos.add(reggae);
        ritmos.add(eletronica);

        JPanel intensidade = new JPanel();
        intensidade.setLayout(new GridLayout(3, 1));
        intensidade.setBackground(new Color(171, 179, 242));
        intensidade.setSize(300, 700);
        ritmos.setSize(300, 700);

        JLabel intensidadecor = new JLabel("INTENSIDADE DAS CORES");
        intensidadecor.setHorizontalAlignment(SwingConstants.CENTER); // Centralizar horizontalmente
        forte = new BotaoForte();
        fraca = new BotaoFraca();
        forte.setForeground(Color.WHITE);
        fraca.setForeground(Color.WHITE);
        intensidade.add(intensidadecor);
        intensidade.add(forte);
        intensidade.add(fraca);

        JPanel velocidade = new JPanel();
        velocidade.setLayout(new GridLayout(3, 1));
        velocidade.setBackground(new Color(171, 179, 242));
        velocidade.setSize(300, 700);

        JLabel velocidades = new JLabel("VELOCIDADE");
        velocidades.setHorizontalAlignment(SwingConstants.CENTER); // Centralizar horizontalmente
        rapida = new BotaoRapida();
        lenta = new BotaoLenta();
        rapida.setForeground(Color.WHITE);
        lenta.setForeground(Color.WHITE);
        velocidade.add(velocidades);
        velocidade.add(rapida);
        velocidade.add(lenta);

        add(ritmos);
        add(intensidade);
        add(velocidade);
    }
}
