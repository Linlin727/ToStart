package model;

public class Task {
    //Things need to be done
    private String task;
    //Statue
    private String statue;

    public Task(String task, String statue) {
        this.task = task;
        this.statue = statue;
    }

    public Task(String task) {
        this.task = task;
        this.statue = "Incomplete";
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

}
