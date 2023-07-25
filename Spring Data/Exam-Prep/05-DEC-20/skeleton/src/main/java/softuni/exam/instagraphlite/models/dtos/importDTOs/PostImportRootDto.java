package softuni.exam.instagraphlite.models.dtos.importDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(value = XmlAccessType.NONE)
public class PostImportRootDto {

    @XmlElement(name = "post")
    List<PostImportDTO> postImportDTOs;

    public List<PostImportDTO> getPostImportDTOs() {
        return postImportDTOs;
    }

    public void setPostImportDTOs(List<PostImportDTO> postImportDTOs) {
        this.postImportDTOs = postImportDTOs;
    }
}
