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
      String s = Integer.toBinaryString(n); // 计算整数对应的二进制1001这种的字符串值
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
8. leetcode中尽量不用static变量。容易产生和本地不一致的结果。可能与加载类的过程有关。leetcode每次加载然后测试，之后变量会变成脏数据，也就是保存上一次的结果。
9. putIfAbsent() 方法会先判断指定的键（key）是否存在，不存在则将键/值对插入到 HashMap 中。
```java
   hashmap.putIfAbsent(K key, V value)
```

10. Stream去重和过滤:
    http://www.classinstance.cn/detail/175.html
```java
    class Record {
        int userId;

        int record;

        int duration;

        public Record(int userId, int record, int duration) {
            this.userId = userId;
            this.record = record;
            this.duration = duration;
        }
    }
    
    List<Record> recordList = new ArrayList<>();
    
    public int[] getTopAthletes(int num) {
        List<Integer> collect = recordList
            .stream()
            .sorted(new Comparator<Record>() {
                @Override
                public int compare(Record o1, Record o2) {
                    if (o1.duration == o2.duration) {
                        return o1.record - o2.record;
                    }
                    return o1.duration - o2.duration;
                }
            })
            .map(r -> r.userId).distinct().collect(Collectors.toList());

        if (collect.size() > num) {
            return collect.subList(0, num).stream().mapToInt(Integer::intValue).toArray();
        } else {
            return collect.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    
    public int[] queryTop3Record(int userId) {
        List<Integer> collect = recordList.stream().filter(r -> r.userId == userId).sorted(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.duration - o2.duration;
            }
        }).map(r -> r.duration).collect(Collectors.toList());
        if (collect.size() > 3) {
            return collect.subList(0, 3).stream().mapToInt(Integer::intValue).toArray();
        } else {
            return collect.stream().mapToInt(Integer::intValue).toArray();
        }
    }    
```

11. Stream流之List、Integer[]、int[]相互转化
   https://blog.csdn.net/qq_43390235/article/details/106592102

12. 二分法使用注意事项: 若求最小满足的left，则：
```java
   if (xxx) {
       low = mid + 1;
   } else {
       high = mid;
   }
```

若求最大满足的left，则：
```java
   if (xxx) {
       low = mid;
   } else {
       high = mid - 1;
   }
```

13. 统计字符串中的缩进的"\t"数量，层数等于"\t"的数量。其中包括 str.startWIth("xx"); 判断字符串是否以"xx"开头。
```java
    public int countTab(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 0;; i++){
            sb.append("\t");
            if(s.startsWith(sb.toString()))
                count++;
            else
                break;
        }
    }
```
