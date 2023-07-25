package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;
import softuni.exam.instagraphlite.models.dtos.importDTOs.PostImportDTO;
import softuni.exam.instagraphlite.models.dtos.importDTOs.PostImportRootDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtils;
import softuni.exam.instagraphlite.util.XmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    private ModelMapper modelMapper;

    private String POSTS_FILE_PATH = "src/main/resources/files/posts.xml";
    private PictureRepository pictureRepository;
    private UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, XmlParser xmlParser, ValidationUtils validationUtils, ModelMapper modelMapper, PictureRepository pictureRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        try {
            return Files.readString(Path.of(POSTS_FILE_PATH));
        }catch (IOException ignored){}
        return null;
    }

    @Override
    public String importPosts() throws IOException {
        PostImportRootDto root = this.xmlParser
                .fromString(readFromFileContent(), PostImportRootDto.class);
        List<PostImportDTO> postDTOs = root.getPostImportDTOs();
        StringBuilder output = new StringBuilder();
        boolean isValid;
        for(PostImportDTO postImportDTO : postDTOs){
            isValid = true;
            Post post = null;
            if(this.validationUtils.isValid(postImportDTO)){
                post = this.modelMapper.map(postImportDTO, Post.class);
            }else {
                isValid = false;
            }

            // set picture
            if(isValid){
                Optional<Picture> picture = this.pictureRepository
                        .findFirstByPath(postImportDTO.getPicture().
                                getPath());
                if(picture.isPresent()){
                    post.setPicture(picture.get());
                }else {
                    isValid = false;
                }
            }

            // set user
            if(isValid){
                Optional<User> user = this.userRepository
                        .findFirstByUsername(postImportDTO
                                .getUser().getUsername());
                if(user.isPresent()){
                    post.setUser(user.get());
                }else {
                    isValid = false;
                }
            }

            // finish
            if(isValid){
                output.append("Successfully imported Post, made by ")
                        .append(post.getUser().getUsername())
                        .append(System.lineSeparator());
                this.postRepository.save(post);
            }else {
                output.append("Invalid Post\n");
            }
        }
        return output.toString().trim();
    }
}
