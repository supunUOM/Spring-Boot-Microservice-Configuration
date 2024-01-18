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
