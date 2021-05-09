package io.github.matrix.workflow.controller;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bing D. Yee
 * @since 2021/05/04
 */
@RestController
@RequestMapping("/v1/workflow")
public class WorkflowController {

    private final ProcessRuntime processRuntime;

    private final TaskService taskService;

    public WorkflowController(ProcessRuntime processRuntime, TaskService taskService) {
        this.processRuntime = processRuntime;
        this.taskService = taskService;
    }

    @GetMapping("/list")
    public Page<ProcessDefinition> listProcess() {
        return processRuntime.processDefinitions(Pageable.of(0, 10));
    }

    /**
     * 启动流程
     *
     * @param key 流程Key
     * @return
     */
    @PostMapping("/deploy/{key}")
    public ProcessInstance startProcess(@PathVariable String key) {
        return  processRuntime.start(ProcessPayloadBuilder.start()
                .withProcessDefinitionKey(key)
                .build()
        );
    }

    @GetMapping("/task/{key}")
    public List<Task> queryTask(@PathVariable String key, @RequestParam String group) {
        return taskService.createTaskQuery()
                .processDefinitionKey(key)
                .taskAssignee(group)
                .list();
    }

    @PutMapping("/task/complete")
    public void completeTask(@RequestParam String taskId) {
        taskService.complete(taskId);
    }

}
