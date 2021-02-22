# dungeon-projects the real one
# **Project Summary**

- This project is about creating a dungeon game that includes player, enemy and other rng elements.
- The purpose of this project is to help me get into the basic graphics in Java.
- The new things I was trying to learn are mainly GUI, game designs, and basic game algorithms.
- I was trying to improve my skills in game design and heritance of classes.
- I also considered making an rpg game, but it&#39;s rejected because it&#39;s too hard to start with since I am still a beginner.
- This is challenging because I never touched Java Graphics before, I did do some python games in the past, but it&#39;s different, and this one is more complicated. However, I love gaming, so at least it&#39;s not that frustrating.

# **Technical Summary**

Some tutorials that were generally helpful:

Getting started with graphics:

[https://docs.oracle.com/javase/tutorial/2d/basic2d/index.html](https://docs.oracle.com/javase/tutorial/2d/basic2d/index.html)

Swing basics:

[https://www.youtube.com/watch?v=ZDw18yUwz6I&amp;list=PLxiaNNnSntXONXWYDOYWqMYvqJEBzDBxc&amp;index=3&amp;t=117s](https://www.youtube.com/watch?v=ZDw18yUwz6I&amp;list=PLxiaNNnSntXONXWYDOYWqMYvqJEBzDBxc&amp;index=3&amp;t=117s)

States Design patterns:

[https://www.youtube.com/watch?v=MGEx35FjBuo&amp;list=PLxiaNNnSntXONXWYDOYWqMYvqJEBzDBxc&amp;index=4](https://www.youtube.com/watch?v=MGEx35FjBuo&amp;list=PLxiaNNnSntXONXWYDOYWqMYvqJEBzDBxc&amp;index=4)

Here are some sample codes that I&#39;ve looked into:

The 2D Framework:

[http://www.java2s.com/Open-Source/Java\_Free\_Code/Game\_2D/Download\_2D\_Framework\_Free\_Java\_Code.htm](http://www.java2s.com/Open-Source/Java_Free_Code/Game_2D/Download_2D_Framework_Free_Java_Code.htm)

A complete 2D game:

[http://www.java2s.com/Open-Source/Java\_Free\_Code/Game\_2D/Download\_2d\_Game\_Free\_Java\_Code.htm](http://www.java2s.com/Open-Source/Java_Free_Code/Game_2D/Download_2d_Game_Free_Java_Code.htm)

RPG game:

[http://www.java2s.com/Open-Source/Java\_Free\_Code/Game\_RPG/Download\_legend\_of\_waffles\_Free\_Java\_Code.htm](http://www.java2s.com/Open-Source/Java_Free_Code/Game_RPG/Download_legend_of_waffles_Free_Java_Code.htm)

## _Framework_

## Gamestates

## GUI

(The JFrame and JPanel: [https://stackoverflow.com/questions/19662095/which-one-is-better-for-game-development-jpanel-or-jframe](https://stackoverflow.com/questions/19662095/which-one-is-better-for-game-development-jpanel-or-jframe)

)

JFrame: JFrame is the top level window which contains a title bar with some controls to close/minimize the window. It also contains the menu bar.Inside the JFrame, there is one big JPanel called content pane. The JPanel is a container that can contain swing components like JButton, JLabel, JTextField, ... etc. JPanel can contain nested JPanels as well

![](RackMultipart20210202-4-rvpm9h_html_fcc634cbeeb7ec35.png)

1. Class: WindowManager. You need JPanel and JFrame to create the main menu gui. Also, you should also add KeyListener to enable players to click the options in the menu. The reason I set the setResizable(false) is because it&#39;s easier for me to design the window so that I don&#39;t have to design different variables for the resized windows. Most of the game windows can&#39;t be resized freely either, they usually only have some certain values for players to resize to fit the monitor. This class will be used in the Engine Class like this:

```

public static void start(){

gameStateManager.stackState(new MainMenu(gameStateManager));

windowManager.addPanel(new GameScreen());//WindowManager application.

windowManager.addKeyListener(new keyBoard());

windowManager.createWindow();

timer.start();

}

```

1. Engine Class. ActionListener: The listener interface for receiving action events. The class that is interested in processing an action event implements this interface, and the object created with that class is registered with a component, using the component&#39;s addActionListener method. When the action event occurs, that object&#39;s actionPerformed method is invoked.

```

private static class Main implements ActionListener{

@Override

public void actionPerformed(ActionEvent arg0){

gameStateManager.loop();

}

}

```

**serialVersionUID: The serialization runtime associates with each serializable class a version number, called a serialVersionUID, which is used during deserialization to verify that the sender and receiver of a serialized object have loaded classes for that object that are compatible with respect to serialization. If the receiver has loaded a class for the object that has a different serialVersionUID than that of the corresponding sender&#39;s class, then deserialization will result in an [InvalidClassException](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/InvalidClassException.html). A serializable class can declare its own serialVersionUID explicitly by declaring a field named serialVersionUID that must be static, final, and of type long:**

**```**

private static class GameScreen extends JPanel{

private static final long serialVersionUID = 1L;

// if this class changed, it will throw an exception

@Override

protected void paintComponent(Graphics g){

super.paintComponent(g);

gameStateManager.render(g);

repaint();

}

**```**

**The Advantages of using serialization:**

1. **Useful to recreate objects into its original states.**
2. **Convert object to stream of bytes for easy shipment of information**
3. **Saves the state of the object for recreation without having to reprocess them in different platform.**

_If I don&#39;t declare serializationVersionUID, the system will generate a random serializationVersionUID for every change in that class, and it will fail every time when the deserialization happens. If I declare it, it will give me the control over versioning._

**For the paintcomponent and stuff, check this out:** [**https://www.oracle.com/java/technologies/painting.html**](https://www.oracle.com/java/technologies/painting.html)

For Swing components, paint() is always invoked as a result of both system-triggered and app-triggered paint requests; update() is never invoked on Swing components.

Programs may trigger a future call to paint() by invoking repaint(), but shouldn&#39;t call paint() directly.

On components with complex output, repaint() should be invoked with arguments which define only the rectangle that needs updating, rather than the no-arg version, which causes the entire component to be repainted.

## Resources

For the texture parts, I first drew some of them by myself in illustrator. It was pretty easy for the attack and armor icon, but when it comes to player texture and some more complicated texture such as enemy and treasure chest, I found it extremely difficult to draw it like a thing. So I used the following websites to get some existing images, it saves tons of time.

chest:[https://opengameart.org/content/treasure-chest-pixel-art-animation](https://opengameart.org/content/treasure-chest-pixel-art-animation)

Enemy: From google image, and paste them in illustrator then make them into 16 x 16 pixels.

![](RackMultipart20210202-4-rvpm9h_html_8214878b7385b5f2.png) ![](RackMultipart20210202-4-rvpm9h_html_554ad45b5aabaa7f.png)

Floor:[https://opengameart.org/content/16x-16-stone-set](https://opengameart.org/content/16x-16-stone-set)

Heart: [https://opengameart.org/content/heart-1616](https://opengameart.org/content/heart-1616)

stairs:[https://opengameart.org/content/wooden-stairs-ns](https://opengameart.org/content/wooden-stairs-ns)

stone:[https://opengameart.org/art-search?keys=stone&amp;page=3](https://opengameart.org/art-search?keys=stone&amp;page=3)

Tile: [https://opengameart.org/content/dark-stone-tile](https://opengameart.org/content/dark-stone-tile)

For the rooms textures, I drew it by myself in illustrator:

Using the rectangular grid tool to draw is good for pixel art.

![](RackMultipart20210202-4-rvpm9h_html_8452f3211761dd1d.png)

## Resources(class)

```

public static final byte FLOOR = 0;

public static final byte STONE = 1;

public static final byte WALL = 2;

public static final byte TILE = 3;

public static final byte GRASS = 4;

public static final byte PLAYER = 5;

public static final byte PLAYER\_2 = 6;

public static final byte PLAYER\_LEFT = 7;

public static final byte PLAYER\_LEFT\_2 = 8;

public static final byte PLAYER\_RIGHT = 9;

public static final byte PLAYER\_RIGHT\_2 = 10;

public static final byte PLAYER\_BACK = 11;

public static final byte PLAYER\_BACK\_2 = 12;

public static final byte STAIRS = 13;

public static final byte CHEST = 14;

public static final byte ENEMY = 15;

public static final byte ENEMY\_2 = 16;

public static final byte ATTACK = 17;

public static final byte HEART = 18;

public static final byte ARMOR = 19;

public static final byte GOLD = 20;

```

I used byte because this will save some space.

```

public static final HashMap<String, BufferedImage> ROOMS = new HashMap<>();

public static final ArrayList<BufferedImage> TEXTURES = new ArrayList<>();

```

I created an ArrayList for the images textures so that I can modify it in anyway I want (I am not sure how many textures I want)

I made a Hashmap for Rooms because later, in the Loader class, I am gonna put the rooms textures into them through enhanced for loop of Hashmap

## Loader

java.io.File

[https://www.geeksforgeeks.org/file-class-in-java/](https://www.geeksforgeeks.org/file-class-in-java/)

A File object is created by passing in a String that represents the name of a file, or a String or another File object. For example

```

File texturesFolder = new File("res/rooms");

```

Here, I used enhanced for loop to iterate through the Hashmap

```

for (File imgFile : texturesFolder.listFiles()){

Resources.ROOMS.put(imgFile.getName(). ImageIO.read(imgFile));

}

```

In each for cycle, a new key-value couple is assigned to the imgFile variable.

[getName](https://docs.oracle.com/javase/7/docs/api/java/io/File.html#getName())()

Returns the name of the file or directory denoted by this abstract pathname

Using the read method of the Java ImageIO class, and you can open/read images in a variety of formats (GIF, JPG, PNG) in basically one line of Java code.

How to use ImageIO.read:

[https://alvinalexander.com/blog/post/java/open-read-image-file-java-imageio-class/#:~:text=Just%20use%20the%20read%20method,one%20line%20of%20Java%20code.&amp;text=As%20you%20can%20see%20from,need%20to%20deal%20with%20that](https://alvinalexander.com/blog/post/java/open-read-image-file-java-imageio-class/#:~:text=Just%20use%20the%20read%20method,one%20line%20of%20Java%20code.&amp;text=As%20you%20can%20see%20from,need%20to%20deal%20with%20that).

listFiles returns an array of file names.

This part basically puts everything into where it should be --- the ROOMS folders.

The following codes are basically putting all the textures into the array of textures.

[File](https://docs.oracle.com/javase/7/docs/api/java/io/File.html#File(java.lang.String))([String](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html) pathname)

Creates a new File instance by converting the given pathname string into an abstract pathname.

```

Resources.TEXTURES.add(Resources.FLOOR, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.STONE, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.WALL, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.TILE, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.GRASS, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.PLAYER\_2, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.PLAYER\_LEFT, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.PLAYER\_BACK, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.PLAYER\_BACK\_2, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.PLAYER\_LEFT\_2, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.PLAYER\_RIGHT, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.PLAYER\_RIGHT\_2, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.STAIRS, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.ARMOR, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.HEART, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.ATTACK, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.CHEST, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.GOLD, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.ENEMY, ImageIO.read(new File("res/textures/floor.png")));

Resources.TEXTURES.add(Resources.ENEMY\_2, ImageIO.read(new File("res/textures/floor.png")));

```

For the IOException in the catch block, it&#39;s explained in here:

[https://stackoverflow.com/questions/5819121/understanding-java-ioexception](https://stackoverflow.com/questions/5819121/understanding-java-ioexception)

What it does is basically catching all the exceptions that might appear in one line.

```

catch (IOException e) {

e.printStackTrace();

```

This is auto-filled by IDE

For printStackTrace, this link here explains it well:

[https://www.educative.io/edpresso/what-is-the-printstacktrace-method-in-java](https://www.educative.io/edpresso/what-is-the-printstacktrace-method-in-java)

It basically just helps you print out the error messages in a clean and organized way.

## Utils

## MathHelper

As what it said, this class is to help other classes do some math.

```

public static int randomInt(int upperBound) {

return rand.nextInt(upperBound);

}

```

java.util.Random.nextInt() : The nextInt() is used to get the next random integer value from this random number generator&#39;s sequence.

The nextInt(int n) is used to get a random number between 0(inclusive) and the number passed in this argument(n), exclusive.

**```**

public static int randomInt(int lowerBound, int upperBound) {

return rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;

}

**```**

**I do this for the random number generator of the looting chest.**

**I learned and used enum class:**

[**https://www.w3schools.com/java/java\_enums.asp#:~:text=An%20enum%20is%20a%20special,the%20constants%20with%20a%20comma**](https://www.w3schools.com/java/java_enums.asp#:~:text=An%20enum%20is%20a%20special,the%20constants%20with%20a%20comma)

**This Direction Class is designed for Enemy&#39;s movements..**

**```**

public enum Direction {

NORTH(0, -1),

SOUTH(0, 1),

WEST(-1, 0),

EAST(1, 0);

public int dirX;

public int dirY;

public Direction opposite;

static {

NORTH.opposite = SOUTH;

SOUTH.opposite = NORTH;

WEST.opposite = EAST;

EAST.opposite = WEST;

}

private Direction(int dirX, int dirY) {

this.dirX = dirX;

this.dirY = dirY;

}

**```**

## _Game_

## Entity

What Entity does here is to be a superclass for both enemy class and player class. According to what I learned from APCSA Barrons prep book, subclass is-a superclass. Since enemy and player are entities with similar manners, why not design a superclass for them. And also, this is what most source codes write at this point.

(Not finished yet.)

# **Process Summary**

- I started this project with some tutorials and sample codes to guide me through the process. And it&#39;s hard to process the hard cold chunks of code from the sample code in my mind, but it&#39;s also too long to start learning the graphics from scratch. This leads to the result that at the end of January the project is still in process.
- I got stuck at the world generation algorithm and how to convert the algorithm into the real things like a map generation. I figured it out a little bit while I was doing my second project, but it&#39;s still more complicated than I think. The challenging parts were basically everywhere, only when creating the textures makes me feel better because it&#39;s fun and easy to do. And I couldn&#39;t understand the state&#39;s design and the usage of stacks, which led me to rack my brain. I succeeded in creating the framework of this project, it&#39;s the first thing I did in the project, but it takes most of the time. I am most proud of the textures, I made most of them by myself. (welp, although it&#39;s drawn by raw strokes and pixels.)
- If I would continue on this project, the next step would be to implement other classes that are unfinished. There are still a lot though, and a lot to process. I may even restart the project just because the current state of the game makes the situation more and more complicated.
 
