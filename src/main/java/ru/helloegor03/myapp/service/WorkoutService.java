package ru.helloegor03.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.helloegor03.myapp.Model.Workout;
import ru.helloegor03.myapp.repository.WorkoutRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    private WorkoutRepository workoutRepository;
    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public List<Workout> getWorkoutByUserId(Long userId){
        return workoutRepository.findByUserId(userId);
    }

    public Workout addNewWorkout(Workout workout){
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long workoutId){
        workoutRepository.deleteById(workoutId);
    }

    public Optional<Workout> getWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId);
    }



}
