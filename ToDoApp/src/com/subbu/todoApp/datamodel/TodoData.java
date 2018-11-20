package com.subbu.todoApp.datamodel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Subbu
 */
public class TodoData{
    private static TodoData instance = new TodoData();
    private List<TodoItem> todoItems;

    public static TodoData getInstance() {
        return instance;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void loadTodoItems(String filename) throws IOException {
        todoItems = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;
        try {
            while ((input = br.readLine()) != null) {
                TodoItem todoItem = new TodoItem(input,1,"25-Jan-2018");
                todoItems.add(todoItem);
            }
        } finally {
            if(br != null) {
                br.close();
            }
        }
    }

}
