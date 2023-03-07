### boot包下为springboot整合websocket的写法

#### 优点
1. 可以定义拦截器对所有链接进行统一处理


过程:
1. 注解@EnableWebSocket开启websocket
2. 定义MyWebSocketHandler实现接口WebSocketHandler，实现对链接的处理（在4配置中指定handler对应的path）
3. 自定义拦截器拦截WebSocket请求,实现HandshakeInterceptor接口（在4中配置拦截器）
4. 实现WebSocketConfigurer进行配置 websocket 入口，允许访问的域、注册 Handler、定义拦截器等等等等
