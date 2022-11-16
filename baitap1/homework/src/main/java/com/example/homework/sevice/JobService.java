package com.example.homework.sevice;

import com.example.homework.model.Job;
import com.example.homework.request.UpsertJobRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {
    private List<Job> jobs = new ArrayList<>();

    public JobService() {
        jobs.add(new Job("1", "java", "Des1", "hn", 1000, 2000, "java.email"));
        jobs.add(new Job("2", "sql", "Des2", "bn", 500, 1000, "sql.email"));
        jobs.add(new Job("3", "ios", "Des3", "hcm", 800, 2000, "ios.email"));
    }

    public List<Job> getJops() {
        return jobs;
    }

    public Job createJob(UpsertJobRequest request) {
        String id = UUID.randomUUID().toString();
        Job job = new Job(id,
                request.getTitle()
                , request.getDescription()
                , request.getLocation()
                , request.getMinSalary()
                , request.getMaxSalary()
                , request.getEmailTo());
        jobs.add(job);
        return job;
    }

    public Job updateJobById(String id, UpsertJobRequest request) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setDescription(request.getDescription());
                job.setLocation(request.getLocation());
                job.setMinSalary(request.getMinSalary());
                job.setMaxSalary(request.getMaxSalary());
                job.setEmailTo(request.getEmailTo());
                return job;
            }
        }
        return null;
    }
    public Job getJobById(String id, UpsertJobRequest request) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }
    public void deleteJob(String id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
            }
        }
    }
    public Job randomJob(){
        int id   = new Random().nextInt(jobs.size());
        return jobs.get(id);
    }
    public List<Job> sortJobBySalary(String field, String direction){
        if(field.equalsIgnoreCase("maxSalary")){
            if(direction.equalsIgnoreCase("ASC")){
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary)).toList();
            }else {
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary).reversed()).toList();
            }
        }else return null;
    }
}
