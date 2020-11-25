package com.example.demo.controller;

import com.example.demo.nativeinterface.lidar.LidarSpring;
import com.example.demo.socket.GetLocalHost;
import com.example.demo.socket.SocketClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import static java.lang.Thread.sleep;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LidarController {
    static final Logger log = LoggerFactory.getLogger(LidarController.class);

    float[] dist = new float[1421];
    float[] angle = new float[1421];
    ArrayList<Float> arr_dist = new ArrayList<Float>();
    ArrayList<Float> arr_angle = new ArrayList<Float>();
    GetLocalHost gh;
    SocketClient sc;

    @GetMapping("/startlidar")
    public String startlidar(Locale locale, Model model) throws InterruptedException {
        log.info("startlidar()");

        /*
        Date date = new Date();

        DateFormat dateFormat = DateFormat.getDateTimeInstance(
                DateFormat.LONG, DateFormat.LONG, locale
        );

        String formattedDate = dateFormat.format(date);
        model.addAttribute("servTime", formattedDate);
         */

        LidarSpring.lidar_start();

        return "lidar";
    }

    @ResponseBody
    @GetMapping("/getlidar")
    public HashMap<String, ArrayList> getlidar() throws InterruptedException {
        log.info("getlidar()");
        ArrayList<Float> dis = new ArrayList<Float>();
        ArrayList<Float> ang = new ArrayList<Float>();
        HashMap<String, ArrayList> ret = new HashMap<String, ArrayList>();
        boolean out = false;

        while (true)
        {
            LidarSpring.print(dist, angle);
            for(int i = 0; i < 1421; i++)
            {
                log.info("dist = " + dist[i] + ", angle = " + angle[i]);
            }
            for(int i=0; i<dist.length; i++)
            {
                arr_angle.add(angle[i]);
                arr_dist.add(dist[i]);
                if(angle[i] > 358.0) {
                    for (int j=0; j<arr_dist.size(); j++)
                    {
                        dis.add(arr_dist.get(j));
                        ang.add(arr_angle.get(j));
                    }
                    arr_angle.clear();
                    arr_dist.clear();
                    out = true;
                }
            }
            if(out)
            {
                out = false;
                break;
            }
        }

        ret.put("key_dist", dis);
        ret.put("key_angle", ang);

        return ret;
    }

    @GetMapping("/stoplidar")
    public void stoplidar(Locale locale, Model model) throws InterruptedException {
        log.info("stoplidar()");

        LidarSpring.lidar_stop();
    }

    ////////////////////////////////////// gsm////////////////////////////////
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

    @GetMapping("/phone_call")
    public String phone_call() throws InterruptedException, UnknownHostException {
        log.info("phone_call()");

        String phoneNum = "01029807183";
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

    @GetMapping("/phone_msg_send")
    public String phone_msg_send(String num) throws InterruptedException, UnknownHostException {
        log.info("phone_msg_send()");
        log.info("num : " + num);
        String phoneNum = "01040826312";
//        String phoneNum = "01029807183";
        //String phoneNum = "01072400150";
        String phoneMsg = "Come!";

        sc.sendData(2, 1, phoneNum, phoneMsg);
        sleep(1000);

        //log.info(UartSpring.phone_msg_send(phoneNum, phoneMsg));

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
