package ru.helloegor03.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.helloegor03.myapp.Model.Workout;

import java.util.List;
import java.util.Optional;
@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByUserId(Long userId);

}
