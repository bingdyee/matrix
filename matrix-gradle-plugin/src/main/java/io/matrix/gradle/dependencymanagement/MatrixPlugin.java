package io.matrix.gradle.dependencymanagement;

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin;
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.springframework.boot.gradle.plugin.SpringBootPlugin;
import org.springframework.boot.gradle.util.VersionExtractor;


/**
 * @author Noa Swartz
 * @date 2020/09/25
 */
public class MatrixPlugin implements Plugin<Project> {

    static final String BOM_COORDINATES = "io.matrix:matrix-parent:";

    @Override
    public void apply(final Project project) {
        project.getPlugins().apply(DependencyManagementPlugin.class);
        project.getPlugins().apply(SpringBootPlugin.class);
        String version = VersionExtractor.forClass(MatrixPlugin.class);
        project.getExtensions().findByType(DependencyManagementExtension.class)
                .imports((importsHandler) -> importsHandler.mavenBom(MatrixPlugin.BOM_COORDINATES + version));
    }

}
