package com.edrpub.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.edrpub.ws.model.Response;
import org.junit.jupiter.api.Test;

/**
 * Test Response
 *
 */
public class TestResponse {

  @Test
  public void testResponse() {
    new Response(-1, null, null, null);
    new Response(400, "Something is not right", null, null);
    new Response(400, "Something is not right", "Datastore is corrupted", null);
    new Response(
      400,
      "Something is not right",
      "Datastore is corrupted",
      "/api/tasking/dosomething"
    );
  }

  @Test
  public void testToJson() {
    String msg = "Something is not right";
    String msgDev = "Datastore is corrupted";
    String link = ".../api/tasking/dosomething";
    Response res = new Response(400, msg, msgDev, link);
    assertTrue(res.getCode() == 400);
    assertTrue(res.getMessage().equals(msg));
    assertTrue(res.getDeveloperMessage().equals(msgDev));
    assertTrue(res.getLink().equals(link));
  }
}
