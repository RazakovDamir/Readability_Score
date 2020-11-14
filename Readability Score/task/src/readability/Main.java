package readability;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        StringBuilder input = new StringBuilder();
        File book = new File(args[0]);
        try (Scanner scanner = new Scanner(book)) {
            while (scanner.hasNext()) {
                input.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found: ");
        }
        Scanner sc = new Scanner(System.in);
        int sentences = input.toString().split("[!.?]").length;
        int words = input.toString().split("\\s").length;
        int characters = input.toString().replaceAll(" |\n|\t", "").split("").length;
        int syllables = input.toString().replace("The | the | We | we", "a")
                .replaceAll("e\\b", "")
                .replaceAll("you", "a")
                .replaceAll("[aeiouy]{2}", "a")
                .replaceAll(" th ", " a ")
                .replaceAll(",", "")
                .replaceAll(" w ", " a ")
                .replaceAll("[0-9]+", "a")
                .replaceAll("[^aeiouy]", "")
                .length();
        int polysyllables = 0;
        String[] p = input.toString().toLowerCase().split("\\s+");
        for(int i = 0; i < words; i++) {
            if(p[i].replaceAll("e\\b", "")
                    .replaceAll("you", "a")
                    .replaceAll("[aeiouy]{2}", "a")
                    .replaceAll(" th ", " a ")
                    .replaceAll(",", "")
                    .replaceAll(" w ", " a ")
                    .replaceAll("[0-9]+", "a")
                    .replaceAll("[^aeiouy]", "")
                    .length() > 2) {
                polysyllables += 1;
            }
        }
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + characters);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);
        double score = 4.71 * ((double) characters / (double) words) + 0.5 * ((double) words / (double) sentences) - 21.43;
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        switch (sc.next()) {
            case "ARI":
                ARI(score);
                break;
            case "FK":
                FK(words, sentences, syllables);
                break;
            case "SMOG":
                SMOG(polysyllables, sentences);
                break;
            case "CL":
                CL(words, sentences, characters);
                break;
            case "all":
                ARI(score);
                FK(words, sentences, syllables);
                SMOG(polysyllables, sentences);
                CL(words, sentences, characters);
                break;
        }
        double score1 = 0.39 * ((double) words / (double) sentences) + 11.8 * ((double) syllables / (double) words) - 15.59;
        double score2 = 1.043 * Math.sqrt(polysyllables * (30 / (double) sentences)) + 3.1291;
        int s = sentences / words * 100;
        int l = characters / words * 100;
        double score3 = 0.0588 * l - 0.296 * s - 15.8;
        double end = (score + score1 + score2 + score3) / 4;
        if (end >= 0 && end < 1) {
            System.out.println("This text should be understood in average by " + end + " (about 6 year olds).");
        } else if (end >= 1 && end < 2) {
            System.out.println("This text should be understood in average by " + end + " (about 7 year olds).");
        } else if (end >= 2 && end < 3) {
            System.out.println("This text should be understood in average by " + end + " (about 9 year olds).");
        } else if (end >= 3 && end < 4) {
            System.out.println("This text should be understood in average by " + end + " (about 10 year olds).");
        } else if (end >= 4 && end < 5) {
            System.out.println("This text should be understood in average by " + end + " (about 11 year olds).");
        } else if (end >= 5 && end < 6) {
            System.out.println("This text should be understood in average by " + end + " (about 12 year olds).");
        } else if (end >= 6 && end < 7) {
            System.out.println("This text should be understood in average by " + end + " (about 13 year olds).");
        } else if (end >= 7 && end < 8) {
            System.out.println("This text should be understood in average by " + end + " (about 14 year olds).");
        } else if (end >= 8 && end < 9) {
            System.out.println("This text should be understood in average by " + end + " (about 15 year olds).");
        } else if (end >= 9 && end < 10) {
            System.out.println("This text should be understood in average by " + end + " (about 16 year olds).");
        } else if (end >= 10 && end < 11) {
            System.out.println("This text should be understood in average by " + end + " (about 17 year olds).");
        } else if (end >= 11 && end < 12) {
            System.out.println("This text should be understood in average by " + end + " (about 18 year olds).");
        } else if (end >= 12 && end < 13) {
            System.out.println("This text should be understood in average by " + end + " (about 24 year olds).");
        } else if (end > 13) {
            System.out.println("This text should be understood in average by " + end + " (about 25 year olds).");
        }
    }

    public static void ARI(double score) {
        if (score >= 0 && score < 1) {
            System.out.println("Automated Readability Index: " + score + " (about 6 year olds).");
        } else if (score >= 1 && score < 2) {
            System.out.println("Automated Readability Index: " + score + " (about 7 year olds).");
        } else if (score >= 2 && score < 3) {
            System.out.println("Automated Readability Index: " + score + " (about 9 year olds).");
        } else if (score >= 3 && score < 4) {
            System.out.println("Automated Readability Index: " + score + " (about 10 year olds).");
        } else if (score >= 4 && score < 5) {
            System.out.println("Automated Readability Index: " + score + " (about 11 year olds).");
        } else if (score >= 5 && score < 6) {
            System.out.println("Automated Readability Index: " + score + " (about 12 year olds).");
        } else if (score >= 6 && score < 7) {
            System.out.println("Automated Readability Index: " + score + " (about 13 year olds).");
        } else if (score >= 7 && score < 8) {
            System.out.println("Automated Readability Index: " + score + " (about 14 year olds).");
        } else if (score >= 8 && score < 9) {
            System.out.println("Automated Readability Index: " + score + " (about 15 year olds).");
        } else if (score >= 9 && score < 10) {
            System.out.println("Automated Readability Index: " + score + " (about 16 year olds).");
        } else if (score >= 10 && score < 11) {
            System.out.println("Automated Readability Index: " + score + " (about 17 year olds).");
        } else if (score >= 11 && score < 12) {
            System.out.println("Automated Readability Index: " + score + " (about 18 year olds).");
        } else if (score >= 12 && score < 13) {
            System.out.println("Automated Readability Index: " + score + " (about 24 year olds).");
        } else if (score > 13) {
            System.out.println("Automated Readability Index: " + score + " (about 25 year olds).");
        }
    }
    public static void FK(int words, int sentences, int syllables) {
        double score1 = 0.39 * ((double) words / (double) sentences) + 11.8 * ((double) syllables / (double) words) - 15.59;
        if (score1 >= 0 && score1 < 1) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 6 year olds).");
        } else if (score1 >= 1 && score1 < 2) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 7 year olds).");
        } else if (score1 >= 2 && score1 < 3) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 9 year olds).");
        } else if (score1 >= 3 && score1 < 4) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 10 year olds).");
        } else if (score1 >= 4 && score1 < 5) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 11 year olds).");
        } else if (score1 >= 5 && score1 < 6) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 12 year olds).");
        } else if (score1 >= 6 && score1 < 7) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 13 year olds).");
        } else if (score1 >= 7 && score1 < 8) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 14 year olds).");
        } else if (score1 >= 8 && score1 < 9) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 15 year olds).");
        } else if (score1 >= 9 && score1 < 10) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 16 year olds).");
        } else if (score1 >= 10 && score1 < 11) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 17 year olds).");
        } else if (score1 >= 11 && score1 < 12) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 18 year olds).");
        } else if (score1 >= 12 && score1 < 13) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 24 year olds).");
        } else if (score1 > 13) {
            System.out.println("Flesch–Kincaid readability tests: " + score1 + " (about 25 year olds).");
        }
    }
    public static  void SMOG(int polysyllables, int sentences) {
        double score2 = 1.043 * Math.sqrt(polysyllables * (30 / (double) sentences)) + 3.1291;
        if (score2 >= 0 && score2 < 1) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 6 year olds).");
        } else if (score2 >= 1 && score2 < 2) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 7 year olds).");
        } else if (score2 >= 2 && score2 < 3) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 9 year olds).");
        } else if (score2 >= 3 && score2 < 4) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 10 year olds).");
        } else if (score2 >= 4 && score2 < 5) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 11 year olds).");
        } else if (score2 >= 5 && score2 < 6) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 12 year olds).");
        } else if (score2 >= 6 && score2 < 7) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 13 year olds).");
        } else if (score2 >= 7 && score2 < 8) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 14 year olds).");
        } else if (score2 >= 8 && score2 < 9) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 15 year olds).");
        } else if (score2 >= 9 && score2 < 10) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 16 year olds).");
        } else if (score2 >= 10 && score2 < 11) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 17 year olds).");
        } else if (score2 >= 11 && score2 < 12) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 18 year olds).");
        } else if (score2 >= 12 && score2 < 13) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 24 year olds).");
        } else if (score2 > 13) {
            System.out.println("Simple Measure of Gobbledygook: " + score2 + " (about 25 year olds).");
        }
    }
    public static void CL(int words, int sentences, int characters) {
        int s = sentences / words * 100;
        int l = characters / words * 100;
        double score3 = 0.0588 * l - 0.296 * s - 15.8;
        if (score3 >= 0 && score3 < 1) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 6 year olds).");
        } else if (score3 >= 1 && score3 < 2) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 7 year olds).");
        } else if (score3 >= 2 && score3 < 3) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 9 year olds).");
        } else if (score3 >= 3 && score3 < 4) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 10 year olds).");
        } else if (score3 >= 4 && score3 < 5) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 11 year olds).");
        } else if (score3 >= 5 && score3 < 6) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 12 year olds).");
        } else if (score3 >= 6 && score3 < 7) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 13 year olds).");
        } else if (score3 >= 7 && score3 < 8) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 14 year olds).");
        } else if (score3 >= 8 && score3 < 9) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 15 year olds).");
        } else if (score3 >= 9 && score3 < 10) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 16 year olds).");
        } else if (score3 >= 10 && score3 < 11) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 17 year olds).");
        } else if (score3 >= 11 && score3 < 12) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 18 year olds).");
        } else if (score3 >= 12 && score3 < 13) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 24 year olds).");
        } else if (score3 > 13) {
            System.out.println("Coleman–Liau index: " + score3 + " (about 25 year olds).");
        }
    }

}