   // EASY Question Set
   
   // Q1 Given a binary array nums, return the maximum number of consecutive 1's in the array.
    // Input: nums = [1,1,0,1,1,1]
    // Output: 3
var findMaxConsecutiveOnes = function(nums) {
    let maxCount=0
    let currentCount = 0
    for(let i=0;i<nums.length;i++){
        if(nums[i]==1)currentCount++
        else{
            maxCount = Math.max(currentCount,maxCount)
            currentCount=0
        }
    }
    return Math.max(maxCount,currentCount)
};

    // Q2. Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    // Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    // Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    // Return k.
    // Input: nums = [1,1,2]
    // Output: 2, nums = [1,2,_]
    var removeDuplicates = function(nums) {
        if(nums.length<2) return nums.length
        let i = 1;
        for(let j=1;j<nums.length;j++){
           if(nums[j]!=nums[j-1]){
            nums[i]=nums[j]
            i++
           }
        }
        return i
    };
    // TWO SUM
    // Q3 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    // Input: nums = [2,7,11,15], target = 9
    // Output: [0,1]
    // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     // Brute Force in which we iterate thorugh each element and then for each elemtnt we check for next element matching with target
     // its time complexity is o(n^2) and space complexity o(1)
    var twoSum = function(nums, target) {
        let temp = 0
        while(temp!=nums.length-1){
        for(let i=temp+1;i<nums.length;i++){
            if(nums[temp]+nums[i]==target)
            {
                return [temp,i]
            }
        }
        temp = temp+1
        }
    };
    // improved version having time complexity o(n) and space complexity o(n) because of map
    var twoSum = function(nums, target) {
        let diff = new Map()
        for(let i=0;i<nums.length;i++){
          let compliment = target-nums[i]
          if(diff.has(compliment)){
             return [diff.get(compliment),i]
          }
          diff.set(nums[i],i)
        }
 };
 // Iteration 1:
 // i = 0, nums[i] = 2
 // complement = 9 - 2 = 7
// 7 not in map → store map[2] = 0

 // Iteration 2:
 // i = 1, nums[i] = 7
 // complement = 9 - 7 = 2
 // 2 is in map → map[2] = 0
 // Found! Return [0, 1]

 // Q4. Best Time to Buy and Sell Stock
 // You are given an array prices where prices[i] is the price of a given stock on the ith day.
 // You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 // Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 // Input: prices = [7,1,5,3,6,4]
 // Output: 5
 // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 // Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 // brute force solution time complexity o(n^2) and space complexity o(1)
 var maxProfit = function(prices) {
    let maxProfit = 0
    for(let i=0;i<prices.length;i++){
        for(let j=i+1;j<prices.length;j++){
            let profit = prices[j]-prices[i]
            if(profit>maxProfit){
                maxProfit = profit
            }
        }
    }
    return maxProfit
};
// best approach time complexity o(n) and space complexity o(1)
// Single Pass (Kadane-style logic)
// Keep track of:
// minPriceSoFar — lowest price seen so far
// maxProfitSoFar — best profit we can get if we sell today
var maxProfit = function(prices) {
    let minPrice = prices[0] // 1️⃣ initialize minimum price with first day
    let maxProfit = 0    // 2️⃣ profit starts at 0
    for(let i=1;i<prices.length;i++){  // 3️⃣ loop from 2nd day to end
        if(prices[i]< minPrice){
           minPrice = prices[i]  // 4️⃣ found a lower buy price
        }else{
            let profit = prices[i]-minPrice // 5️⃣ calculate profit if sold today
            if(profit>maxProfit){
                maxProfit = profit  // 6️⃣ update max profit if it's better
            }
        }
           
    }
    return maxProfit    // 7️⃣ return best profit
};
// Q5. Contains Duplicate
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Input: nums = [1,2,3,1]
// Output: true
// optimised  with time and space complexity is o(n)
// in brute force we use object mapping but complexity is same
var containsDuplicate = function(nums) {
    let set = new Set()
    for(let num of nums){
        if(set.has(num))return true
        set.add(num)
    }
     return false
 };
 // Q6. 3SUm
 // Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 // Notice that the solution set must not contain duplicate triplets.
 // Input: nums = [-1,0,1,2,-1,-4]
 // Output: [[-1,-1,2],[-1,0,1]]

 // can't possible with brute force because it will take n^3 so i am directly moving on optimised way
 // it will take o(n^2) time and o(1) space complexity
 var threeSum = function(nums) {
    nums.sort((a,b)=>a-b)
    let output = []
    for(let i=0;i<nums.length-2;i++){
        if(i>0 && nums[i]==nums[i-1])continue
        let left = i+1;
        let right = nums.length-1
        while(left<right){
            let sum = nums[i]+nums[left]+nums[right]
            if(sum==0){
                output.push([nums[i],nums[left],nums[right]])
                while(left<right && nums[left]==nums[left+1])left++
                while(left<right && nums[right]==nums[right-1])right--
                left++
                right--
            }else if(sum<0)left++
            else right--
        }
    }
    return output
};
// Product of Array Except Self
// Q7. Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// time complexity o(n) ans space o(1)
var productExceptSelf = function(nums) {
    let result = new Array(nums.length).fill(1)
    let prefix = 1
    for(let i = 0;i<nums.length;i++){
          result[i]=prefix
          prefix*=nums[i]
    }
    let suffix=1
    for(let j=nums.length-1;j>=0;j--){
        result[j]*=suffix
        suffix*=nums[j]
    }
    return result
};
// Q8. 



