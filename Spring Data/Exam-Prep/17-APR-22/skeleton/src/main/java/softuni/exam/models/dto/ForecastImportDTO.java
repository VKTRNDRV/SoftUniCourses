package softuni.exam.models.dto;

import softuni.exam.models.enums.DayOfWeek;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@XmlRootElement(name = "forecast")
@XmlAccessorType(value = XmlAccessType.NONE)
public class ForecastImportDTO {

    @XmlElement(name = "day_of_week")
    @NotNull
    private DayOfWeek dayOfWeek;

    @XmlElement(name = "max_temperature")
    @Min(value = -20)
    @Max(value = 60)
    @NotNull
    private double maxTemperature;

    @XmlElement(name = "min_temperature")
    @Min(value = -50)
    @Max(value = 40)
    @NotNull
    private double minTemperature;

    @XmlElement
    @NotNull
    private String sunrise;

    @XmlElement
    @NotNull
    private String sunset;

    @XmlElement
    private Long city;



    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public LocalTime getSunriseAsLocalTime(){
        return LocalTime.parse(this.sunrise,
                DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public LocalTime getSunsetAsLocalTime(){
        return LocalTime.parse(this.sunset,
                DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
