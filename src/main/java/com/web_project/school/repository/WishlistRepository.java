package com.web_project.school.repository;

import com.web_project.school.model.WishlistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface WishlistRepository extends JpaRepository<WishlistModel, UUID> {
}