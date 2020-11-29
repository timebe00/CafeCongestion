package com.example.demo.controller;

import com.example.demo.nativeinterface.uart.UartSpring;
import com.example.demo.socket.GetLocalHost;
import com.example.demo.socket.SocketClient;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.HashMap;

import static java.lang.Thread.sleep;

@Log
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GSMController {
    GetLocalHost gh;
    SocketClient sc;

    @GetMapping("/phone_init")
    public String phone_init() throws UnknownHostException {
        log.info("phone_init()");

        gh = new GetLocalHost();
        sc = new SocketClient(gh.getLocalHost().getHostAddress(), 33333);

        return "gsm";
    }

    @GetMapping("/phone_finish")
    public String phone_finish() throws UnknownHostException {
        log.info("phone_finish()");

        sc.closeSocket();

        return "gsm";
    }

    @PostMapping("/phone_call")
    public String phone_call(@Validated @RequestBody HashMap num) throws InterruptedException, UnknownHostException {
        log.info("phone_call()");
        log.info("num : " + num);
        String phoneNum = (String)num.get("num");
        log.info(phoneNum);
//        String phoneNum = "01029807183";
        sc.sendData(1, 1, phoneNum);
        sleep(1000);

        //log.info(UartSpring.phone_call("01029807183"));

        return "gsm";
    }

    @GetMapping("/call_fin")
    public String call_fin() throws InterruptedException, UnknownHostException {
        log.info("call_fin()");

        sc.sendData(1, 0);
        sleep(1000);

        //log.info(UartSpring.phone_call("01029807183"));

        return "gsm";
    }

    @PostMapping("/phone_msg_send")
    public String phone_msg_send1(@Validated @RequestBody HashMap num) throws InterruptedException, UnknownHostException {
        log.info("phone_msg_send()");
        log.info("num : " + num);
        log.info("num Hash : " + num.get("pho"));
//        String phoneNum = "01040826312";
        String phoneNum = (String)num.get("pho");
        //String phoneNum = "01072400150";
        String phoneMsg = "Come!";

        sc.sendData(2, 1, phoneNum, phoneMsg);
        sleep(1000);

//        log.info(UartSpring.phone_msg_send(phoneNum, phoneMsg));

        return "gsm";
    }

    @PostMapping("/phone_msg_send2")
    public String phone_msg_send2(@Validated @RequestBody HashMap num) throws InterruptedException, UnknownHostException {
        log.info("phone_msg_send()");
        log.info("num : " + num);
        log.info("num Hash : " + num.get("pho"));
//        String phoneNum = "01040826312";
        String phoneNum = (String)num.get("num");
        String phoneMsg = (String)num.get("mess");
        log.info(phoneNum);
        log.info(phoneMsg);
        //String phoneNum = "01072400150";
//        String phoneMsg = "Come!";

        sc.sendData(2, 1, phoneNum, phoneMsg);
        sleep(1000);

//        log.info(UartSpring.phone_msg_send(phoneNum, phoneMsg));

        return "gsm";
    }

    @GetMapping("/sms_fin")
    public String sms_fin() throws InterruptedException, UnknownHostException {
        log.info("sms_fin()");

        sc.sendData(2, 0);
        sleep(1000);

        //log.info(UartSpring.phone_call("01029807183"));

        return "gsm";
    }

    @GetMapping("/kill_daemon")
    public String kill_daemon() throws InterruptedException, UnknownHostException {
        log.info("kill_daemon()");

        sc.sendData(3);
        sleep(1000);

        //log.info(UartSpring.phone_call("01029807183"));

        return "gsm";
    }
}
