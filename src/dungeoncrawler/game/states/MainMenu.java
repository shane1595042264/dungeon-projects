package dungeoncrawler.game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


import dungeoncrawler.framework.gamestates.GameState;
import dungeoncrawler.framework.gamestates.GameStateManager;
import dungeoncrawler.framework.gui.WindowManager;

public class MainMenu extends GameState{

    private String[] optionsMenu;
    private static final String START_GAME = "Start Game!";
    private static final String QUIT_GAME = "Quit Game";
    private int selected; //an integer indicating which option is selected

    public MainMenu(GameStateManager manager){
        super(manager);
        this.optionsMenu = new String[] {START_GAME, QUIT_GAME};
        this.selected = 0;
    }

    @Override
    protected void loop() {

    }

    @Override
    protected void render(Graphics graphics) {
        graphics.setColor(new Color(100, 30, 80)); //red color?
        graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);

        graphics.setFont(new Font("Aerial", Font.PLAIN, 25));
        //Draw some sweet Lines
        for (int i=0; i<this.optionsMenu.length; i++){
            if(i == this.selected) graphics.setColor(Color.MAGENTA);
            else graphics.setColor(Color.WHITE);
            graphics.drawString(this.optionsMenu[i], 20, 50+i*40); //Draw the menu
        }

    }

    @Override
    protected void keyPressed(int keyCode) {
        // virtual keyboard = VK. this is for selecting options in menu
        switch (keyCode){
            case keyEvent.VK_UP:
                if(this.selected > 0) this.selected--;
                break;
            case keyEvent.VK_DOWN:
                if(this.selected < this.optionsMenu.length-1) this.selected++;
                break;
            case KeyEvent.VK_ENTER:
                switch (this.optionsMenu[selected]){
                    case START_GAME:
                        super.gameStateManager.stackState(new PlayingState(gameStateManager));//update current state
                        break;
                    case QUIT_GAME:
                        System.exit(0);
                        break;

                }
                break;
        }
    }

    @Override
    protected void keyReleased(int keyCode) {

    }
}
