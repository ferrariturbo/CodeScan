package com.andy.gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class TabbedPaneFrame extends JFrame {
	
	private JTabbedPane tabbedPane;

    private int count = 0;

 

    public TabbedPaneFrame() {

 

       // 添加选项卡

       tabbedPane = new JTabbedPane();

       tabbedPane.addTab("Mercury", null);

       tabbedPane.addTab("Venus", null);

       tabbedPane.addTab("Earth", null);

       tabbedPane.addTab("Mars", null);

       tabbedPane.addTab("Jupiter", null);

       tabbedPane.addTab("Saturn", null);

       tabbedPane.addTab("Uranus", null);

       tabbedPane.addTab("Neptune", null);

       tabbedPane.addTab("Pluto", null);

       // 添加选项卡面板

       add(tabbedPane, "Center");
       
       
       
       //TabbedPaneFrame.add(null);
       // 添加监听器

       tabbedPane.addChangeListener(new ChangeListener() {

 

           @Override

           public void stateChanged(ChangeEvent e) {

              // TODO Auto-generated method stub

              int n = tabbedPane.getSelectedIndex();

              loadTab(n);

           }

       });

       loadTab(0);

       //添加单选按钮，用于调节选项卡的布局方式
      
       JPanel buttonPanel = new JPanel();
       JLabel label = new JLabel("标签");//实例化一个JLabel对象  
       JButton okButton = new JButton("OK");//实例化一个按钮对象  
       JTextField text = new JTextField(4);//实例化一个显示4个字节的文本框  
       JCheckBox checkbox = new JCheckBox("复选框");//实例化一个复选框  
       //将这些组件添加到窗体上  
       okButton.setActionCommand("OK");
       okButton.addActionListener(new ButtonClickListener()); 
       
       buttonPanel.add(okButton);
       buttonPanel.add(label);
       ButtonGroup buttonGroup = new ButtonGroup();

       JRadioButton wrapButton = new JRadioButton("Wrap tabs");

       wrapButton.setSelected(true);

       wrapButton.addActionListener(new ActionListener() {

 

           @Override

           public void actionPerformed(ActionEvent arg0) {

              // TODO Auto-generated method stub

              tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

           }

       });

       buttonGroup.add(wrapButton);

       buttonPanel.add(wrapButton);

 

       JRadioButton scroButton = new JRadioButton("Scroll tabs");

       scroButton.addActionListener(new ActionListener() {

 

           @Override

           public void actionPerformed(ActionEvent arg0) {

              // TODO Auto-generated method stub

       tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

           }

       });

       buttonGroup.add(scroButton);

       buttonPanel.add(scroButton);

 

       add(buttonPanel, BorderLayout.SOUTH);

    }

    private void loadTab(int n) {

       String title = tabbedPane.getTitleAt(n);

       String countString = String.valueOf(count ++);

       String msg = "this is " + title + ", load at " + countString + " times";

       tabbedPane.setComponentAt(n, new JLabel(msg));

    }
    
    
	static public void add(JFrame jf){  
        JLabel label = new JLabel("标签");//实例化一个JLabel对象  
        JButton button = new JButton("按钮");//实例化一个按钮对象  
        JTextField text = new JTextField(4);//实例化一个显示4个字节的文本框  
        JCheckBox checkbox = new JCheckBox("复选框");//实例化一个复选框  
        //将这些组件添加到窗体上  
        jf.add(label);  
        jf.add(button);  
        jf.add(text);  
        jf.add(checkbox);  
      //  return jf;
    }  
	
	public static void addlayout(JFrame jf){  
        FlowLayout flow = new FlowLayout();  
        jf.setLayout(flow);  
    }  
    
    
    
}
