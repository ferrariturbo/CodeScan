package com.andy.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.andy.bean.Product;
import com.andy.main.DemoMain;
public class DemoGui {
	private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JLabel idLabel;
	   private JLabel nameLabel;
	   private JLabel barCoderLabel;
	   private JPanel controlPanel;
	   public DemoGui(){
		   prepareGUI();
	   }
	   
	   public static void main(String[] args){
		   DemoGui swingLayoutDemo = new DemoGui();  
		      swingLayoutDemo.showEventDemo();       
		   }
		      
		   private void prepareGUI(){
		      mainFrame = new JFrame("Java SWING Examples");
		      mainFrame.setSize(500,500);
		      mainFrame.setLayout(new GridLayout(6, 1));
		      headerLabel = new JLabel("",JLabel.CENTER );
		      statusLabel = new JLabel("",JLabel.CENTER);        
		      idLabel = new JLabel("",JLabel.CENTER); 
		      nameLabel = new JLabel("",JLabel.CENTER); 
		      barCoderLabel = new JLabel("",JLabel.CENTER); 
		      
		      idLabel.setSize(1,5);
		      nameLabel.setSize(1,5);
		      barCoderLabel.setSize(1,5);
		      
		      mainFrame.addWindowListener(new WindowAdapter() {
		         public void windowClosing(WindowEvent windowEvent){
			        System.exit(0);
		         }        
		      });    
		      controlPanel = new JPanel();
		      controlPanel.setLayout(new FlowLayout());

		      mainFrame.add(headerLabel);
		      mainFrame.add(controlPanel);
		      //mainFrame.add(statusLabel);
		      mainFrame.add(idLabel);
		      mainFrame.add(nameLabel);
		      mainFrame.add(barCoderLabel);
		      mainFrame.setVisible(true);  
		   }

		   private void showEventDemo(){
		      headerLabel.setText("Control in action: Button"); 

		      JButton okButton = new JButton("OK");
		      JButton submitButton = new JButton("Submit");
		      JButton cancelButton = new JButton("Cancel");

		      okButton.setActionCommand("OK");
		      submitButton.setActionCommand("Submit");
		      cancelButton.setActionCommand("Cancel");

		      okButton.addActionListener(new ButtonClickListener()); 
		      submitButton.addActionListener(new ButtonClickListener()); 
		      cancelButton.addActionListener(new ButtonClickListener()); 

		      controlPanel.add(okButton);
		      controlPanel.add(submitButton);
		      controlPanel.add(cancelButton);       

		      mainFrame.setVisible(true);  
		   }

		   private class ButtonClickListener implements ActionListener{
		      public void actionPerformed(ActionEvent e) {
		         String command = e.getActionCommand();  
		         if( command.equals( "OK" ))  {
		            statusLabel.setText("Ok Button clicked.");
		            DemoMain dm = new DemoMain();
		            Product product = dm.runScan();
		            idLabel.setText(product.getId());
		            nameLabel.setText(product.getName());
		            barCoderLabel.setText(product.getBarCode());
		           
		         }
		         else if( command.equals( "Submit" ) )  {
		            statusLabel.setText("Submit Button clicked."); 
		         }
		         else  {
		            statusLabel.setText("Cancel Button clicked.");
		         }  	
		      }		
		   }
	   
}
