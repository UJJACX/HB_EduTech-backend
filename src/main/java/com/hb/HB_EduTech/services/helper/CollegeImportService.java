package com.hb.HB_EduTech.services.helper;

import com.hb.HB_EduTech.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeImportService {

    @Autowired
    private FileReaderService fileReaderService;

    @Autowired
    private CollegeService collegeService;

    public void importFromFile() throws Exception {
        List<CollegeInput> json = fileReaderService.readCollegeJsonFile();
        collegeService.saveFromJson(json);
    }
}