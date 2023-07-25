package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.PostExportDTO;
import softuni.exam.instagraphlite.models.dtos.UserExportDTO;
import softuni.exam.instagraphlite.models.dtos.importDTOs.UserImportDTO;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private String USERS_FILE_PATH = "src/main/resources/files/users.json";

    private Gson gson;
    private ValidationUtils validationUtils;
    private ModelMapper modelMapper;
    private PictureRepository pictureRepository;
    private PostRepository postRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper, PictureRepository pictureRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
        this.postRepository = postRepository;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        try {
            return Files.readString(Path.of(USERS_FILE_PATH));
        }catch (IOException ignored){}
        return null;
    }

    @Override
    public String importUsers() throws IOException {
        UserImportDTO[] userDTOs = this.gson
                .fromJson(readFromFileContent(), UserImportDTO[].class);
        StringBuilder output = new StringBuilder();
        boolean isValid;
        for(UserImportDTO userImportDTO : userDTOs){
            isValid = false;
            User user = null;
            if(this.validationUtils.isValid(userImportDTO) &&
                    isUsernameUnique(userImportDTO.getUsername())){
                user = this.modelMapper.map(userImportDTO, User.class);
                Optional<Picture> picOptional = this.pictureRepository
                        .findFirstByPath(userImportDTO.getProfilePicture());
                if(picOptional.isPresent()){
                    user.setProfilePicture(picOptional.get());
                    isValid = true;
                }
            }
            if(isValid){
                output.append(String.format(
                        "Successfully imported User: %s\n",
                        user.getUsername()));
                this.userRepository.save(user);
            }else {
                output.append("Invalid User\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isUsernameUnique(String username) {
        return this.userRepository
                .findFirstByUsername(username)
                .isEmpty();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        List<User> users = this.userRepository.findAll();
        List<UserExportDTO> userDTOs = new ArrayList<>();
        for(User user : users){
            List<Post> posts = this.postRepository
                    .findAllByUser(user);
            userDTOs.add(new UserExportDTO(user, posts));
        }
        userDTOs.sort((u1,u2) -> {
            int result = u2.getCountOfPosts()
                    .compareTo(u1.getCountOfPosts());
            if(result == 0){
                result = u1.getId().compareTo(u2.getId());
            }
            return result;
        });
        StringBuilder output = new StringBuilder();
        userDTOs.forEach(u -> output.append(u.toString())
                .append(System.lineSeparator()));
        return output.toString().trim();
    }
}
