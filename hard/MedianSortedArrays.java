public double findMedianSortedArrays(int[] nums1, int[] nums2) {

      int[] nums3 = new int[nums1.length + nums2.length];

      System.arraycopy(nums1, 0, nums3, 0, nums1.length);
      System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);

      for(int i = 0; i < nums3.length; i++) {
          if(nums3[i] == 0){
              if(i + 1 < nums3.length && nums3[i+1] != 0){
                  nums3[i] = nums3[i+1];
                  nums3[i+1] = 0;
              }
          }
      }

      nums3 = Arrays.stream(nums3).sorted().toArray();

      System.out.println(Arrays.toString(nums3));

      final int index = nums3.length-1;

      if(index % 2 == 0) {
          return nums3[index / 2];
      }
      int middle = index / 2;
     return (double) (nums3[middle] + nums3[middle+1]) * .5;
  
    }
