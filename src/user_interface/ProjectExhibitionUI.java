package user_interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entities.Project;
import Entities.Task;

public class ProjectExhibitionUI implements ActionListener {
	Project project2;

	JFrame frame;

	JLabel projectInfo = new JLabel(), taskInfo = new JLabel();
	JButton updateState = new JButton("Update Task status"), exit = new JButton();

	public ProjectExhibitionUI(Project project2) {

		this.project2 = project2;

		this.frame = new JFrame();

		JPanel pane = new JPanel(new GridBagLayout());
	    
	    JPanel subPane = new JPanel();
	    subPane.setLayout(new BoxLayout(subPane, BoxLayout.PAGE_AXIS));
	    
	    subPane.add(new JLabel("PROJECT"));
	    subPane.add(new JLabel(""));
	    subPane.add(new JLabel(">" + this.project2.getProjectName() + "<"));
	    subPane.add(new JLabel(this.project2.getProjectDescription()));
	    subPane.add(new JLabel(""));
	    subPane.add(new JLabel("--------------------------"));
	    
	    GridBagConstraints const1 = new GridBagConstraints();
		const1.gridx = 0;
		const1.gridy = 0;
	    const1.fill = GridBagConstraints.HORIZONTAL;
	    pane.add(subPane, const1);
	    
	    JPanel subPane2 = new JPanel();
	    subPane2.setLayout(new BoxLayout(subPane2, BoxLayout.PAGE_AXIS));
	    
	    GridBagConstraints const2 = new GridBagConstraints();
		const2.gridx = 0;
		const2.gridy = 1;
	    const2.fill = GridBagConstraints.HORIZONTAL;

	    for(Task t : project2.getTasks()) {
	    	int i=1;
	    	subPane2.add(new JLabel(i + ". Task name: " + t.getTaskName()));
	    	subPane2.add(new JLabel("Task description: " + t.getTaskDescription()));
	    	subPane2.add(new JLabel("Due date: " + t.getDueDate()));
	    	i++;
	    	subPane2.add(new JLabel("--------------------------"));
	    }
	    
	    pane.add(subPane2, const2);
	    
		frame.add(pane);
		frame.setSize(400, 500);
		frame.setVisible(true);

	}

	public void abortSystem() {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			abortSystem();
		} else if (e.getSource() == updateState) {
			
		}
	}
}
