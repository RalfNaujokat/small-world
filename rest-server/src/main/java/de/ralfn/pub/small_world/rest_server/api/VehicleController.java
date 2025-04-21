package de.ralfn.pub.small_world.rest_server.api;

import de.ralfn.pub.small_world.api.VehicleService;
import de.ralfn.pub.small_world.model.Vehicle;

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
@RequestMapping( VehicleController.Path )
public interface VehicleController
	extends VehicleService
{
	String Path = RootController.RestApiV1 + "/vehicle";
	String Json = MediaType.APPLICATION_JSON_VALUE;

	@Override
	@PostMapping( consumes = Json, produces = Json )
	@Operation(
		summary = "Create a new Vehicle",
		description = "This API creates a new Vehicle item in the backend database."
	)
	Vehicle create(
		@RequestBody
		final Vehicle vehicle
	);

	@Override
	@GetMapping( path = "size", produces = Json )
	long size();

	@Override
	@GetMapping( path = "{id}", produces = Json )
	@Operation( operationId = "readById" )
	Vehicle read(
		@PathVariable( "id" )
		final Long id
	);

	@Override
	List<Long> read(
		final Predicate<Vehicle> predicate,
		final Comparator<Vehicle> comparator
	);

	@Override
	@GetMapping( produces = Json )
	@Operation( operationId = "readByIdList" )
	List<Vehicle> read(
		@RequestParam( "ids" )
		final List<Long> ids
	);

	@Override
	@PutMapping( path = "{id}", produces = Json )
	Vehicle update(
		@RequestBody
		final Vehicle vehicle
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
		final Vehicle vehicle
	);

	//

	@Override
	@GetMapping( path = "byManufacturer/{manufacturer}", produces = Json )
	List<Vehicle> byManufacturer(
		@PathVariable( "manufacturer" )
		final String manufacturer,
		@RequestParam( name = "maxNum", required = false, defaultValue = "100")
		final Integer limit
	);

	@Override
	@GetMapping( path = "byModel/{model}", produces = Json )
	List<Vehicle> byModel(
		@PathVariable( "model" )
		final String model,
		@RequestParam( name = "maxNum", required = false, defaultValue = "100")
		final Integer limit
	);
}
