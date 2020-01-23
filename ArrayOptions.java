package com.company;

import java.lang.Math;
import java.util.Scanner;

class ArrayOptions {

    private Scanner scanner = new Scanner(System.in);
    private short[] ar;

    void Menu(){

        System.out.println("////////////////////////////");

        if (ar == null) {
            System.out.println("1: Создать массив");
            System.out.println("2: Закончить программу");
        } else {
            System.out.println("1: Показать массив");
            System.out.println("2: Поменять местами значения максимального и минимального значений массива");
            System.out.println("3: Удалить из массива все числа, в которых есть цифра 7");
            System.out.println("4: Закончить программу");
        }

        System.out.println("Введите номер команды");

        switch (scanner.nextInt()){

            case 1:
                if (ar == null) COMMAND_1_1(); else COMMAND_1_2();
                Menu();
                break;

            case 2:
                if (ar == null) break; else COMMAND_2();
                Menu();
                break;

            case 3:
                COMMAND_3();
                Menu();
                break;

            case 4:
                break;

            default:
                Menu();
        }

    }

    private void COMMAND_1_1(){

        System.out.println("------------------------");
        System.out.println("Введите длину массива");
        ar = new short[scanner.nextInt()];
        System.out.println("1: Сгенерировать случайно");
        System.out.println("2: Задать вручную");
        System.out.println("Выберете способ:");

        switch (scanner.nextInt()){

            case 1:
                for (int i = 0; i<ar.length; i++){
                    ar[i] = (short) (Math.random() * 1000);
                }
                break;

            case 2:
                System.out.println("Введите элементы массива");
                for (int i = 0; i<ar.length; i++){
                    ar[i] = scanner.nextShort();
                }
                break;

            default:
                break;
        }
    }

    private void COMMAND_1_2(){

        System.out.println("------------------------");
        System.out.println("1: Отобразить слева направо");
        System.out.println("2: Отобразить справа налево");
        System.out.println("Выберете способ:");

        int cmd = scanner.nextInt();

        if (cmd == 1)
            for (int num : ar) {
                System.out.print(num + " ");
            }
        else if (cmd == 2)
            for(int i = ar.length - 1; i>=0; i--){
                System.out.print(ar[i] + " ");
            }
        System.out.print("\n");
    }

    private void COMMAND_2(){

        int ma, mi, ma_n = 0, mi_n = 0;
        short q;

        ma = ar[0];
        mi = ar[0];

        for (int i = 0; i < ar.length; i++){
            if(ar[i] < mi) {mi = ar[i]; mi_n = i;}
            if(ar[i] > ma) {ma = ar[i]; ma_n = i;}
        }

        q = ar[mi_n];
        ar[mi_n] = ar[ma_n];
        ar[ma_n] = q;

    }

    private  void COMMAND_3(){

        int num;

        for(int i = 0; i < ar.length; i++){

            num = 1;

            while ((int) (ar[i] / Math.pow(10, num)) != 0) num++;

            for (int q = 1; q <= num; q++){
                if((int) ((ar[i] / Math.pow(10, q - 1)) % 10) == 7) ar[i] = 0;
            }

        }

    }

}
