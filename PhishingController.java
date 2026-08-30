package com.phishingdetector.phishing_email_detector;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PhishingController {

    // Opens the home page
    @GetMapping("/")
    public String home() {

        return "index";
    }


    // This method receives the email form
    @PostMapping("/analyze")
    public String analyzeEmail(

            @RequestParam String sender,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam String url,
            @RequestParam String attachment,

            Model model) {


        // Create a list to store detection reasons
        List<String> reasons = new ArrayList<>();


        // Create an Email object
        Email email = new Email(
                sender,
                subject,
                body,
                url,
                attachment
        );


        // Create analyzer object
        EmailAnalyzer analyzer = new EmailAnalyzer();


        // Calculate phishing score
        int score = analyzer.calculateScore(
                email,
                reasons
        );


        // Decide the risk level
        String result;

        if (score >= 60) {

            result = "HIGH RISK - POSSIBLE PHISHING";

        } else if (score >= 30) {

            result = "MEDIUM RISK - SUSPICIOUS EMAIL";

        } else {

            result = "LOW RISK - EMAIL APPEARS SAFE";
        }


        // Send data to HTML
        model.addAttribute("score", score);
        model.addAttribute("result", result);
        model.addAttribute("reasons", reasons);


        // Open result page
        return "result";
    }
}