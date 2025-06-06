package de.ralfn.pub.small_world.rest_server.api;

import de.ralfn.pub.small_world.api.PersonService;
import de.ralfn.pub.small_world.model.Person;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping( PersonController.Path )
public interface PersonController
	extends PersonService
{
	String Path = RootController.RestApiV1 + "/person";
	String Json = MediaType.APPLICATION_JSON_VALUE;

	@Override
	@PostMapping( consumes = Json, produces = Json )
	@Operation(
		summary = "Create a new Person",
		description = "This API creates a new Person item in the backend database."
	)
	Person create(
		@RequestBody
		final Person person
	);

	@Override
	@GetMapping( path = "size", produces = Json )
	long size();

	@Override
	@GetMapping( path = "{id}", produces = Json )
	@Operation( operationId = "readById" )
	Person read(
		@PathVariable( "id" )
		final Long id
	);

	@Override
	List<Long> read(
		final Predicate<Person> predicate,
		final Comparator<Person> comparator
	);

	@Override
	@GetMapping( produces = Json )
	@Operation( operationId = "readByIdList" )
	List<Person> read(
		@RequestParam( "ids" )
		final List<Long> ids
	);

	@Override
	@PutMapping( path = "{id}", produces = Json )
	Person update(
		@RequestBody
		final Person person
	);

	@Override
	@DeleteMapping( "{id}" )
	@Operation( operationId = "deleteById" )
	void delete(
		@PathVariable( "id" )
		final Long id
	);

	@Override
	@DeleteMapping( consumes = Json )
	void delete(
		@RequestBody
		final Person person
	);

	//

	@Override
	@GetMapping( path = "byCity/{city}", produces = Json )
	public List<Person> byCity(
		@PathVariable( "city" )
		final String city,
		@RequestParam( name = "maxNum", required = false, defaultValue = "100")
		final Integer limit
	);

	@Override
	@GetMapping( path = "byLastName/{lastName}", produces = Json )
	List<Person> byLastName(
		@PathVariable( "lastName" )
		final String lastName,
		@RequestParam( name = "maxNum", required = false, defaultValue = "100")
		final Integer limit
	);
}
