package caocong;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
public class Zhuce extends JFrame implements ActionListener {
	  private JLabel userLa;
	    private	JButton about;
	    private JLabel pwdLa;
	    private JLabel verCodeLa;//验证码
	    private JTextField userTxt;
	    private JPasswordField pwdTxt;
	    private JTextField verCodeTxt;//验证码
	    private JButton sureBt;
	    private JButton quitBt;
	    private Mypanel mp;
	    public Zhuce(){
	        Init();
	    }
	    public void Init(){
	    	setTitle("欢迎来到注册界面");
	        //设置标题 

	        //用户文本
	        userLa = new JLabel();
	        userLa.setText("用户名：");
	        userLa.setSize(60, 50);
	        userLa.setLocation(100, 80);
	 
	        //密码文本
	        pwdLa = new JLabel();
	        pwdLa.setText("密码：");
	        pwdLa.setSize(50, 50);
	        pwdLa.setLocation(100, 120);

	        //用户输入框
	        userTxt = new JTextField();
	        userTxt.setSize(100, 20);
	        //this.setSize(width, height)
	        userTxt.setLocation(170, 95);

	        //密码输入框
	        pwdTxt = new JPasswordField();
	        pwdTxt.setSize(100, 20);
	        pwdTxt.setLocation(170, 135);

	        //确认按钮
	        sureBt = new JButton("提交");
	        sureBt.setSize(60, 25);
	        sureBt.setLocation(135, 260);

	        //退出按钮
	        quitBt = new JButton("退出");
	        quitBt.setSize(60, 25);
	        quitBt.setLocation(240, 260);
	       
	     
	        
	        //关于按钮
	        about = new JButton("关于");
	        about.setSize(60,25);
	        about.setLocation(135,300);
	        
	        //验证码文本
	        verCodeLa = new JLabel();
	        verCodeLa.setText("验证码：");
	        verCodeLa.setSize(60, 50);
	        verCodeLa.setLocation(100,165);

	        //验证码文本框
	        verCodeTxt = new JTextField();
	        verCodeTxt.setSize(100, 20);
	        verCodeTxt.setLocation(170, 180);

	        //验证码
	        mp = new Mypanel();
	        mp.setSize(100, 30);
	        mp.setLocation(280, 175);




	        this.setLocation(1000,500);    
	        this.setLayout(null);
	        this.setSize(500, 400);
	        this.add(userLa);
	        this.add(pwdLa);
	        this.add(userTxt);
	        this.add(pwdTxt);
	        this.add(sureBt);
	        this.add(quitBt);
	        this.add(about);
	        this.add(verCodeLa);
	        this.add(verCodeTxt);
	        this.add(mp);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        sureBt.addActionListener(this);
	        quitBt.addActionListener(this);
	        about.addActionListener(this);
	        this.setVisible(true);
	        
	    }
	    
	    public void actionPerformed(ActionEvent e){
	         //获取产生事件的事件源强制转换
	         JButton bt = (JButton)e.getSource();
	         //获取按钮上显示的文本
	         String str = bt.getText();
	        if(str.equals("提交")){
	             if(!CheckIsNull()){
	                 //获取用户所输入的用户名
	                 String user = userTxt.getText().trim();//trim是去掉开头和结尾的空格
	                 //获取用户所输入的密码
	                 String pwd = pwdTxt.getText().trim();
	                 Jdbc q =new Jdbc();
	                 try {
						q.init();
						q.addUser(pwd, user);
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                 
					}
	             }
	         
	        
	        
	         if(str.equals("关于")){
	        	  /*JDialog dialogabout = new JDialog(this,true);
	        	  dialogabout.setTitle("关于");*/
	        	 JOptionPane.showMessageDialog(null, "我们是来自软件1602,停车管理系统-课程设计.", "关于",JOptionPane.PLAIN_MESSAGE);
	         }
	         
	        
	         
	         if(str.equals("退出")) {
	             //调用系统类中的一个正常退出
	             System.exit(0);
	         }
	     }
	     
	     //判断是否为空
	     private boolean CheckIsNull() {
	         boolean flag = false;
	         if(userTxt.getText().trim().equals(" ")){
	             flag = true;
	         }
	         else{
	             if(pwdTxt.getText().trim().equals(" ")){
	                 flag = true;
	             }
	         }
	         return flag;
	     }
	     
	    
}
