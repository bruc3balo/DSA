class MergeSortProblem {
    public static void main(String[] args) {
        
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            
        //merge
        int[] mergedArray = new int[nums1.length + nums2.length];
        
        int j = 0;
        
        for(int i = 0; i < mergedArray.length; i++) {
            if (i < nums1.length) {
                mergedArray[i] = nums1[i];
                continue;
            }
            
            mergedArray[i] = nums2[j];
            j++;
        }
        
        //merge sort
        
        mergeSort(mergedArray);
        
        int length = mergedArray.length;
        
        //find median of sorted array
        if(length % 2 == 0) {
            //even
            // ((length / 2) + ((length / 2) + 1))
            //(mergedArray[length / 2] + mergedArray[((length / 2) + 1)]) / 2;
            //mergedArray[5] + mergedArray[6] = (Answer / 2)
            //median = (middle + (middle + 1)) / 2
            int middle = length / 2;
            return (mergedArray[middle] + mergedArray[middle + 1]) / 2;
        } else {
        
            //odd
            //median = (length + 1) / 2;
            int median = (length + 1) / 2;
            return mergedArray[median - 1];
        }
    }
    
    private void mergeSort(int[] array) {
        
        
        //split the arrays in halves recursively
        int length = array.length;
        if(length <= 1) return;
        
        
        int[] leftArray = new int[length / 2];
        int[] rightArray = new int[length - leftArray.length];
        
        //split the arrays
        int j = 0;
        for(int i = 0; i < length; i++) {
            if (i < (length / 2)) {
                leftArray[i] = array[i];
                continue;
            }
            
            rightArray[j] = array[i];
            j++;
        }
        
        //recurse left
        mergeSort(leftArray);
        
        //recrurse right 
        mergeSort(rightArray);
        
        //merge 
        merge(leftArray,rightArray,array);
    }
    
    private void merge(int[] leftArray, int[] rightArray, int[] originalArray) {
        //cache left & right lengths
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;
        int o = 0, l = 0, r = 0;
        
        //** compare left & right values in arrays and populate / replace original array **
        while (l < leftLength && r < rightLength) {
            //compare left with right
            if (leftArray[l] < rightArray[r]) {
                originalArray[o] = leftArray[l];
                l++;
                o++;
            } else {
                //compare right with left
                originalArray[0] = rightArray[r];
                r++;
                o++;
            }
            
        }
        
        
        //make sure corner case for no values to compare are dealt with
        while(l < leftLength) {
            originalArray[o] = leftArray[l];
            o++;
            l++;
        }
        
        while(r > rightLength) {
            originalArray[o] = rightArray[r];
            o++;
            r++;
        }
        
    }
}


class TwoSum {




    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
         int[] output = twoSum(nums, target);

        for (int i = 0; i < output.length; i++) {
            System.out.println("Output is "+output[i]);
        }
        
    }

    public static int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        int current;
        int complement;
        
        for(int i = 0; i < nums.length; i++){
            current = nums[i];
            for(int j = i = 1; j < nums.length; j++) {
                complement = nums[j];
                if((complement + current) == target) {
                    result[0] = complement;
                    result[1] = current;
                    return result;
                }
            }
        }
            
        return result;
    }
}


class SelectionSort {
    public static void main(String[] args) {
        
        int[] nums = new int[]{64,25,12,22,11,64};
        
        //early exit
        if(nums.length == 1) {
            System.out.print("Early exit");
            return;
        }
        //edge cases
        //sort
        //selection sort
       for(int i = 0; i < nums.length - 1; i++) {
           //set current element as min
           int min = i;
          
          //check element to be min amongs others
          for(int j = i + 1; j < nums.length; j++) {
              int c = nums[j];
              
              //if find another min change pointer
              if(c < nums[min]) {
                  min = j;
              }
          }
          
          //if min has changed swap elements    
          if (min != i) {
               System.out.print("\n Swapping "+nums[i] + " for "+nums[min] +" ,,, ");
              int temp = nums[i];
              nums[i] = nums[min];
              nums[min] = temp;
              
                 System.out.print("\n Swapped "+nums[i] + " for "+nums[min] + " \n");
          }
          
          for (int b : nums) {
           System.out.print("Step "+i + ":  "+b +" \n");
        }
          
        }   
        
        System.out.print("\n ");
        
        
        //merge sort the array
        //O(log n)
        
        
        int previousNum = nums[0];
        //look for O(n)
        for(int i = 1; i < nums.length; i++) {
            int current = nums[i];
    
            if(current == previousNum) {
                System.out.print("\n Found "+current + " and "+previousNum);
                return;
            }
            previousNum = nums[i];
        }
        
        System.out.print("\n Not found");
        
    }
}