package com.web_project.school.service;

import com.web_project.school.model.StatusModel;
import com.web_project.school.repository.StatusRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryStatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;

    public InMemoryStatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<StatusModel> findAllStatuses() {
        return statusRepository.findAll(Sort.by("id"));
    }

    @Override
    public StatusModel findStatusById(UUID id) {
        return statusRepository.findById(id).orElse(null);
    }

    @Override
    public StatusModel addStatus(StatusModel status) {
        return statusRepository.save(status);
    }

    @Override
    public StatusModel updateStatus(StatusModel status) {
        if (statusRepository.existsById(status.getId())) {
            return statusRepository.save(status);
        }
        return null;
    }

    @Override
    public void deleteStatus(UUID id) {
        if (statusRepository.existsById(id)) {
            statusRepository.deleteById(id);
        }
    }
}