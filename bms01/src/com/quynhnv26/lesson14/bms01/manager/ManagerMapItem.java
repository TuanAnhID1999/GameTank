package com.quynhnv26.lesson14.bms01.manager;

import com.quynhnv26.lesson14.bms01.model.MapItem;
import com.quynhnv26.lesson14.bms01.model.Tank;

import javax.swing.text.TabableView;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ManagerMapItem {
    public static final int ROW = 29;
    public static final int COLUMN = 28;

    private ArrayList<MapItem> items;
    private ArrayList<MapItem> water;
    private ArrayList<MapItem> trees;
    private Tank myTank;

    public ManagerMapItem() {
        items = new ArrayList<>();
        water = new ArrayList<>();
        trees = new ArrayList<>();
        myTank = new Tank(100, 100, Tank.UP);
    }

    public void generateMap() {
        try {
            String path = ManagerMapItem.class.getResource("/res/assets/newMap.txt").getPath();
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            for (int i = 0; i < ROW; i++) {
                String line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    int type = line.charAt(j) - 48;
                    if (type != 0) {
                        int x = MapItem.SIZE * j;
                        int y = MapItem.SIZE * i;
                        MapItem mapItem = new MapItem(x, y, type);

                        switch (type) {
                            case MapItem.TYPE_BRICK:
                            case MapItem.TYPE_BOSS:
                            case MapItem.TYPE_ROCK:
                                items.add(mapItem);
                                break;

                            case MapItem.TYPE_TREE:
                                trees.add(mapItem);
                                break;

                            case MapItem.TYPE_WATER:
                                water.add(mapItem);
                                break;

                            default:
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void drawItems(Graphics2D graphics2D) {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).draw(graphics2D);
        }
    }

    public void drawWater(Graphics2D graphics2D) {
        for (int i = 0; i < water.size(); i++) {
            water.get(i).draw(graphics2D);
        }
    }

    public void drawTrees(Graphics2D graphics2D) {
        for (int i = 0; i < trees.size(); i++) {
            trees.get(i).draw(graphics2D);
        }
    }

    public void drawMyTank(Graphics2D graphics2D) {
        myTank.draw(graphics2D);
    }

    public void changeMyTankDirection(int direction) {
        if (myTank.getDirection() != direction) {
            myTank.setDirection(direction);             // khi thay doi huong thi moi doi direction
        }
    }

    public void moveMyTank() {               // va cham xu li o day
        if (isMyTankCanMove()) {
            myTank.move();

        }

    }

    private boolean isMyTankCanMove() {                // kiem tra xem neu tank du dieu kien di => moi cho di
        if (isMyTankCollisionWater() || isMyTankCollisionItem()) {
            return false;
        }         // return thi thoqat khoi chg trinh luon
        return true;
    }

    /**
     * chu thich code tai day
     *
     * @return
     */
    private boolean isMyTankCollisionItem() {      // kiem tra Tank co va cham vao item nao khong?     // tree k can kiem tra va cham
        // TODO
        for (int i = 0; i < items.size(); i++) {
            if (isMyTankCollision(items.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isMyTankCollisionWater() {
        for (int i = 0; i < water.size(); i++) {
            if (isMyTankCollision(water.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isMyTankCollision(MapItem mapItem) {
        // rectangle luon kiem tra tank co va cham vs item j khong? kiem tra truoc 1 pixcel => neu rectangle day va cham => k cho di
        if(myTank.getRectangle().intersects(mapItem.getRectangle())){
            return true;
        }
        return false;
        // inserct = > chi can cham 2 hinh => la va cham
        // intersertion tra ve retangle. => pacman => kiem tra neu giao nhau (tra ve 1 hinh chu nhat) tra ve width = 50 (vd, do minh quy dinh) => coi la va cham
    }

}
