package com.quynhnv26.lesson14.bms01.view;

import com.quynhnv26.lesson14.bms01.manager.ManagerMapItem;
import com.quynhnv26.lesson14.bms01.model.MapItem;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame implements IViewinitializer {
    public static final int WIDTH_FRAME = ManagerMapItem.COLUMN * MapItem.SIZE;
    public static final int HEIGHT_FRAME =  ManagerMapItem.ROW * MapItem.SIZE;

    public Gui() {
        initContainer();
        initComponent();
        registerListener();
    }

    @Override
    public void initContainer() {
        setTitle("Tank_90");

        Image icon = new ImageIcon(Gui.class.getResource("/res/drawable/tank_right.png")).getImage();
        setIconImage(icon);

        setLayout(new CardLayout());
//        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        getContentPane().setPreferredSize(new Dimension(WIDTH_FRAME,HEIGHT_FRAME));         // can chinh cho kich thuoc frame vua bang kich thuoc map
        setResizable(false);
        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private GamePanel gamePanel;

    @Override
    public void initComponent() {
        gamePanel = new GamePanel();
        add(gamePanel);

        gamePanel.startGame();

    }

    @Override
    public void registerListener() {

    }
}
