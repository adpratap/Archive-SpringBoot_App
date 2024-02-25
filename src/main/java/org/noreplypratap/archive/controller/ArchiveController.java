package org.noreplypratap.archive.controller;


import org.noreplypratap.archive.model.Archive;
import org.noreplypratap.archive.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ArchiveController {

    @Autowired
    ArchiveService service;

    @GetMapping("/")
    public ModelAndView getHome() {
        List<Archive> list = service.getAllArchives();
        return new ModelAndView("home.html","archive",list);
    }

    @GetMapping("/deleteAll")
    public String deleteAllArchive() {
        service.deleteAllArchive();
        return "home.html";
    }

    @GetMapping("/addArchive")
    public String addArchive() {
        return "add.html";
    }

    @PostMapping("/save")
    public String addArchive(@ModelAttribute Archive archive) {
        System.out.println(archive);
        service.saveArchive(archive);
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteArchive(@PathVariable("id")Long id) {
        service.deleteArchive(id);
        return "redirect:/";
    }

    @RequestMapping("/update/{id}")
    public String updateArchive(@PathVariable("id") Long id, Model model) {
        Archive archive = service.getByIdArchive(id);
        model.addAttribute("archive",archive);
        return "edit.html";
    }

}
