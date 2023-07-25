package softuni.exam.instagraphlite.models.dtos.importDTOs;

import com.google.gson.annotations.Expose;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PictureImportDTO {

    @Expose
    @NotNull
    private String path;

    @Expose
    @NotNull
    @Min(value = 500)
    @Max(value = 60000)
    private Double size;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
}
