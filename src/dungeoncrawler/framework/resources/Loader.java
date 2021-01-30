package dungeoncrawler.framework.resources;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
    public static void load(){
        try{
            // Create a file object
            File texturesFolder = new File("res/rooms");
            // Get all the names of the files present
            // in the given directory
            for (File imgFile : texturesFolder.listFiles()){
                Resources.ROOMS.put(imgFile.getName(). ImageIO.read(imgFile));
            }
            Resources.TEXTURES.add(Resources.FLOOR, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.STONE, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.WALL, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.TILE, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.GRASS, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.PLAYER_2, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.PLAYER_LEFT, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.PLAYER_BACK, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.PLAYER_BACK_2, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.PLAYER_LEFT_2, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.PLAYER_RIGHT, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.PLAYER_RIGHT_2, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.STAIRS, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.ARMOR, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.HEART, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.ATTACK, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.CHEST, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.GOLD, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.ENEMY, ImageIO.read(new File("res/textures/floor.png")));
            Resources.TEXTURES.add(Resources.ENEMY_2, ImageIO.read(new File("res/textures/floor.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
}
