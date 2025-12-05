package com.hb.HB_EduTech.services.helper;


import com.hb.HB_EduTech.entities.*;
import com.hb.HB_EduTech.models.*;
import com.hb.HB_EduTech.repositories.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    public void saveFromJson(List<CollegeInput> collegesJson) {

        for (CollegeInput input : collegesJson) {

            College college = new College();
            college.setCollegeName(input.getCollege_name());
            college.setCollegeCode(input.getCollege_code());
            college.setStatus(input.getStatus());
            college.setHomeUniversity(input.getHome_university());
            college.setRound("ROUND 1");

            Branch branch = new Branch();
            branch.setBranchName(input.getBranch_name());
            branch.setBranchCode(input.getBranch_code());
            branch.setCollege(college);

            List<Level> levelList = new ArrayList<>();

            for (LevelInput li : input.getLevels()) {

                Level level = new Level();
                level.setLevelName(li.getLevel());
                level.setBranch(branch);

                List<Cutoff> cutoffList = new ArrayList<>();

                for (Map.Entry<String, CutoffInput> entry : li.getCutoffs().entrySet()) {
                    CutoffInput ci = entry.getValue();

                    Cutoff cutoff = new Cutoff();
                    cutoff.setCategory(entry.getKey());
                    cutoff.setRank(ci.getRank());
                    cutoff.setPercentile(ci.getPercentile());
                    cutoff.setLevel(level);

                    cutoffList.add(cutoff);
                }

                level.setCutoffs(cutoffList);
                levelList.add(level);
            }

            branch.setLevels(levelList);
            college.setBranches(List.of(branch));

            collegeRepository.save(college); // cascade saves all
        }
    }
}