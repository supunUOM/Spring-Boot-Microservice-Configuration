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
  The final result is equal to Collections.unmodifiableList() returned result.
     List<Integer> list = Arrays.asList(arr);
     List<Integer> integers = Collections.unmodifiableList(list); 
  This will return an intStream if you create array with int[]. Then it can use for get the summaryStatistics()

    
=== Array to Collection ===
1. Arrays.stream() will return a IntStream
      int[] arr = {1, 4, 2, 6, 2, 4, 5}; // Primitive type array
      int sum = (int) Arrays.stream(arr).summaryStatistics().getSum();
   If you want to convert it to List<Integer> use .boxed() intermediate operation.
      List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

      Integer[] arr = {1, 4, 2, 6, 2, 4, 5}; //Wrapper class type Array
      List<Integer> list = Array.asList(arr); 


=== ArrayList ===
Integer[] arr = {1, 4, 2, 6, 2, 4, 5}; //Array with Wrapper class
List<Integer> list = Arrays.asList(arr); //create unmodifiable List
list.sort(Integer::compareTo); //sort the list

List<Integer> list1 = new ArrayList<>(list); // create new List using unmodifiable list
list1.add(33); // add element
list1.get(0); //get the 0th element
list1.remove(0); //remove the 0th element
list1.removeIf((e)->e.equals(1)); //it will remove element equal to 1
list1.isEmpty(); //check list is empty
list1.contains(3); //check 3 is existing in the list
list1.containsAll(list2); // if all the elements in list2 present in the list1 it will return true 
list1.size(); //get the size of the list.
list1.sort(Integer::compareTo); //sort the list
list1.indexOf(4) //return the index of 4

  
=== HashMap ===
Map<String, Integer> basket = new HashMap<>();
basket.put("apple", 2);
basket.merge("apple", 1, Integer::sum); //increase the prev value by one  
basket.merge("apple", 3, (prev, curr) -> prev + curr);
basket.containsKey("apple") //check key is exist.

  
=== Collection Map ====
1. filter a map and return new map
  //here values is a map
  Map<String, Integer> result = values.entrySet()
                .stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
