package com.db.javaschool.tdd.taskmanager;

import java.util.List;

/**
 * Created by oglujul on 26.12.2014.
 */
public class TaskOperations {
    public static Task getHeadTask(Task task) {
        while (task.getPrevTask() != null)
            task = task.getPrevTask();
        return task;
    }

    public static Task getTaskById(Task task, int id) {
        if (task.getId() == id) return task;

        if (task.getFollowTasks() != null) {
            List<Task> tasks = task.getFollowTasks();

            for (Task t : tasks) {
                Task r = getTaskById(t, id);
                if (r != null)
                    return r;
            }
        }

        return null;

    }
}
