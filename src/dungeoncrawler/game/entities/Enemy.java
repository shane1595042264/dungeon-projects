package dungeoncrawler.game.entities;

import dungeoncrawler.framework.utils.MathHelper;
public class Enemy extends Entity{
    private static final long serialVersionUID = 1L;
    private Player target;// aim player as target
    private int hp;

    public Enemy(byte id, int health, Player target);

}
