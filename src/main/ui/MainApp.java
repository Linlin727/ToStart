package ui;

import exception.InvalidUserInputException;
import model.Task;
import model.ToDoList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// CLASS EFFECTS:  Create and set up a content pane.

public class MainApp extends JPanel
        implements ListSelectionListener {

    private JList list;
    private DefaultListModel listModel;

    private ToDoList todoList;


    private static final String saveString = "Save ToStartList";
    private static final String addString = "Add Task";
    private static final String deleteString = "Delete Task";
    private static final String markString = "Mark Task";
    private JButton deleteButton;
    private JTextField task;
    private JTextField state;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/todoList.json";

    // MODIFIES: this
    // EFFECTS:  Create and set up a content pane.
    public MainApp() {
        super(new BorderLayout());
        init();
        loadTodoList();
        makeListScrollPane();

        JButton addButton = new JButton(addString);
        MainApp.AddListener addListener = new MainApp.AddListener(addButton);
        addButton.setActionCommand(addString);
        addButton.addActionListener(addListener);
        addButton.setEnabled(false);

        makeDeleteButton();

//        JButton markButton = new JButton(markString);
//        markButton = new JButton(markString);
//        markButton.setActionCommand(markString);
//        markButton.addActionListener(new MainApp.MarkListener());

        task = new JTextField(10);
        task.addActionListener(addListener);
        task.getDocument().addDocumentListener(addListener);
//        String taskName = listModel.getElementAt(
//                listModel.size() - 1).toString();

        state = new JTextField(10);
        state.addActionListener(addListener);
        state.getDocument().addDocumentListener(addListener);
//        String stateName = listModel.getElementAt(
//                listModel.size() - 1).toString();
        addMenuBar();
        makeButtonPane(addButton);


    }

    // MODIFIES: this
    // EFFECTS:  Create a button pane, and put it in the content pane.

    private void makeButtonPane(JButton addButton) {
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
        buttonPane.add(deleteButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(task);
        buttonPane.add(state);
        buttonPane.add(addButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(buttonPane, BorderLayout.PAGE_END);
    }


    // MODIFIES: this
    // EFFECTS:  Create a delete button and make it functional.

    private void makeDeleteButton() {
        deleteButton = new JButton(deleteString);
        deleteButton.setActionCommand(deleteString);
        deleteButton.addActionListener(new DeleteListener());
    }


    // MODIFIES: this
    // EFFECTS:  Create the list and a scroll pane, put the list in a scroll pane.
    // Then put the scroll pane in the content pane.

    private void makeListScrollPane() {
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
        add(listScrollPane, BorderLayout.CENTER);
    }

    // MODIFIES: this
    // EFFECTS:  Create a menu bar and put it in the content pane.

    private void addMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Quit");
        JMenuItem menuItem = new JMenuItem("Save and Quit ToStart App", new ImageIcon("data/images.png"));
        menuItem.addActionListener(new ActionListener() {
            @Override
            // EFFECTS: Stop MainApp.
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        add(menuBar, BorderLayout.NORTH);
    }


    // MODIFIES: this
    // EFFECTS:  initializes a DefaultListMode, a JsonWriter, a JsonReader, and a ToDoList
    // to be used.
    private void init() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        listModel = new DefaultListModel();
        todoList = new ToDoList();
    }


    // MODIFIES: todoList and listModel
    // EFFECTS:  load the todoList saved in json file, then add every task in the todoList to listModel

    private void loadTodoList() {
        try {
            todoList = jsonReader.read();
            Task task1 = null;
            for (int i = 0; i < todoList.getSize(); i++) {
                task1 = todoList.getTask(i);
                String s = task1.getTask() + " | " + task1.getState();
                listModel.addElement(s);
            }
        } catch (IOException e) {
            System.out.println("a");
        }


    }


    // CLASS EFFECTS: Make a listener for delete button.
    // When the delete button is clicked with valid selection,
    // the selected task is gone from the listModel and removed from the todoList.
    // Also, this modify will be saved automatically.

    class DeleteListener implements ActionListener {

        // REQUIRE: valid selection, one task is selected.
        // EFFECTS: Delete the selected task from the listModel and remove it from the todoList.
        // Also, this modify will be saved automatically.
        public void actionPerformed(ActionEvent e) {
            int index = list.getSelectedIndex();
            todoList.deleteTask(listModel.getElementAt(index).toString().split("\\s\\|\\s")[0]);
            try {
                jsonWriter.open();
                jsonWriter.write(todoList);
                jsonWriter.close();
            } catch (IOException ex) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }


            listModel.remove(index);


            int size = listModel.getSize();

            if (size == 0) { //Nobody's left, disable firing.
                deleteButton.setEnabled(false);

            } else { //Select an index.
                if (index == listModel.getSize()) {
                    //removed item in last position
                    index--;
                }

                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }


    // CLASS EFFECTS: Make a listener for add task button.
    // This listener is shared by the text field and the add task button.
    // When the add button is clicked with valid inputs,
    // new unique task will be added to the end of listModel and the todoList.
    // Also, this modify will be saved automatically.Text field will be reset.

    class AddListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }


        // EFFECTS: When the add button is clicked with valid inputs,
        // new unique task will be added to the end of listModel and the todoList.
        // Also, this modify will be saved automatically.Text field will be reset.

        public void actionPerformed(ActionEvent e) {
            String name = task.getText() + " | " + state.getText();

            if (name.equals("") || alreadyInList(name)) {
                Toolkit.getDefaultToolkit().beep();
                task.requestFocusInWindow();
                task.selectAll();
                return;
            }

            int index = list.getSelectedIndex(); //get selected index
//            if (index == -1) { //no selection, so insert at beginning
//                index = 0;
//            } else {           //add after the selected item
//                index++;
//            }
            try {
                todoList.addTask(new Task(task.getText(), state.getText()));
            } catch (InvalidUserInputException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage());;
                return;
            }

            listModel.addElement(task.getText() + " | " + state.getText());


            saveAddition();


            //Reset the text field.
            task.requestFocusInWindow();
            task.setText("");
            state.requestFocusInWindow();
            state.setText("");

            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }


        // EFFECTS:  save the todoList with the new task to json file.

        private void saveAddition() {
            try {

                jsonWriter.open();
                jsonWriter.write(todoList);
                jsonWriter.close();
            } catch (IOException ex) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }
        }

        //EFFECTS: Return true if the task is already exist.

        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }

        //EFFECTS: Enable the button if it is not already enable. Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //EFFECTS: Call the handleEmptyTextField method.Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //EFFECTS: If the text field is not empty, enable the button.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        //EFFECTS: Enable the button.

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        //EFFECTS: Return true of the text field is empty and enable the button,
        // return false otherwise
        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    // EFFECTS: when e.getValueIsAdjusting() == false, but there is no selection ,disable fire button.
    // Otherwise,enable the fire button.

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                deleteButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                deleteButton.setEnabled(true);
            }
        }
    }


    // EFFECTS: Create the GUI and show it.
    // For thread safety,this method should be invoked from the event-dispatching thread.

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ToStart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Create and set up the content pane.
        JComponent newContentPane = new MainApp();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);


        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    // CLASS EFFECTS:creating and showing ToStart App's GUI.

    public static void main(String[] args) {

        //EFFECTS:Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

