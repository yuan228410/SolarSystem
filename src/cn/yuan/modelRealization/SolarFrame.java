package cn.yuan.modelRealization;

import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Image;  
  
import cn.yuan.modelutil.Constant;  
import cn.yuan.modelutil.GameUtil;  
import cn.yuan.modelutil.MyFrame;  
  
/** 
 *  
 * @author zyq_zhang 太阳系主窗口 
 * 
 */  
public class SolarFrame extends MyFrame {  
    private Image iBuffer;  
    private Graphics gBuffer;  
    SolarFrame(String s) {  
        super(s);  
    }  
  
    private static final long serialVersionUID = 1L;  
  
    Image bg = GameUtil.getImage("images/bg1.jpg");// 背景图片  
    Star Sun = new Star("images/sun.png", Constant.FRAME_WIDETH / 2, Constant.FRAME_HIGHTH / 2-25);  
    Planet mercury = new Planet(Sun, "images/mercury.png", 120, 60, 0.3);// 水星  
    Planet venus = new Planet(Sun, "images/venus.png", 160, 100, 0.4);// 金星  
    Planet earth = new Planet(Sun, "images/earth.png", 200, 140, 0.1);// 地球  
    Planet mars = new Planet(Sun, "images/mars.png", 240, 180 ,0.3);// 火星  
    Planet jupiter = new Planet(Sun, "images/jupiter.png", 280, 220, 0.4);// 木星  
    Planet saturn = new Planet(Sun, "images/saturn.png", 320, 260, 0.3);// 土星  
    Planet uranus = new Planet(Sun, "images/uranus.png", 350, 300, 0.2);// 天王星  
    Planet neptune = new Planet(Sun, "images/neptune.png", 390,340, 0.1);// 海王星  
    Planet moon = new Planet(earth, "images/moon.png", 40, 30, 0.2, true);// 月球  
  
    public void paint(Graphics g) {  
        Color c = g.getColor();  
        g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), null) ;
        Sun.draw(g);  
        mercury.draw(g);  
        venus.draw(g);  
        earth.draw(g);  
        mars.draw(g);   
        jupiter.draw(g);   
        saturn.draw(g);   
        uranus.draw(g);  
        neptune.draw(g);  
        moon.draw(g);  
        this.setVisible(true);  
       g.setColor(c);  
    }  
    //JAVA双缓冲  ，防止屏幕闪烁  
    public void update(Graphics scr)  
    {  
        if(iBuffer==null)  
        {  
           iBuffer=createImage(this.getSize().width,this.getSize().height);  
           gBuffer=iBuffer.getGraphics();  
        }  
           gBuffer.setColor(getBackground());  
           gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);  
           paint(gBuffer);  
           scr.drawImage(iBuffer,0,0,this);  
    }  
    public static void main(String[] args) {  
        new SolarFrame("太阳系模型").launchFrame();  
    }  
}  