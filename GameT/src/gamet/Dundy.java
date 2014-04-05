package gamet;
import java.util.Random;


public class Dundy extends Enemy
{
	Random random = new Random();
	public Dundy(int x, int y, int width, int height, World pimpland)
	{
		super(x, y, width, height, pimpland);
	    move = true;
	    speed = 9;
	}
	@Override
	public void move()
	{
		super.move();
	}
}
