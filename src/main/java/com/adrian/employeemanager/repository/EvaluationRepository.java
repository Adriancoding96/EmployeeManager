package com.adrian.employeemanager.repository;

import com.adrian.employeemanager.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.adrian.employeemanager.dto.MonthlyEvaluationCountDTO;


import java.util.List;

public interface EvaluationRepository  extends JpaRepository<Evaluation, Long> {

    @Query("SELECT e FROM Evaluation e WHERE FUNCTION('YEAR', e.dateOfEvaluation) = :year AND e.employee.employeeId = :employeeId")
    List<Evaluation> findAllEvaluationsByYearAndEmployeeId(@Param("year") int year, @Param("employeeId") Long employeeId);

    @Query("SELECT new com.adrian.employeemanager.dto.MonthlyEvaluationCountDTO(FUNCTION('YEAR', e.dateOfEvaluation) as year, FUNCTION('MONTH', e.dateOfEvaluation) as month, COUNT(e)) " +
            "FROM Evaluation e " +
            "GROUP BY year, month " +
            "ORDER BY year, month")
    List<MonthlyEvaluationCountDTO> findEvaluationCountsPerYearMonth();

}
