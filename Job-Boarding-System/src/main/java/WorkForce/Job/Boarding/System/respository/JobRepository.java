package WorkForce.Job.Boarding.System.respository;

import WorkForce.Job.Boarding.System.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Page<Job> findByIsActiveTrue(Pageable pageable);

    @Query("SELECT j FROM Job j WHERE j.isActive = true AND " +
            "(LOWER(j.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(j.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(j.company.name) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    Page<Job> searchJobs(@Param("keyword") String keyword, Pageable pageable);

    Page<Job> findByCompanyIdAndIsActiveTrue(Long companyId, Pageable pageable);

    @Query("SELECT j FROM Job j WHERE j.isActive = true AND j.location LIKE %:location%")
    Page<Job> findByLocationContainingAndIsActiveTrue(@Param("location") String location, Pageable pageable);
}
