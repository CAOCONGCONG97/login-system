package caocong;
import java.awt.*;
import java.sql.SQLException;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
    private JLabel userLa;
    private JButton zhuce ;
    private	JButton about;
    private JLabel pwdLa;
    private JLabel verCodeLa;//验证码
    private JTextField userTxt;
    private JPasswordField pwdTxt;
    private JTextField verCodeTxt;//验证码
    private JButton sureBt;
    private JButton quitBt;
    private Mypanel mp;
    private JLabel j1;
    //构造方法
    public GUI(){
        Init();
    }
    public void Init(){
    	setTitle("停车管理系统登录界面");
    	this.setIconImage(new ImageIcon("1.jpg").getImage());//设置图标
    	//背景音乐
    	Music a =new Music();
        //设置标题 
    	j1 = new JLabel(); 
    	 Image img1 = new ImageIcon("2.jpg").getImage(); 
    	 j1.setIcon(new ImageIcon(img1)); 
    	 j1.setBounds(0, 0, 500, 350); 
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
        sureBt = new JButton("登录");
        sureBt.setSize(60, 25);
        sureBt.setLocation(135, 260);

        //退出按钮
        quitBt = new JButton("退出");
        quitBt.setSize(60, 25);
        quitBt.setLocation(240, 260);
       
        //注册按钮
        zhuce = new JButton("注册");
        zhuce.setSize(60, 25);
        zhuce.setLocation(240, 300);
        
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
        this.add(zhuce);
        this.add(about);
        this.add(verCodeLa);
        this.add(verCodeTxt);
        this.add(mp);
        this.add(j1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sureBt.addActionListener(this);
        quitBt.addActionListener(this);
        about.addActionListener(this);
        zhuce.addActionListener(this);
        this.setVisible(true);
        
    }
    
    
    
    //具体事件的处理
     public void actionPerformed(ActionEvent e){
         //获取产生事件的事件源强制转换
         JButton bt = (JButton)e.getSource();
         //获取按钮上显示的文本
         String str = bt.getText();
        if(str.equals("登录")){
             if(!CheckIsNull()){
                 //获取用户所输入的用户名
                 String user = userTxt.getText().trim();//trim是去掉开头和结尾的空格
                 //获取用户所输入的密码
                 String pwd = pwdTxt.getText().trim();
                 try {
					if(checkUserAndPwd(user,pwd)){

					     //隐藏当前登录窗口
					     this.setVisible(false);
					     //验证成功创建一个主窗口
					    SetParkUi frame = new SetParkUi();
					   
					 }
					 else{
					     //如果错误则弹出一个显示框
					     JOptionPane pane = new JOptionPane("用户或密码错误");
					     JDialog dialog  = pane.createDialog(this,"警告");
					     dialog.show();
					 }
				} catch (HeadlessException | SQLException e1) {
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
         
         if(str.equals("注册")){
        	 Zhuce frame = new Zhuce();
        	 
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
     
     /* 判断密码账号是否正确
     	第一次是用txt来调试保存密码  但是 这样不安全  改用mysql来保存 
		并且在user这个数据库中保存着   user有id 有name 有password  
		经过查询资料发现目前数据库的password是经过加密实现
		由于比较麻烦所以没有采用密文 使用明文进行加密
		希望在课程设计结束后再加上
		第二点 起初判断的时候  使用if(user1==user)  发现不管咋样都是 false
		后来查资料  如果是new的俩个String比较必须使用equals函数 
		第三个小bug  发现每次只能读取一个密码的时候  换另一种思路来解决
		*/
     private boolean checkUserAndPwd(String user,String pwd) throws SQLException{
         boolean result = false;
         String password ;
        // String password;
         Jdbc j =new Jdbc();
         try {
        	 j.init();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         /*user1 =j.username();
         password = j.userpassword();
 		if(user1.equals(user)&&(password.equals(pwd))){								
         return true;
 		}*/
         password=j.userpassword(user);
         if(password.equals(pwd)){
        	 return true;
         }
 		
 		else {
        	return result;}
        }
     }

