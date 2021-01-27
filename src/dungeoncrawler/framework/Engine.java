package dungeoncrawler.framework;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;

import javax.swing.JPanel;
import javax.swing.Timer;

import dungeoncrawler.framework.gamestates.GameState;
import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.gui.WindowManager;
import dungeoncrawler.game.states.MainMenu;


public class Engine {
    private static GameStateManager gameStateManager;
    private static WindowManager windowManager;
    private static Timer timer;
/*Initialization*/
    public static void init() {
        gameStateManager = new GameStateManager();
        windowManager = new WindowManager();
        timer = new Timer(20, new MainGameLoop());

    }

    public static void start(){
        gameStateManager.stackState(new MainMenu(gameStateManager));
        windowManager.addPanel(new GameScreen());//WindowManager application.
        windowManager.addKeyListener(new keyBoard());
        windowManager.createWindow();
        timer.start();
    }

    private static class Main implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0){
            gameStateManager.loop();
        }

    }
    private static class GameScreen extends JPanel{
        private static final long serialVersionUID = 1L;
        // if this class changed, it will throw an exception
        @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            gameStateManager.render(g);
            repaint();
        }

    }

    private static class Keyboard implements KeyListener{

        @Override
        public void keyTyped(KeyEvent arg0) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            gameStateManager.keyPressed(key.getKeyCode( ));

        }

        @Override
        public void keyReleased(KeyEvent e) {
            gameStateManager.keyReleased(key.getKeyCode());

        }

    }
}
