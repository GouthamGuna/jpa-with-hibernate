package in.gmsk.respository;

import in.gmsk.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepository extends JpaRepository<FileData, Long> {

    Optional<FileData> findByName(String fileName);
}
