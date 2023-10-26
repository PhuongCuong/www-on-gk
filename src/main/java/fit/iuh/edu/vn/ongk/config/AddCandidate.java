package fit.iuh.edu.vn.ongk.config;

import fit.iuh.edu.vn.ongk.enums.Roles;
import fit.iuh.edu.vn.ongk.modules.Candidate;
import fit.iuh.edu.vn.ongk.modules.Experience;
import fit.iuh.edu.vn.ongk.services.CandidateService;
import fit.iuh.edu.vn.ongk.services.ExperienceServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddCandidate {
    public static void main(String[] args) {
        CandidateService service = new CandidateService();
        ExperienceServices experienceServices = new ExperienceServices();


        Candidate candidate = new Candidate("nguyen van a", "a@gmail.com", "12345678");
        Candidate candidate2 = new Candidate("nguyen van b", "b@gmail.com", "12345678");
        Candidate candidate3 = new Candidate("nguyen van c", "c@gmail.com", "12345678");

        service.inserCan(candidate);
        service.inserCan(candidate2);
        service.inserCan(candidate3);

        Experience experience = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate);
        Experience experience1 = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate);
        Experience experience2 = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate);

        Experience experience3 = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate2);
        Experience experience4 = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate2);
        Experience experience5 = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate2);

        Experience experience6 = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate3);
        Experience experience7 = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate3);
        Experience experience8 = new Experience(LocalDate.of(2021,10,26),"ăn chơi","thất nghiệp",LocalDate.now(), Roles.STAFF,candidate3);

        List<Experience> list = new ArrayList<>();
        list.add(experience);
        list.add(experience1);
        list.add(experience2);
        list.add(experience3);
        list.add(experience4);
        list.add(experience5);
        list.add(experience6);
        list.add(experience7);
        list.add(experience8);
        for (Experience ex:
                list) {
            experienceServices.inserCan(ex);
        }

        System.out.println("insert success!");

    }
}
