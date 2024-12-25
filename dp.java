import java.util.*;
public class dp{
     public static List<Integer> allocateClassrooms(List<lecture> lectures) {
        // Sort lectures by start time
        lectures.sort(Comparator.comparingDouble(l -> l.starttime));

        List<Integer> endTimes = new ArrayList<>();
        for (lecture lecture : lectures) {
            boolean assigned = false;

            // check if a room is available for the current lecture
            for (int i = 0; i < endTimes.size(); i++) {
                if (lecture.starttime >= endTimes.get(i)) {
                    lecture.room = i + 1;
                    endTimes.set(i, lecture.endtime);
                    assigned = true;
                    break;
                }
            }

            // If no room is available, creat a new room
            if (!assigned) {
                lecture.room = endTimes.size() + 1;
                endTimes.add(lecture.endtime);
            }
        }
        

        // Collect room assignments
        List<Integer> roomAssignments = new ArrayList<>();
        for (lecture lecture : lectures) {
            roomAssignments.add(lecture.room);
        }
        System.out.println("Total Rooms Required : "+endTimes.size());
        return roomAssignments;
   }
}