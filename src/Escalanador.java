import java.util.List;

public class Escalanador {

    // Métodos

    // Retorna o maior ArrivalTime
    public int lastAt(List<Processo> processos) {
        int lastAt = 0;
        for (Processo processo : processos) {
            if (processo.getArrivalTime() > lastAt) {
                lastAt = processo.getArrivalTime();
            }
        }
        return lastAt;
    }

    // FCFS (First-Come, First-Served) → Primeiro a chegar, primeiro servido (não
    // preemptivo)
    public Relatorio FCFS(List<Processo> processos, Relatorio relatorio) {
        int lastAt = lastAt(processos);
        int tempo = 0;
        System.out.println("lastAt: " + lastAt);
        while (tempo <= lastAt) {
            for (int i = 0; i < processos.size(); i++) {
                if (processos.get(i).getArrivalTime() == tempo) {
                    processos.get(i).setCompletionTime(tempo + processos.get(i).getBurstTime());
                    processos.get(i).setWaitingTime(processos.get(i).getCompletionTime()
                            - processos.get(i).getArrivalTime() - processos.get(i).getBurstTime());
                    relatorio.setLinhaDoTempo(relatorio.getLinhaDoTempo() + processos.get(i).getpId() + "--");
                    relatorio.getProcessos().add(processos.get(i));
                }
            }
            tempo++;
        }

        return relatorio;
    }

    // SJF (Shortest Job First) → Menor tarefa primeiro (não preemptivo)
    public Relatorio SJF(List<Processo> processos, Relatorio relatorio) {
        int tempo = 0;
        int lastAt = lastAt(processos);
        while (tempo <= lastAt) {
            for (Processo processo : processos) {
                if (processo.getArrivalTime() == tempo) {
                    processo.setCompletionTime(tempo + processo.getBurstTime());
                    processo.setWaitingTime(processo.getCompletionTime() - processo.getArrivalTime()
                            - processo.getBurstTime());
                    relatorio.setLinhaDoTempo(relatorio.getLinhaDoTempo() + processo.getpId() + "--");
                    relatorio.getProcessos().add(processo);
                }
            }
            tempo++;
        }
        return relatorio;
    }

    // RR (Round Robin) → Fila Circular (preemptivo)
    public Relatorio RR(List<Processo> processos, int quantum, Relatorio relatorio) {
        int tempo = 0;
        int lastAt = lastAt(processos);
        while (tempo <= lastAt) {
            for (Processo processo : processos) {
                if (processo.getArrivalTime() == tempo) {
                    processo.setCompletionTime(tempo + processo.getBurstTime());
                    processo.setWaitingTime(processo.getCompletionTime() - processo.getArrivalTime()
                            - processo.getBurstTime());
                    relatorio.setLinhaDoTempo(relatorio.getLinhaDoTempo() + processo.getpId() + "--");
                    relatorio.getProcessos().add(processo);
                }
            }
            tempo++;
        }
        return relatorio;
    }

    // Priority → Prioridade (preemptivo)
    public Relatorio Priority(List<Processo> processos, Relatorio relatorio) {
        int tempo = 0;
        int lastAt = lastAt(processos);
        processos.sort((p1, p2) -> p1.getPriority() - p2.getPriority());
        while (tempo <= lastAt) {
            for (Processo processo : processos) {
                if (processo.getArrivalTime() == tempo) {
                    processo.setCompletionTime(tempo + processo.getBurstTime());
                    processo.setWaitingTime(processo.getCompletionTime() - processo.getArrivalTime()
                            - processo.getBurstTime());
                    relatorio.setLinhaDoTempo(relatorio.getLinhaDoTempo() + processo.getpId() + "--");
                    relatorio.getProcessos().add(processo);
                }
            }
            tempo++;
        }
        return relatorio;
    }
}