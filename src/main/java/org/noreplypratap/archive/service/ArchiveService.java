package org.noreplypratap.archive.service;

import org.noreplypratap.archive.model.Archive;

import java.util.List;

public interface ArchiveService {

    public List<Archive> getAllArchives();

    public Archive saveArchive(Archive archive);
    public void deleteArchive(Long id);

    public void deleteAllArchive();

    public Archive getByIdArchive(Long id);

}
