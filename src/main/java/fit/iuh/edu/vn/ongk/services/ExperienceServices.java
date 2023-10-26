package fit.iuh.edu.vn.ongk.services;

import fit.iuh.edu.vn.ongk.modules.Candidate;
import fit.iuh.edu.vn.ongk.modules.Experience;
import fit.iuh.edu.vn.ongk.responsitories.CandidateResponsitory;
import fit.iuh.edu.vn.ongk.responsitories.ExperienceResoponsitory;

import java.util.List;

public class ExperienceServices {
    private ExperienceResoponsitory experienceResoponsitory;

    public ExperienceServices() {
        experienceResoponsitory = new ExperienceResoponsitory();
    }

    public boolean inserCan(Experience experience){
        return experienceResoponsitory.insertCan(experience);
    }

    public boolean updateCan(Experience experience){
        return experienceResoponsitory.updateCan(experience);
    }

    public List<Experience> getAllexbycanid(long id){
        return experienceResoponsitory.getAllexbycanid(id);
    }
}
