package com.quynhnv26.lesson14.bms01.view;

import com.quynhnv26.lesson14.bms01.manager.ManagerMapItem;
import com.quynhnv26.lesson14.bms01.model.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;

public class GamePanel extends BasePanel {
    private ManagerMapItem managerMapItem;
    private BitSet bitSet;
    private KeyAdapter keyAdapter;

    public GamePanel() {
    }

    @Override
    public void initContainer() {
        setBackground(Color.BLACK);
        setFocusable(true);
    }

    @Override
    public void initComponent() {
        managerMapItem = new ManagerMapItem();
        managerMapItem.generateMap();

        bitSet = new BitSet();    // chua 256 o nho de luu tru data
        keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                bitSet.set(e.getKeyCode(), true);        // e.getKeyCode() = ma ASCII (256) => bitSet cung tuong duong vi tri nvay
            }

            @Override
            public void keyReleased(KeyEvent e) {
                bitSet.set(e.getKeyCode(), false);            // neu nhan phim len , code LEn trong ascii = 10 => no se duoc luu vao biSet vi tri thu 10
            }
        };
        addKeyListener(keyAdapter);

    }

    @Override
    public void registerListener() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        managerMapItem.drawMyTank(graphics2D);      // thang nao ve len truoc thi hien truoc, => trees se hien len tren tank
        managerMapItem.drawItems(graphics2D);
        managerMapItem.drawWater(graphics2D);
        managerMapItem.drawTrees(graphics2D);
    }

    public void startGame() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (bitSet.get(KeyEvent.VK_LEFT)) {           // KeyEvent.VK_LEFT = 1 so nao do trong ma ASCII, no tuong duong vi tri o nho trong bitSet
                        managerMapItem.changeMyTankDirection(Tank.LEFT);
                        managerMapItem.moveMyTank();                 // game pacman thi phai de ngoai, thi khi chuyen huong no moi di chuyen, k can giu phim
                    }
                    if (bitSet.get(KeyEvent.VK_UP)) {           // KeyEvent.VK_LEFT = 1 so nao do trong ma ASCII, no tuong duong vi tri o nho trong bitSet
                        managerMapItem.changeMyTankDirection(Tank.UP);
                        managerMapItem.moveMyTank();                 // game pacman thi phai de ngoai, thi khi chuyen huong no moi di chuyen, k can giu phim
                    }
                    if (bitSet.get(KeyEvent.VK_RIGHT)) {           // KeyEvent.VK_LEFT = 1 so nao do trong ma ASCII, no tuong duong vi tri o nho trong bitSet
                        managerMapItem.changeMyTankDirection(Tank.RIGHT);
                        managerMapItem.moveMyTank();                 // game pacman thi phai de ngoai, thi khi chuyen huong no moi di chuyen, k can giu phim
                    }
                    if (bitSet.get(KeyEvent.VK_DOWN)) {           // KeyEvent.VK_LEFT = 1 so nao do trong ma ASCII, no tuong duong vi tri o nho trong bitSet
                        managerMapItem.changeMyTankDirection(Tank.DOWN);
                        managerMapItem.moveMyTank();                 // game pacman thi phai de ngoai, thi khi chuyen huong no moi di chuyen, k can giu phim
                    }
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread backgroundThread = new Thread(runnable);
        backgroundThread.start();
    }
}
