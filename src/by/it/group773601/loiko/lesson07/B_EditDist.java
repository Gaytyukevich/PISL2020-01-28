package loiko.lesson07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Задача на программирование: расстояние Левенштейна
    https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
    http://planetcalc.ru/1721/

Дано:
    Две данных непустые строки длины не более 100, содержащие строчные буквы латинского алфавита.

Необходимо:
    Решить задачу МЕТОДАМИ ДИНАМИЧЕСКОГО ПРОГРАММИРОВАНИЯ
    Итерационно вычислить расстояние редактирования двух данных непустых строк

    Sample Input 1:
    ab
    ab
    Sample Output 1:
    0

    Sample Input 2:
    short
    ports
    Sample Output 2:
    3

    Sample Input 3:
    distance
    editing
    Sample Output 3:
    5

*/

public class B_EditDist {


    int calculate(String s1, String s2){
        int[][]D = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++) {
                if (i == 0){
                    D[i][j] = j;
                }
                else if (j == 0){
                    D[i][j] = i;
                }
                else {
                    int count = costOfSubstitution(s1.charAt(i-1),s2.charAt(j-1));
                    D[i][j] = min(D[i-1][j-1] + count, D[i-1][j]+1, D[i][j-1]+1);
                }
            }
        }
        return D[s1.length()][s2.length()];
    }

    private int costOfSubstitution(char a, char b) {
        return a==b ? 0 : 1;
    }

    private int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }

    int getDistanceEdinting(String one, String two) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return calculate(one, two);
    }



    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson07/dataABC.txt");
        B_EditDist instance = new B_EditDist();
        Scanner scanner = new Scanner(stream);
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
        System.out.println(instance.getDistanceEdinting(scanner.nextLine(),scanner.nextLine()));
    }

}
