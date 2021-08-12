package algo.array;

import java.util.LinkedList;
import java.util.List;

public class Countsmallerinversionarray {

        private int[] result;
        private int[] nums;

        public List<Integer> countSmaller(int[] nums) {
            this.nums = nums;
            int length = nums.length;
            int[] indexes = new int[length];

            for (int i = 0; i < length; i++) {
                indexes[i] = i;
            }
            result = new int[length];
            for (int i = 0; i < result.length; i++) {
                result[i] = 0;
            }

            mergeSortCount(indexes, 0, length - 1);

            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < result.length; i++) {
                list.add(result[i]);
            }

            return list;
        }

        private void mergeSortCount(int[] indexes, int start, int end) {
            if (start >= end) {
                return;
            }
            int middle = (start + end) / 2;
            mergeSortCount(indexes, start, middle);
            mergeSortCount(indexes, middle + 1, end);
            mergeAndCount(indexes, start, middle, end);
        }

        private void mergeAndCount(int[] indexes, int start, int middle, int end) {
            int[] left = new int[middle - start + 1];
            int[] right = new int[end - middle];

            for (int i = 0; i < left.length; i++) {
                left[i] = indexes[start + i];
            }
            for (int i = 0; i < right.length; i++) {
                right[i] = indexes[middle + 1 + i];
            }

            int leftPointer = 0;
            int rightPointer = 0;
            int pointer = 0;

            while (leftPointer < left.length || rightPointer < right.length) {
                if (rightPointer >= right.length || (leftPointer < left.length && nums[left[leftPointer]] <= nums[right[rightPointer]])) {
                    int index = left[leftPointer];
                    indexes[start + pointer] = index;
                    result[index] += rightPointer; //this is possibly the only line which deviates with standard merge sort
                    leftPointer++;
                } else {
                    int index = right[rightPointer];
                    indexes[start + pointer] = index;
                    rightPointer++;
                }
                pointer++;
            }
        }
    }
