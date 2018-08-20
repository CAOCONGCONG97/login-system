package caocong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SetParkUi extends JFrame  implements ActionListener{
    private JButton carinto ;
    private	JButton about;
    private	JButton info;
    private	JButton set;
    public SetParkUi(){
        Init();
    }
  public void Init()
  {
	  setTitle("停车管理系统界面");
	  //车辆进入按钮
	  carinto = new JButton("车辆进入");
	  carinto.setSize(250,50);
	  carinto.setLocation(125, 30);
	  
	  //管理
      set = new JButton("车场管理");
      set.setSize(250,50);
      set.setLocation(125, 100);
	  
      info = new JButton("信息查询");
      info.setSize(250,50);
      info.setLocation(125, 170);
	  
      about= new JButton("关于");
      about.setSize(250,50);
      about.setLocation(125, 240);
      
      this.add(carinto);
      this.add(about);
      this.add(info);
      this.add(set);
      
      this.setLocation(1000,500);    
      this.setLayout(null);
      this.setSize(500, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      about.addActionListener(this);
      this.setVisible(true);
      
  }
@Override
public void actionPerformed(ActionEvent e) {
    JButton bt = (JButton)e.getSource();
    //获取按钮上显示的文本
    String str = bt.getText();
	// TODO Auto-generated method stub
    if(str.equals("关于")){
    	
  	  /*JDialog dialogabout = new JDialog(this,true);
  	  dialogabout.setTitle("关于");*/
  	 JOptionPane.showMessageDialog(null, "我们是来自软件1602,停车管理系统-课程设计.", "关于",JOptionPane.PLAIN_MESSAGE);
   }
    if(str.equals("车辆进入")){
    	//
    }
}
}
