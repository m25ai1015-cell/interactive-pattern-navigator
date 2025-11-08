package org.iitj.catalog.controller;

import org.iitj.catalog.service.PatternFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.iitj.catalog.model.Pattern;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatternController {

    @Autowired
    private PatternFileService service;

    @GetMapping("/")
    public String home() { return "index"; }

    @GetMapping("/patterns/{name}")
    public String patternPage(@PathVariable("name") String name, Model model) {
        Pattern p = service.findByKey(name);

        if (p == null) {
            model.addAttribute("error", "Pattern not found");
            return "pattern-not-found";
        }

        // similar patterns
        List<String> similar = new ArrayList<>();
        for(String x : p.getSimilar()){
            similar.add(x);
        }


        model.addAttribute("pattern", p);
        model.addAttribute("similarPatterns", similar);
        return "pattern-details";
    }

    @GetMapping("/patterns")
    public String listPatterns(Model model) {
        model.addAttribute("patterns", service.all());
        return "patterns-list";
    }
}
