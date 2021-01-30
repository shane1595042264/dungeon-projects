package dungeoncrawler.game.entities;
import java.awt.Graphics;
import java.awt.Rectangle;

import dungeoncrawler.framework.resources.
import dungeoncrawler.framework.utils.MathHelper;

public class Entity extends Rectangle{
    private static final long serialVersionUID = 1L;

    protected byte entityID;

    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;

    protected int speed;
    protected MathHelper.Direction facing; // a blank variable

}
