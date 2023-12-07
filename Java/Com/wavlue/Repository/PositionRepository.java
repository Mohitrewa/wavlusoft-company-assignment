import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Long> {

    // Custom query method using naming convention
    Position findByName(String name);

    // Custom query method using @Query annotation
    @Query("SELECT p FROM Position p WHERE p.name = :name")
    Position findPositionByName(@Param("name") String name);

    // Custom query method to find positions by a certain criteria
    List<Position> findByCriteria(String criteria);

    // Custom query method to find all active positions
    List<Position> findByIsActiveTrue();

    // Custom query method to find positions by a department
    List<Position> findByDepartment(String department);

    // Custom query method to count positions with a certain status
    long countByStatus(String status);

    // Custom query method to find positions with a specific level
    List<Position> findByLevel(String level);

    // Custom query method to find positions with salary greater than a given amount
    List<Position> findBySalaryGreaterThan(double amount);

    // Custom query method to find positions by multiple criteria
    List<Position> findByDepartmentAndLevelAndIsActiveTrue(String department, String level);

    // You can add more custom query methods as needed
}
