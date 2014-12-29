package com.db.javaschool.tdd.taskmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oglujul on 26.12.2014.
 */
public class TaskExecutor implements ITaskExecutor{

    private List<Integer> executerLog;

    public TaskExecutor(Task task) {
        executerLog = new ArrayList<>();
        Task headTask = TaskOperations.getHeadTask(task);
        execute(headTask);
    }

    private void execute(Task task) {
        if (task.getFollowTasks() != null) {
            task.getFollowTasks().forEach(t -> execute(t));
        }

//        System.out.println("Task #" + task.getId() + " executed");
        executerLog.add(task.getId());
        task.executed();
    }

    public List<Integer> getExecuterLog() {
        return executerLog;
    }
}
