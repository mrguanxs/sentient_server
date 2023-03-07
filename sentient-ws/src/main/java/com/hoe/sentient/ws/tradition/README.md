#### tradition包下为传统方式websocket链接的使用

1. 配置config ServerEndpointExporter 用来自动注册使用了@ServerEndpoint注解声明的对象
2. 每一种链接使用@ServerEndpoint("/api/pushMessage/{userId}")注解声明链接地址
3. 在方法上使用注解的方式进行打开链接、关闭链接、发送消息等操作的实现
