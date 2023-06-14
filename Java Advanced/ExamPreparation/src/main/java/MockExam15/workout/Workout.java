package MockExam15.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (this.exercises.size() < this.exerciseCount) {
            this.exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                this.exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : this.exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        if (this.exercises.isEmpty()) {
            return null;
        }

        Exercise mostCaloriesExercise = this.exercises.get(0);
        for (Exercise exercise : this.exercises) {
            if (exercise.getBurnedCalories() > mostCaloriesExercise.getBurnedCalories()) {
                mostCaloriesExercise = exercise;
            }
        }
        return mostCaloriesExercise;
    }

    public int getExerciseCount() {
        return this.exercises.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("Workout type: ").append(this.type).append("\n");
        for (Exercise exercise : this.exercises) {
            statistics.append(exercise.toString()).append("\n");
        }
        return statistics.toString().trim();
    }
}
