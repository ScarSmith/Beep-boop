package gamet;

public class Enemy extends Character
{
	protected int shootingSpeed = 59;
	public Enemy(int x, int y, int width, int height, World pimpland)
	{
		super(x, y, width, height, pimpland);
		if (this instanceof Tank)
		{
			health = 30;
		}else{
		health = 10;
		}
	}
	public void move()
	{
		super.move();
		if (o % shootingSpeed == 0)
		{
			if (shootingSpeed >= 15)
			{
				shootingSpeed--;
				pimpland.addProj(new Projectile(x, y, x, y, 10, 10, angle, enemyChar));
			}else{
			pimpland.addProj(new Projectile(x, y, x, y, 10, 10, angle, enemyChar));
			}
		}
		o++;
		
	}


}
