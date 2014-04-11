package gamet;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Start implements ActionListener
{
	private JFrame frame = new JFrame("Survival");
	private Timer paintTimer = new Timer(33, this);
	private Timer pimplandTimer = new Timer(30, this);
	private World world = new World();
	private Draw paint = new Draw(world);
	public Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	Random random = new Random();

	public static void main(String[] args)
	{
		Start start = new Start();
	}

	public Start()
	{
		frame.setBounds(0, 0, dim.width, dim.height);
		frame.addKeyListener(paint);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(paint);
		frame.setResizable(false);
		paintTimer.start();
		playSound();
		pimplandTimer.start();
		frame.setVisible(true);
	}

	public void playSound() {
		int songSelection = random.nextInt(3);
		AudioClip W2 = JApplet
				.newAudioClip(getClass().getResource("Wandering2.wav"));
		AudioClip W = JApplet
				.newAudioClip(getClass().getResource("Wandering.wav"));
		AudioClip Op = JApplet
				.newAudioClip(getClass().getResource("Opening.wav"));
	if (songSelection == 1) {
		W2.loop();
	}else if (songSelection == 2) {
		W.loop();
	}else {
		Op.loop();
	}
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
//}
