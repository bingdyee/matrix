package io.github.matrix.workflow;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Bing D. Yee
 * @since 2021/05/04
 */
@SpringBootTest
public class WorkflowApplicationTest {

    @Autowired
    private ProcessRuntime processRuntime;

    @Test
    public void list() {
        List<ProcessDefinition> definitions = processRuntime.processDefinitions(Pageable.of(0, 10)).getContent();
        definitions.forEach(System.err::println);
    }

}
