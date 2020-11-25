package com.example.demo.controller;

import com.example.demo.nativeinterface.lidar.LidarSpring;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

@Log
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LidarController {

    float[] dist = new float[1421];
    float[] angle = new float[1421];
    ArrayList<Float> arr_dist = new ArrayList<Float>();
    ArrayList<Float> arr_angle = new ArrayList<Float>();

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
}
