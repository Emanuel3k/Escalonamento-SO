public class Processo {
    // Atributos
    private int pId;
    private int arrivalTime;
    private int burstTime;
    private int completionTime;
    private int waitingTime;
    private int quantum; // Usado apenas no escalonamento Round Robin
    private Integer priority; // Usado apenas no escalonamento por prioridade

    // Construtor

    // FCFS, SJF e RR
    public Processo(int pId, int arrivalTime, int burstTime) {
        this.pId = pId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }

    // Priority
    public Processo(int pId, int priority, int arrivalTime, int burstTime) {
        this.pId = pId;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
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

    public int getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public int getQuantum() {
        return quantum;
    }

    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }

    @Override
    public String toString() {
        if (priority != null) {
            return pId + "\t" + priority + "\t" + arrivalTime + "\t" + burstTime + "\t" + completionTime + "\t"
                    + getArrivalTime() + "\t" + getWaitingTime()
                    + "\t";
        }
        return pId + "\t" + arrivalTime + "\t" + burstTime + "\t" + completionTime + "\t" + getArrivalTime() + "\t"
                + getWaitingTime() + "\t";

    }

}