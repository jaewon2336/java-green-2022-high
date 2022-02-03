package site.metacoding.ex23;

// 스레드가 컨텍스트 스위칭할 때는 내부적으로 0.000000001초라도 졸고 넘어간다.
// 모든 언어 공통 -> 스레드는 OS가 관리하기 때문

// 제어권이 넘어가지 않으면 직접 재워줘야함
// cpu가 엄청 집중하고 있으면 넘어가야하는걸 까먹어버리기 때문에
// OS가 인터럽트를 걸어서 잠깐 재워준다.

// 하나의 프로세스안에 여러개의 스레드가 동작한다.

// 스레드 일시 정지 하는 방법

// Host가 Monster 좌표에 도달하면 Monster 죽음
// Monster는 2초씩 자고 움직인다.
class Monster /* implements Runnable */ {
    int x = 10;
    int speed = 1;
    boolean check = true;
    /*
     * @Override
     * public void run() {
     * while (check) {
     * x = x + speed;
     * System.out.println("Monster의 좌표 : " + x);
     * 
     * try {
     * Thread.sleep(1000);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */
}

// 1씩 계속 움직인다.
class Host /* implements Runnable */ {
    int x = 0;
    int speed = 2;
    boolean check = true;
    /*
     * @Override
     * public void run() {
     * while (check) {
     * x = x + speed;
     * System.out.println("Host의 좌표 : " + x);
     * 
     * try {
     * Thread.sleep(1000);
     * } catch (Exception e) {
     * e.printStackTrace();
     * }
     * }
     * }
     */
}

// 실습 -> Host의 speed를 2로 만들고, Monster는 잠자지 않는다.
// -> Monster와 Host는 1초마다 각자의 speed 만큼 움직이는 run()을 가진다.
// -> 둘의 x좌표가 동일해지면 게임은 종료된다.
public class ThreadEx05 {
    public static void main(String[] args) {
        Monster monster = new Monster();
        Host host = new Host();

        Thread mThread = new Thread(() -> {
            while (monster.check) {
                monster.x = monster.x + monster.speed;
                System.out.println("Monster의 좌표 : " + monster.x);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread hThread = new Thread(() -> {
            while (host.check) {
                host.x = host.x + host.speed;
                System.out.println("Host의 좌표 : " + host.x);

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        mThread.start();
        hThread.start();

        while (true) {
            if (monster.x <= host.x) { // 같다고만(==) 해놓으면 위험!
                monster.check = false;
                host.check = false;
                System.out.println("Host가 Monster를 잡았습니다.");
                System.out.println("Host 좌표 : " + host.x);
                System.out.println("Monster 좌표 : " + monster.x);
                break;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
