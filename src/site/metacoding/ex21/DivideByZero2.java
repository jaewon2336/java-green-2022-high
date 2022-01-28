package site.metacoding.ex21;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // InputMismatchException

        // 통신, 사용자 입력 -> 예외처리!!

        boolean check = true;
        while (check) {

            try {
                int x = sc.nextInt();
                int result = x / 0;
                System.out.println("받은 값 : " + x);
                System.out.println("결과 값 : " + result);

                check = false;
            } catch (Exception e) {
                System.out.println("===============");
                System.out.println(e.getMessage());
                System.out.println("===============");

                e.printStackTrace();
                System.out.println("정수를 다시 입력해주세요.");
                sc.nextLine(); // 버퍼 비워!!
            }
        }

    }
}
