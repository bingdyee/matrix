package io.matrix.gradle.dependencymanagement

import org.gradle.api.Plugin
import org.gradle.api.Project
import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import org.springframework.boot.gradle.plugin.SpringBootPlugin

/**
 *
 * @author Noa Swartz
 * @date 2020/09/05
 */
class MatrixPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        SpringBootPlugin().apply(project)
        DependencyManagementPlugin().apply(project)
    }

}