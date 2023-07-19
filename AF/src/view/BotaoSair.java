package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controle.Controlador;
public class BotaoSair extends JButton implements ActionListener{
	public BotaoSair() {
		setText("sair");
		setBackground(Color.BLUE);}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Controlador.sair=true;
	}

}

