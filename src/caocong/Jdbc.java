package caocong;

import java.sql.*;

import javax.swing.JOptionPane;

public class Jdbc {
	 private static Statement stmt =null;
	 private static ResultSet rs = null;
	 private static int rs1 = 0;
	 private static Connection conn = null;
	 
	 static void init() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/park";
		String username = "root";
		String password = "123456";
		conn = DriverManager.getConnection(url, username, password);
	 }
	 
	 //第一种方案 已经放弃
	 /*static String username() throws SQLException{
			stmt = conn.createStatement();
			String sql="select name from users";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
			return  rs.getString("name");
			}
			return " ";
	 }*/
	 
	 static String userpassword(String user) throws SQLException{
			stmt = conn.createStatement();
			String sql="select password from users where name='"+user+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
			return  rs.getString("password");
			}
			return " ";
	 }
	 
	 static void addUser(String password ,String username) throws SQLException{
			stmt = conn.createStatement();
			String $sql=("insert  into  users  values('"+username+"','"+password+"')") ;
			rs1 = stmt.executeUpdate($sql);
			if(rs1>0){
				JOptionPane.showMessageDialog(null, "提交成功", "注册成功",JOptionPane.PLAIN_MESSAGE);
			}
	 }
	 
}
