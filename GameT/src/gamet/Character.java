package gamet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class Character
{
	Random random = new Random();
	protected int health = 150;
	protected int speed = 20;
	protected int o = 0;
	protected int angle;
	protected int angle2;
	protected int x;
	protected int y;
	private int width;
	private int height;
	protected boolean move;
	protected boolean ifIntersected;
	protected boolean enemyChar;
	protected World pimpland;
	private Rectangle boundingBox = new Rectangle();

	public Character(int x, int y, int width, int heigth, World pimpland)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = heigth;
		this.pimpland = pimpland;
		if (this instanceof Enemy)
		{
			enemyChar = true;
		} else
		{
			enemyChar = false;
		}
	}

	public void paintCharacter(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		boundingBox.setFrame(x, y, width, height);
		g2.fill(boundingBox);
		PlayerIsOutsideTheWindow();
		g2.draw(boundingBox);
	}

	private void PlayerIsOutsideTheWindow()
	{
		if (getX() > Toolkit.getDefaultToolkit().getScreenSize().width)
		{
			x = (int) Toolkit.getDefaultToolkit().getScreenSize().width;
			if (this instanceof Dundy)
			{
				angle = random.nextInt(180) + 90;
			}
		}
		if (getY() > (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight())
		{
			y = (int) Toolkit.getDefaultToolkit().getScreenSize().height;
			if (this instanceof Dundy)
			{
				angle = random.nextInt(180) + 180;
			}
		}
		if (getX() < 0)
		{
			x = 0;
			if (this instanceof Dundy)
			{
				angle = random.nextInt(180) - 90;
			}
		}
		if (getY() < 0)
		{
			y = 0;
			if (this instanceof Dundy)
			{
				angle = random.nextInt(180);
			}
		}
	}

	public void move()
	{
		if (move)
		{
			x += speed * Math.cos(Math.toRadians(angle));
			y += speed * Math.sin(Math.toRadians(angle));
		}
		if (ifIntersected)
		{
			x += speed * Math.cos(Math.toRadians(angle2));
			y += speed * Math.sin(Math.toRadians(angle2));
		}
	}

	public void collision(Rectangle rect, boolean isProjectile, boolean isEnemyProjectile)
	{
		if (!isProjectile)
		{
			ifIntersected = true;
			angle = (int) Math.toDegrees(Math.atan2(boundingBox.y - rect.y, boundingBox.x - rect.x));
		}
		ifIntersected = false;
		if (isProjectile && isEnemyProjectile != enemyChar)
		{

			health -= 10;
		}
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public Rectangle getRec()
	{
		return boundingBox;
	}

	public int getHealth()
	{
		return health;
	}

}
