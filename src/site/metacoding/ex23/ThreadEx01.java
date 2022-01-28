package site.metacoding.ex23;

public class ThreadEx01 {

    // main 스레드 시작
    public static void main(String[] args) {
        System.out.println(1);
        // 컴파일 에러 -> 쓰레드가 잠드는 시점에 예외가 발생할 수 있음
        try {
            Thread.sleep(2000); // 밀리세컨즈 1/1000초, cpu가 sleep중 ...
        } catch (Exception e) { // InterruptedException 니가 잘때가 아니야!(방해)
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
