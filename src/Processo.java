public class Processo {
    // Atributos
    private int pId;
    private int arrivalTime;
    private int burstTime;
    private int priority; // Usado apenas no escalonamento por prioridade

    // Construtor
    public Processo(int pId, int arrivalTime, int burstTime, int priority) {
        this.pId = pId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    // Getters e Setters
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Processo [pId=" + pId + ", arrivalTime=" + arrivalTime + ", burstTime=" + burstTime + ", priority="
                + priority + "]";
    }

}