package com.cdq.app.processor.task.controller;

import com.cdq.app.processor.task.model.Task;
import com.cdq.app.processor.task.model.TaskCreateInput;
import com.cdq.app.processor.task.model.TaskRepresentation;
import com.cdq.app.processor.task.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getTasks();
    }

    @PostMapping
    public TaskRepresentation calculateBestMatch(@RequestBody TaskCreateInput taskCreateInput) {
        return taskService.bestMatch(taskCreateInput.getInput(), taskCreateInput.getPattern());
    }


}
