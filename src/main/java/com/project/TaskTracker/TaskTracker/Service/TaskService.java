package com.project.TaskTracker.TaskTracker.Service;

import com.project.TaskTracker.TaskTracker.Model.Tasks;
import com.project.TaskTracker.TaskTracker.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public List<Tasks> getAllTasks(){
        return taskRepo.findAll();
    }


    public Tasks addTask(Tasks tasks) {
        tasks.setCreatedAt(LocalDate.now());
        tasks.setUpdatedAt(LocalDate.now());
        return taskRepo.save(tasks);
    }

    public List<Tasks> getAllDoneTasks(){
        return taskRepo.getAllDoneTasks();
    }

    public List<Tasks> getAllTaskByStatus(String status){
        switch (status){
            case "Done":
                return taskRepo.getAllDoneTasks();
            case "Pending":
                return taskRepo.getAllPendingTasks();
            case "In Progress":
                return taskRepo.getAllInProgressTasks();
            case "To do":
                return taskRepo.getAllToDoTasks();
            default:
                return new ArrayList<>();
        }

    }


    public Tasks updateTask(int id, Tasks tasks) throws IOException {
        Tasks updatedTask = getById(id);
        updatedTask.setDescription(tasks.getDescription());
        updatedTask.setUpdatedAt(LocalDate.now());
        updatedTask.setStatus(tasks.getStatus());
        return taskRepo.save(updatedTask);
    }

    public Tasks getById(int id){
        return taskRepo.findById(id).orElse(null);
    }


}
