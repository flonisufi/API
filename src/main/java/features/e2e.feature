@Test

  Feature: Add/Get/Put/Delete Test API

    Scenario: Add Place API
      Given User Payload with informations and query parameter "qaclick123"
      When User calls Post http request
      Then User call for success with status code 200
      Then Validate that status is "OK"

      Scenario: Get Place API
        Given User enter query parameter "qaclick123" and place_id
        When User calls Get http request
        Then User Get call for success with status code 200
        Then Validate that address is "29, side layout, cohen 09"

    Scenario: Put Place API
      Given User Payload and query parameters "qaclick123" and place_id
      When User calls Put http request
      Then User Put call for success with status code 200
      Then Validate that address is changed

      Scenario: Delete Place API
        Given User Payload and query paramter "qaclick123"
        When User calls Delete with http request
        Then User Delete call for success with status code 200
        Then Validate that status response is "OK"


