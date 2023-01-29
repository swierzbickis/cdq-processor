package com.cdq.app.processor.task.service;

import com.cdq.app.processor.task.model.Task;
import com.cdq.app.processor.task.model.TaskRepresentation;
import com.cdq.app.processor.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getTasks() {
        return repository.getAllTasks();
    }

    public TaskRepresentation bestMatch(String input, String pattern) {
        int bestMatch = -1;
        int diffIndx = pattern.length();

        for (int i = 0; i <= input.length() - pattern.length(); i++) {
            int diff = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if (input.charAt(i + j) != pattern.charAt(j)) {
                    diff++;
                }
            }

            if (diff < diffIndx) {
                diffIndx = diff;
                bestMatch = i;
            }
        }

        int typosCount = 0;
        for (int i = bestMatch, j = 0; i < pattern.length(); i++, j++) {
            if (input.charAt(i) != pattern.charAt(j)) {
                typosCount++;
            }
        }
        return new TaskRepresentation(bestMatch, typosCount);
    }


}
