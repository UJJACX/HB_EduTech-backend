package com.hb.HB_EduTech.controllers;

import com.hb.HB_EduTech.services.helper.CollegeImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImportController {

    @Autowired
    private CollegeImportService importService;

    @PostMapping("/from-file")
    public ResponseEntity<String> importData() throws Exception {
        importService.importFromFile();
        return ResponseEntity.ok("Import completed!");
    }
}