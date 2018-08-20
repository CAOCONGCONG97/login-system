package caocong;


//验证码的生成
import java.awt.*;
import java.util.*;
public class Mypanel extends Panel {
public void paint(Graphics g)
{
    int height = 50;
    int width = 90;
    //验证码框背景颜色
    g.setColor(Color.LIGHT_GRAY);
    //填充验证码背景
    g.fillRect(0, 0, width, height);
    g.setColor(Color.BLACK);
    g.drawRect(0, 0, width-1, height-1);
    Random r = new Random();
    //设置干扰点
    for(int i = 0;i<100;i++)
    {
        int x = r.nextInt(width)-1;
        int y = r.nextInt(height)-1;
        g.drawOval(x, y, 2, 2);
    }
    g.setFont(new Font("黑体",Font.BOLD,20));//设置验证码字体以及大小
    g.setColor(Color.RED);//设置验证码字体颜色
    //生成随机验证码
    char[] tmp = ("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int i = 0;i<4;i++)
    {
        int pos = r.nextInt(tmp.length);
        char c = tmp[pos];
        sb.append(c + " ");
    }
    g.drawString(sb.toString(), 10, 15);//写入验证码
}
}
