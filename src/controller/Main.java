package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.gameHelper.GameState;
import model.world.generator.Maze;
import model.world.type.BlockType;
import view.GameBoard;
import view.GameFrame;
import view.Tile;

/**
 * Created by Project on 5/14/2015.
 */
public class Main
{
    public static GameState state;
    public static GameFrame frame;
    public static GameBoard board;
    public static ArrayList<Tile> tileset;
    public static int width;
    public static int height;
    public static char pionCounter = 3;
    public static int rootID = -1;


    public static void main(String[] args)
    {
        SwingUtilities.invokeLater
                (() -> {
                {
                    try
                    {
                        // Set cross-platform Java L&F (also called "Metal")
                        UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
                    } catch (UnsupportedLookAndFeelException e)
                    {
                        // handle exception
                    } catch (ClassNotFoundException e)
                    {
                        // handle exception
                    } catch (InstantiationException e)
                    {
                        // handle exception
                    } catch (IllegalAccessException e)
                    {
                        // handle exception
                    }
                    frame = new view.GameFrame();
                    Main.frame.setVisible(Boolean.TRUE);

                    board = new GameBoard(25);
                    initGame(board);

                    frame.getContentPane().add(board, BorderLayout.CENTER);
                    frame.pack();
                }
                });
        new Thread(() -> {
            while (true)
            {
                System.out.printf("%3d %3d\r", (int) Main.pionCounter, Main.rootID);
                try
                {
                    Thread.sleep(50);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void initGame(GameBoard board)
    {
        Maze maze = new Maze();
        maze.generateWorld(5, 5);
        ArrayList<ArrayList<BlockType>> tmp = maze.getWorld();

        Main.width = tmp.get(0).size();
        Main.height = tmp.size();

        board.setPreferredSize(new Dimension(Main.width * board.getTileSize(), Main.height * board.getTileSize()));


        Main.tileset = new ArrayList<>(Main.width * Main.height);

        for (int i = 0; i < tmp.size(); ++i)
        {
            for (int j = 0; j < tmp.get(i).size(); ++j)
            {
                Main.tileset.add((i * tmp.size()) + j, new Tile(tmp.get(i).get(j), board, (i * tmp.size()) + j));
                board.add(Main.tileset.get((i * tmp.size()) + j), (i * tmp.size()) + j);
                Main.tileset.get((i * tmp.size()) + j).setLocation(j * board.getTileSize(), i * board.getTileSize());

            }
        }

        tmp.clear();
        tmp = null;
        maze = null;
    }
}
