package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import view.Janela;
import view.MenuSuperior;
import view.PainelBotao;
import view.PainelSecundario;

public class Controlador {
	public static String ritmo;
	public static int velocidade = 1000;
	public static float intensidade = 0.4f;
	public static File endarquivo;
	private JPanel botoes;
	public static String aluno;
	public static boolean sair;
	private PainelBotao painelBotao;
	private PainelSecundario painelSecundario;
	private MenuSuperior menuSuperior;
	private Janela janela;
	private JPanel menuInferior;
	public LeitorArquivo leitor;
	private SwingWorker<Void, Void> worker;

	public Controlador(PainelBotao painelBotao, PainelSecundario painelSecundario, MenuSuperior menuSuperior, JPanel menuInferior, Janela janela) {
		this.painelBotao = painelBotao;
		this.painelSecundario = painelSecundario;
		this.menuSuperior = menuSuperior;
		this.menuInferior = menuInferior;
		this.janela = janela;
		this.leitor = new LeitorArquivo();
		setupActionListeners();
	}

	public void dormir(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
	}

	// Função para alterar a opacidade dos JPanels do PainelBotao
	public void alterarOpacidadeJPanel(List<List<Integer>> arrayLista, int intervaloTempo, float fatorEscurecimento) {
        // Se houver um worker em execução, interrompe-o
        if (worker != null && !worker.isDone()) {
            worker.cancel(true);
        }

        worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                int numRows = arrayLista.size();
                boolean interrupted = false;

                for (int i = 0; i < numRows && !interrupted; i++) {
                    List<Integer> linha = arrayLista.get(i);

                    for (int j = 0; j < linha.size() && !interrupted; j++) {
                        int valor = linha.get(j);

                        // Definir a intensidade da cor de acordo com o valor (0 ou 1)
                        float intensidade = valor == 1 ? 1.0f : fatorEscurecimento;

                        // Alterar a cor de fundo do JPanel correspondente
                        switch (j) {
                            case 0:
                                alterarCorEOpacidade(painelBotao.azul, escurecerCor(Color.BLUE, intensidade));
                                break;
                            case 1:
                                alterarCorEOpacidade(painelBotao.vermelho, escurecerCor(Color.RED, intensidade));
                                break;
                            case 2:
                                alterarCorEOpacidade(painelBotao.verde, escurecerCor(Color.GREEN, intensidade));
                                break;
                            case 3:
                                alterarCorEOpacidade(painelBotao.rosa, escurecerCor(Color.PINK, intensidade));
                                break;
                            case 4:
                                alterarCorEOpacidade(painelBotao.roxo, escurecerCor(new Color(36, 27, 83), intensidade));
                                break;
                            case 5:
                                alterarCorEOpacidade(painelBotao.amarelo, escurecerCor(Color.YELLOW, intensidade));
                                break;
                        }

                        // Verificar se o trabalho foi interrompido
                        if (isCancelled()) {
                            interrupted = true;
                        }
                    }

                    // Aguardar o intervalo de tempo antes de alterar a próxima linha
                    dormir(intervaloTempo);
                }
                return null;
            }
        };

        worker.execute();
    }
	
	public Color escurecerCor(Color corOriginal, float fatorEscurecimento) {
	    float[] hsbValues = Color.RGBtoHSB(corOriginal.getRed(), corOriginal.getGreen(), corOriginal.getBlue(), null);
	    float brightness = hsbValues[2] * fatorEscurecimento;
	    return Color.getHSBColor(hsbValues[0], hsbValues[1], brightness);
	}
	
	private void alterarCorEOpacidade(JPanel painel, Color color) {
		painel.setBackground(color);
	}

	private void setupActionListeners() {
		painelSecundario.rock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ROCK");
				alterarOpacidadeJPanel(leitor.configRock, velocidade, intensidade);
				ritmo = "rock";
			}
		});

		painelSecundario.reggae.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("REGGAE");
				alterarOpacidadeJPanel(leitor.configReggae, velocidade, intensidade);
				ritmo = "reggae";
			}
		});

		painelSecundario.eletronica.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ELETRONICA");
				alterarOpacidadeJPanel(leitor.configEletronica, velocidade, intensidade);
				ritmo = "eletronica";
			}
		});

		painelSecundario.forte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				intensidade = "forte";
				intensidade = 0.7f;
			}
		});

		painelSecundario.fraca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				intensidade = "fraca";
				intensidade = 0.3f;
			}
		});

		painelSecundario.rapida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				velocidade = "rapida";
				velocidade = 300;
			}
		});

		painelSecundario.lenta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				velocidade = "lenta";
				velocidade = 1000;
			}
		});
		
		menuSuperior.iniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("iniciar");
				menuSuperior.iniciar.setEnabled(false);
				menuSuperior.tecnico.setEditable(false);
				painelSecundario.setVisible(true);
				painelBotao.setVisible(true);
				menuInferior.setVisible(true);
			}
		});


		menuSuperior.sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
			}
		});
	}

}



