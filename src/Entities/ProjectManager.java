package Entities;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
	private List<Project> projects = new ArrayList();
	
	public ProjectManager(){
	}
	
	public void addProject(Project project) {
		this.projects.add(project);
	}
}
