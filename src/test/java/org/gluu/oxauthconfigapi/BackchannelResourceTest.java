/**
 * 
 */
package org.gluu.oxauthconfigapi;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.OK;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import org.gluu.oxauthconfigapi.rest.model.Backchannel;

/**
 * @author Puja Sharma
 *
 */
@QuarkusTest
@Tag("integration")
public class BackchannelResourceTest {
	
	private static final String API_V1_OXAUTH_BACKCHANNEL = "/api/v1/oxauth/backchannel";
	
	@Test
	public void getBackchannelConfiguration() {
		given().log().all()
		.when()
		.get(API_V1_OXAUTH_BACKCHANNEL).then().statusCode(OK.getStatusCode());
	}
	
	@Test
	public void updateBackchannelConfiguration() {
		Backchannel backchannel = new Backchannel();
		given().log().all()
		.body(backchannel)
		.header(CONTENT_TYPE,APPLICATION_JSON)
		.header(ACCEPT,APPLICATION_JSON)
		.when()
		.put(API_V1_OXAUTH_BACKCHANNEL).then().statusCode(OK.getStatusCode());
	}

}
