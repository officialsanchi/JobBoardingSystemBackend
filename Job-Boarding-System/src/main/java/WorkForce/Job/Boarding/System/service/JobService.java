package WorkForce.Job.Boarding.System.service;

import java.util.Optional;

import WorkForce.Job.Boarding.System.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface JobService {
    Page<Job> searchJobs(String keyword, Pageable pageable);
    Page<Job> getJobsByLocation(String location, Pageable pageable);
    Optional<Job> getJobById(Long id);

    Optional<Job> getJobById(Long id);
    void deleteJob(Long id);
    Page<Job> getAllActiveJobs(Pageable pageable);
    Job saveJob(Job job);
    void deleteJob(Long id);
    Page<Job> getJobsByCompany(Long companyId, Pageable pageable);
}
