package com.fintech.courseproject.controller;

import com.fintech.courseproject.entity.PostOffice;
import com.fintech.courseproject.service.PostOfficeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post-office")
@Slf4j
@RequiredArgsConstructor
public class PostOfficeController {

    private final PostOfficeService postOfficeService;

    @PostMapping("/save")
    public PostOffice createPostOffice(@RequestBody PostOffice postOffice) {
        log.info("Handling post office creation: " + postOffice);
        return postOfficeService.savePostOffice(postOffice);
    }
}
