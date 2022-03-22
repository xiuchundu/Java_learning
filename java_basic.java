1. 使用Pair, Pairy<>(key, value)用于关联键值对。通过与组合Set集合。可判断集合中有无(key、value),相比HashMap更简单。
    Set<Pair<Integer, Integer>> obstacleSet = new HashSet<>();
    for (int i = 0; i < obstacles.length; i++) {
        obstacleSet.add(new Pair<>(obstacles[i][0], obstacles[i][1]));
    }

    if (!obstacleSet.contains(new Pair<>(nx, ny))) {
           ...
    }
