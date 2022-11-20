package gson;

import com.google.gson.Gson;
import pojo.Address;
import pojo.Geolocation;
import pojo.Person;

import java.util.ArrayList;
import java.util.List;

public class ObjToJson {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Person p1 = new Person();
        p1.setName("Abhishek");
        p1.setAge(31);
        Address addres1 = new Address();
        addres1.setCity("Bangalore");
        addres1.setStreet("Avenue");
        Geolocation geolocation1 = new Geolocation();
        geolocation1.setLat("-95.234");
        geolocation1.setLng("45.343");
        addres1.setGeolocation(geolocation1);
        p1.setAddress(addres1);

        Person p2 = new Person();
        p2.setName("Romy");
        p2.setAge(31);
        Address addres2 = new Address();
        addres2.setCity("Indore");
        addres2.setStreet("Avenue");
        Geolocation geolocation2 = new Geolocation();
        geolocation2.setLat("-25.234");
        geolocation2.setLng("85.343");
        addres2.setGeolocation(geolocation2);
        p2.setAddress(addres2);

        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);

        System.out.println(gson.toJson(personList));
    }
}
