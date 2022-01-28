package site.metacoding.ex23;

class NewWorker implements Runnable {

    // 타겟
    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            try {
                System.out.println("뉴워커 스레드 : " + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

public class ThreadEx02 {

    // MainThread의 타겟은 main 메서드 -> 메인 쓰레드의 'task' 작업, 임무
    // 타겟을 실행시키고 종료시키는 임무,
    public static void main(String[] args) {

        // NewWorker 생성
        Thread newWorker = new Thread(new NewWorker()); // 타겟이 없음 -> 타겟은 생성자로 지정
        newWorker.start(); // run() 메서드 호출

        // 메인쓰레드는 스타트만 때려놓고 자기 일 하러 감
        // 그리고 뉴워커 쓰레드가 런 메서드 내부 실행

        // 비동기 프로그램 !

        for (int i = 1; i < 6; i++) {
            try {
                System.out.println("메인 스레드 : " + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
