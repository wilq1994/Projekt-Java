package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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

		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.PLAIN, 50));
		FontMetrics fm = g2d.getFontMetrics();
		
		if(boubles != null){
			for(int i=0; i<this.boubles.size(); i++){
				Bouble b = boubles.get(i);
				if(b.getState()=="WAIT"){
					g2d.drawImage(bouble, b.getLocationX(), b.getLocationY(), b.getLocationX()+130, b.getLocationY()+130, 0, 0, 130, 130, null);
				}else if(b.getState()=="CLICK"){
					g2d.drawImage(bouble, b.getLocationX(), b.getLocationY(), b.getLocationX()+130, b.getLocationY()+130, 130, 0, 260, 130, null);
				}else if(b.getState()=="FAILURE"){
					g2d.drawImage(bouble, b.getLocationX(), b.getLocationY(), b.getLocationX()+130, b.getLocationY()+130, 260, 0, 390, 130, null);
				}else if(b.getState()=="SUCCESS"){
					g2d.drawImage(bouble, b.getLocationX(), b.getLocationY(), b.getLocationX()+130, b.getLocationY()+130, 390, 0, 520, 130, null);
				}
				g2d.drawString(b.getSymbol(), b.getLocationX()+50, b.getLocationY()+fm.getHeight()+20);
				
			}
		}
		g2d.dispose();
	}

}
