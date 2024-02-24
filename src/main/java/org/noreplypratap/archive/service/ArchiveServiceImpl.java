package org.noreplypratap.archive.service;

import org.noreplypratap.archive.model.Archive;
import org.noreplypratap.archive.repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveRepository repository;

    @Override
    public List<Archive> getAllArchives() {
        return repository.findAll();
    }

    @Override
    public Archive saveArchive(Archive archive) {
        return repository.save(archive);
    }

}
