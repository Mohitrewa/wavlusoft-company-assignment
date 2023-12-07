import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Optional<Position> getPositionById(Long positionId) {
        return positionRepository.findById(positionId);
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(Long positionId, Position updatedPosition) {
        Optional<Position> existingPositionOptional = positionRepository.findById(positionId);

        if (existingPositionOptional.isPresent()) {
            Position existingPosition = existingPositionOptional.get();
            // Update fields as needed
            existingPosition.setName(updatedPosition.getName());

            return positionRepository.save(existingPosition);
        } else {
            // Handle position not found
            return null;
        }
    }

    public void deletePosition(Long positionId) {
        positionRepository.deleteById(positionId);
    }

    // Add more business logic as needed
}
