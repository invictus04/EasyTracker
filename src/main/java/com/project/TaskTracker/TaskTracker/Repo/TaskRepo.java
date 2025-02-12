package com.project.TaskTracker.TaskTracker.Repo;

import com.project.TaskTracker.TaskTracker.Model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Tasks, Integer> {

}
