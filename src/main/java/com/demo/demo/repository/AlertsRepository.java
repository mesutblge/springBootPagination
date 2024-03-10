package com.demo.demo.repository;

import com.demo.demo.dao.Alerts;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertsRepository extends JpaRepository<Alerts,Long> {
    @Query(value = "SELECT s.scenario_name, t.tag_color, a.created_time " +
            "FROM scenarios s " +
            "JOIN tags t ON s.id = t.id " +
            "JOIN alerts a ON s.id = a.id", nativeQuery = true)
    List<Object[]> joinQuery();

}
