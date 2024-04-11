package org.am.binary.search;


public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target)
                return mid;
            if (mid == l || mid == r)
                return target == nums[l] ? l : target == nums[r] ? r : -1;

            if (nums[mid] < nums[r] && nums[mid - 1] < nums[mid]) {
                if (target >= nums[mid + 1] && target <= nums[r])
                    return binarySearch(nums, target, mid + 1, r);
                else
                    r = mid - 1;
            } else //if (nums[mid] > nums[l] && nums[mid + 1] > nums[mid]) {
                if (target <= nums[mid - 1] && target >= nums[l])
                    return binarySearch(nums, target, l, mid - 1);
                else
                    l = mid + 1;
        }
        return nums[l] == target ? l : -1;
    }

    private static int binarySearch(int[] nums, int target, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            if (target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return nums[l] == target ? l : -1;
    }
}
