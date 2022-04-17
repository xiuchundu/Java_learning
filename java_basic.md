1. Pair的使用
   
`Pairy<>(key, value)`用于关联键值对。通过与组合Set集合。可判断集合中有无(key、value),相比HashMap更简单。HashMap使用弊端：key值唯一，但Set<new Pair<x, y>> 通过(x,y)确定唯一一个对象。
   
```java
   Set<Pair<Integer, Integer>> obstacleSet = new HashSet<>();
   for (int i = 0; i < obstacles.length; i++) {
     obstacleSet.add(new Pair<>(obstacles[i][0], obstacles[i][1]));
   }

   if (!obstacleSet.contains(new Pair<>(nx, ny))) {
        ...
   }
```
    
 2. map的复制：
   ```java
       materialsMap.replaceAll((i, v) -> materialsMapCopy.get(i));
   ```

3.计算整数对应的二进制中1的个数：
   ```java
      Integer.bitCount(i)
   ```
4. 使用box去除list中的值：
```java
   public boolean remove(int val) {
      if (map.containsKey(val)) {
          IntStream.range(0,list.size()).filter(i->
              list.get(i).equals(val)).
              boxed().findFirst().map(i->list.remove((int)i));
          return true;
      }

      return false;
   }
```
   
5. 使用Character.isDigit(s.charAt(i - 1))判断字符串s中的第i-1位是否为数字。
6. 二分查找模板
(1)返回mid的二分查找模板
```java
   int binary_search(int[] nums,int target) {
   int left = 0,right = nums.length-1;
   while (left <= right) {
      int mid = left+(right-left)/2;
      if(nums[mid] == target) return mid;
      else if(nums[mid] > target) {
         right = mid - 1;
         从右端向mid逼近
      }
      else if(nums[mid] < target) {
         left = mid + 1;
         从左端向mid逼近
      }
   }
   return -1;
}
```
(2)返回left的二分查找模板
```java
   int binary_search(int[] nums,int target){
   int left = 0, right = nums.length-1;
   while (left <= right) {
      int mid = left+(right-left)/2;
      if(nums[mid] == target) right = mid-1;
      从右端向left逼近
      else if(nums[mid] > target){
         right = mid-1;
         从右端向left逼近
      }
      else if(nums[mid] < target){
         left = mid + 1;
      }
   }
   if(left >= length || nums[left] != target){
      return -1;
   } 

   return left;
   }
```
(3)返回right的二分查找模板
```java
   int binary_search(int[] nums,int target){
   int left = 0, right = nums.length-1;
   while (left <= right) {
      int mid = left + (right - left) / 2;
      if(nums[mid] == target) left = mid+1;
      从左端向right逼近
      else if (nums[mid] > target) {
         right = mid-1;
      }
      else if (nums[mid] < target) {
         left = mid+1;
         从左端向right逼近
      }
   }
   if (right < 0 || nums[right] != target) {
      return -1;
   }

   return right;
   }
```

7. Java字符串替换时遇到 .或者?需要使用"\\."或者"\\?"。若使用使用"."则变成了全部替换，不实际匹配。   
