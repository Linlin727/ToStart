//package ui;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class MainGUI {
//    JFrame jf = new JFrame("ToStart App");
//    final int width = 1000;
//    final int height = 700;
//
//
//    public static void createAndShowGUI() {
//        //设置窗口属性
//        final int width = 1000;
//        final int height = 700;
//        JFrame jf = new JFrame("ToStart App");
//        jf.setVisible(true);
//        jf.setSize(width,height);
//        jf.setBackground(new Color(203, 220, 217));
//        jf.setResizable(false);
//        jf.setLocation(200,200);
//
//        //设置菜单栏
//        JMenuBar menuBar = new JMenuBar();
//        JMenu menu = new JMenu("Quit");
//        JMenuItem menuItem = new JMenuItem("Quit ToStart App");
//        menuItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
//            }
//        });
//        menu.add(menuItem);
//        menuBar.add(menu);
//        jf.setJMenuBar(menuBar);
//
//        jf.add(new Render(jf));
//
//
//
//    }
//
//    public static void main(String[] args) {
//        //Schedule a job for the event-dispatching thread:
//        //creating and showing this application's GUI.
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//}
