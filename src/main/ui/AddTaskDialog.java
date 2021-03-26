//package ui;
//
//import model.Task;
//import model.ToDoList;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class AddTaskDialog extends JDialog {
//    final int width = 700;
//    final int height = 700;
//    private ToDoList toDoList;
//
//    public AddTaskDialog(JFrame jf, String title, boolean isModel) {
//        super(jf, title, isModel);
//        toDoList = new ToDoList();
//
//        //组装视图
//        this.setLocation(200, 200);
//
//        Box box = Box.createVerticalBox();
//        //组装task
//        Box taskBox = Box.createHorizontalBox();
//        JLabel taskLabel = new JLabel("Task");
//        JTextField taskField = new JTextField(7);
//        taskBox.add(taskLabel);
//        taskBox.add(Box.createHorizontalStrut(20));
//        taskBox.add(taskField);
//
//        //组装State
//
//        Box stateBox = Box.createHorizontalBox();
//        JLabel stateLabel = new JLabel("State");
//        JTextField stateField = new JTextField(7);
//        stateBox.add(stateLabel);
//        stateBox.add(Box.createHorizontalStrut(20));
//        stateBox.add(stateField);
//
//        //组装按钮
//
//        Box buttonBox = Box.createHorizontalBox();
//        JButton addButton = new JButton("Add Task");
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //get input
//                String task = taskField.getText().trim();
//                String state = stateField.getText().trim();
//                Task t = new Task(task, state);
//                toDoList.addTask(t);
//                dispose();
//
//            }
//        });
//        buttonBox.add(addButton);
//
//        //add together
//        box.add(Box.createVerticalStrut(20));
//        box.add(taskBox);
//        box.add(Box.createVerticalStrut(20));
//        box.add(stateBox);
//        box.add(Box.createVerticalStrut(20));
//        box.add(buttonBox);
//
//        Box spaceBox = Box.createHorizontalBox();
//        spaceBox.add(Box.createHorizontalStrut(70));
//        spaceBox.add(box);
//        spaceBox.add(Box.createHorizontalStrut(70));
//
//        this.add(spaceBox);
//
//
//    }
//
//}
