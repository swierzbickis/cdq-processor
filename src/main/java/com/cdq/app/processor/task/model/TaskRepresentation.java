package com.cdq.app.processor.task.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TaskRepresentation {

    private final Integer diffIndex;
    private final Integer typoCount;

}
