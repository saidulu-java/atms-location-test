package test.atm.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtmDetail{
    public Address address;
    public int distance;
    public List<OpeningHour> openingHours;
    public String functionality;
    public String type;
    
    
}

