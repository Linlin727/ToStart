package ui;

import javax.lang.model.element.NestingKind;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Render extends Box {
    JFrame jf = null;
    final int width = 700;
    final int height = 600;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;

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
                new AddTaskDialog(jf,"Add Task",true).setVisible(true);

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

    }
    public void requestData(){


    }

}
