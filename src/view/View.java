package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import controler.Controler;
import model.Bouble;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class View {
	
	private JFrame screen;

	private JPanel mainView;
	
	private JPanel multiplayerView;
	
	private JPanel serverView;
	
	private JPanel clientView;

	private JPanel gameView;
	
	private JPanel finishView;
	
	private JLayeredPane gameViewPane;

	private	JLabel happinessLabel;
	
	private	JLabel enemyLabel;
	
	private PetAnimation petAnim;
	
	private GameBgAnimation bgAnim;
	
	private BoublesAnim boublesAnim;
	
	private AudioPlayer audioPly;
	
	private AudioStream audioStr;
	
	private JProgressBar progressBar;
	
	private JLabel scoreField;
	
	private JLabel scoreEnemyField;
	
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
				multiplayerView = new JPanel(null);
				clientView = new JPanel(null);
				serverView = new JPanel(null);
				gameView = new JPanel(null);
				finishView = new JPanel(null);
				
				initMainView();
				initMultiplayerView();
				initServerView();
				initClientView();
				initGameView();
				initFinishView();
				screen.add(mainView);

				
				audioPly = AudioPlayer.player;
				try {
					InputStream test = new FileInputStream("res/music.wav");
					audioStr = new AudioStream(test);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
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
		
		JButton btnMultiplayer = new JButton("Multiplayer");
		btnMultiplayer.setBounds(200, 570, 150, 50);
		btnMultiplayer.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnMultiplayer.setBackground(Color.YELLOW);
		btnMultiplayer.setForeground(Color.BLUE);
		btnMultiplayer.setFocusPainted(false);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(200, 640, 150, 50);
		btnHelp.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnHelp.setBackground(Color.YELLOW);
		btnHelp.setForeground(Color.BLUE);
		btnHelp.setFocusPainted(false);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.setBounds(200, 710, 150, 50);
		btnCredits.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnCredits.setBackground(Color.YELLOW);
		btnCredits.setForeground(Color.BLUE);
		btnCredits.setFocusPainted(false);

		mainViewPane.add(bg,new Integer(1));
		mainViewPane.add(btnPlay,new Integer(2));
		mainViewPane.add(btnMultiplayer,new Integer(2));
		mainViewPane.add(btnHelp,new Integer(2));
		mainViewPane.add(btnCredits,new Integer(2));
			
		btnPlay.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("NOWA GRA");
			}
		});
		
		btnMultiplayer.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MULTI");
			}
		});
	}
	private void initMultiplayerView(){
		/* --- MULTIPLAYER VIEW --- */
		JLayeredPane multiplayerViewPane = new JLayeredPane();
		multiplayerViewPane.setBounds(0, 0, 540, 960);
		multiplayerView.add(multiplayerViewPane);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("res/main.png"));
		bg.setBounds(0,0,540,960);
		
		JButton btnServer = new JButton("Server");
		btnServer.setBounds(200, 500, 150, 50);
		btnServer.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnServer.setBackground(Color.YELLOW);
		btnServer.setForeground(Color.BLUE);
		btnServer.setFocusPainted(false);
		
		JButton btnClient = new JButton("Client");
		btnClient.setBounds(200, 570, 150, 50);
		btnClient.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnClient.setBackground(Color.YELLOW);
		btnClient.setForeground(Color.BLUE);
		btnClient.setFocusPainted(false);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(200, 710, 150, 50);
		btnBack.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnBack.setBackground(Color.YELLOW);
		btnBack.setForeground(Color.BLUE);
		btnBack.setFocusPainted(false);

		multiplayerViewPane.add(bg,new Integer(1));
		multiplayerViewPane.add(btnServer,new Integer(2));
		multiplayerViewPane.add(btnClient,new Integer(2));
		multiplayerViewPane.add(btnBack,new Integer(2));
		
		btnServer.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("SERVER");
			}
		});
		
		btnClient.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("CLIENT");
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MAIN");
			}
		});
	}
	private void initServerView(){
		/* --- MULTIPLAYER VIEW --- */
		JLayeredPane serverViewPane = new JLayeredPane();
		serverViewPane.setBounds(0, 0, 540, 960);
		serverView.add(serverViewPane);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("res/main.png"));
		bg.setBounds(0,0,540,960);
		
		JTextField port = new JTextField();
		port.setBounds(150, 500, 250, 50);
		port.setText("PORT");
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(200, 570, 150, 50);
		btnOk.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnOk.setBackground(Color.YELLOW);
		btnOk.setForeground(Color.BLUE);
		btnOk.setFocusPainted(false);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(200, 710, 150, 50);
		btnBack.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnBack.setBackground(Color.YELLOW);
		btnBack.setForeground(Color.BLUE);
		btnBack.setFocusPainted(false);

		serverViewPane.add(bg,new Integer(1));
		serverViewPane.add(port,new Integer(2));
		serverViewPane.add(btnOk,new Integer(2));
		serverViewPane.add(btnBack,new Integer(2));
		
		btnOk.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("s, "+port.getText());
				Controler.handleClickedButton("s, "+port.getText());
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MULTI");
			}
		});
	}
	private void initClientView(){
		/* --- MULTIPLAYER VIEW --- */
		JLayeredPane clientViewPane = new JLayeredPane();
		clientViewPane.setBounds(0, 0, 540, 960);
		clientView.add(clientViewPane);
		
		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("res/main.png"));
		bg.setBounds(0,0,540,960);

		JTextField ip = new JTextField();
		ip.setBounds(150, 500, 250, 50);
		ip.setText("IP");
		
		JTextField port = new JTextField();
		port.setBounds(150, 570, 250, 50);
		port.setText("PORT");
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(200, 640, 150, 50);
		btnOk.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnOk.setBackground(Color.YELLOW);
		btnOk.setForeground(Color.BLUE);
		btnOk.setFocusPainted(false);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(200, 710, 150, 50);
		btnBack.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnBack.setBackground(Color.YELLOW);
		btnBack.setForeground(Color.BLUE);
		btnBack.setFocusPainted(false);

		clientViewPane.add(bg,new Integer(1));
		clientViewPane.add(ip,new Integer(2));
		clientViewPane.add(port,new Integer(2));
		clientViewPane.add(btnOk,new Integer(2));
		clientViewPane.add(btnBack,new Integer(2));
		
		btnOk.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("c, "+ip.getText()+", "+port.getText());
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MULTI");
			}
		});
	}
	private void initGameView(){
		/* --- GAME VIEW --- */
		gameViewPane = new JLayeredPane();
		gameViewPane.setBounds(0, 0, 540, 960);
		gameView.add(gameViewPane);
		
		progressBar = new JProgressBar();
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
		

		bgAnim = new GameBgAnimation();
		bgAnim.setBounds(0, 0, 540, 960);
		
		petAnim = new PetAnimation();
		petAnim.setBounds(140, 250, 270, 529);
		
		boublesAnim = new BoublesAnim();
		boublesAnim.setBounds(0, 0, 540, 960);
		
		gameViewPane.add(bgAnim, new Integer(1));
		gameViewPane.add(petAnim, new Integer(2));
		gameViewPane.add(boublesAnim, new Integer(3));

		gameViewPane.add(progressBar, new Integer(4));
		gameViewPane.add(happinessLabel, new Integer(4));
		gameViewPane.add(enemyLabel, new Integer(4));
	}
	private void initFinishView(){
		/* --- RESULT VIEW --- */
		JLayeredPane finishViewPane = new JLayeredPane();
		finishViewPane.setBounds(0, 0, 540, 960);
		finishView.add(finishViewPane);

		scoreField = new JLabel();
		scoreField.setBounds(100, 100, 200, 50);
		scoreField.setText("Twój wynik: ");
		
		scoreEnemyField = new JLabel();
		scoreEnemyField.setBounds(100, 200, 200, 50);
		scoreEnemyField.setText("Wynik przeciwnika: ");
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(200, 640, 150, 50);
		btnStart.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		btnStart.setBackground(Color.YELLOW);
		btnStart.setForeground(Color.BLUE);
		btnStart.setFocusPainted(false);

		finishViewPane.add(scoreField);
		finishViewPane.add(scoreEnemyField);
		finishViewPane.add(btnStart);

		btnStart.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MAIN");
			}
		});
		
	}
	
	/**
	 * Renderuje grê
	 */
	public void renderGame(){
		bgAnim.play();
		petAnim.play();

		audioPly.start(audioStr);
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
			renderGame();
			gameView.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {}
				
				@Override
				public void keyReleased(KeyEvent e) {
					Controler.handleClickedBouble(Character.toString(e.getKeyChar()));
				}
				
				@Override
				public void keyPressed(KeyEvent e) { }
			});
			gameView.setFocusable(true);
			gameView.requestFocusInWindow();
			break;
		case "multi":
			screen.add(multiplayerView);
			break;
		case "server":
			screen.add(serverView);
			break;
		case "client":
			screen.add(clientView);
			break;
		case "finish":
			audioPly.stop(audioStr);
			screen.add(finishView);
			break;
		default:
			audioPly.stop(audioStr);
			screen.add(mainView);
			break;
		}
		screen.repaint();
		screen.revalidate();
	}
	
	public void refresh(ArrayList <Bouble> boubles, Integer petHappiness, Integer enemyHappiness){
		int percent = (int) Math.round((petHappiness/1000.0)*100);
		boublesAnim.refreshBoubles(boubles);
		progressBar.setValue(percent);
		happinessLabel.setText("Happiness: "+petHappiness);
		enemyLabel.setText("Enemy happiness: " + enemyHappiness);
	}
	
	public void setScore(int score, int scoreEnemy){
		this.scoreField.setText("Twój wynik: "+score);
		try{
			this.scoreEnemyField.setText("Wynik przeciwnika: "+scoreEnemy);
		} catch (NullPointerException e){}
	}
	
}