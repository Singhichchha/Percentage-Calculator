package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Service.PercentageCalculatorService;

@Controller
public class PercentageCalculatorController {
	
	 private final PercentageCalculatorService percentageCalculatorService;

	    // Constructor injection without @Autowired
	    public PercentageCalculatorController(PercentageCalculatorService percentageCalculatorService) {
	        this.percentageCalculatorService = percentageCalculatorService;
	    }

    @GetMapping("/")
    public String index() {
        return "index"; // Return the initial form to input the number of subjects
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam int subjects,
            @RequestParam(required = false) int[] marks,
            @RequestParam(required = false) int[] totalMarks,
            Model model) {

        // Check if marks and totalMarks are not null, which means we are processing the final calculation
        if (marks != null && totalMarks != null) {
            double percentage = percentageCalculatorService.calculatePercentage(marks, totalMarks);
            model.addAttribute("percentage", percentage);
            model.addAttribute("totalObtained", percentageCalculatorService.getTotalObtained());
            model.addAttribute("totalPossible", percentageCalculatorService.getTotalPossible());
            return "result"; // Return the result view
        }

        // If marks and totalMarks are null, it means we are rendering the form to enter marks
        model.addAttribute("subjects", subjects);
        return "marksForm"; // Return the form to input marks and total marks
    }
    
}
