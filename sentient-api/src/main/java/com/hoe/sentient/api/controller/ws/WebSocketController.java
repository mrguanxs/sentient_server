package com.hoe.sentient.api.controller.ws;

import com.hoe.sentient.common.result.Result;
import com.hoe.sentient.ws.tradition.server.WebSocketServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author guan
 * @Date 2023/3/7
 */
@RestController()
@RequestMapping("/api/vs/ws")
public class WebSocketController {

    /**
     * 启动页面
     * @return
     */
    @GetMapping("/start")
    public String start(){
        return "index";
    }

    @PostMapping("/pushToWeb/{userId}")
    @ApiOperation(value = "服务器端向客户端推送消息", notes = "服务器端向客户端推送消息")
    public Result pushToWeb(@PathVariable (value = "userId") String userId){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = dateFormat.format(new Date());
        WebSocketServer.sendMsg(userId, date);
        System.out.println(date);
        return Result.success();
    }

}
