=== Maven dependency ===
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

=== UserRequest Class ===
//@NotNull
//@Email
//@Min
//@Max
//@NotBalnk = @NotNull + Not empty
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "username shouldn't be null")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;

}

=== UserController class ===
// use @Valid annotation for validation used class.

@PostMapping("/signup")
public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
  return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
}

=== ApplicationExceptionHandler Class ===
//when particular validation failed, will throws the MethodArgumentNotValidExcepton

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
}

=== Sample Error Output after testing using Postman ===
{
  "age": "must be less than or equal to 60",
  "email": "invalid email address",
  "mobile": "invalid mobile number entered"
}
