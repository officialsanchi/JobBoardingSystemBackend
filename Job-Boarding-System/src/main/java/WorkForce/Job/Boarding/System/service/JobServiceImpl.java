package WorkForce.Job.Boarding.System.service;

import WorkForce.Job.Boarding.System.entity.Job;
import WorkForce.Job.Boarding.System.respository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {


    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public Page<Job> getAllActiveJobs(Pageable pageable) {
        return jobRepository.findByIsActiveTrue(pageable);
    }



    @Override
    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Page<Job> searchJobs(String keyword, Pageable pageable) {
        return jobRepository.searchJobs(keyword, pageable);
    }

    @Override
    public Page<Job> getJobsByCompany(Long companyId, Pageable pageable) {
        return jobRepository.findByCompanyIdAndIsActiveTrue(companyId, pageable);
    }

    @Override
    public Page<Job> getJobsByLocation(String location, Pageable pageable) {
        return jobRepository.findByLocationContainingAndIsActiveTrue(location, pageable);
    }

    @Override
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
