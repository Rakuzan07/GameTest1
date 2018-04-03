package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.Hero;

/**
 * 
 * @author Francesco
 *
 *         Pannello con repaint personalizzato
 */
public class PanelWCR extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage[] hero_Animation = new BufferedImage[8];
	BufferedImage[] hero_Animationt = new BufferedImage[8];
	BufferedImage environment_Image;
	BufferedImage terrain_Image;
	BufferedImage terrain_ImageM;
	Hero hero;
	int width, height, contRun = 0, contFor;
	private static final int INITIAL_X = 0, INITIAL_Y = 810;
    boolean okRun=true;
	public PanelWCR() {
		hero = new Hero(INITIAL_X, INITIAL_Y, 142, 131);
		width = 0;
		height = 0;
		try {
			for (int i = 1; i < 9; i++) {
				hero_Animation[i - 1] = ImageIO.read(this.getClass().getResource("hero_run_bomb000" + i + ".png"));
				hero_Animationt[i - 1] = ImageIO.read(this.getClass().getResource("hero_run_bomb000" + i + "t.png"));
			}
			environment_Image = ImageIO.read(this.getClass().getResource("NewBackGround1920x1080.png"));
			terrain_Image = ImageIO.read(this.getClass().getResource("Grass.png"));
			terrain_ImageM = ImageIO.read(this.getClass().getResource("GrassM.png"));
		} catch (IOException e) {
		}

	}

	public PanelWCR(int x, int y) {
		hero = new Hero(x, y, 0, 0);
		width = 0;
		height = 0;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setEnvironment(g);
		this.buildTerrain(g);
		this.paintHero_Run(g);
	}

	/*
	 * Imposta lo sfondo del JPanel personalizzato
	 */
	private void setEnvironment(Graphics g) {
		g.drawImage(environment_Image, 0, 0, this);

	}

	public Runnable returnSketcher() {
		return new Sketcher();
	}

	/*
	 * Imposta il terreno del JPanel personalizzato
	 */

	private void buildTerrain(Graphics g) {
		int w = width / 128;
		int h = height - 128;
		for (int i = 0; i < w; i++) {
			g.drawImage(terrain_Image, 128 * i, h, this);
			g.drawImage(terrain_ImageM, 128 * i , h-(128*3), this);
			if(i<13)g.drawImage(terrain_ImageM, 128 * ((i+1)) , h-(128*5), this);
			if(i<9)g.drawImage(terrain_ImageM, 128 * ((i+3)) , h-(128*7), this);
		}
	}

	private void paintHero_Run(Graphics g) {
		contRun = (contRun + 1) % 8;
		if (hero.getX() + hero.getWidth() <= 1920&&okRun) {
			g.drawImage(hero_Animation[contRun], hero.getX(), hero.getY(), this);
			hero.setX(hero.getX() + 4);
		}
		else {
			g.drawImage(hero_Animationt[contRun], hero.getX(), hero.getY(), this);
			hero.setX(hero.getX() - 4);
			okRun=(hero.getX()-4)<0;
		}
	}

	private class Sketcher implements Runnable {

		public void run() {
			while (true) {
				try {
					PanelWCR.this.repaint();
					TimeUnit.MILLISECONDS.sleep(18);
				} catch (InterruptedException e) {
				}
			}
		}

	}
}
