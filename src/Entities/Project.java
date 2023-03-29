package Entities;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String projectName;
	private String projectDescription;
	private List<Task> tasks = new ArrayList();
	
	public Project(String projectName, String projectDescription) {
		this.projectName = projectName;
		this.projectDescription = projectDescription;
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}

	public List<Task> getTasks() {
		return tasks;
	}

	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", projectDescription=" + projectDescription
				+ "]";
	}
	
	
}
