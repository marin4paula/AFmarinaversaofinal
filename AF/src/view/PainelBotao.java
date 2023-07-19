package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;

import controle.Controlador;

public class PainelBotao extends JPanel {
    public JPanel azul;
    public JPanel vermelho;
    public JPanel verde;
    public JPanel rosa;
    public JPanel roxo;
    public JPanel amarelo;

    public PainelBotao() {
    	this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(1, 6));

        azul = criarPainel(Color.BLUE);
        vermelho = criarPainel(Color.RED);
        verde = criarPainel(Color.GREEN);
        rosa = criarPainel(Color.PINK);
        roxo = criarPainel(new Color(36, 27, 83));
        amarelo = criarPainel(Color.YELLOW);

        add(azul);
        add(vermelho);
        add(verde);
        add(rosa);
        add(roxo);
        add(amarelo);

        if (!Controlador.sair) {
            festa();
        }
    }

    private JPanel criarPainel(Color cor) {
        JPanel painel = new JPanel();
        painel.setPreferredSize(new Dimension(50, 10));
        painel.setBackground(cor);
        return painel;
    }

    public void festa() {
        if (Controlador.ritmo != null && !Controlador.sair) {
            if (Controlador.ritmo.equals("rock"))
                Controlador.endarquivo = new File("C:\\Users\\amand\\OneDrive\\Documentos\\marina\\AF\\src\\documentos\\rock");
            else if (Controlador.ritmo.equals("reggae"))
                Controlador.endarquivo = new File("C:\\Users\\amand\\OneDrive\\Documentos\\marina\\AF\\src\\documentos\\reggae");
            else if (Controlador.ritmo.equals("eletro"))
                Controlador.endarquivo = new File("C:\\Users\\amand\\OneDrive\\Documentos\\marina\\AF\\src\\documentos\\eletronica");

            try {
                BufferedReader arquivo = new BufferedReader(new FileReader(Controlador.endarquivo));
                while (arquivo.ready()) {
                    String linha = arquivo.readLine();
                    String[] aux = linha.split(";");
                    if (aux[0].equals("1")) {
                        alterarCorPainel(azul, Color.BLUE);
                    }
                    if (aux[1].equals("1")) {
                        alterarCorPainel(vermelho, Color.RED);
                    }
                    if (aux[2].equals("1")) {
                        alterarCorPainel(verde, Color.GREEN);
                    }
                    if (aux[3].equals("1")) {
                        alterarCorPainel(rosa, Color.PINK);
                    }
                    if (aux[4].equals("1")) {
                        alterarCorPainel(roxo, new Color(36, 27, 83));
                    }
                    if (aux[5].equals("1")) {
                        alterarCorPainel(amarelo, Color.YELLOW);
                    }
                }
                arquivo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void alterarCorPainel(JPanel painel, Color cor) {
        painel.setBackground(Color.WHITE);
        dormir();
        painel.setBackground(cor);
    }

    public void dormir() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
