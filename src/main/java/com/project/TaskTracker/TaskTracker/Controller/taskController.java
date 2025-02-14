package com.project.TaskTracker.TaskTracker.Controller;

import com.project.TaskTracker.TaskTracker.Model.Tasks;
import com.project.TaskTracker.TaskTracker.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
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

    @GetMapping("all")
    public ResponseEntity<List<Tasks>> getAllTasks(){
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("all/{status}")
    public ResponseEntity<List<Tasks>> getAllTasksByStatus(@PathVariable String status){
        return ResponseEntity.ok(taskService.getAllTaskByStatus(status));
    }

//    @GetMapping("all/done")
//    public ResponseEntity<List<Tasks>> getAllDoneTasks(){
//        return ResponseEntity.ok(taskService.getAllDoneTasks());
//    }

    @PostMapping("add")
    public ResponseEntity<Tasks> addTask(@RequestBody Tasks tasks){
        try{
            Tasks tasks1 = taskService.addTask(tasks);
            return ResponseEntity.ok(tasks1);
        } catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Tasks tasks){
        Tasks tasks1 = null;

        try{
            tasks1 = taskService.updateTask(id, tasks);
        } catch (IOException e){
            return new ResponseEntity<>("failed to Update", HttpStatus.BAD_REQUEST);
        }

        if(tasks1 != null){
            return new ResponseEntity<>("Task is Updated", HttpStatus.OK);
        }

        return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
    }




}
