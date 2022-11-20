package gson;

import com.google.gson.Gson;
import pojo.Person;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class JsonToObj {
    public static void main(String[] args) {
        String jsonStr = "[{\"name\":\"Abhishek\",\"age\":31,\"address\":{\"city\":\"Bangalore\",\"street\":\"Avenue\",\"geolocation\":{\"lat\":\"-95.234\",\"lng\":\"45.343\"}}},{\"name\":\"Romy\",\"age\":31,\"address\":{\"city\":\"Indore\",\"street\":\"Avenue\",\"geolocation\":{\"lat\":\"-25.234\",\"lng\":\"85.343\"}}}]";
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
        List<Person> personList = new Gson().fromJson(jsonStr, listType);
        for (Person p: personList) {
            System.out.println(p.getName());
        }
    }
}
