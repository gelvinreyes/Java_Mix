package com.runtastic.level1.service;

import com.runtastic.level1.domain.GPS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.runtastic.level1.repository.GPSRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GpsService {
    @Autowired
    private GPSRepository gpsRepository;


    public GPS save(GPS gps){
        return this.gpsRepository.save(gps);
    }
    public Iterable<GPS>  saveAll(List<GPS> gpsx)    {
        return this.gpsRepository.saveAll(gpsx);
    }
    @Transactional
    public List<GPS> saveAllGPS(List<GPS> gpsList) {
        List<GPS> response = (List<GPS>) gpsRepository.saveAll(gpsList);
        return response;
    }
    public Iterable<GPS> list(){
        return gpsRepository.findAll();
    }

    public GpsService(GPSRepository gpsRepository) {
        this.gpsRepository = gpsRepository;
    }

}
