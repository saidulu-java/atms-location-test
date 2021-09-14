package test.atm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address{
    public String street;
    public String housenumber;
    public String postalcode;
    public String city;
    public GeoLocation geoLocation;
}

