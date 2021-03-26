package ui;

import model.Task;
import model.ToDoList;
import persistence.JsonReader;

import javax.lang.model.element.NestingKind;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

public class Render extends Box {
    JFrame jf = null;
    final int width = 700;
    final int height = 600;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/todoList.json";

    private ToDoList todoList;
    private Task task1;

    public Render(JFrame jf) {
        super(BoxLayout.Y_AXIS);
        this.jf = jf;
        JPanel panel = new JPanel();
        panel.setBackground(new Color(203, 220, 217));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton markButton = new JButton("Mark Task");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出对话框
                new AddTaskDialog(jf, "Add Task", true).setVisible(true);

            }
        });

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(markButton);

        this.add(panel);

        //组装表格
        String[] ts = {"Task", "State"};
        titles = new Vector<>();
        for (String title : ts) {
            titles.add(title);
        }

        tableData = new Vector<>();

        tableModel = new DefaultTableModel(tableData, titles);
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(table);

    }

//    public void loadData() {
//        try {
//            todoList = jsonReader.read();
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//        Vector<Vector> vectors = new Vector<>();
//        for (int i = 0; i < todoList.getSize(); i++) {
//            HashMap map = (HashMap) todoList.getTask(i
//
//    }
//
}
