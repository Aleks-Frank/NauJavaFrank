package org.example;

public class WorkingWithArrays {

    public void showTaskOne(int n) {
        int[] arr = createArrayRandomTaskOne(n);
        showArray(arr);
        System.out.println(getLastPositiveNum(arr));

    }

    /* Создаем массив с рандомными значениями длинной n
     * на вход падается длинна массива
     * создается массив и с помощь цикла присваивает каждому элементу значения
     * с помощью функции Math.random в диапозоне от -100 до 100
     * и возвращает массив */
    public int[] createArrayRandomTaskOne(int n){
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*200-100);
        }
        return arr;
    }

    /* Метод ищит последние положительное значение в массиве
     * на вход подается массив
     * с поомщью цикла мы идем от последнего элемента до первого в массиве
     * с поомщью условия проверяе числа, если нашли первое положительно,
     * то возвращаем его. Если число не найдено (в массиве нет положительных чисел), то -1 */
    public int getLastPositiveNum(int[] arr){
        for(int i = arr.length-1; i >= 0; i--){
            if (arr[i] > 0){
                return arr[i];
            }
        }

        return -1;
    }

    /* Выводит элементы списка в консоль*/
    public void showArray(int[] arr){
        for(int i : arr){
            System.out.println(i);
        }
    }

}
