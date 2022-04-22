package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 쓰레드 로컬은 해당 쓰레드만 접근할 수 있는 특별한 저장소를 말한다.
 * 쓰레드 로컬을 통해서 데이터를 조회할 때도 thread-A 가 조회하면 쓰레드 로컬은 thread-A 전용
 * 보관소에서 userA 데이터를 반환해준다. 물론 thread-B 가 조회하면 thread-B 전용 보관소에서
 * userB 데이터를 반환해준다
 * 자바는 언어차원에서 쓰레드 로컬을 지원하기 위한 java.lang.ThreadLocal 클래스를 제공한다.*/
@Slf4j
public class ThreadLocalService {

    private ThreadLocal<String> nameStore = new ThreadLocal<>();

    public String logic(String name) {
        log.info("저장 name={} -> nameStore{}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("조회 nameStore ={}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
