package site.metacoding.ex23;

public class ThreadEx04 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            // 이 부분이 run 메서드 내부
        });
        System.out.println("메인 쓰레드 종료");
        t1.start();
    }
}
