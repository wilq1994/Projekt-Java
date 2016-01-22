package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBgAnimation extends JPanel implements ActionListener {

	private BufferedImage bg;
	Timer t;
	private int x = 0;
	private int max;
	
	public GameBgAnimation(){

		try {
			bg = ImageIO.read(getClass().getResourceAsStream("/gameBg.png"));
			max = bg.getWidth() - 540;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repaint();
		t = new Timer(40, this);
	}
	
	public void play(){
		x = 0;
		t.start();
	}
	
	public void stop(){
		x = 0;
		t.stop();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawImage(bg, 0, 0, 540, 960, x, 0, x+540, 960, null);
		g2d.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(x>=max){
			x=0;
		}
		x+=540;
		repaint();
		revalidate();		
	}

}
