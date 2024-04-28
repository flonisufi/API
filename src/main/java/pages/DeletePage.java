package pages;

import pojos.DeletePojo;

import static stepDefinitions.AddPlace.place_id;

public class DeletePage {

    DeletePojo deletePojo = new DeletePojo();

    public DeletePojo deletePayload()
    {
        deletePojo.setPlace_id(place_id);
        return deletePojo;
    }
}
