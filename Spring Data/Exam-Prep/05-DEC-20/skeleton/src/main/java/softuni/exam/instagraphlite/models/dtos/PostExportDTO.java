package softuni.exam.instagraphlite.models.dtos;

import softuni.exam.instagraphlite.models.Post;

public class PostExportDTO {

    private String caption;

    private Double size;

    public PostExportDTO(Post post){
        this.caption = post.getCaption();
        this.size = post.getPicture()
                .getSize();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return String.format(
                "==Post Details:\n" +
                "----Caption: %s\n" +
                "----Picture Size: %.2f",
                this.caption, this.size);
    }
}
