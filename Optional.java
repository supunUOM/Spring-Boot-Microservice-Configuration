DONT USE OPTINAL
1. As method parameter
2. As class variable

==================== REPOSITORY ====================
public class UserRepository {

//    List<User> users = List.of(new User(1, "supun"));
    List<User> users = Collections.emptyList();

    public Optional<List<User>> getUsers() {
        if (users.isEmpty())
            return Optional.empty();
        return Optional.of(users);
    }
}


===================== SERVICE =====================
public class UserService {

    UserRepository userRepository = new UserRepository();

    public void getUsers() {
        var userList = userRepository.getUsers();

        //TODO: Optional.of(data); if data is null throw NullPointerException
        var data1  = Optional.of(null); //throw NullPointerException

        //TODO: Optinal.ofNullable(data); if data is null it is not going to throw NullPointerException
        var data2 = Optional.ofNullable(null); //if data is null returns Optional.empty()
        System.out.println(data2);

        //TODO: ifPresent() return void
        userList.ifPresent(users -> {
            System.out.println(users);
        });

        //TODO ifPresentOrElse()
        userList.ifPresentOrElse(users -> {
            System.out.println(users);
        }, () -> System.out.println("user list is empty"));

        //TODO: if empty Throw NoSuchElementException()
        userList.orElseThrow();

        //TODO: orElseThrow() throw customize exception
        userList.orElseThrow(()-> new NoSuchElementException("No element"));

        //TODO: OrElse(T t) can provide default value if empty
        var list1 = userList.orElse(Collections.singletonList(new User(55, "John")));
        System.out.println(list1);

        //TODO: OrElseGet(()->) can provide default value if empty
        var list2 = userList.orElseGet(() -> Collections.singletonList(new User(55, "John")));
        System.out.println(list2);

        Optional<String> optionalName = Optional.empty();
        String name = optionalName.orElseGet(() -> getNameFromDatabase());

    }
}


===================== PRACTICAL USAGE =====================
https://www.bezkoder.com/jpa-one-to-many-unidirectional/

  @GetMapping("/tutorials/{id}")
  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
    Tutorial tutorial = tutorialRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id)); //Or Else Throw

    return new ResponseEntity<>(tutorial, HttpStatus.OK);
  }

  @GetMapping("/tutorials")
  public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
    List<Tutorial> tutorials = new ArrayList<Tutorial>();

    if (title == null)
      tutorialRepository.findAll().forEach(tutorials::add);  //Method Reference
    else
      tutorialRepository.findByTitleContaining(title).forEach(tutorials::add); //forEach Usage

    if (tutorials.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(tutorials, HttpStatus.OK);
  }


  Tutorial tutorial = tutorialRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
