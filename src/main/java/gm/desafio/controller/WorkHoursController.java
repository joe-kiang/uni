package gm.desafio.controller;

import gm.desafio.entity.WorkHours;
import gm.desafio.exception.EntityNotFoundException;
import gm.desafio.repository.WorkHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/WorkHours")
public class WorkHoursController {

    private WorkHoursRepository workHoursRepository;

    @Autowired
    public WorkHoursController(WorkHoursRepository workHoursRepository) {
        this.workHoursRepository = workHoursRepository;
    }

    @GetMapping
    public List<WorkHours> findWorkHours() {
        return workHoursRepository.findAll();
    }

    @PostMapping
    public WorkHours createWokrHours(@Valid @RequestBody WorkHours workHours) {
        return workHoursRepository.save(workHours);
    }

    @GetMapping(value = "/{id}")
    public WorkHours getWorkHoursById(@PathVariable(value = "id") Long workId) {
        return workHoursRepository.findById(workId).orElseThrow(() -> new EntityNotFoundException("WorkHours", "id", workId));
    }

    @PutMapping(value = "/{id}")
    public Boolean updateWorkHours(@Valid @RequestBody WorkHours workHours, @PathVariable(value = "id") Long workId) {
        WorkHours workHours1 = workHoursRepository.findById(workId).orElseThrow(() -> new EntityNotFoundException("WorkHours", "id", workId));

        workHours1.setUser(workHours.getUser());
        workHours1.setStartwork(workHours.getStartwork());
        workHours1.setEndWork(workHours.getEndWork());
        workHoursRepository.save(workHours1);

        return true;
    }

    @DeleteMapping(value = "/{id}")
    public Boolean deleteWorkHours(@PathVariable(value = "id") Long workId) {

        WorkHours workHours = workHoursRepository.findById(workId).orElseThrow(() -> new EntityNotFoundException("WorkHours", "id", workId));
        workHoursRepository.delete(workHours);

        return true;
    }

}
