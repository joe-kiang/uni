package gm.desafio.repository;

import gm.desafio.entity.WorkHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHoursRepository extends JpaRepository<WorkHours, Long> {
}
