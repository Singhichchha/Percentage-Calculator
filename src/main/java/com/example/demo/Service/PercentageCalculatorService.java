package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class PercentageCalculatorService {
	
	private double totalObtained;
    private double totalPossible;

    public double calculatePercentage(int[] marks, int[] totalMarks) {
        totalObtained = 0;
        totalPossible = 0;

        for (int i = 0; i < marks.length; i++) {
            totalObtained += marks[i];
            totalPossible += totalMarks[i];
        }

        return (totalObtained / totalPossible) * 100;
    }

    public double getTotalObtained() {
        return totalObtained;
    }

    public double getTotalPossible() {
        return totalPossible;
    }

}
