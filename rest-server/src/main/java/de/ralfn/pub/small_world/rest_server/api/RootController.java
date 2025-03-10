package de.ralfn.pub.small_world.rest_server.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
	info = @Info(
		title = "Small World - Population",
		version = "1.0",
		description = "see title",
		license = @License( name = "No license." ),
		contact = @Contact( name = "R. Naujokat", email = "me@ralfn.de" )
	)
)
@RestController
@RequestMapping( RootController.Root )
public interface RootController
{
	String Root = "/";
	String RestApiV1 = Root + "rest-api/v1";

	@GetMapping
	String get();

	@GetMapping( "health" )
	String health();
}
