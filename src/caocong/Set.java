package caocong;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class Set extends JFrame{
	 private JButton shezhi ;
	 private JComboBox<String> cb1; 
	 private JComboBox<String> cb2; 
    public Set(){
        Init();
    }
  public void Init()
  {
	  setTitle("停车管理系统设置界面");
      shezhi = new JButton("设置");
      shezhi.setSize(60, 25);
      shezhi.setLocation(135, 260);
      cb1 = new JComboBox<String>(); 
      cb1.addItem("无"); 
	  cb1.addItem("半个小时免费"); 
	  cb1.addItem("一小时3元"); 
	  cb1.setBounds(150,300, 150, 50);
	  
	  cb2= new JComboBox<String>();
	  cb2.addItem("无"); 
	  cb2.addItem("半个小时免费"); 
	  cb2.addItem("一小时3元"); 
	  cb2.setBounds(300,300, 150, 50);
      this.add(shezhi);
      this.add(cb1);
      this.add(cb2);
      this.setLocation(1000,500);    
      this.setLayout(null);
      this.setSize(500, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      
  }
  public void actionPerformed(ActionEvent e) {
  
}
}