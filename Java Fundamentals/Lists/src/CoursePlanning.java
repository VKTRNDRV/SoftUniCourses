import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> lessonsList = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());

        while(true){
            String[] currentCommand = scan.nextLine().split(":");
            if(currentCommand[0].equals("course start")){
                break;
            }
            String titleOfLesson = currentCommand[1];
            boolean isLessonPresent = lessonsList.contains(titleOfLesson);

            switch (currentCommand[0]){
                case "Add":
                    if(!isLessonPresent){
                        lessonsList.add(titleOfLesson);
                    }
                    break;

                case "Insert":
                    if(!isLessonPresent){
                        int insertIndex = Integer.parseInt(currentCommand[2]);
                        lessonsList.add(insertIndex, titleOfLesson);
                    }
                    break;

                case "Remove":
                    if(isLessonPresent){
                        int removeIndex = lessonsList.indexOf(titleOfLesson);
                        if(!containsExercise(lessonsList, titleOfLesson)){
                            lessonsList.remove(removeIndex);
                        }else{
                            lessonsList.remove(removeIndex);
                            lessonsList.remove(removeIndex + 1);
                        }
                    }
                    break;

                case "Swap":
                    boolean isSecondLessonPresent = lessonsList.contains(currentCommand[2]);
                    if(isLessonPresent && isSecondLessonPresent){
                        String titleOfSecondLesson = currentCommand[2];
                        boolean isFirstLessonExercise = containsExercise(lessonsList, titleOfLesson);
                        boolean isSecondLessonExercise = containsExercise(lessonsList, titleOfSecondLesson);

                        int firstLessonIndex = lessonsList.indexOf(titleOfLesson);
                        int secondLessonIndex = lessonsList.indexOf(titleOfSecondLesson);

                        if(!isFirstLessonExercise && !isSecondLessonExercise){
                            swapTwoElements(lessonsList, firstLessonIndex, secondLessonIndex);

                        }else if(isFirstLessonExercise && isSecondLessonExercise){
                            swapTwoElements(lessonsList, firstLessonIndex, secondLessonIndex);
                            swapTwoElements(lessonsList, firstLessonIndex + 1, secondLessonIndex + 1);

                        }else if(isFirstLessonExercise && !isSecondLessonExercise){
                            swapTwoElements(lessonsList, firstLessonIndex, secondLessonIndex);
                            lessonsList.add(secondLessonIndex + 1, titleOfLesson + "-Exercise");
                            lessonsList.remove(firstLessonIndex + 1);

                        }else{// !isFirstLessonExercise && isSecondLessonExercise
                            swapTwoElements(lessonsList, firstLessonIndex, secondLessonIndex);
                            lessonsList.add(firstLessonIndex + 1, titleOfSecondLesson + "-Exercise");
                            lessonsList.remove(secondLessonIndex + 2); //+2 because we added a new element on the previous line
                        }
                    }
                    break;

                case "Exercise":
                    if(isLessonPresent && !containsExercise(lessonsList,titleOfLesson)){
                        int lessonIndex = lessonsList.indexOf(titleOfLesson);
                        lessonsList.add(lessonIndex + 1, titleOfLesson + "-Exercise");

                    }else if(!isLessonPresent){
                        lessonsList.add(titleOfLesson);
                        lessonsList.add(titleOfLesson + "-Exercise");
                    }

                    break;
            }
        }

        for (int i = 0; i < lessonsList.size(); i++) {
            System.out.printf("%d.%s%n", i+1, lessonsList.get(i));
        }
    }

    public static boolean containsExercise(List<String> lessonsList, String titleOfLesson){
        int lessonIndex = lessonsList.indexOf(titleOfLesson);

        if(lessonIndex == -1){//if there is no such lesson
            return false;
        }else if(lessonIndex == (lessonsList.size() - 1)){//if the lesson is the last element
            return false;
        }else{
            return lessonsList.get(lessonIndex + 1).equals(titleOfLesson + "-Exercise");
        }
    }

    public static void swapTwoElements(List<String> list, int index1, int index2){
        String firstElement = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, firstElement);
    }
}
