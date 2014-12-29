package com.db.javaschool.tdd.taskmanager;

import java.util.List;

/**
 * Created by Julia on 30.12.2014.
 */
public interface ITask {
    public void resetExecuted();

    public void setPrevTask(Task prevTask);

    public void setFollowTasks(List<Task> followTasks);

    public void addFollowTask(Task followTask);

    public Task getPrevTask();

    public void executed();

    public int getExecuted();

    public List<Task> getFollowTasks();

    public int getId();

}
