### WebSocket封装

包含两种方式

1. 方式一 拦截器方式
boot包下
优点：可对消息进行统一处理，例如token认证等
缺点：代码复杂

2. 方式二 简单方式
tradition包下
优点：代码简单，容易上手
缺点：没有做统一消息处理

待优化：消息格式封装

### 使用websocket存在的问题
1. 连接自动化断开
解决：前端定时发送心跳

2. session无法共享
分布式场景会存在这样一个问题，当一次请求负载到第一台服务器时，session在第一台服务器线程上，
第二次请求，负载到第二台服务器上，此时通过userId查找当前用户的session时，是查找不到的。
且session不支持序列化

解决：每次连接时，都将userId和对应的session存入到本机，发送消息时，直接发送给MQ，然后每台应用都去消费这个消息，拿到消息之后，判断在本机能根据userId是否能找到session，找到则推送到客户端

3. 对象无法自动注入
使用了@ServerEndpoint注解的类中使用@Resource或@Autowired注入对象都会失败，并且报空指针异常。
原因是WebSocket服务是线程安全的，那么当我们去发起一个ws连接时，就会创建一个端点对象。
WebSocket服务是多对象的，不是单例的。而我们的Spring的Bean默认就是单例的，在非单例类中注入一个单例的Bean是冲突的
或者说：Spring管理采用单例模式（singleton），而 WebSocket 是多对象的，即每个客户端对应后台的一个 WebSocket 对象，也可以理解成 new 了一个 WebSocket，这样当然是不能获得自动注入的对象了，因为这两者刚好冲突Spring管理采用单例模式（singleton），而 WebSocket 是多对象的，即每个客户端对应后台的一个 WebSocket 对象，也可以理解成 new 了一个 WebSocket，这样当然是不能获得自动注入的对象了，因为这两者刚好冲突

解决：使用静态对象，并且对外暴露set方法，这样在对象初始化的时候，将其注入到WebSocketServer中

4. nginx配置问题
作者：不焦躁的程序员
链接：https://www.zhihu.com/question/54678903/answer/3197116107
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

当只有一层nginx的时候，配置比较简单，如下：
```
location ~* ^/api/websocket/* {
      proxy_pass http://localhost:8089;
      
      proxy_read_timeout 300s;
      proxy_send_timeout 300s;
      proxy_set_header Host localhost:8089;
      proxy_http_version 1.1;
      proxy_set_header Upgrade $http_upgrade;
      proxy_set_header Connection "Upgrade";
      proxy_set_header X-Real-IP $remote_addr;
 }
```
 但是，当有两层nginx转发的时候，问题就出现了。
 在最外层的nginx需要使用如下配置，不能照抄后面一层的配置。proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for和proxy_set_header  X-Forwarded-Proto $scheme这两个配置不能少，用来将协议和真实IP传递给后面一层的nginx。
 ```
 location ~* ^/api/websocket/* {
      proxy_pass http://localhost:8089;

      proxy_read_timeout 300s;
      proxy_send_timeout 300s;
      proxy_set_header  Host $http_host;
      proxy_set_header  X-Real-IP  $remote_addr;
      proxy_set_header  X-Forwarded-For $proxy_add_x_forwarded_for;
      proxy_set_header  X-Forwarded-Proto $scheme;
      proxy_http_version 1.1;
      proxy_set_header Upgrade $http_upgrade;
      proxy_set_header Connection $connection_upgrade;
}
```
