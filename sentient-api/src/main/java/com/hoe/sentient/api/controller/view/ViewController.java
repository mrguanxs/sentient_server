package com.hoe.sentient.api.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author guan
 * @date 2024/1/11
 */
@Controller
public class ViewController {

    @RequestMapping("/boot_ws.html")
    public String bootWs(){
        return "boot_ws.html";
    }

    @RequestMapping("/tradition_ws.html")
    public String traditionWs(){
        return "tradition_ws.html";
    }
}
