package io.matrix.gradle.dependencymanagement;

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin;
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.springframework.boot.gradle.plugin.SpringBootPlugin;

/**
 * @author Noa Swartz
 * @date 2020/09/25
 */
public class MatrixPlugin implements Plugin<Project> {

    static final String BOM_COORDINATES = "io.matrix:matrix-parent:1.0.0-SNAPSHOT";

    @Override
    public void apply(final Project project) {
        new DependencyManagementPlugin().apply(project);
        new SpringBootPlugin().apply(project);
        project.getExtensions().findByType(DependencyManagementExtension.class)
                .imports((importsHandler) -> importsHandler.mavenBom(MatrixPlugin.BOM_COORDINATES));
    }

}
