package io.github.matrix.gradle;

import io.spring.gradle.dependencymanagement.DependencyManagementPlugin;
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.PluginContainer;
import org.springframework.boot.gradle.plugin.SpringBootPlugin;
import org.springframework.boot.gradle.util.VersionExtractor;

/**
 * @author yubinbin
 * @since 2021/04/24
 */
public class MatrixBootPlugin implements Plugin<Project> {

    static final String MATRIX_VERSION = VersionExtractor.forClass(MatrixBootPlugin.class);

    static final String BOM_COORDINATES = "io.github.matrix:matrix-dependencies:" + MATRIX_VERSION;

    @Override
    public void apply(Project project) {
        PluginContainer plugins = project.getPlugins();
        plugins.apply(DependencyManagementPlugin.class);
        plugins.apply(SpringBootPlugin.class);
        project.getExtensions().findByType(DependencyManagementExtension.class)
                .imports((importsHandler) -> importsHandler.mavenBom(MatrixBootPlugin.BOM_COORDINATES));
    }

}
