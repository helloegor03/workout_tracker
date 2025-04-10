package ru.helloegor03.myapp.controller;

import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.helloegor03.myapp.Config.UserDetailsImplementaion;
import ru.helloegor03.myapp.Model.User;
import ru.helloegor03.myapp.Model.Workout;
import ru.helloegor03.myapp.service.UserService;
import ru.helloegor03.myapp.service.WorkoutService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;
    private final UserService userService;  // Сервис для получения пользователя

    @Autowired
    public WorkoutController(WorkoutService workoutService, UserService userService) {
        this.workoutService = workoutService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout, Authentication authentication) {

        UserDetailsImplementaion userDetails = (UserDetailsImplementaion) authentication.getPrincipal();


        User user = userDetails.getUser();  // Теперь можно получить объект User

        workout.setUser(user);

        Workout createdWorkout = workoutService.addNewWorkout(workout);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWorkout);
    }
}