/*
 * This is how customise the authentication response.
 * Because in the authentication part we cannot customise the response with the GlobalExceptionHandling (@RestAdviceController)
 **/

@Slf4j
public void validate(HttpServletRequest request, HttpServletResponse response){
  
          response.setStatus(HttpStatus.BAD_REQUEST.value());
  
          var logoutSuccessRes = LogOutSuccessResponse.builder()
                    .status("success")
                    .username(username)
                    .build();
  
            try {
                new ObjectMapper().writeValue(response.getOutputStream(), logoutSuccessRes);
            } catch (IOException IOEx) {
                log.error("Object mapping exception in JWTAuthenticationFilter");
                throw new ObjectMappingException("Object mapping exception in JWTAuthenticationFilter", IOEx);
            }
}  
