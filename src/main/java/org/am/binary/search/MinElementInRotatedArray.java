package org.am.binary.search;

public class MinElementInRotatedArray {

    // The idea is to identify that position in the array where the increasing sequence ends
    // A sorted but rotated array has atleast one half which is an increasing sequence.
    // The crux here is to narrow the search by identifying such halves and eliminating them
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {

            if (r - l + 1 == 2)
                return Math.min(nums[l], nums[r]);

            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if (nums[mid] < nums[mid - 1])
                return nums[mid];

            if (nums[mid] < nums[r] && nums[mid - 1] < nums[mid])
                r = mid - 1;
            else //if (nums[mid] > nums[l] && nums[mid + 1] > nums[mid])
                l = mid + 1;
        }
        return nums[l];
    }
}
