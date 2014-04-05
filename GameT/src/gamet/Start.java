package gamet;

import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Start implements ActionListener
{
	private JFrame frame = new JFrame("Dungeon Game");
	private Timer paintTimer = new Timer(33, this);
	private Timer pimplandTimer = new Timer(30, this);
	private World world = new World();
	private Draw paint = new Draw(world);

	public static void main(String[] args)
	{
		Start start = new Start();
	}

	public Start()
	{
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.addKeyListener(paint);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(paint);
		paintTimer.start();
		playSound();
		pimplandTimer.start();
		frame.setVisible(true);
	}

	private void playSound() {
		AudioClip sound = JApplet
				.newAudioClip(getClass().getResource("Wandering 2.wav"));
		sound.loop();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(paintTimer))
		{
			paint.repaint();
		}
		if (e.getSource().equals(pimplandTimer))
		{
			world.move();
		}
	}

}
