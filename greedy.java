import java.util.*;

public class greedy {
     public static int allocation(LinkedList<lecture> lectures) {
    int roomcount = 0;

    //  Sort all lectures by start time
    lectures.sort(Comparator.comparingInt(lecture -> lecture.starttime));

    //  Priority Queue to track end times of rooms
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    for (lecture lecture : lectures) {
        // Reuse a room if its end time is <= the current lecture's start time
        if (!pq.isEmpty() && pq.peek()[1] <= lecture.starttime) {
            int[] room = pq.poll();
            // Assign the lecture for this room
            lecture.room = (int) room[0]; 
        } else {
            // Otherwise, creat a new room
            roomcount++;
            lecture.room = roomcount;
        }

        // Add the current lecture's room and end time to the priority queue
        pq.offer(new int[]{lecture.room, lecture.endtime});
    }

    return roomcount;
 }
    
}
