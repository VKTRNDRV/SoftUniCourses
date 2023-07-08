package org.example.services;

import org.example.domain.entities.Game;
import org.example.domain.entities.User;
import org.example.domain.models.UserLoginDTO;
import org.example.domain.models.UserRegisterDTO;
import org.example.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

import static org.example.constants.ErrorMessages.EMAIL_ALREADY_EXISTS;

@Service
public class UserServiceImpl implements UserService{
    private User loggedInUser;
    private UserRepository userRepository;
    private ModelMapper modelMapper;


    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public String registerUser(String[] args) {
        final int argsLength = args.length;

        final String email = argsLength > 1 ? args[1] : "";
        final String password = argsLength > 2 ? args[2] : "";
        final String confirmPassword = argsLength > 3 ? args[3] : "";
        final String fullName = argsLength > 4 ? args[4] : "";

        UserRegisterDTO userRegDTO;

        try {
            userRegDTO = new UserRegisterDTO(email, password, confirmPassword, fullName);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }

        if (this.userRepository.findFirstByEmail(userRegDTO.getEmail()).isPresent()) {
            return EMAIL_ALREADY_EXISTS;
        }

        final User user = this.modelMapper.map(userRegDTO, User.class);

        if (this.userRepository.count() == 0) {
            user.setIsAdmin(true);
        } else {
            user.setIsAdmin(false);
        }

        this.userRepository.saveAndFlush(user);

        return userRegDTO.successfullyRegisteredUser();
    }

    @Override
    public String loginUser(String[] args) {
        if (this.loggedInUser != null) return "User is already logged.";

        final int argsLength = args.length;

        final String email = argsLength > 1 ? args[1] : "";
        final String password = argsLength > 2 ? args[2] : "";

        Optional<User> userToBeLogged = this.userRepository.findFirstByEmail(email);

        if (userToBeLogged.isEmpty()) return "Incorrect user.";

        final UserLoginDTO userLoginDto = new UserLoginDTO(email, password);

        try {
            userLoginDto.validate(userToBeLogged.get().getPassword());
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }

        this.loggedInUser = userToBeLogged.get();

        return userLoginDto.successfullyLoggedIn();
    }

    @Override
    public String logoutUser() {
        if(this.loggedInUser == null) return "Cannot log out. No user was logged in.";

        String name = this.loggedInUser.getFullName();
        this.loggedInUser = null;
        return name + " logged out.";
    }

    @Override
    public boolean isLoggedUserAdmin() {
        return this.loggedInUser != null && this.loggedInUser.getIsAdmin();
    }

    @Override
    public boolean isUserLoggedIn(){
        return this.loggedInUser != null;
    }

    @Override
    public Long getLoggedUserId(){
        return this.loggedInUser.getId();
    }

    @Override
    public Set<Game> getGamesByUserId(long id){
        return this.userRepository.findGamesByUserId(id);
    }
}
