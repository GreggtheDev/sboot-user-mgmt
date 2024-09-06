public class UserRegistrationDTO {

    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 20)
    private String username;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

    // Getters and setters...
}
