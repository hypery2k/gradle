package cz.jiradesign.gradle.api.plugins.aspectj

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPlugin
import org.gradle.plugins.ide.eclipse.GenerateEclipseProject
import org.gradle.plugins.ide.eclipse.EclipsePlugin

/**
 * The AspectJ plugin extends the Java plugin to add support for aspectj to gradle build system.
 *
 * @author Jiri Mares (jiramares@gmail.com) 
 */ 
class AspectjPlugin implements Plugin<Project> {
    
    public void apply(Project project) {
       project.plugins.apply(JavaPlugin)
       project.plugins.apply(AspectjBasePlugin)
       project.plugins.whenPluginAdded { plugin -> 
          if (plugin.class == EclipsePlugin) 
             project.plugins.apply(AspectjEclipsePlugin)
       }
    }

}