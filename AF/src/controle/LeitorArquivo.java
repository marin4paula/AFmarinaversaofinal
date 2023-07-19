package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeitorArquivo {

	public List<List<Integer>> configRock;
    public List<List<Integer>> configReggae;
    public List<List<Integer>> configEletronica;

    public LeitorArquivo() {
    	configRock = lerArquivo("C:\\Users\\amand\\OneDrive\\Documentos\\marina\\AF\\src\\documentos\\rock");
        configReggae = lerArquivo("C:\\Users\\amand\\OneDrive\\Documentos\\marina\\AF\\src\\documentos\\reggae");
        configEletronica = lerArquivo("C:\\Users\\amand\\OneDrive\\Documentos\\marina\\AF\\src\\documentos\\eletronica");
    }
    
    public static List<List<Integer>> lerArquivo(String caminhoArquivo) {
        List<List<Integer>> dados = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] valores = linha.split(";");
                List<Integer> linhaDados = new ArrayList<>();
                for (String valor : valores) {
                    linhaDados.add(Integer.parseInt(valor));
                }
                dados.add(linhaDados);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return dados;
    }

    public static void imprimirDados(List<List<Integer>> dados) {
        for (List<Integer> linhaDados : dados) {
            System.out.println(Arrays.toString(linhaDados.toArray()));
        }
    }
}

