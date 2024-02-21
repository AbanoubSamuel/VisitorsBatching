package org.abg.visitor.controller;

import org.abg.visitor.utls.JsonResponse;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class JobController {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @GetMapping("/runJob")
    public ResponseEntity<JsonResponse> load() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("timestamp", Calendar.getInstance().getTime())
                .toJobParameters();
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        while (jobExecution.isRunning()) {
            System.out.println("Job Executing.....");
        }
        JsonResponse<String> jsonResponse = new JsonResponse<>();
        jsonResponse.setStatus(true);
        jsonResponse.setMessage("Job: " + jobExecution.getStatus());
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }
}
