package gamet;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.stream.events.Characters;

public class Draw extends Canvas implements KeyListener
{

	private ArrayList<Character> characters;
	private ArrayList<Projectile> projectiles;

	public Draw(World pimpland)
	{
		characters = pimpland.getCharArrayList();
		projectiles = pimpland.getProjArrayList();
	}

	public void paint(Graphics g)
	{
		for (int i = 0; i < characters.size(); i++)
		{
			if (i == 0)
			{
				g.setColor(Color.blue);
			} else if (characters.get(i) instanceof Soldier)
			{
				g.setColor(Color.RED);
			} else if (characters.get(i) instanceof Dundy)
			{
				g.setColor(Color.ORANGE);
			} else if (characters.get(i) instanceof Tank)
			{
				g.setColor(Color.GRAY);
			}
			characters.get(i).paintCharacter(g);
		}

		for (int t = 0; t < projectiles.size(); t++)
		{
			g.setColor(Color.BLACK);
			projectiles.get(t).paint(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		((Player) characters.get(0)).keyPressed(e);

	}

	@Override
	public void keyReleased(KeyEvent e)
	{

		((Player) characters.get(0)).keyReleased(e);
	}

}
