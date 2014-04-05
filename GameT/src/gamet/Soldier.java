package gamet;

public class Soldier extends Enemy
{

	public Soldier(int x, int y, int width, int height, World pimpland)
	{
		super(x, y, width, height, pimpland);
	    move = true;
	    speed = 5;
	}
	@Override
	public void move()
	{
		super.move();
		angle = 180 + (int) Math.toDegrees(Math.atan2(getY() - pimpland.getPlayer().getY(), getX() - pimpland.getPlayer().getX()));
		
	}
	
}
