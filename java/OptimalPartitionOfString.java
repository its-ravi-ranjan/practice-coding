import java.util.HashSet;

// Start with an int vairable: This variable will hold the count of the string that we create.

// Use two pointers: Think of these as two fingers pointing at different letters in the string. One finger (l) starts at the beginning, and the other finger (r) moves from the beginning to the end.

// Use a set to keep track of letters: A set is like a bag that can hold letters, but it won't let you put the same letter in twice.

// Move the right finger (r) through the string:
// If the letter at r is already in the set, it means we've seen this letter before in the current part. So, we increase count by 1.

// Then, we move the left finger (l) to where the right finger (r) is, and clear the set to start a new part.
// If the letter at r is not in the set, we just add it to the set.
// Count the parts: The number of parts in the list plus one (for the last part that might not have been added yet) is the answer.


public class OptimalPartitionOfString{
    public int partitionString(String s) {
        
        HashSet<Character> visited = new HashSet<>();
        int finalcount = 0;

        for(char letter : s.toCharArray()){
            if(visited.contains(letter)){
                finalcount = finalcount+1;
                visited.clear();
            }
            visited.add(letter);
        }
        return finalcount+1;

    }

    public static void main(String[] args){
        OptimalPartitionOfString partitions = new OptimalPartitionOfString();
        // int answer = partitions.partitionString("abacaba");
        System.out.println(partitions.partitionString("abacaba"));
    }
}