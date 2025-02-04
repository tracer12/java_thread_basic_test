public class IncrementThread extends Thread{
    private Counter counter; // Counter 클래스에 있는 메서드를 사용하기 위해 인스턴스 변수 선언

    public IncrementThread(Counter counter){ // 그럼 여기서 카운터 객체를 받는다
        // 근데 각각 thread1 thread2에 전달된 카운터 객체는 동일한 객체이다
        // 즉 increment를 사용하면 동일한 value가 증가됨
        // 동시성 문제 때문에 최종 값이 20000이 안됨
        this.counter = counter;
        // 이 인스턴스 변수(counter)는 매개변수로 받아온 카운터 객체이다
    }
    
    public void run(){
        for(int i = 0; i< 10000; i++){
            counter.increment();
        }
        System.out.println(counter.getValue());
        // 그럼 카운터 클래스에서 받아온 increment와 getValue 가 들어간 인스턴스 변수 counter를 이용해서
        // 해당 메서드를 사용할 수 있다

        // counter의 increment를 synchronized를 사용해서 선언했으므로 한번에 값이 1개씩만 올라간다
        // thread1과 thread2가 value값을 올리므로 thread1이 종료된 시점엔 값이 10000보다 무조건 큼 (thread1이 value 값을 1 올린다음 그 다음 thread2가 value 값을 1 올림)
        // 그러나 결국 thread2가 종료된 시점은 20000이 나오는데 그 이유는 1씩 10000번 증가시키는 반복문이 총 2번이 돌았고
        // 그 동안 value 값은 한번에 한번씩만 증가가 됐으므로 정확한 20000이 나온다
    }
}
