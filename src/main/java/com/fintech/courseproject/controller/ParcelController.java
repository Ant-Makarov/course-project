package com.fintech.courseproject.controller;

import com.fintech.courseproject.entity.Parcel;
import com.fintech.courseproject.service.ParcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcel")
@Slf4j
public class ParcelController {

    @Autowired
    private ParcelService parcelService;

    @PostMapping("/save")
    public void createParcel(@RequestBody Parcel parcel) {
        log.info("Handling parcel creation: " + parcel);
        parcelService.saveParcel(parcel);
    }

    @PostMapping("/take")
    public void takeParcel(@RequestBody Parcel parcel) {
        log.info("Handling parcel taking: " + parcel);
        parcelService.takeParcel(parcel);
    }
}
