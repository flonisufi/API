package pages;

import pojos.PutPojo;

import static stepDefinitions.AddPlace.place_id;

public class PutPage {

    PutPojo putPojo = new PutPojo();

    public PutPojo putPayload()
    {
        putPojo.setPlace_id(place_id);
        putPojo.setAddress("70 winter walk, USA");
        putPojo.setKey("qaclick123");
        return putPojo;
    }
}
