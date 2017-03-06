package cn.yuan.modelRealization;

import java.awt.Graphics;
import java.awt.Image;

import cn.yuan.modelutil.GameUtil;

/**
 * 
 * @author zhixiang.yuan 星球类
 */
public class Star {
	Image img;// 星球的图片
	double x, y;
	int width, height;

	public Star() {
	}

	public Star(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	public Star(String imgpath, double x, double y) {
		this(GameUtil.getImage(imgpath), x, y);
	}

	public Star(Image img) {
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	public void draw(Graphics g) {
		g.drawImage(img, (int) x, (int) y, null);
	}
}