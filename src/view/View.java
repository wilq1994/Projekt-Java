package view;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class View {
	
	private JFrame screen;

	private JPanel mainView;
	
	private JPanel gameView;
	
	private JLayeredPane gameViewPane;

	private	JLabel happinessLabel;
	
	private	JLabel enemyLabel;
	
	public View(){
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				Toolkit tk = Toolkit.getDefaultToolkit();
				Dimension screenSize = tk.getScreenSize();
				
				screen = new JFrame("Sad Pets");
				screen.setSize(540, 960);
				screen.setResizable(false);
				screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				screen.setVisible(true);
				screen.setLocation(screenSize.width/2-540/2, screenSize.height/2-960/2);

				mainView = new JPanel(null);
				gameView = new JPanel(null);
				
				initMainView();
				initGameView();
				screen.add(mainView);
			}
			
		});	
	}
	private void initMainView(){
		/* --- MAIN VIEW --- */
		JLayeredPane mainViewPane = new JLayeredPane();
		mainViewPane.setBounds(0, 0, 540, 960);
		mainView.add(mainViewPane);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("res/main.png"));
		bg.setBounds(0,0,540,960);
	
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(200, 500, 150, 50);
		btnPlay.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnPlay.setBackground(Color.YELLOW);
		btnPlay.setForeground(Color.BLUE);
		btnPlay.setFocusPainted(false);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(200, 570, 150, 50);
		btnHelp.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnHelp.setBackground(Color.YELLOW);
		btnHelp.setForeground(Color.BLUE);
		btnHelp.setFocusPainted(false);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(200, 640, 150, 50);
		btnCredits.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnCredits.setBackground(Color.YELLOW);
		btnCredits.setForeground(Color.BLUE);
		btnCredits.setFocusPainted(false);

		mainViewPane.add(bg,new Integer(1));
		mainViewPane.add(btnPlay,new Integer(2));
		mainViewPane.add(btnHelp,new Integer(2));
		mainViewPane.add(btnCredits,new Integer(2));
			
		btnPlay.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				changeView("game");
			}
		});
	}
	private void initGameView(){
		/* --- GAME VIEW --- */
		gameViewPane = new JLayeredPane();
		gameViewPane.setBounds(0, 0, 540, 960);
		gameView.add(gameViewPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(410, 20, 100, 50);
		btnBack.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnBack.setBackground(Color.YELLOW);
		btnBack.setForeground(Color.BLUE);
		btnBack.setFocusPainted(false);
		btnBack.setContentAreaFilled(false);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setString("");
		progressBar.setBounds(150,30,230,30);
		progressBar.setValue(50);
		progressBar.setBorderPainted(false);
		progressBar.setForeground(new Color(255,0,0));
		progressBar.setBackground(new Color(155,100,100));
				
		
		happinessLabel = new JLabel();
		happinessLabel.setText("Happiness: 50");
		happinessLabel.setBounds(20, 20, 160, 50);

		enemyLabel = new JLabel();
		enemyLabel.setText("Enemy happiness: 50");
		enemyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		enemyLabel.setBounds(350, 880, 160, 50);
		

		GameBgAnimation bg = new GameBgAnimation();
		bg.setBounds(0, 0, 540, 960);
		
		PetAnimation pet = new PetAnimation();
		pet.setBounds(140, 250, 270, 529);
		
		gameViewPane.add(bg, new Integer(1));
		gameViewPane.add(pet, new Integer(2));

		gameViewPane.add(btnBack, new Integer(3));
		gameViewPane.add(progressBar, new Integer(3));
		gameViewPane.add(happinessLabel, new Integer(3));
		gameViewPane.add(enemyLabel, new Integer(3));
		
		btnBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				changeView("main");
			}
		});
	}
	
	private void renderFrame(){
	}
	
	private void renderHUD(){
		
	}
	
	private void playMusic(){
		
	}
	
	/**
	 * Metoda zmieniaj¹ca widok aplikacji
	 * @param view nazwa widoku
	 */
	public void changeView(String view){
		screen.getContentPane().removeAll();
		switch (view) {
		case "game":
			screen.add(gameView);
			renderFrame();
			break;
		default:
			screen.add(mainView);
			break;
		}
		screen.repaint();
		screen.revalidate();
	}
	
	public void refresh(Integer happiness){
		enemyLabel.setText("Enemy happiness: " + happiness);
	}
	
}