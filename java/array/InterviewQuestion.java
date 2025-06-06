package java.array;

public class InterviewQuestion {
    // Q1 Given a binary array nums, return the maximum number of consecutive 1's in the array.
    // Input: nums = [1,1,0,1,1,1]
    // Output: 3
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0;
        int tempCount = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)tempCount++;
            if(nums[i]!=1){
                if(tempCount>maxCount)
                maxCount=tempCount;
                tempCount=0;
            }

        }
        if(tempCount>maxCount)
                maxCount=tempCount;
        return maxCount;
    }
    // Q2. Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    // Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    // Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    // Return k.
    // Input: nums = [1,1,2]
    // Output: 2, nums = [1,2,_]
    public int removeDuplicates(int[] nums) {
        if(nums.length<=0)return 0;
        int i=1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[j-1]){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}
