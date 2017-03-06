package cn.yuan.modelRealization;

import java.awt.Color;  
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import cn.yuan.modelutil.GameUtil;  
  
/** 
 *   
 * 行星类，继承星球类 
 */  
public class Planet extends Star {  
  
    double longAxis;// 长轴  
    double shortAxis;// 短轴  
    double speed;// 速度  
    double degree;// 角度  
    Star center;// 绕着那个星球飞  
    boolean satellite;//是否是行星，默认是，true表示不是行星  
  
    public Planet(String Imgpath, double longAxis, double shortAxis, double speed, double degree, Star center) {  
  
        this.longAxis = longAxis;  
        this.shortAxis = shortAxis;  
        this.speed = speed;  
        this.degree = degree;  
        this.center = center;  
    }  
  
    public Planet() {  
  
    }  
  
    public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speed) {  
        super(GameUtil.getImage(imgpath));  
        this.center = center;  
        this.x = center.x + longAxis;  
        this.y = center.y;  
  
        this.longAxis = longAxis;  
        this.shortAxis = shortAxis;  
        this.speed = speed;  
  
          
        /*this.width = img.getWidth(null); this.height = img.getHeight(null);*/  
           
    }  
  
    public Planet(Star center, String imgpath, double longAxis, double shortAxis, double speed, boolean satellite) {  
  
        this(center, imgpath, longAxis, shortAxis, speed);  
        this.satellite = satellite;  
    }  
  
    public void draw(Graphics g) {  
        super.draw(g);  
        starmove();  
        if (!satellite) {  
            this.drawTrace(g);  
        }  
    }  
  
    public Planet(Image img, double x, double y) {  
        super(img, x, y);  
    }  
  
    public Planet(String imgpath, double x, double y) {  
        super(imgpath, x, y);  
    }  
  
    private void drawTrace(Graphics g) {  
    	((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double ovalX, ovalY, ovalWidth, ovalHeight;  
        ovalWidth = longAxis * 2;  
        ovalHeight = shortAxis * 2;  
        ovalX = (center.x + center.width / 2) - longAxis;  
        ovalY = (center.y + center.height / 2) - shortAxis;  
        Color c = g.getColor();  
        g.setColor(Color.BLUE);  
        g.drawOval((int) ovalX, (int) ovalY, (int) ovalWidth, (int) ovalHeight);  
        g.setColor(c);  
    }  
  
    public void starmove() {  
        // 沿着椭圆轨迹飞行  
        x = center.x + center.width / 2-this.width/2 + longAxis * Math.cos(degree);  
        y = center.y + center.height / 2-this.height/2 + shortAxis * Math.sin(degree);  
        degree += speed;  
    }  
  
}  