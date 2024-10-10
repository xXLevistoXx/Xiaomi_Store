package com.web_project.school.repository;

import com.web_project.school.model.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StatusRepository extends JpaRepository<StatusModel, UUID> {
}