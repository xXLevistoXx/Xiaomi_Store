package com.web_project.school.service;

import com.web_project.school.model.StatusModel;

import java.util.List;
import java.util.UUID;

public interface StatusService {
    public List<StatusModel> findAllStatuses();

    public StatusModel findStatusById(UUID id);

    public StatusModel addStatus(StatusModel status);

    public StatusModel updateStatus(StatusModel status);

    public void deleteStatus(UUID id);
}