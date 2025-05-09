package WorkForce.Job.Boarding.System.respository;

import WorkForce.Job.Boarding.System.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
