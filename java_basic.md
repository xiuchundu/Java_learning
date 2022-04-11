1. Pair的使用
   Pairy<>(key, value)用于关联键值对。通过与组合Set集合。可判断集合中有无(key、value),相比HashMap更简单。HashMap使用弊端：key值唯一，但Set<new Pair<x, y>> 通过(x,y)确定唯一一个对象。
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
