public class Counter {
    private int value;

    public synchronized void increment (){
        value++;
    }
    // synchronized -> increment에 하나의 스레드만 접근 가능하도록 함, 
    // 그러나 thread1의 run 실행 도중 thread1이 종료되지 않았음에도 thread2가 실행되어 run이 실행되고
    // value값이 증가한다 (동시성 문제는 생기지 않음)
    public int getValue(){
        return value;
    }
}
