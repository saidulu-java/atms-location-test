package test.atm.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpeningHour{
    public int dayOfWeek;
    public List<Hour> hours;
}

