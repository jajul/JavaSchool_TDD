package com.db.javaschool.tdd.taskmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oglujul on 26.12.2014.
 *
 * Each Task has only one parent task (or zero, if it's a head task)
 * And several following tasks.
 */
public class Task implements ITask {
    private int id;
    private Task prevTask;
    private List<Task> followTasks;
    private int executed;

    /**
     * Head Task
     */
    public Task() {
        this.prevTask = null;
        this.executed = 0;
        this.id = GenSeq.genId();
    }

    public Task(Boolean reset) {
       if (reset)
           GenSeq.resetId();
        this.prevTask = null;
        this.executed = 0;
        this.id = GenSeq.genId();
    }

    public Task(Task prevTask, List<Task> followTasks) {
        this();
        this.prevTask = prevTask;
        this.followTasks = followTasks;
    }

    public void resetExecuted() {
        this.executed = 0;
    }

    public void setPrevTask(Task prevTask) {
        this.prevTask = prevTask;
    }

    public void setFollowTasks(List<Task> followTasks) {
        this.followTasks = followTasks;
    }

    public void addFollowTask(Task followTask) {
        if (this.followTasks == null )
            this.followTasks = new ArrayList<>();
        this.followTasks.add(followTask);
    }

    public Task getPrevTask() {
        return prevTask;
    }

    public void executed() {
        executed++;
    }

    public int getExecuted(){
        return executed;
    }


    public List<Task> getFollowTasks() {
        return followTasks;
    }

    public int getId() {
        return id;
    }
}
