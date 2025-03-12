package org.example.Interface;

import java.util.LinkedList;

public class TaskQueue implements Task {

    private final LinkedList<String> queue = new LinkedList<>();
    private Boolean isStart = true;
    private int count = 0;

    @Override
    public void start() {
        System.out.println("Start");
        isStart = true;
        while (isStart){
            if (!queue.isEmpty()){
                String data = queue.poll();
                System.out.println(data + " покинуло очередь");
            } else {
                stop();
            }
        }
    }

    @Override
    public void stop() {
        isStart = false;
        System.out.println("Stop");
    }

    public void addTask(String data){
        queue.add(data);
    }

    public String createTask(){
        return String.format("Задание №%d",count);
    }

    public void testCreateTask(){
        for(int i = 0; i <= 10; i++){
            addTask(createTask());
            System.out.println(createTask() + " дабавлено в очередь");
            count++;

        }
    }

}
