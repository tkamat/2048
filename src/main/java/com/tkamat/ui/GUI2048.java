package com.tkamat.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

import com.tkamat.game.Board2048;

/**
 * UI for 2048 game
 *
 * @author Tushaar Kamat
 */
public class GUI2048 extends JFrame {

    private HashMap<Integer, Color> colorMap;
    private Board2048 board;
    private JLabel[][] tiles;

    /**
     * Constructor for GUI class.
     */
    public GUI2048(String name) {
        super(name);

        this.initiaizeColorMap();
        board = new Board2048();

        tiles = createTiles();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                panel.add(tiles[i][j]);
            }
        }

        panel.getInputMap().put(KeyStroke.getKeyStroke("H"), "moveLeft");
        panel.getActionMap().put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.moveLeft();
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles.length; j++) {
                        if (board.getBoard()[i][j] > 0) {
                            tiles[i][j].setText("" + board.getBoard()[i][j]);
                        }
                        else {
                            tiles[i][j].setText("");
                        }
                        tiles[i][j].setBackground(colorMap.get(new Integer(board.getBoard()[i][j])));
                    }
                }
            }

        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("L"), "moveRight");
        panel.getActionMap().put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.moveRight();
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles.length; j++) {
                        if (board.getBoard()[i][j] > 0) {
                            tiles[i][j].setText("" + board.getBoard()[i][j]);
                        }
                        else {
                            tiles[i][j].setText("");
                        }
                        tiles[i][j].setBackground(colorMap.get(new Integer(board.getBoard()[i][j])));
                    }
                }
            }
        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("K"), "moveUp");
        panel.getActionMap().put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.moveUp();
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles.length; j++) {
                        if (board.getBoard()[i][j] > 0) {
                            tiles[i][j].setText("" + board.getBoard()[i][j]);
                        }
                        else {
                            tiles[i][j].setText("");
                        }
                        tiles[i][j].setBackground(colorMap.get(new Integer(board.getBoard()[i][j])));
                    }
                }
            }

        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("J"), "moveDown");
        panel.getActionMap().put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.moveDown();
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles.length; j++) {
                        if (board.getBoard()[i][j] > 0) {
                            tiles[i][j].setText("" + board.getBoard()[i][j]);
                        }
                        else {
                            tiles[i][j].setText("");
                        }
                        tiles[i][j].setBackground(colorMap.get(new Integer(board.getBoard()[i][j])));
                    }
                }
            }
        });
        panel.getInputMap().put(KeyStroke.getKeyStroke("R"), "restart");
        panel.getActionMap().put("restart", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                board.clearBoard();
                board.assignStartingNumbers(Board2048.getRandomPoint(), Board2048.getRandomPoint());
                for (int i = 0; i < tiles.length; i++) {
                    for (int j = 0; j < tiles.length; j++) {
                        if (board.getBoard()[i][j] > 0) {
                            tiles[i][j].setText("" + board.getBoard()[i][j]);
                        }
                        else {
                            tiles[i][j].setText("");
                        }
                        tiles[i][j].setBackground(colorMap.get(new Integer(board.getBoard()[i][j])));
                    }
                }
            }
            });

        this.setSize(700, 700);
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JLabel[][] createTiles() {
        JLabel[][] tiles = new JLabel[Board2048.BOARD_SIZE][Board2048.BOARD_SIZE];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                tiles[i][j] = new JLabel("", SwingConstants.CENTER);
                tiles[i][j].setFont(new Font("Helvetica", Font.BOLD, 72));
                tiles[i][j].setBackground(Color.LIGHT_GRAY);
                tiles[i][j].setOpaque(true);
                if (board.getBoard()[i][j] > 0) {
                    tiles[i][j].setText("" + board.getBoard()[i][j]);
                }
                tiles[i][j].setBackground(colorMap.get(new Integer(board.getBoard()[i][j])));
            }
        }
        return tiles;
    }

    private void initiaizeColorMap() {
        colorMap = new HashMap<Integer, Color>();
        colorMap.put(new Integer(0), Color.LIGHT_GRAY);
        colorMap.put(new Integer(2), new Color(239, 190, 110));
        colorMap.put(new Integer(4), new Color(232, 148, 11));
        colorMap.put(new Integer(8), new Color(132, 83, 2));
        colorMap.put(new Integer(16), new Color(209, 244, 66));
        colorMap.put(new Integer(32), new Color(147, 181, 10));
        colorMap.put(new Integer(64), new Color(239, 115, 91));
        colorMap.put(new Integer(128), new Color(239, 73, 40));
        colorMap.put(new Integer(256), new Color(239, 11, 65));

    }

}
