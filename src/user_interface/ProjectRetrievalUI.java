package user_interface;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ProjectRetrievalUI  extends JFrame implements ActionListener {
	JFrame frame;

	
	JLabel description = new JLabel("Search for already existing project by name.");
	JTextField searchTool = new JTextField();
	JButton searchButton = new JButton("Search"), exit = new JButton("Exit");
	
	ProjectRetrievalUI(){
		this.frame = new JFrame();
		frame.setSize(350, 150);

		JPanel pane = new JPanel(new GridBagLayout());
		
		JPanel subPane = new JPanel(new FlowLayout());
		subPane.add(searchButton);
		subPane.add(exit);
		
		GridBagConstraints const1 = new GridBagConstraints();
		const1.gridx = 0;
		const1.gridy = 0;
	    const1.fill = GridBagConstraints.HORIZONTAL;
	    pane.add(description, const1);
	    
	    GridBagConstraints const2 = new GridBagConstraints();
		const2.gridx = 0;
		const2.gridy = 1;
	    const2.fill = GridBagConstraints.HORIZONTAL;
	    pane.add(searchTool, const2);
	    
	    GridBagConstraints const3 = new GridBagConstraints();
		const2.gridx = 0;
		const2.gridy = 2;
	    const2.fill = GridBagConstraints.HORIZONTAL;
	    pane.add(subPane, const2);
	    
	    
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pane);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
