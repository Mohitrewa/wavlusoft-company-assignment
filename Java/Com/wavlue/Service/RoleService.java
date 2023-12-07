import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long roleId, Role updatedRole) {
        Optional<Role> existingRoleOptional = roleRepository.findById(roleId);

        if (existingRoleOptional.isPresent()) {
            Role existingRole = existingRoleOptional.get();
            // Update fields as needed
            existingRole.setName(updatedRole.getName());

            return roleRepository.save(existingRole);
        } else {
            // Handle role not found
            return null;
        }
    }

    public void deleteRole(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    // Add more business logic as needed
}
