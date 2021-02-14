package model;

@SuppressWarnings("checkstyle:WhitespaceAround")
public class Task {
    //Things need to be done
    private String task;
    //Statue
    private String state;

    public Task(String task, String state) {
        this.task = task;
        this.state = state;
    }


    public String getTask() {
        return task;
    }



    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "task: " + task + " state: " + state;
    }
}
