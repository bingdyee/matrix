package io.matrix.gradle.dependencymanagement

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import io.spring.gradle.dependencymanagement.DependencyManagementPlugin

/**
 *
 * @author Noa Swartz
 * @date 2020/09/25
 */
class MatrixPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        new SpringBootPlugin().apply(project)
        new DependencyManagementPlugin().apply(project)
    }

}
