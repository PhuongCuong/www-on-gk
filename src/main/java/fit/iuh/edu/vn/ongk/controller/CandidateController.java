package fit.iuh.edu.vn.ongk.controller;

import fit.iuh.edu.vn.ongk.enums.Roles;
import fit.iuh.edu.vn.ongk.modules.Candidate;
import fit.iuh.edu.vn.ongk.modules.Experience;
import fit.iuh.edu.vn.ongk.services.CandidateService;
import fit.iuh.edu.vn.ongk.services.ExperienceServices;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/control"})
public class CandidateController extends HttpServlet {

    private CandidateService service = new CandidateService();
    private ExperienceServices experienceServices = new ExperienceServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("actions");
        if(action.equalsIgnoreCase("View")){
            long id = Long.parseLong(req.getParameter("action"));
            HttpSession session = req.getSession();
            session.setAttribute("infocandidate",service.getcanbyid(id));
            session.setAttribute("infoex",experienceServices.getAllexbycanid(id));
            resp.sendRedirect("candidate_details.jsp");
        }
        else if(action.equalsIgnoreCase("roleid")){
            Roles role = Roles.valueOf(req.getParameter("roles"));
            HttpSession session = req.getSession();
            session.setAttribute("dscandidaterole",service.getcanbyrole(role));
            resp.sendRedirect("report1.jsp");
        }
    }
}
