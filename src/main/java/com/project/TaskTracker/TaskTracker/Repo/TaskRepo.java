package com.project.TaskTracker.TaskTracker.Repo;

import com.project.TaskTracker.TaskTracker.Model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Tasks, Integer> {

    @Query("SELECT t FROM Tasks t WHERE t.status = 'Done'")
    public List<Tasks> getAllDoneTasks();

    @Query("SELECT t FROM Tasks t WHERE t.status = 'Pending'")
    public List<Tasks> getAllPendingTasks();

    @Query("SELECT t FROM Tasks t WHERE t.status = 'To do'")
    public List<Tasks> getAllToDoTasks();

    @Query("SELECT t FROM Tasks t WHERE t.status = 'In Progress'")
    public List<Tasks> getAllInProgressTasks();



}
