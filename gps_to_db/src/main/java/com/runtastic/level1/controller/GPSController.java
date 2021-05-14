package com.runtastic.level1.controller;

import com.runtastic.level1.domain.GPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.runtastic.level1.service.GpsService;

import java.util.List;

@RestController
@RequestMapping("/gps")
public class GPSController {
    @Autowired
    private GpsService gpsService;

    public GPSController(GpsService gpsService) {
        this.gpsService = gpsService;
    }

    @GetMapping("/list")
    public Iterable<GPS> list(){
        return gpsService.list();
    }

    @RequestMapping(value = "/saveall", method = RequestMethod.POST)
    @ResponseBody
    public List<GPS> saveAllSGPS(@RequestBody List<GPS> studentList) {
        List<GPS> gpsResponse = (List<GPS>) gpsService.saveAllGPS(studentList);
        return gpsResponse;
    }
}
