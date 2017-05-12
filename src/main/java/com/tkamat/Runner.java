package com.tkamat;

import com.tkamat.ui.GUI2048;

import javax.swing.SwingUtilities;

import com.tkamat.game.Board2048;

/**
 * Runs 2048 game
 *
 * @author Tushaar Kamat
 */
public class Runner {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    final GUI2048 ui = new GUI2048("2048");
                }
            });
    }
}
