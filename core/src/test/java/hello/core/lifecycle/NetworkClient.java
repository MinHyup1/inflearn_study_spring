package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient  {

    private String url;

    public NetworkClient() {
        System.out.println("생성자호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message =  " + message);

    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() {//빈생성될시(의존관계주입을 마친 후)
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {//빈이 내려갈때
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
