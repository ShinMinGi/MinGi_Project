package org.example.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dto.LectNthDto;
import org.example.entity.LectNth;
import org.example.repository.AdminThisTimeRegisTration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LectNthService {

    private final AdminThisTimeRegisTration adminThisTimeRegisTration;

    public List<LectNthDto> lectNthList() {
        return adminThisTimeRegisTration.findLectNthDtos();
    }


    /* search */
    @Transactional
    public List<LectNth> search(String keyword) {
        List<LectNth> lectNthList = adminThisTimeRegisTration.findByNthIdContaining(keyword);
        return lectNthList;
    }

}