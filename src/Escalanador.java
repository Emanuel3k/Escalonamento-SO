import java.util.ArrayList;
import java.util.List;

public class Escalanador {

    // Métodos

    // FCFS (First-Come, First-Served) → Primeiro a chegar, primeiro servido (não
    // preemptivo)
    public void FCFS(List<Processo> processos) {
        int n = processos.size();

        // Tempo de espera para o primeiro processo é 0
        int wt[] = new int[n];
        int tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Calcula o tempo de espera para todos os processos
        for (int i = 1; i < n; i++) {
            tat[i] = processos.get(i).getBurstTime() + wt[i];
            wt[i] = processos.get(i - 1).getBurstTime() + wt[i - 1];
        }

        // Calcula o tempo de retorno médio e o tempo de espera médio
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];

            System.out.println("Processo " + processos.get(i).getpId() + " | Tempo de espera: " + wt[i]
                    + " | Tempo de retorno: " + tat[i]);
        }

        System.out.println("Tempo de espera médio = " + (float) total_wt / (float) n);
        System.out.println("Tempo de retorno médio = " + (float) total_tat / (float) n);
    }

    // SJF (Shortest Job First) → Menor tarefa primeiro (não preemptivo)
    public void SJF(List<Processo> processos) {
        int n = processos.size();

        // Tempo de espera para o primeiro processo é 0
        int wt[] = new int[n];
        int tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Ordena os processos pelo tempo de burst em lambda
        List<Processo> processosOrdenados = new ArrayList<Processo>();
        processos.stream().sorted((p1, p2) -> p1.getBurstTime() - p2.getBurstTime()).forEach(processosOrdenados::add);

        // Calcula o tempo de espera para todos os processos
        for (int i = 1; i < n; i++) {
            tat[i] = processos.get(i).getBurstTime() + wt[i];
            wt[i] = processos.get(i - 1).getBurstTime() + wt[i - 1];
        }

        // Calcula o tempo de retorno médio e o tempo de espera médio
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];

            System.out.println("Processo " + processos.get(i).getpId() + " | Tempo de espera: " + wt[i]
                    + " | Tempo de retorno: " + tat[i]);
        }

        System.out.println("Tempo de espera médio = " + (float) total_wt / (float) n);
        System.out.println("Tempo de retorno médio = " + (float) total_tat / (float) n);
    }

    // RR (Round Robin) → Fila Circular (preemptivo)
    public void RR(List<Processo> processos, int quantum) {
        int n = processos.size();

        // Tempo de espera para o primeiro processo é 0
        int wt[] = new int[n];
        int tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Copia o tempo de burst para um vetor auxiliar
        int burstTime[] = new int[n];
        for (int i = 0; i < n; i++) {
            burstTime[i] = processos.get(i).getBurstTime();
        }

        while (true) {
            boolean done = true;

            // Percorre todos os processos um a um
            for (int i = 0; i < n; i++) {
                // Se o tempo de burst do processo for maior que 0, então ainda há processos a
                // serem executados
                if (burstTime[i] > 0) {
                    done = false;

                    // Se o tempo de burst do processo for maior que o quantum, então o processo
                    // será executado por um quantum
                    if (burstTime[i] > quantum) {
                        // Aumenta o tempo de espera do processo pelo tempo de quantum
                        wt[i] += quantum;

                        // Diminui o tempo de burst do processo pelo tempo de quantum
                        burstTime[i] -= quantum;
                    } else {
                        // Aumenta o tempo de espera do processo pelo tempo de burst
                        wt[i] += burstTime[i];

                        // O tempo de burst do processo é zerado
                        burstTime[i] = 0;
                    }
                }
            }

            // Se todos os processos foram executados
            if (done == true) {
                break;
            }
        }

        // Calcula o tempo de retorno para todos os processos
        for (int i = 0; i < n; i++) {
            tat[i] = processos.get(i).getBurstTime() + wt[i];
        }

        // Calcula o tempo de retorno médio e o tempo de espera médio
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];

            System.out.println("Processo " + processos.get(i).getpId() + " | Tempo de espera: " + wt[i]
                    + " | Tempo de retorno: " + tat[i]);
        }

        System.out.println("Tempo de espera médio = " + (float) total_wt / (float) n);
        System.out.println("Tempo de retorno médio = " + (float) total_tat / (float) n);
    }

    // Priority → Prioridade (preemptivo)
    public void Priority(List<Processo> processos) {
        int n = processos.size();

        // Tempo de espera para o primeiro processo é 0
        int wt[] = new int[n];
        int tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Ordena os processos pela prioridade
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (processos.get(j).getPriority() > processos.get(j + 1).getPriority()) {
                    Processo aux = processos.get(j);
                    processos.set(j, processos.get(j + 1));
                    processos.set(j + 1, aux);
                }
            }
        }

        // Calcula o tempo de espera para todos os processos
        for (int i = 1; i < n; i++) {
            tat[i] = processos.get(i).getBurstTime() + wt[i];
            wt[i] = processos.get(i - 1).getBurstTime() + wt[i - 1];
        }

        // Calcula o tempo de retorno médio e o tempo de espera médio
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];

            System.out.println("Processo " + processos.get(i).getpId() + " | Tempo de espera: " + wt[i]
                    + " | Tempo de retorno: " + tat[i]);
        }

        System.out.println("Tempo de espera médio = " + (float) total_wt / (float) n);
        System.out.println("Tempo de retorno médio = " + (float) total_tat / (float) n);
    }

}
