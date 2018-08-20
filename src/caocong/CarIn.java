package caocong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CarIn extends JFrame  implements ActionListener{
    private JLabel chepai ;
    private	JLabel leixing;
    private JTextField chepaihao;
    private JTextField leixinghao;
    private JComboBox<String> cb1; 
    public CarIn(){
        Init();
    }
  public void Init()
  {
	  setTitle("车辆进入");
	  cb1 = new JComboBox<String>(); 
	  cb1.addItem("无VIP卡"); 
	  cb1.addItem("有VIP卡"); 
	  cb1.setBounds(250,300, 150, 50); 
	  
	  chepai = new JLabel();
	  chepai.setText("车牌号码：");
	  chepai.setSize(100, 50);
	  chepai.setLocation(150, 50);
	  
	  leixing = new JLabel();
	  leixing.setText("车辆类型：");
	  leixing.setSize(150, 100);
	  leixing.setLocation(150, 100);
	  
	//车牌输入框
	  chepaihao = new JTextField();
	  chepaihao.setSize(100, 20);
	  chepaihao.setLocation(200, 50);
	 
	  leixinghao= new JTextField();
	  leixinghao.setSize(100, 20);
	  leixinghao.setLocation(350, 150);
	  
	  this.add(cb1);
	  this.add(chepai);
	  this.add(leixing);
	  this.add(chepaihao);
	  this.add(leixinghao);
      this.setLocation(1000,500);    
      this.setLayout(null);
      this.setSize(500, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setVisible(true);
      
  }
@Override
public void actionPerformed(ActionEvent e) {
  
}
}
