package org.noreplypratap.archive.controller;


import org.noreplypratap.archive.model.Archive;
import org.noreplypratap.archive.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArchiveController {

    @Autowired
    ArchiveService service;

    @GetMapping("/")
    public String getHome() {
        //service.saveArchive(new Archive("Do Something","Nothing","13254654"));
        return "home.html";
    }
}
