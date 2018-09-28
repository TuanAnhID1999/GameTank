package com.quynhnv26.lesson14.bms01.manager;

import javax.swing.*;
import java.awt.*;

public class ImageStore {
    public static final Image IMG_BRICK = getPicture("/res/drawable/brick.png");
    public static final Image IMG_BOSS = getPicture("/res/drawable/boss.png");
    public static final Image IMG_ROCK = getPicture("/res/drawable/rock.png");
    public static final Image IMG_WATER = getPicture("/res/drawable/water.png");
    public static final Image IMG_TREE = getPicture("/res/drawable/tree.png");

    public static final Image IMG_TANK_RIGHT = getPicture("/res/drawable/tank_right.png");
    public static final Image IMG_TANK_LEFT  = getPicture("/res/drawable/tank_left.png");
    public static final Image IMG_TANK_UP  = getPicture("/res/drawable/tank_up.png");
    public static final Image IMG_TANK_DOWN  = getPicture("/res/drawable/tank_down.png");


    private static Image getPicture(String path){
        return new ImageIcon(ImageStore.class.getResource(path)).getImage();
    }
}
