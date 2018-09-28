package com.quynhnv26.lesson14.bms01.model;

import com.quynhnv26.lesson14.bms01.manager.ImageStore;
import com.quynhnv26.lesson14.bms01.manager.ManagerMapItem;
import com.quynhnv26.lesson14.bms01.view.Gui;
import com.sun.xml.internal.ws.api.pipe.ServerTubeAssemblerContext;

import java.awt.*;

public class Tank extends BaseItem {
    public static final int SIZE = 2 * MapItem.SIZE;
    public static final int LEFT = 0;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;

    private int direction;

    public Tank(int x, int y, int direction) {
        this.direction = direction;
        this.x = x;
        this.y = y;
        rectangle = new Rectangle(x, y, SIZE, SIZE);
    }

    public void draw(Graphics2D graphics2D) {
        switch (direction) {
            case LEFT:
                graphics2D.drawImage(ImageStore.IMG_TANK_LEFT, x, y, SIZE, SIZE, null);
                break;

            case RIGHT:
                graphics2D.drawImage(ImageStore.IMG_TANK_RIGHT, x, y, SIZE, SIZE, null);
                break;

            case UP:
                graphics2D.drawImage(ImageStore.IMG_TANK_UP, x, y, SIZE, SIZE, null);
                break;

            case DOWN:
                graphics2D.drawImage(ImageStore.IMG_TANK_DOWN, x, y, SIZE, SIZE, null);
                break;

            default:
                break;
        }
    }

    public void move() {
        if (direction == RIGHT) {
            x++;
            rectangle.setLocation(x + 1, y);
        } else if (direction == LEFT) {
            x--;                                    // x-- la thay doi gia tri x, x-1 = gtri thoi
            rectangle.setLocation(x - 1, y);
        } else if (direction == UP) {
            y--;
            rectangle.setLocation(x, y - 1);
        } else if (direction == DOWN) {
            y++;
            rectangle.setLocation(x, y + 1);
        }
    }

    // va cham thi xu li o manager
    // trong 1 thoi diem bat nhieu phim


    public void setDirection(int direction) {
        this.direction = direction;
        if (direction == RIGHT) {
            rectangle.setLocation(x + 1, y);
        } else if (direction == LEFT) {
            rectangle.setLocation(x - 1, y);
        } else if (direction == UP) {
            rectangle.setLocation(x, y - 1);
        } else if (direction == DOWN) {
            rectangle.setLocation(x, y + 1);
        }
    }

    public int getDirection() {
        return direction;
    }
}
