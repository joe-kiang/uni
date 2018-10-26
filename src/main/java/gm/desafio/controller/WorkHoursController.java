package gm.desafio.controller;

import gm.desafio.entity.WorkHours;
import gm.desafio.repository.WorkHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/WorkHours")
public class WorkHoursController {

    private WorkHoursRepository workHoursRepository;

    @Autowired
    public WorkHoursController(WorkHoursRepository workHoursRepository) {
        this.workHoursRepository = workHoursRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<WorkHours> findWorkHours() {
        return workHoursRepository.findAll();
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public void addNewWebWorkHours(@RequestBody AddWorkHoursRequest addWorkHoursRequest) {
//        WorkHours workHours = new WorkHours();
//        workHours.setUser(addWorkHoursRequest.getUser());
//        workHours.setStartwork(addWorkHoursRequest.getStartWork());
//        workHours.setEndWork(addWorkHoursRequest.getEndWork());
//        workHoursRepository.save(workHours);
//    }

}
