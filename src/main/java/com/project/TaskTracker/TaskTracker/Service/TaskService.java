package com.project.TaskTracker.TaskTracker.Service;

import com.project.TaskTracker.TaskTracker.Model.Tasks;
import com.project.TaskTracker.TaskTracker.Repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo task;

    public List<Tasks> getAllTasks(){
        return task.findAll();
    }
}
