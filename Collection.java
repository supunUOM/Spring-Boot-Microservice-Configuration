=== HashMap ===
  
Map<String, Integer> basket = new HashMap<>();
basket.put("apple", 2);
basket.merge("apple", 1, Integer::sum); //increase the prev value by one  
basket.merge("apple", 3, (prev, curr) -> prev + curr);

basket.containsKey("apple") //check key is exist.

=== Array/Arrays ===
1. Arrays.stream() 
     int[] ints = {1,2,3};
     List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

2. Arrays.toString() //print array
     System.out.println(Arrays.toString(arr));

3. Arrays.sort() // sort the array
     int[] arr = {1, 4, 2, 6, 2, 4, 5};
     Arrays.sort(arr);
     System.out.println(Arrays.toString(arr));

4. Arrays.asList() //this return unmodifiable list
  This will return an intStream we can use for get the summaryStatistics()

=== Array to Collection ===
1. Arrays.stream() will return a IntStream
      int[] arr = {1, 4, 2, 6, 2, 4, 5}; // Primitive type array
      int sum = (int) Arrays.stream(arr).summaryStatistics().getSum();
   If you want to convert it to List<Integer> use .boxed() intermediate operation.
      List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

      Integer[] arr = {1, 4, 2, 6, 2, 4, 5}; //Wrapper class type Array
      List<Integer> list = Array.asList(arr); 
      
    
=== Collection Map ====
1. filter a map and return new map
  //here values is a map
  Map<String, Integer> result = values.entrySet()
                .stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
