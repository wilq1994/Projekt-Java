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

public class PetAnimation extends JPanel implements ActionListener {
	
	private BufferedImage pet;
	Timer t;
	private int x = 0;
	private int max;
	
	public PetAnimation(){
		setOpaque(false);
		
		try {
			pet = ImageIO.read(getClass().getResourceAsStream("/petAnim.png"));
			max = pet.getWidth() - 270;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repaint();
		t = new Timer(80, this);
		t.start();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.drawImage(pet, 0, 0, 270, 529, x, 0, x+270, 529, this);
		g2d.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(x >= max){
			x=0;
		}
		x+=270;
		repaint();
		revalidate();
	}

}
