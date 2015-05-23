package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.world.type.BlockType;
import view.GameBoard;
import view.GameFrame;
import view.Tile;

/**
 * Created by Project on 5/14/2015.
 */
public class Main
{
    public static GameFrame frame;
    public static GameBoard board;
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

                    board = new GameBoard(35);
                    initGame(board);

                    frame.getContentPane().add(board, BorderLayout.CENTER);
                    frame.pack();


                }
            }
                );
    }

    public static void initGame(GameBoard board)
    {
        board.setPreferredSize(new Dimension(350, 350));
        board.setBackground(Color.BLUE);
        Tile tile1 = new Tile(BlockType.PLAIN, board);
        board.add(tile1, 0);
    }
}
