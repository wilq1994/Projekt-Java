package view;

import java.awt.Color;
import java.awt.Dimension;
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
	
	private InputStream music;
	
	private JLayeredPane finishViewPane;
	
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
					music = new FileInputStream("res/music.wav");
					audioStr = new AudioStream(music);
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

		JLabel btnPlay = new JLabel(new ImageIcon("res/playButton.png"));
		btnPlay.setBounds(160, 640, 228, 71);

		JLabel btnMultiplayer = new JLabel(new ImageIcon("res/multiplayerButton.png"));
		btnMultiplayer.setBounds(160, 731, 228, 71);

		JLabel btnCredits = new JLabel(new ImageIcon("res/creditsButton.png"));
		btnCredits.setBounds(160, 822, 228, 71);

		mainViewPane.add(bg,new Integer(1));
		mainViewPane.add(btnPlay,new Integer(2));
		mainViewPane.add(btnMultiplayer,new Integer(2));
		mainViewPane.add(btnCredits,new Integer(2));
			
		btnPlay.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("NOWA GRA");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlay.setIcon(new ImageIcon("res/playButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlay.setIcon(new ImageIcon("res/playButton.png"));
			}
		});
		
		btnMultiplayer.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MULTI");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMultiplayer.setIcon(new ImageIcon("res/multiplayerButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMultiplayer.setIcon(new ImageIcon("res/multiplayerButton.png"));
			}
		});
		
		btnCredits.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MULTI");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCredits.setIcon(new ImageIcon("res/creditsButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCredits.setIcon(new ImageIcon("res/creditsButton.png"));
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
		
		JLabel btnServer = new JLabel(new ImageIcon("res/serverButton.png"));
		btnServer.setBounds(160, 640, 228, 71);

		JLabel btnClient = new JLabel(new ImageIcon("res/clientButton.png"));
		btnClient.setBounds(160, 731, 228, 71);

		JLabel btnBack = new JLabel(new ImageIcon("res/backButton.png"));
		btnBack.setBounds(160, 822, 228, 71);

		multiplayerViewPane.add(bg,new Integer(1));
		multiplayerViewPane.add(btnServer,new Integer(2));
		multiplayerViewPane.add(btnClient,new Integer(2));
		multiplayerViewPane.add(btnBack,new Integer(2));
		
		btnServer.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("SERVER");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnServer.setIcon(new ImageIcon("res/serverButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnServer.setIcon(new ImageIcon("res/serverButton.png"));
			}
		});
		
		btnClient.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("CLIENT");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnClient.setIcon(new ImageIcon("res/clientButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnClient.setIcon(new ImageIcon("res/clientButton.png"));
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MAIN");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setIcon(new ImageIcon("res/backButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setIcon(new ImageIcon("res/backButton.png"));
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
		port.setBounds(160, 660, 228, 50);
		port.setText("PORT");

		JLabel btnPlay = new JLabel(new ImageIcon("res/playButton.png"));
		btnPlay.setBounds(160, 731, 228, 71);

		JLabel btnBack = new JLabel(new ImageIcon("res/backButton.png"));
		btnBack.setBounds(160, 822, 228, 71);

		serverViewPane.add(bg,new Integer(1));
		serverViewPane.add(port,new Integer(2));
		serverViewPane.add(btnPlay,new Integer(2));
		serverViewPane.add(btnBack,new Integer(2));
		
		btnPlay.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("s, "+port.getText());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlay.setIcon(new ImageIcon("res/playButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlay.setIcon(new ImageIcon("res/playButton.png"));
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MULTI");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setIcon(new ImageIcon("res/backButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setIcon(new ImageIcon("res/backButton.png"));
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
		ip.setBounds(160, 600, 228, 50);
		ip.setText("IP");
		
		JTextField port = new JTextField();
		port.setBounds(160, 660, 228, 50);
		port.setText("PORT");

		JLabel btnPlay = new JLabel(new ImageIcon("res/playButton.png"));
		btnPlay.setBounds(160, 731, 228, 71);

		JLabel btnBack = new JLabel(new ImageIcon("res/backButton.png"));
		btnBack.setBounds(160, 822, 228, 71);

		clientViewPane.add(bg,new Integer(1));
		clientViewPane.add(ip,new Integer(2));
		clientViewPane.add(port,new Integer(2));
		clientViewPane.add(btnPlay,new Integer(2));
		clientViewPane.add(btnBack,new Integer(2));
		
		btnPlay.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("c, "+ip.getText()+", "+port.getText());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlay.setIcon(new ImageIcon("res/playButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPlay.setIcon(new ImageIcon("res/playButton.png"));
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MULTI");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setIcon(new ImageIcon("res/backButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setIcon(new ImageIcon("res/backButton.png"));
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
		progressBar.setBackground(new Color(153,51,100));
		progressBar.setForeground(new Color(255,204,0));
				
		
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
		finishViewPane = new JLayeredPane();
		finishViewPane.setBounds(0, 0, 540, 960);
		finishView.add(finishViewPane);

		JLabel bg = new JLabel();
		bg.setIcon(new ImageIcon("res/finishbg.png"));
		bg.setBounds(0,0,540,960);

		scoreField = new JLabel();
		scoreField.setBounds(120, 440, 200, 50);
		scoreField.setText("Twój wynik: ");
		
		scoreEnemyField = new JLabel();
		scoreEnemyField.setBounds(120, 480, 200, 50);
		scoreEnemyField.setText("Wynik przeciwnika: ");

		JLabel btnBack = new JLabel(new ImageIcon("res/backButton.png"));
		btnBack.setBounds(155, 560, 228, 71);

		finishViewPane.add(bg, new Integer(1));
		finishViewPane.add(scoreField,new Integer(2));
		finishViewPane.add(scoreEnemyField,new Integer(2));
		finishViewPane.add(btnBack,new Integer(2));

		btnBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Controler.handleClickedButton("MAIN");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setIcon(new ImageIcon("res/backButton2.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setIcon(new ImageIcon("res/backButton.png"));
			}
		});
		
	}
	
	/**
	 * Renderuje grê
	 */
	public void renderGame(){
		bgAnim.play();
		petAnim.play();

		try {
			music = new FileInputStream("res/music.wav");
			audioStr = new AudioStream(music);
			audioPly.start(audioStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public void setScore(Integer score, Integer scoreEnemy){
		this.scoreField.setText("Your score: "+score);
		if (scoreEnemy != null)
		{
			this.scoreEnemyField.setText("Enemy's score: "+scoreEnemy);
		}
		else
		{
			this.scoreEnemyField.setText("");
		}

		JLabel head = new JLabel();
		head.setBounds(183,255,184,191);
		if(score < 250){
			head.setIcon(new ImageIcon("res/head1.png"));
		}else if(score >= 250 && score < 500){
			head.setIcon(new ImageIcon("res/head2.png"));
		}else if(score >= 500 && score < 750){
			head.setIcon(new ImageIcon("res/head3.png"));
		}else if(score >= 750) {
			head.setIcon(new ImageIcon("res/head4.png"));
		}
		finishViewPane.add(head, new Integer(2));
	}
	
}