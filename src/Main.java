//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args)throws InterruptedException  {
        Counter counter = new Counter();// 카운터 객체를 하나 만들어서

        IncrementThread thread1 = new IncrementThread(counter);
        // thread1 이란 이름을 가진 IncrementThread 객체를 하나 만들어서 counter 객체를 넘겨줌
        IncrementThread thread2 = new IncrementThread(counter);
        // thread2 이란 이름을 가진 IncrementThread 객체를 하나 만들어서 counter 객체를 넘겨줌

        thread1.start();
        //thread1.join(); -> thread1이 다 끝날때까지 기다림
        thread2.start();
        //thread2.join(); -> thread2가 다 끝날때까지 기다림
    }
}