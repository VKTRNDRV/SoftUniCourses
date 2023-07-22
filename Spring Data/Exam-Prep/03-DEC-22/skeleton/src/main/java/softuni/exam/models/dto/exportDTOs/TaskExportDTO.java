package softuni.exam.models.dto.exportDTOs;

import java.math.BigDecimal;

public class TaskExportDTO {
    private Long id;
    private BigDecimal price;
    private CarExportDTO carExportDTO;
    private MechanicExportDTO mechanicExportDTO;
    private static final String STRING_FORMAT =
            "Car %s %s with %dkm\n-Mechanic: %s %s - task №%d:\n --Engine: %.1f\n---Price: %.2f$";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarExportDTO getCarExportDTO() {
        return carExportDTO;
    }

    public void setCarExportDTO(CarExportDTO carExportDTO) {
        this.carExportDTO = carExportDTO;
    }

    public MechanicExportDTO getMechanicExportDTO() {
        return mechanicExportDTO;
    }

    public void setMechanicExportDTO(MechanicExportDTO mechanicExportDTO) {
        this.mechanicExportDTO = mechanicExportDTO;
    }

    @Override
    public String toString(){
        return String.format(STRING_FORMAT,
                this.carExportDTO.getCarMake(),
                this.carExportDTO.getCarModel(),
                this.carExportDTO.getKilometers(),
                this.mechanicExportDTO.getFirstName(),
                this.getMechanicExportDTO().getLastName(),
                this.getId(),
                this.carExportDTO.getEngine(),
                this.getPrice());
    }
}
