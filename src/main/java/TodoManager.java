import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

@ApplicationScoped
@Named
public class TodoManager {
    private String input;
    private ArrayList<Task> activeTasks = new ArrayList<Task>();
    private ArrayList<Task> finishedTasks = new ArrayList<Task>();

    public void addTask() {
        activeTasks.add(new Task(this.input));
    }

    public void finishTask(int index) {
        finishedTasks.add(activeTasks.get(index));
        activeTasks.remove(activeTasks.get(index));
    }

    public void deleteTask(int index) {
        finishedTasks.remove(index);
    }

    public ArrayList<Task> getActiveTasks() {
        return activeTasks;
    }

    public ArrayList<Task> getFinishedTasks() {
        return finishedTasks;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String in) {
        this.input = in;
    }
}
