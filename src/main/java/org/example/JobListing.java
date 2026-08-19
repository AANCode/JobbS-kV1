package org.example;

import java.util.List;

public class JobListing {

    private String title;
    private String company;
    private String location;
    private List<String> technologies;
    private String url;
    private String status;

    public JobListing(String title, String company, String location, List<String> technologies, String url, String status) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.technologies = technologies;
        this.url = url;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getTechnologies() {
        return technologies;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "JobListing{" +
                "title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", technologies=" + technologies +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}