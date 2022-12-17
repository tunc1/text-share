package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Text;

import java.time.LocalDateTime;
import java.util.Optional;

public interface TextRepository extends JpaRepository<Text,Long>
{
    Optional<Text> findByIdAndExpireDateGreaterThan(Long id,LocalDateTime dateTime);
    void deleteByExpireDateLessThan(LocalDateTime dateTime);
}