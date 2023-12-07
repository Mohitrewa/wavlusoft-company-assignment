import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    // Custom query method using naming convention
    Role findByName(String name);

    // Custom query method to find roles by category
    List<Role> findByCategory(String category);

    // Custom query method to find roles by type
    List<Role> findByType(String type);

    // Custom query method to find roles by status
    List<Role> findByStatus(String status);

    // Custom query method to count roles by permission
    long countByPermission(String permission);

    // Custom query method to find roles by level
    List<Role> findByLevel(String level);

    // Custom query method to find roles by department
    List<Role> findByDepartment(String department);

    // Custom query method to find roles by multiple criteria
    List<Role> findByTypeAndStatusAndLevel(String type, String status, String level);

    // You can add more custom query methods as needed
}
