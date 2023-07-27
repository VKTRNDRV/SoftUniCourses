package com.example.football.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(value = XmlAccessType.NONE)
public class StatImportRootDTO {

    @XmlElement(name = "stat")
    private List<StatImportDTO> stats;


    public List<StatImportDTO> getStats() {
        return stats;
    }

    public void setStats(List<StatImportDTO> stats) {
        this.stats = stats;
    }
}
