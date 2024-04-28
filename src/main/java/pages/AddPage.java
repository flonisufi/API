package pages;

import pojos.AddPojo;
import pojos.Location;

import java.util.ArrayList;
import java.util.List;

public class AddPage {

    AddPojo addPojo = new AddPojo();
    Location location = new Location();

    public AddPojo addPayload()
    {
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPojo.setLocation(location);
        addPojo.setAccuracy(50);
        addPojo.setName("Frontline house");
        addPojo.setPhone_number("(+91) 983 893 3937");
        addPojo.setAddress("29, side layout, cohen 09");
        List<String> myList = new ArrayList<>();
        myList.add("shoe park");
        myList.add("shop");
        addPojo.setTypes(myList);
        addPojo.setWebsite("http://google.com");
        addPojo.setLanguage("French-IN");
        return addPojo;
    }
}
