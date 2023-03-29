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

public class CrudUI implements ActionListener{
	JFrame frame;
	JButton createProject = new JButton("Create"), retrieveProject = new JButton("Retrieve"), exit = new JButton("Exit");
	JLabel label = new JLabel("Do you wish to create a new project or to retrieve an already existing one?");
	
	public CrudUI() {
		this.frame = new JFrame();
		frame.setSize(500, 100);

		JPanel pane1 = new JPanel(new GridBagLayout());
		
		GridBagConstraints const1 = new GridBagConstraints();
		const1.gridx = 0;
		const1.gridy = 0;
		const1.fill = GridBagConstraints.HORIZONTAL;
		pane1.add(label, const1);
		
		JPanel subPane1 = new JPanel(new FlowLayout());
		subPane1.add(createProject);
		subPane1.add(retrieveProject);
		subPane1.add(exit);
		GridBagConstraints const2 = new GridBagConstraints();
		const2.gridx = 0;
		const2.gridy = 1;
	    const2.fill = GridBagConstraints.HORIZONTAL;
	    pane1.add(subPane1, const2);
	    
	    createProject.addActionListener(this);
	    retrieveProject.addActionListener(this);

	    
	    frame.add(pane1);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void abortSystem() {
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==createProject) {
			new ProjectCreationUI();
		} else if(e.getSource()==retrieveProject) {
			new ProjectRetrievalUI();
		} else if(e.getSource()==exit) {
			abortSystem();
		} 
	}
}
