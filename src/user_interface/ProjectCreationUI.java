package user_interface;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Entities.Project;

public class ProjectCreationUI extends JFrame implements ActionListener {
	JFrame frame;
	JLabel projName = new JLabel("Project name: "), projDescription = new JLabel("Project description: ");
	JTextField projNameInput = new JTextField("", 10), projDescriptionInput = new JTextField("", 20);
	JButton cria = new JButton("Create"), limpa = new JButton("Clean"), sai = new JButton("Exit");

	public ProjectCreationUI() {
		this.frame = new JFrame("New Project");
		frame.setSize(400, 150);

		JPanel pane = new JPanel(new GridBagLayout());
		JPanel subPane1 = new JPanel(new FlowLayout());
		JPanel subPane2 = new JPanel(new FlowLayout());
		JPanel subPane3 = new JPanel(new FlowLayout());
		
		subPane1.add(projName);
		subPane1.add(projNameInput);
		subPane2.add(projDescription);
		subPane2.add(projDescriptionInput);
		subPane3.add(cria);
		subPane3.add(limpa);
		subPane3.add(sai);
		
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
		
		cria.addActionListener(this);
		limpa.addActionListener(this);
		sai.addActionListener(this);
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pane);
		frame.setVisible(true);
	}
	
	public void cleanFields() {
		projNameInput.setText(null);
		projDescriptionInput.setText(null);
	}
	
	public void abortSystem() {
		dispose(); 
		System.exit(0);
	}
	
	public void createProject() {
		String name = projNameInput.getText();
		String description = projDescriptionInput.getText();
		new TaskCreationUI(new Project(name, description));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cria) {
			createProject();
		}
		else if(e.getSource()==limpa) {
		cleanFields();
	} 
		else if(e.getSource()==sai) {
			abortSystem();
		}
	}
}
