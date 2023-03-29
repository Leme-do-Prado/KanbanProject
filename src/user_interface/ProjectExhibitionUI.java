package user_interface;

import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entities.Project;
import Entities.Task;

public class ProjectExhibitionUI implements ActionListener{
	Project project2;
	
	JFrame frame;
	
	JLabel projectInfo = new JLabel(), taskInfo = new JLabel();
	JButton updateState = new JButton("Update Task status"), exit = new JButton();

	public ProjectExhibitionUI(Project project2) {
		
		this.project2 = project2;

		this.frame = new JFrame();
		
		JPanel pane = new JPanel(new GridBagLayout());
		
		JPanel subpane1 = new JPanel();
		projectInfo.setText(project2.toString());
		subpane1.add(projectInfo);
		pane.add(subpane1);
		
		JPanel subpane2 = new JPanel();
		
		GridBagConstraints c = new GridBagConstraints ();
		c.weightx = 0.0;
        c.weighty = 1.0;
        
        c.fill = GridBagConstraints.VERTICAL;
		
		for(Task t : project2.getTasks()) {
			subpane2.add(new JLabel("[------------------]"));
			subpane2.add(new JLabel(t.toString()));
			subpane2.add(updateState);
			subpane2.add(new JLabel("[------------------]"));
		}
		subpane2.add(exit);
		
		pane.add(subpane2, c);
		frame.add(pane);
		frame.setSize(400, 500);
		frame.setVisible(true);
		
	}
	
	public void abortSystem() {
		System.exit(0);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit) {
			abortSystem();
		} else if (e.getSource()==updateState) {
			
		}
	}
}
