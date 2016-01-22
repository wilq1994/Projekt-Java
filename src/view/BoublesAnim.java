package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Bouble;

public class BoublesAnim extends JPanel {

	private BufferedImage bouble;
	
	private ArrayList <Bouble> boubles;

	public BoublesAnim(){
		setOpaque(false);
		
		try {
			bouble = ImageIO.read(getClass().getResourceAsStream("/bouble.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repaint();
	}
	
	public void refreshBoubles(ArrayList <Bouble> boubles){
		this.boubles = boubles;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		
		if(boubles != null){
			for(int i=0; i<this.boubles.size(); i++){
				Bouble b = boubles.get(i);
				g2d.drawImage(bouble, b.getLocationX(), b.getLocationY(), this);
			}
		}
		g2d.dispose();
	}

}
