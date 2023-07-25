package softuni.exam.instagraphlite.models.dtos;

import com.google.gson.annotations.Expose;
import softuni.exam.instagraphlite.models.Post;
import softuni.exam.instagraphlite.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserExportDTO {

    private Integer id;

    private String username;

    private List<PostExportDTO> posts;

    public UserExportDTO(User user, Collection<Post> posts){
        this.id = user.getId();
        this.username = user.getUsername();
        this.posts = new ArrayList<>();
        for(Post post : posts){
            this.posts.add(new PostExportDTO(post));
        }
        this.posts.sort((p1,p2) -> p1.getSize()
                .compareTo(p2.getSize()));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PostExportDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostExportDTO> posts) {
        this.posts = posts;
    }

    public Integer getCountOfPosts(){
        return this.posts.size();
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("User: ").append(this.username)
                .append(System.lineSeparator())
                .append("Post count: ")
                .append(this.posts.size())
                .append(System.lineSeparator());
        this.posts.forEach(p -> output.append(p.toString())
                .append(System.lineSeparator()));
        return output.toString().trim();
    }
}
