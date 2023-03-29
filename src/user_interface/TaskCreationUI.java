package user_interface;
import java.awt.FlowLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

import Entities.Person;
import Entities.Project;
import Entities.Task;

public class TaskCreationUI implements ActionListener {
	Project project1;
	JFrame frame;
	JLabel taskName = new JLabel("Task name: "), taskDescription = new JLabel("Task description: "), taskDueDate = new JLabel("Due: "), taskEstimatedHours = new JLabel("Estimated hours: "), taskAssignee = new JLabel("Text assignee: ");
	JTextField taskNameInput = new JTextField(15), taskDescriptionInput = new JTextField(20), taskDueDateDayInput = new JTextField(4), taskDueDateMonthInput = new JTextField(4), taskDueDateYearInput = new JTextField(4), taskEstimatedHoursInput = new JTextField(5), taskAssigneeInput = new JTextField(15);
	JButton addNext = new JButton("Add/Next"), addFinish = new JButton("Add/Finish"), clean = new JButton("Clean"), exit = new JButton("Exit");
	
	public TaskCreationUI(Project project) {
		this.project1 = project;
		
		this.frame = new JFrame("New Task");

		JPanel pane = new JPanel(new GridBagLayout());
		
		JPanel subPane1 = new JPanel(new FlowLayout());
		JPanel subPane2 = new JPanel(new FlowLayout());
		JPanel subPane3 = new JPanel(new FlowLayout());
		JPanel subPane4 = new JPanel(new FlowLayout());
		JPanel subPane5 = new JPanel(new FlowLayout());
		JPanel subPane6 = new JPanel(new FlowLayout());
		
		subPane1.add(taskName);
		subPane1.add(taskNameInput);
		subPane2.add(taskDescription);
		subPane2.add(taskDescriptionInput);
		subPane3.add(taskDueDate);
		subPane3.add(taskDueDateDayInput);
		subPane3.add(taskDueDateMonthInput);
		subPane3.add(taskDueDateYearInput);
		subPane4.add(taskEstimatedHours);
		subPane4.add(taskEstimatedHoursInput);
		subPane5.add(taskAssignee);
		subPane5.add(taskAssigneeInput);
		subPane6.add(addNext);
		subPane6.add(addFinish);
		subPane6.add(clean);
		subPane6.add(exit);

		GridBagConstraints const1 = new GridBagConstraints();
		const1.gridx = 0;
		const1.gridy = 0;
	    const1.fill = GridBagConstraints.HORIZONTAL;
		pane.add(subPane1, const1);
		
		GridBagConstraints const2 = new GridBagConstraints();
		const2.gridx = 0;
		const2.gridy = 1;
	    const2.fill = GridBagConstraints.HORIZONTAL;
		pane.add(subPane2, const2);
		
		GridBagConstraints const3 = new GridBagConstraints();
		const3.gridx = 0;
		const3.gridy = 2;
	    const3.fill = GridBagConstraints.HORIZONTAL;
		pane.add(subPane3, const3);
		
		GridBagConstraints const4 = new GridBagConstraints();
		const4.gridx = 0;
		const4.gridy = 3;
	    const4.fill = GridBagConstraints.HORIZONTAL;
		pane.add(subPane4, const4);
		
		GridBagConstraints const5 = new GridBagConstraints();
		const5.gridx = 0;
		const5.gridy = 4;
	    const5.fill = GridBagConstraints.HORIZONTAL;
		pane.add(subPane5, const5);
		
		GridBagConstraints const6 = new GridBagConstraints();
		const6.gridx = 0;
		const6.gridy = 5;
	    const6.fill = GridBagConstraints.HORIZONTAL;
		pane.add(subPane6, const6);
		
		addNext.addActionListener(this);
		addFinish.addActionListener(this);
		clean.addActionListener(this);
		exit.addActionListener(this);
		
		
		frame.add(pane);
		frame.setSize(400, 300);
		frame.setVisible(true);
		
		}
	
	public void cleanFields() {
		taskNameInput.setText(null);
		taskDescriptionInput.setText(null);
		taskDueDateDayInput.setText(null);
		taskDueDateMonthInput.setText(null);
		taskDueDateYearInput.setText(null);
		taskEstimatedHoursInput.setText(null);
		taskAssigneeInput.setText(null);
	}
	
	public void abortSystem() {
		System.exit(0);
	}
	
	public void createTask() {		
		String name = taskNameInput.getText();
		String description = taskDescriptionInput.getText();
		int dueDateDay = Integer.parseInt(taskDueDateDayInput.getText());
		int dueDateMonth = Integer.parseInt(taskDueDateMonthInput.getText());
		int dueDateYear = Integer.parseInt(taskDueDateYearInput.getText());
		String taskAssignee = taskAssigneeInput.getText();
		int estimatedHours = Integer.parseInt(taskEstimatedHoursInput.getText());
		
		LocalDate myDate = LocalDate.of(dueDateYear, dueDateMonth, dueDateDay);
		project1.addTask(new Task(name, description, myDate, new Person(taskAssignee), estimatedHours));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addNext) {
			createTask();
			cleanFields();
		} else if(e.getSource()==addFinish) {
			createTask();
			new ProjectExhibitionUI(project1);
	} else if(e.getSource()==clean) {
		cleanFields();
	} else if(e.getSource()==exit) {
		abortSystem();
	}
	}
}
