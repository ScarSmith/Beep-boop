package gamet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player extends Character
{
	public Player(int x, int y, int width, int heigth, World pimpland)
	{
		super(x, y, width, heigth, pimpland);
	}

	protected int shootingperiod;
	private boolean pressingW;
	private boolean pressingA;
	private boolean pressingS;
	private boolean pressingD;
	private boolean pressingSpace;

	public void paintCharacter(Graphics g2)
	{
		super.paintCharacter(g2);
		if(health < 150) {
			g2.fillRect(40, 40, 150, 40);
			g2.setColor(Color.green);
		}else{
		g2.setColor(Color.green);
		}
		g2.fillRect(40, 40, health, 40);
		

	}

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyChar() == ' ')
		{
			pimpland.addProj(new Projectile(x, y, x, y, 10, 10, angle, enemyChar));
		}
		if (e.getKeyChar() == 's')
		{
			pressingS = true;
			move = true;
		}
		if (e.getKeyChar() == 'd')
		{
			pressingD = true;
			move = true;
		}
		if (e.getKeyChar() == 'a')
		{
			pressingA = true;
			move = true;
		}
		if (e.getKeyChar() == 'w')
		{
			pressingW = true;
			move = true;
		}

		shootingperiod++;
		if (pressingSpace && shootingperiod > 2)
		{
			pimpland.addProj(new Projectile(x, y, x, y, 10, 10, angle, enemyChar));
			shootingperiod = 0;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyChar() == ' ')
		{
			pressingSpace = false;
		}
		if (e.getKeyChar() == 's')
		{
			pressingS = false;
		}
		if (e.getKeyChar() == 'd')
		{
			pressingD = false;
		}
		if (e.getKeyChar() == 'a')
		{
			pressingA = false;
		}
		if (e.getKeyChar() == 'w')
		{
			pressingW = false;
		}
		if (!pressingA && !pressingD && !pressingS && !pressingW)
		{
			move = false;
		}
	}

	public void move()
	{

		super.move();
		if (pressingW)
		{
			angle = 270;
		}
		if (pressingA)
		{
			angle = 180;
		}
		if (pressingS)
		{
			angle = 90;
		}
		if (pressingD)
		{
			angle = 0;
		}
		if (pressingA && pressingS)
		{
			angle = 135;
		}
		if (pressingD && pressingS)
		{
			angle = 45;
		}
		if (pressingW && pressingD)
		{
			angle = 315;
		}
		if (pressingA && pressingW)
		{
			angle = 225;
		}
	}
}
