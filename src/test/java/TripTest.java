import org.junit.Test;
import tripDemo.model.Passenger;
import tripDemo.model.Trip;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class TripTest {
    @Test
    public void c1reateTrip() {
        Trip trip = new Trip();
        trip.setCompanyId(1L);
        trip.setPlane("plane№2");
        trip.setTownFrom("Moscow");
        trip.setTownTo("St. Peterburg");
        trip.setTimeOut("2021-05-16T03:31:43");
        trip.setTimeIn("2021-05-16T03:31:43");

        List<Passenger> passengerList = new ArrayList<>();
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("Andrey");
        passenger1.setMiddleName("Maksimov");
        passenger1.setLastName("Pupkin");

        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("Pavel");
        passenger2.setMiddleName("Pupkin");

        passengerList.add(passenger1);
        passengerList.add(passenger2);

        trip.setPassengerList(passengerList);

        given()
                .log().all(true)
                .accept("application/json")
                .contentType("application/json")
                .body(trip)
                .when()
                .post("http://localhost:8080/trip/createTrip")
                .thenReturn();
        //  System.out.println(response.getBody(). prettyPrint());

    }

    @Test
    public void g2etTrip() {
        given()
                .log().all()
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get("http://localhost:8080/trip/getTrip/18")
                .then()
                .assertThat()
                .statusCode(200)
                .body("townFrom", equalTo("Moscow"));
    }


    @Test
    public void putTrip() {
        Trip trip = new Trip();
        trip.setCompanyId(1L);
        trip.setPlane("plane№2");
        trip.setTownFrom("Moscow");
        trip.setTownTo("St. Peterburg");
        trip.setTimeOut("2021-05-16T03:31:43");
        trip.setTimeIn("2021-05-16T03:31:43");

        List<Passenger> passengerList = new ArrayList<>();
        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("Andrey");
        passenger1.setMiddleName("Maksimov");
        passenger1.setLastName("Pupkin");

        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("Pavel");
        passenger2.setMiddleName("Pupkin");

        passengerList.add(passenger1);
        passengerList.add(passenger2);

        trip.setPassengerList(passengerList);

        given()
                .log().all(true)
                .accept("application/json")
                .contentType("application/json")
                .body(trip)
                .when()
                .put("http://localhost:8080/trip/putTrip/18")
                .thenReturn();
    }


    @Test
    public void deleteTrip() {
   //

        given()
                .log().all()
                .accept("application/json")
                .contentType("application/json")
                // .body(trip)
                .when()
                .delete("http://localhost:8080/trip/deleteTrip/18")
                .then()
                .assertThat()
                .statusCode(200)
                .body("companyId", equalTo(1), "plane", equalTo("Plane№2"), "townFrom", equalTo("Moscow"), "townTo", equalTo("Pekin"))
                .log().all();

    }
}