=== HashMap ===
  
Map<String, Integer> basket = new HashMap<>();
basket.put("apple", 2);
basket.merge("apple", 1, Integer::sum); //increase the prev value by one  
basket.merge("apple", 3, (prev, curr) -> prev + curr);

basket.containsKey("apple") //check key is exist.

