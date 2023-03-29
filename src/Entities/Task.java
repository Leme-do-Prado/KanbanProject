package Entities;
import java.time.LocalDate;
import java.util.Date;

import descriptive.State;

public class Task {
	private String taskName;
	private String taskDescription;
	private State state;
	private LocalDate dueDate;
	private int estimatedHours;
	private Person taskAssignee;
	
	public Task(String taskName, String taskDescription, LocalDate dueDate, Person taskAssignee, int estimatedHours) {
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.dueDate = dueDate;
		this.estimatedHours = estimatedHours;
		this.taskAssignee = taskAssignee;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public int getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(int estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public Person getTaskAssignee() {
		return taskAssignee;
	}

	public void setTaskAssignee(Person taskAssignee) {
		this.taskAssignee = taskAssignee;
	}

	public float estimateWorkDays() {
		return estimatedHours / taskAssignee.getShift();
	}
	
	public boolean isOverdue() {
		
		LocalDate today = LocalDate.now();
		
		if(today.isAfter(dueDate)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Task " + taskName
				+ "/n" + taskDescription
				+ "/n/n Assignee: " + taskAssignee.getName()
				+ "/n Estimated Worktime: " + estimateWorkDays() + " days"
				+ "/n Due " + dueDate;
	}
}
