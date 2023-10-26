package fit.iuh.edu.vn.ongk.services;

import fit.iuh.edu.vn.ongk.enums.Roles;
import fit.iuh.edu.vn.ongk.modules.Candidate;
import fit.iuh.edu.vn.ongk.responsitories.CandidateResponsitory;

import java.util.List;
import java.util.Optional;

public class CandidateService {

    private CandidateResponsitory candidateResponsitory;

    public CandidateService() {
        candidateResponsitory = new CandidateResponsitory();
    }

    public boolean inserCan(Candidate candidate){
        return candidateResponsitory.insertCan(candidate);
    }

    public boolean updateCan(Candidate candidate){
        return candidateResponsitory.updateCan(candidate);
    }

    public List<Candidate> getAllCandidate(){
        return candidateResponsitory.getAllcan();
    }

    public Optional<Candidate> getcanbyid(long id){
        return candidateResponsitory.getcanbyid(id);
    }

    public List<Candidate> getcanbyrole(Roles role) {
        return candidateResponsitory.getcanbyrole(role);
    }

    public List<Candidate> getcanbyemail() {
        return candidateResponsitory.getcanbyemail();
    }
}
