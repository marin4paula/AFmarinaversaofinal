package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controle.Controlador;

public class Janela extends JFrame {
    public Janela() {
        setTitle("arena aeroporto");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        MenuSuperior menusuperior = new MenuSuperior();
        add(BorderLayout.NORTH, menusuperior);

        PainelSecundario secundario = new PainelSecundario();
        add(BorderLayout.EAST, secundario);

        JPanel centro = new JPanel(new BorderLayout());
        PainelBotao botoes = new PainelBotao();

        // Diminuir a altura dos botões em 5 vezes
        Dimension botaoSize = new Dimension(botoes.getWidth(), botoes.getHeight() / 5);
        botoes.setPreferredSize(botaoSize);
        botoes.setMinimumSize(botaoSize);
        botoes.setMaximumSize(botaoSize);

        centro.add(BorderLayout.CENTER, botoes);

        // Adicionar outro JPanel (painelInferior) abaixo dos botões
        JPanel painelInferior = new JPanel();
        painelInferior.setPreferredSize(new Dimension(botoes.getWidth(), 420)); // Defina a altura desejada (100 neste exemplo)
        painelInferior.setBackground(Color.BLACK); // Defina a cor desejada

        // Carregar a imagem
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\amand\\OneDrive\\Documentos\\marina\\AF\\src\\documentos\\banda.jpg");
        Image image = imageIcon.getImage();

        // Definir o novo tamanho da imagem (aumentar o tamanho em 2 vezes)
        int newWidth = (int) (image.getWidth(null) * 1.3);
        int newHeight = (int) (image.getHeight(null) * 1.3);
        Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Criar um novo ImageIcon com a imagem redimensionada
        ImageIcon newImageIcon = new ImageIcon(newImage);

        JLabel imagemLabel = new JLabel(newImageIcon);
        painelInferior.add(imagemLabel);

        centro.add(BorderLayout.SOUTH, painelInferior);

        add(BorderLayout.CENTER, centro);
        botoes.setVisible(false);
        secundario.setVisible(false);
        painelInferior.setVisible(false);
        Controlador controlador = new Controlador(botoes, secundario, menusuperior, painelInferior, this);
        
        setVisible(true);
        
    }
}

