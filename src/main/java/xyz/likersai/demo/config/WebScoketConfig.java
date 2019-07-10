package xyz.likersai.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @program: awi
 * @description: 配置WebSocket 继承AbstractWebSocketMessageBrokerConfigurer类已过时
 * 改为实现WebSocketMessageBrokerConfigurer接口
 * @author: sun.ye
 * @create: 2019-05-04 15:55
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebScoketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * @Description: 注册STOMP协议的节点（endpoint），并映射为Url
     * @Param:  StompEndpointRegistry`
     * @Author: SunYe
     * @Date: 2019/5/4
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**
         * 注册一个STOMP的endpoint，并指定使用SockJS协议
         */
        registry.addEndpoint("/endpoint").withSockJS();
        registry.addEndpoint("/endpointChat").withSockJS();
        registry.addEndpoint("/endpointLikersai").withSockJS();
    }


    /**
     * @Description: 配置消息代理（Massage Broker）
     * @Param:  MessageBrokerRegistry
     * @Author: SunYe
     * @Date: 2019/5/4
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * 广播式应配置一个/topic消息代理
         */
//        registry.enableSimpleBroker("/topic");
        registry.enableSimpleBroker("/queue","/topic");
    }


}