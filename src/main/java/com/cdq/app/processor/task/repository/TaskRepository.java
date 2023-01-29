package com.cdq.app.processor.task.repository;

import com.cdq.app.processor.task.model.Status;
import com.cdq.app.processor.task.model.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskRepository {

    Map<Long, Task> map = new HashMap<>() {{
        put(1L, new Task(1L, Status.DONE,100,"ABCD"));
        put(2L, new Task(2L, Status.NOT_DONE,55,"ABCDEFG"));
        put(3L, new Task(3L, Status.NOT_DONE,33,"ABCABC"));
    }};




}
