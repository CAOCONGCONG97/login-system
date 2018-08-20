package caocong;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class Info extends JFrame{
	 private JButton chaxun ;
	 private JTextField xianshi;
    public Info(){
        Init();
    }
  public void Init()
  {
	  setTitle("停车管理系统查询界面");
      chaxun = new JButton("查询");
      chaxun.setSize(60, 25);
      chaxun.setLocation(135, 260);
      xianshi = new JTextField();
      xianshi.setSize(100, 20);
      xianshi.setLocation(170, 95);
      this.add(chaxun);
      this.add(xianshi);
      this.setLocation(1000,500);    
      this.setLayout(null);
      this.setSize(500, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      
  }
  public void actionPerformed(ActionEvent e) {
  
}
}