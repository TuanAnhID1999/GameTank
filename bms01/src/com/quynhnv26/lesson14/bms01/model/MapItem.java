package com.quynhnv26.lesson14.bms01.model;

import com.quynhnv26.lesson14.bms01.manager.ImageStore;

import java.awt.*;

public class MapItem extends BaseItem {
    //    private int x;
//    private int y;
    private int type;
    public static final int SIZE = 20;
    public static final int TYPE_BRICK = 1;
    public static final int TYPE_BOSS = 9;
    public static final int TYPE_WATER = 2;
    public static final int TYPE_ROCK = 5;
    public static final int TYPE_TREE = 4;

    public MapItem(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;

        if (type == TYPE_BOSS) {
            rectangle = new Rectangle(x, y, 2 * SIZE, 2 * SIZE);
        } else {
            rectangle = new Rectangle(x, y, SIZE-2, SIZE-2);        // SIZE-2 de noi' rong khoang gtri de Tank co the di vao loi
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics2D graphics2D) {
        switch (type) {
            case TYPE_BRICK:
                graphics2D.drawImage(ImageStore.IMG_BRICK, x, y, SIZE, SIZE, null);
                break;
            case TYPE_WATER:
                graphics2D.drawImage(ImageStore.IMG_WATER, x, y, SIZE, SIZE, null);
                break;
            case TYPE_TREE:
                graphics2D.drawImage(ImageStore.IMG_TREE, x, y, SIZE, SIZE, null);
                break;
            case TYPE_ROCK:
                graphics2D.drawImage(ImageStore.IMG_ROCK, x, y, SIZE, SIZE, null);
                break;
            case TYPE_BOSS:
                graphics2D.drawImage(ImageStore.IMG_BOSS, x, y, 2 * SIZE, 2 * SIZE, null);
                break;
            default:
                break;
        }
    }

}
