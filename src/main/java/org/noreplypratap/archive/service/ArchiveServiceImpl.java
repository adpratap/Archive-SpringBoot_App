package org.noreplypratap.archive.service;

import jakarta.transaction.Transactional;
import org.noreplypratap.archive.model.Archive;
import org.noreplypratap.archive.repository.ArchiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveRepository repository;

    @Override
    public List<Archive> getAllArchives() {
        return repository.findAll();
    }

    @Override
    public Archive saveArchive(Archive archive) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        archive.setTimestamp(timeStamp);
        return repository.save(archive);
    }

    @Override
    public void deleteArchive(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAllArchive() {
        repository.deleteAll();
    }

    @Override
    public Archive getByIdArchive(Long id) {
        return repository.findById(id).get();
    }


}
