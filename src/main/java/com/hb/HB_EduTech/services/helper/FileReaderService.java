package com.hb.HB_EduTech.services.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hb.HB_EduTech.models.CollegeInput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FileReaderService {

    @Autowired
    private ObjectMapper objectMapper;

    public List<CollegeInput> readCollegeJsonFile() throws Exception {

//        File file = new ClassPathResource("D:\\UJJWAL\\STARTUP-CAREER\\Data\\mhtcet_round_1_cutoffs_multilevel.json").getFile();
        File file = new File("D:\\UJJWAL\\STARTUP-CAREER\\Data\\mhtcet_round_1_cutoffs_multilevel.json");
        return objectMapper.readValue(
                file,
                objectMapper.getTypeFactory().constructCollectionType(List.class, CollegeInput.class)
        );
    }
}