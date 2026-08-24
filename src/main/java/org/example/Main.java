package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<JobListing> jobs = new ArrayList<>();

        JobListing job1 = new JobListing("Nyutdannet Teknologi 2027", "Sopra Steria", "Oslo", List.of("Java", "Spring", "PostgreSQL"), "*Senere", "søkt");
        JobListing job2 = new JobListing("Nyutdannet utvikler 2027", "Capgemini", "Oslo", List.of("Java", "Spring", "PostgreSQL"), "*Senere", "søkt");
        JobListing job3 = new JobListing("Junior utvikler", "Skynet", "Oslo", List.of(".Net", "C#", "PostgreSQL"), "*Senere", "Ikke søkt");
        JobListing job4 = new JobListing("Junior utvikler", "NRK", "Trondheim", List.of("C", "SDL2", "PostgreSQL"), "*Senere", "Ikke søkt");
        JobListing job5 = new JobListing("Junior utvikler", "Arasaka", "Oslo", List.of("Java", "Spring", "PostgreSQL"), "*Senere", "Ikke søkt");
        JobListing job6 = new JobListing("Junior utvikler", "Arasaka", "CA", List.of("Java", "Spring", "PostgreSQL"), "*Senere", "Ikke søkt");
        JobListing job7 = new JobListing("Senior utvikler", "Kongsbergs gruppen", "Kongsberg", List.of("Java", "Spring", "PostgreSQL"), "*Senere", "Ikke søkt");

        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        jobs.add(job5);
        jobs.add(job6);
        jobs.add(job7);

        Scanner scanner = new Scanner(System.in);
        int valg = -1;

        while (valg != 0) {
            printMenu();
            valg = Integer.parseInt(scanner.nextLine());

            switch (valg) {
                case 0: {
                    System.out.println("Avslutter...");
                    break;
                }

                case 1: {
                    printAllJobs(jobs);
                    break;
                }

                case 2: {
                    printJavaJobs(jobs);
                    break;
                }

                case 3: {
                    printRelevantJobs(jobs);
                    break;
                }

                case 4: {
                    System.out.println("Hvilket sted vildu søke");
                    String location = scanner.nextLine();

                    printJobsByLocation(jobs,location);
                    break;
                }

                case 5: {
                    printNotApplied(jobs);
                    break;
                }

                case 6: {
                    addJob(jobs, scanner);
                    break;
                }

                default:{
                    System.out.println("Ugyldig valg!");
                }
            }

        }
    }

    public static void printMenu(){
        System.out.println ("""
                1. Vis alle jobber\s
                2. Vis Java-jobber\s
                3. Vis Junior/nyutdannet Java-jobber som ikke er søkt\s
                4. Vis jobber etter sted\s
                5. Vis ikke-søkte jobber\s
                5. Legg til ny jobb\s
                0. Avslutt\s
                """);
    }

    public static boolean isJuniorGraduate(JobListing job) {
        return job.getTitle().contains("Junior") || job.getTitle().contains("Nyutdannet");
    }

    public static boolean hasJava(JobListing job) {
        return job.getTechnologies().contains("Java");
    }

    public static boolean isNotApplied(JobListing job) {
        return job.getStatus().equals("Ikke søkt");
    }

    public static void printAllJobs(List<JobListing> jobs){
        for (JobListing job : jobs){
            System.out.println(job);
        }
    }

    public static void printJavaJobs(List<JobListing> jobs){
        for (JobListing job : jobs){
            if (hasJava(job)){
                System.out.println(job);
            }
        }
    }

    public static void printRelevantJobs(List<JobListing> jobs){
        for (JobListing job : jobs){
            if (isJuniorGraduate(job) && hasJava(job) && isNotApplied(job)){
                System.out.println(job);
            }
        }
    }

    public static void printJobsByLocation(List<JobListing> jobs, String location){
        for (JobListing job : jobs){
            if (job.getLocation().equals(location)){
                System.out.println(job);
            }
        }
    }

    public static void printNotApplied(List<JobListing> jobs){
        for (JobListing job : jobs){
            if (isNotApplied(job)){
                System.out.println(job);
            }
        }
    }

    public static void addJob(List<JobListing> jobs, Scanner scanner){
        System.out.println("Hva er titlen til jobben?");
        String title = scanner.nextLine();

        System.out.println("Hva er navnet til selskap til jobben?");
        String company = scanner.nextLine();

        System.out.println("hvor er det det jobben er?");
        String location = scanner.nextLine();

        System.out.println("Hvilke er Teknologier kan du?");
        String techInput = scanner.nextLine();
        List<String> technologies = Arrays.asList(techInput.split(","));

        System.out.println("Hva er url til jobben?");
        String url = scanner.nextLine();

        System.out.println("Hva er statusen til jobben?");
        String status = scanner.nextLine();

        JobListing newJob = new JobListing(title,company,location,technologies,url,status);
        jobs.add(newJob);
        System.out.println("jobben har blitt lagt til");

    }
}