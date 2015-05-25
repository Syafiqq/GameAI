package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.gameHelper.GameState;
import model.world.generator.Maze;
import model.world.generator.Obstacle;
import model.world.type.BlockType;
import model.world.type.ObstacleSpread;
import view.Controller;
import view.Debugger;
import view.GameBoard;
import view.GameFrame;
import view.Tile;

/**
 * Created by Project on 5/14/2015.
 */

public class Main
{
    public static GameState state = GameState.PLACEOBSTACLE;;
    public static GameFrame frame;
    public static GameBoard board;
    public static Controller control;
    public static ArrayList<Tile> tileset;
    public static model.gameHelper.Dimension dimension;
    public static char pionCounter;
    public static int rootID;
    public static Debugger debugger;


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

                    debugger = new Debugger();
                    debugger.setVisible(true);

                    Main.dimension  = new model.gameHelper.Dimension();
                    state = GameState.PLACEOBSTACLE;

                    frame = new view.GameFrame();
                    Main.frame.setVisible(Boolean.TRUE);
                    Main.frame.setSize(800, 600);

                    control = new Controller();
                    frame.getContentPane().add(control, BorderLayout.EAST);

                    board = new GameBoard(25);
                    //initGame(board);

                    //frame.getContentPane().add(board, BorderLayout.CENTER);
                    ((JScrollPane)((BorderLayout)frame.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).setViewportView(board);
                    frame.pack();
                    state = GameState.PLACEOBSTACLE;


                }
                });

       new Thread(() -> {

            while (true)
            {
                //System.out.printf("%3d %3d\r", (int) Main.pionCounter, Main.rootID);
                //System.out.printf("%20s\r", state.toString());

                try
                {
                    debugger.textArea1.setText(Main.getLinkage());
                } catch (NullPointerException ignore)
                {
                }
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

    public static void initGame(GameBoard board, ArrayList<ArrayList<BlockType>> tmp )
    {
        try
        {
            Main.tileset.clear();
        } catch (NullPointerException ignore)
        {
        }

        board.removeAll();


        Main.dimension.setX(tmp.get(0).size());
        Main.dimension.setY(tmp.size());

        board.setPreferredSize(new Dimension(Main.dimension.getX() * board.getTileSize(), Main.dimension.getY() * board.getTileSize()));


        Main.tileset = new ArrayList<>(Main.dimension.getX() * Main.dimension.getY());


        for (int i = 0; i < tmp.size(); ++i)
        {
            for (int j = 0; j < tmp.get(i).size(); ++j)
            {
                Main.tileset.add((i * tmp.get(i).size()) + j, new Tile(tmp.get(i).get(j), board, (i * tmp.get(i).size()) + j));
                board.add(Main.tileset.get((i * tmp.get(i).size()) + j), (i * tmp.get(i).size()) + j);
                Main.tileset.get((i * tmp.get(i).size()) + j).setLocation(j * board.getTileSize(), i * board.getTileSize());
            }
        }



        tmp.clear();
        tmp = null;
        generateLinkage();
        board.repaint();
        Main.pionCounter = 3;
        Main.rootID = -1;

        ((JScrollPane)((BorderLayout)Main.frame.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).repaint();
        ((JScrollPane)((BorderLayout)Main.frame.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).revalidate();
    }

    private static void generateLinkage()
    {
        for(int i = 0; i < Main.tileset.size(); ++i)
        {
            Main.tileset.get(i).generateLinkage();
        }
    }

    public  static String getLinkage()
    {
        String a = "";
        for(int i = 0; i < Main.tileset.size(); ++i)
        {
            if(i % Main.dimension.getX() == 0)
            {
                a += String.format("\n%d ", Main.tileset.get(i).getLinkageSize());
            }
            else
            {
                a += String.format(" %d ", Main.tileset.get(i).getLinkageSize());
            }
        }
        return a;
    }
}
