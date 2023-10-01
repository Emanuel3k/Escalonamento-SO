import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    // Atributos
    private String nomeEscalonador;
    private String linhaDoTempo;
    private int tempo;
    private List<Processo> processos = new ArrayList<>();

    // Construtor
    public Relatorio(String nomeEScalanador, int tempo) {
        this.nomeEscalonador = nomeEScalanador;
        this.tempo = tempo;
        linhaDoTempo = "0--";
    }

    // Métodos
    public String gerarRelatorio() {
        List<Processo> processosOrdenados = getProcessos().stream()
                .sorted((e1, e2) -> Integer.compare(e1.getpId(), e2.getpId())).toList();

        String relatorio = "";

        relatorio += "Escalonador: " + getNomeEscalonador() + "\n";
        relatorio += "Tempo total de execução: " + getTempo() + "\n";
        relatorio += "Tempo médio no sistema: " + getTempoMedio() + "\n";
        relatorio += "Tempo médio de espera: " + getTempoMedioEspera() + "\n";
        if (getNomeEscalonador().equals("Priority")) {
            relatorio += "pId\tPR\tAT\tBT\tCT\tWT\n";
        } else {
            relatorio += "pId\tAT\tBT\tCT\tWT\n";
        }
        for (Processo p : processosOrdenados) {
            relatorio += p + "\n";
        }

        return relatorio;

    }

    public Double getTempoMedio() {
        Double tempoMedio = 0.0;
        for (Processo processo : getProcessos()) {
            tempoMedio += processo.getArrivalTime();
        }
        return tempoMedio / getProcessos().size();
    }

    public Double getTempoMedioEspera() {
        Double tempoMedioEspera = 0.0;
        for (Processo processo : getProcessos()) {
            tempoMedioEspera += processo.getWaitingTime();
        }
        return tempoMedioEspera / getProcessos().size();
    }

    // getters e setters
    public String getNomeEscalonador() {
        return nomeEscalonador;
    }

    public void setNomeEscalonador(String nomeEscalonador) {
        this.nomeEscalonador = nomeEscalonador;
    }

    public String getLinhaDoTempo() {
        return linhaDoTempo;
    }

    public void setLinhaDoTempo(String linhaDoTempo) {
        this.linhaDoTempo = linhaDoTempo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public void setProcessos(List<Processo> processos) {
        this.processos = processos;
    }

}
