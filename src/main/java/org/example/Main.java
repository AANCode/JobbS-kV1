package org.example;

import java.util.ArrayList;
import java.util.List;

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



    }

    public static void printMenu(){
        System.out.println ("1. Vis alle jobber \n" +
                            "2. Vis Java-jobber \n" +
                            "3. Vis Junior/nyutdannet Java-jobber som ikke er søkt \n" +
                            "4. Vis jobber etter sted \n" +
                            "5. Vis ikke-søkte jobber \n");
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

    public static void handleMenuChoice(){

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

    public static void handleMenuChoice(){

    }
}