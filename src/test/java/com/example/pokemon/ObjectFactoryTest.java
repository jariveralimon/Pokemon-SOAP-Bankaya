package com.example.pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class ObjectFactoryTest {

    private final ObjectFactory objectFactory = new ObjectFactory();

    @Test
    void testCreateGetAbilitiesRequest() {
        GetAbilitiesRequest request = objectFactory.createGetAbilitiesRequest();
        assertNotNull(request, "GetAbilitiesRequest instance should not be null");
    }

    @Test
    void testCreateGetAbilitiesResponse() {
        GetAbilitiesResponse response = objectFactory.createGetAbilitiesResponse();
        assertNotNull(response, "GetAbilitiesResponse instance should not be null");
    }

    @Test
    void testCreateGetBaseExperienceRequest() {
        GetBaseExperienceRequest request = objectFactory.createGetBaseExperienceRequest();
        assertNotNull(request, "GetBaseExperienceRequest instance should not be null");
    }

    @Test
    void testCreateGetBaseExperienceResponse() {
        GetBaseExperienceResponse response = objectFactory.createGetBaseExperienceResponse();
        assertNotNull(response, "GetBaseExperienceResponse instance should not be null");
    }

    @Test
    void testCreateGetHeldItemsRequest() {
        GetHeldItemsRequest request = objectFactory.createGetHeldItemsRequest();
        assertNotNull(request, "GetHeldItemsRequest instance should not be null");
    }

    @Test
    void testCreateGetHeldItemsResponse() {
        GetHeldItemsResponse response = objectFactory.createGetHeldItemsResponse();
        assertNotNull(response, "GetHeldItemsResponse instance should not be null");
    }

    @Test
    void testCreateGetIdRequest() {
        GetIdRequest request = objectFactory.createGetIdRequest();
        assertNotNull(request, "GetIdRequest instance should not be null");
    }

    @Test
    void testCreateGetIdResponse() {
        GetIdResponse response = objectFactory.createGetIdResponse();
        assertNotNull(response, "GetIdResponse instance should not be null");
    }

    @Test
    void testCreateGetNameRequest() {
        GetNameRequest request = objectFactory.createGetNameRequest();
        assertNotNull(request, "GetNameRequest instance should not be null");
    }

    @Test
    void testCreateGetNameResponse() {
        GetNameResponse response = objectFactory.createGetNameResponse();
        assertNotNull(response, "GetNameResponse instance should not be null");
    }

    @Test
    void testCreateGetLocationAreaEncountersRequest() {
        GetLocationAreaEncountersRequest request = objectFactory.createGetLocationAreaEncountersRequest();
        assertNotNull(request, "GetLocationAreaEncountersRequest instance should not be null");
    }

    @Test
    void testCreateGetLocationAreaEncountersResponse() {
        GetLocationAreaEncountersResponse response = objectFactory.createGetLocationAreaEncountersResponse();
        assertNotNull(response, "GetLocationAreaEncountersResponse instance should not be null");
    }
}
