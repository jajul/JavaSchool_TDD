package com.db.javaschool.tdd.taskmanager;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class TaskExecutorTest {

    Task firstTask;

    @org.junit.Before
    /**
     *                    1
     *                 /     \
     *                2       3
     *              / | \   / | \
     *             4  5 6  7  8  9
     */
    public void setUp() throws Exception {
        firstTask = new Task(true);

        for (int i = 0; i < 2; i++)
            firstTask.addFollowTask(new Task());

        for (Task secondTasks : firstTask.getFollowTasks()) {
            for (int i = 0; i < 3; i++)
                secondTasks.addFollowTask(new Task());
        }
    }

    @Test
    public void testExecutor_shouldBeRightOrder() {
        TaskExecutor te = new TaskExecutor(firstTask);
        int[] result = {4, 5, 6, 2, 7, 8, 9, 3, 1};

        for (int i = 0; i<result.length; i++)
            assertEquals(te.getExecuterLog().get(i).intValue(), result[i]);
    }

    public void testExecutor_taskInTheTaskExecutorTree() {
        TaskExecutor te = new TaskExecutor(firstTask);

        Task eightsTask = TaskOperations.getTaskById(firstTask, 8);
        assertNotNull(eightsTask);

        Task thirdTask = TaskOperations.getTaskById(firstTask, 3);
        assertNotNull(thirdTask);
    }

    public void testExecutor_taskIsNotInTheTaskExecutorTree() {
        TaskExecutor te = new TaskExecutor(firstTask);

        Task ZeroTask = TaskOperations.getTaskById(firstTask, 0);
        assertNull(ZeroTask);
    }

    @Test
    public void testExecutor_TaskExecutesAfterFollowingTasks() {
        TaskExecutor te = new TaskExecutor(firstTask);

        assertTrue(te.getExecuterLog().indexOf(8) < te.getExecuterLog().indexOf(3));
    }


    @Test
    public void testExecutor_TasksExecutesWithoutLoop() {
        TaskExecutor te = new TaskExecutor(firstTask);

        for (int i = 1; i<10; i++)
            assertTrue(TaskOperations.getTaskById(firstTask, i).getExecuted() == 1);
    }
}