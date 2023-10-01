import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("Priority.txt"));
        String tipo = sc.nextLine();

        Relatorio relatorio = new Relatorio(tipo, 0);

        Escalanador escalanador = new Escalanador();
        List<Processo> processos = new ArrayList<>();

        if (tipo.equals("FCFS")) {
            while (sc.hasNextLine()) {
                String[] linha = sc.nextLine().split(" ");
                processos.add(new Processo(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]),
                        Integer.parseInt(linha[2])));
            }
            relatorio = escalanador.FCFS(processos, relatorio);
        } else if (tipo.equals("SJF")) {
            while (sc.hasNextLine()) {
                String[] linha = sc.nextLine().split(" ");
                processos.add(new Processo(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]),
                        Integer.parseInt(linha[2])));
            }
            relatorio = escalanador.SJF(processos, relatorio);
        } else if (tipo.equals("RR")) {
            int quantum = Integer.parseInt(sc.nextLine());
            while (sc.hasNextLine()) {
                String[] linha = sc.nextLine().split(" ");
                processos.add(new Processo(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]),
                        Integer.parseInt(linha[2])));
            }
            relatorio = escalanador.RR(processos, quantum, relatorio);
        } else if (tipo.equals("Priority")) {
            while (sc.hasNextLine()) {
                String[] linha = sc.nextLine().split(" ");
                processos.add(new Processo(Integer.parseInt(linha[0]), Integer.parseInt(linha[1]),
                        Integer.parseInt(linha[2]), Integer.parseInt(linha[3])));
            }
            relatorio = escalanador.Priority(processos, relatorio);
        }
        System.out.println(relatorio.gerarRelatorio());

        try (FileWriter saida = new FileWriter("out.txt")) {
            saida.write(relatorio.gerarRelatorio());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
