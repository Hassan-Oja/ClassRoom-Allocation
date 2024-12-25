import java.util.LinkedList;
import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lectures: ");
        int n = sc.nextInt();
        LinkedList<lecture> lectures = new LinkedList<>();

        for(int i = 0; i < n ; i++){
            System.out.println("Enter the start time of the lecture " + (i+1) + ": ");
            int start = sc.nextInt();
            System.out.println("Enter the end time of the lecture"+ (i+1) + ": ");
            int end = sc.nextInt();
            lectures.add(new lecture(start, end));
        }

        // Run greedy

        System.out.println("Greedy Algorithm:");

        int totalRooms = greedy.allocation(lectures);

         //Display the total number of rooms required
        System.out.println("Total Rooms Required: " + totalRooms);
         //Display the room assignments
        System.out.println("Room Assignments:");
        for (int i = 0; i < lectures.size(); i++) {
            lecture lecture = lectures.get(i);
            System.out.println("Lecture " + (i + 1) + " (" + lecture.starttime + "-" + lecture.endtime + "): Room " + lecture.room);
        }
       
          System.out.println("");
          
        // Run Dynamic Programming
        System.out.println("Dynamic Programming Algorithm:");
       
        List<Integer> roomAssignments = dp.allocateClassrooms(lectures);

        // Display total number of rooms required and the room assignments
         System.out.println("Room Assignments:");
        for (int i = 0; i < lectures.size(); i++) {
            lecture lecture = lectures.get(i);
            System.out.println("Lecture " + (i + 1) + " (" + lecture.starttime + "-" + lecture.endtime + "): Room " + lecture.room);
        }

    }
}