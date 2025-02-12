package com.project.TaskTracker.TaskTracker.Controller;

import com.project.TaskTracker.TaskTracker.Model.Tasks;
import com.project.TaskTracker.TaskTracker.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class taskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String welcomeTask(){
        return "Welcome to the Task Tracker Backend";
    }

    @RequestMapping("all")
    public ResponseEntity<List<Tasks>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }
}
