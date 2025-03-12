package org.example;

import java.util.ArrayList;

public class WorkingWithList {

    /* Метод, который меняет 2 значения в списке по индексу
    * на вход дается лист со значениями, которые нужно менять
    * и 2 индекса чисел, которые надо поменять.
    * Создается переменная, в которую сохраняется значение по 2 индексу,
    * в яцейку со 2 индексем записывается значение из 1 индекса
    * в ячейку с 1 индексом записывается значение переменной*/
    public void swapPlaces(ArrayList<Double> list, int indexOne, int indexTwo){
        double tempValue = list.get(indexTwo);
        list.set(indexTwo, list.get(indexOne));
        list.set(indexOne, tempValue);
    }

    /* Сортировка выборкой: идея в том, что мы проходим по массиву
    * и наименьшие элементы меняется с начальным элементм
    * Проходимся по массиву*/
    public void selectionSort(ArrayList<Double> list){
        for(int left = 0; left < list.size(); left++){
            int minValueIndex = left;
            for(int i = left; i < list.size(); i++){
                if(list.get(i) < list.get(minValueIndex)){
                    minValueIndex = i;
                }
            }
            swapPlaces(list, left, minValueIndex);
        }
    }

    public ArrayList<Double> createArrayListRandom(int n){
        ArrayList<Double> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add((double) (Math.round(Math.random()*200-100))/100 + Math.round(Math.random()*200-100));
        }
        return list;
    }

    public void sortedTest(int n){
        ArrayList<Double> list = createArrayListRandom(n);
        selectionSort(list);
        System.out.println(list);
    }

}
