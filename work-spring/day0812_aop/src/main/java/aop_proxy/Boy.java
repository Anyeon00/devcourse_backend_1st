package aop_proxy;

import java.util.Random;

public class Boy implements Person{
    public void makeFood() throws Exception {
        System.out.println("멕시칸 타코를 만든다."); // 핵심 관심사항
        if (new Random().nextBoolean()) { // 핵심 관심사항 수행 도중 만약 예외가 발생한다면?
            throw new Exception("불났다!!!!");
        }
    }
}
