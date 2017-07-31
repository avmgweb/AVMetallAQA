package POM.classes;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Дмитрий on 18.07.2017.
 */
public class FunctionBase {
    public static String generateRandomNumber(int col){
        if (col<=0) return "";
        Random random = new Random();
        int[] arr = new int[col];
        for (int i=0; i<= arr.length-1; i++){
            arr[i] = random.nextInt(10);
        }
        String rand =  Arrays.toString(arr).replace(",","").replace("[", "").replace(" ","").replace("]","");
        return rand;
    }

    public static String generateRandomChars(int col) {
        if (col <= 0) return "";
        Random random = new Random();
        char[] arr = new char[col];
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = (char) (random.nextInt(26) + 'a');
        }
        String rand = Arrays.toString(arr).replace(",", "").replace("[", "").replace(" ", "").replace("]", "");
        return rand;
    }

    public static String  getRandomTown() {
        String[] transaction = {"Днепр", "Львов", "Киев", "Кривой Рог", "Харьков", "Одесса", "Ужгород", "Луцк", "Донецк", "Винница"};
        int a = (int) (Math.random() * 10);
        return transaction[a];
    }

    public static String  getRandomLegalStatus() {
        return "СПД (ФЛП)";
    }

    public static String  getRandomMail() {
        String mail = "username"+ generateRandomNumber(4) +"@gmail.com";
        return mail;
    }

    public static String  getRandomFileName() {
        String mail = "file"+ generateRandomNumber(6) + ".txt";
        return mail;
    }



}
