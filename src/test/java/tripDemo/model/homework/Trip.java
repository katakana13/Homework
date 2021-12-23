package tripDemo.model.homework;
import lombok.*;
import tripDemo.model.Passenger;

import java.util.ArrayList;
import java.util.List;

@Data
public class Trip {
    private Long id;
    private Long companyId;
    private String plane;
    private String townFrom;
    private String townTo;
    private String timeOut;
    private String timeIn;
    private final List<Passenger> passengerList = new ArrayList<>();
}
