package gamet;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class World
{
	Random random = new Random();
	private int playerX = 100;
	private int playerY = 100;
	protected int enemylvl = 1;
	protected int lvl = 0;
	ArrayList<Character> characters = new ArrayList<Character>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public World()
	{

	}

	public void move()
	{
		if (characters.size() <= 1)
		{
			characters.clear();
			projectiles.clear();
			enemylvl += 1;
			lvl++;
			JOptionPane.showMessageDialog(null, ("Level " + lvl + "/" + enemylvl*2 + "enemies"));
			characters.add(new Player(playerX, playerY, 20, 20, this));
			for (int t = 0; t < enemylvl; t++)
			{
				characters.add(new Soldier(random.nextInt(Toolkit.getDefaultToolkit().getScreenSize().width), random.nextInt(Toolkit.getDefaultToolkit().getScreenSize().height), 25, 25, this));
				//characters.add(new Dundy(random.nextInt(Toolkit.getDefaultToolkit().getScreenSize().width), random.nextInt(Toolkit.getDefaultToolkit().getScreenSize().height), 30, 30, this));
				characters.add(new Tank(random.nextInt(Toolkit.getDefaultToolkit().getScreenSize().width),random.nextInt(Toolkit.getDefaultToolkit().getScreenSize().height), 50, 50, this));
			}

		}
		for (int i = 0; i < characters.size(); i++)
		{
			characters.get(i).move();
		}
		for (int t = 0; t < projectiles.size(); t++)
		{
			projectiles.get(t).move();

		}

		for (int i = 0; i < characters.size(); i++)
		{
			for (int j = 0; j < characters.size(); j++)
			{
				if (characters.get(i).getRec().intersects(characters.get(j).getRec()))
				{

					if (j != i)
					{
						characters.get(i).collision(characters.get(j).getRec(), false, false);
					}
				}
			}
		}
		for (int i = 0; i < characters.size(); i++)
		{
			for (int j = 0; j < projectiles.size(); j++)
			{
				if (j != i)
				{
					if (characters.get(i).getRec().intersects(projectiles.get(j).getRec()))
					{
						characters.get(i).collision(projectiles.get(j).getRec(), true, projectiles.get(j).isEnemyProjectile);
						if (characters.get(i) instanceof Tank)
						{
							projectiles.remove(j);

						} 
						
					
					}
				}
			}
		}
		for (int i = 0; i < characters.size(); i++)
		{
			if (characters.get(i).health <= 0)
			{
				if (characters.get(0).health <= 0)
				{
					JOptionPane.showMessageDialog(null, "You Dead Son");
					System.exit(0);
				}
				characters.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++)
		{
			if (projectiles.get(i).x <= 0 || projectiles.get(i).x >= 1915 || projectiles.get(i).y <= 0 || projectiles.get(i).y >= 960)
			{
				projectiles.remove(i);

			}
		}

	}

	public void addProj(Projectile p)
	{
		projectiles.add(p);
	}

	public ArrayList<Character> getCharArrayList()
	{
		return characters;
	}

	public ArrayList<Projectile> getProjArrayList()
	{
		return projectiles;
	}

	public Player getPlayer()
	{
		return ((Player) characters.get(0));
	}
}
