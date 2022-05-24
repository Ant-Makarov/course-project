package com.fintech.courseproject.service;

import com.fintech.courseproject.entity.PostOffice;
import com.fintech.courseproject.exceptions.PostOfficeAlreadyExistsException;
import com.fintech.courseproject.repository.PostOfficeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostOfficeService {

    private final PostOfficeRepository postOfficeRepository;

    public void savePostOffice(PostOffice postOffice) {
        List<PostOffice> postOfficeList = postOfficeRepository.findAll();
        PostOffice savedPostOffice;
        boolean isPostOfficeNotExists = postOfficeList.stream().noneMatch(p -> p.getDescription()
                                                                .equals(postOffice.getDescription()));
        if (isPostOfficeNotExists) {
            savedPostOffice = postOfficeRepository.save(PostOffice.builder()
                    .description(postOffice.getDescription())
                    .build());
            log.info("This post-office: " + postOffice + "has been created successfully!");
        } else {
            log.error("This post-office: " + postOffice + "already exists!");
            throw new PostOfficeAlreadyExistsException(postOffice.getDescription());
        }
    }

}
