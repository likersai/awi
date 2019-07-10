package xyz.likersai.demo.websocket;

/**
 * @program: awi
 * @description: 服务端向浏览器发送此类的消息
 * @author: sun.ye
 * @create: 2019-05-04 16:12
 */
public class LikersaiResponse {
    private String responseMessage;

    public LikersaiResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}