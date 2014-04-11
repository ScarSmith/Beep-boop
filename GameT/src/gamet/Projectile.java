package gamet;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Projectile
{
	protected boolean isEnemyProjectile;
	protected int x;
	protected int y;
	protected int xEnd;
	protected int yEnd;
	protected int angle;
	protected int width = 3;
	protected int heigth = 3;
	protected int speed = 30;
	private Rectangle boundingRec = new Rectangle();

	public Projectile(int x, int y, int xEnd, int yEnd, int width, int heigth, int angle, boolean enemyProjectile)
	{
		this.x = x;
		this.y = y;
		this.xEnd = xEnd;
		this.yEnd = yEnd;
		this.width = width;
		this.heigth = heigth;
		this.angle = angle;
		this.isEnemyProjectile = enemyProjectile;
	}

	public void paint(Graphics g)
	{
		g.drawOval(x, y, width, heigth);
	}

	public void move()
	{
		x += speed * Math.cos(Math.toRadians(angle));
		y += speed * Math.sin(Math.toRadians(angle));
		boundingRec.setBounds(x, y, width, heigth);
	}

	public Rectangle getRec()
	{
		return boundingRec;
	}
}
