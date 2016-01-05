import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame screen = new JFrame("Sad Pets");
				screen.setSize(467, 730);
				screen.setResizable(false);
				screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				screen.setVisible(true);
				
				JLayeredPane lp = screen.getLayeredPane();

				JButton btn = new JButton("Play");
				btn.setBounds(200, 200, 100, 50);
				btn.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
				btn.setBackground(Color.YELLOW);
				btn.setForeground(Color.BLUE);/*
				btn.setFocusPainted(false);
				btn.setContentAreaFilled(false);*/
				
				
				JPanel anim = new Animacja();
				anim.setBounds(0, 0, 467, 730);

				lp.add(anim,new Integer(1));
				lp.add(btn,new Integer(2));

				/*JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.add(anim);
				panel.add(btn);
				
				screen.add(panel);*/
			}
			
		});	
	}
}

class Animacja extends JPanel implements ActionListener{
	private BufferedImage image;
	Timer t;
	private int x = 0;
	private int y = 0;
	Animacja(){
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/makieta2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
		t = new Timer(5, this);
		t.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(image, 0, 0, null);
		g.drawImage(image, 10, 10, 200, 200, x, y, x+200, y+200, null);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(y>520){
			y=0;
		}
		y++;
		repaint();
	}
}
