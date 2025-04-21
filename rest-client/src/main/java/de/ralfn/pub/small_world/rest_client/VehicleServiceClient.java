package de.ralfn.pub.small_world.rest_client;

import de.ralfn.pub.commons.RestClient;
import de.ralfn.pub.commons.RestClient.Request;
import de.ralfn.pub.commons.RestClient.Response;
import de.ralfn.pub.small_world.api.VehicleService;
import de.ralfn.pub.small_world.model.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class VehicleServiceClient
	implements VehicleService
{
	public VehicleServiceClient( final RestClient restClient )
	{
		this.restClient = restClient;
	}

	//

	private final RestClient restClient;

	//

	@Override
	public Vehicle create( final Vehicle vehicle )
	{
		Response<Vehicle> response = restClient
			.post( Request.of( "", null, vehicle ) );

		return response
			.body();
	}

	@Override
	public long size()
	{
		return 0;
	}

	@Override
	public Vehicle read( final Long aLong )
	{
		return null;
	}

	@Override
	public List<Long> read( final Predicate<Vehicle> predicate, final Comparator<Vehicle> comparator )
	{
		return List.of();
	}

	@Override
	public List<Vehicle> read( final List<Long> longs )
	{
		return List.of();
	}

	@Override
	public Vehicle update( final Vehicle vehicle )
	{
		return null;
	}

	@Override
	public void delete( final Long aLong )
	{

	}

	@Override
	public void delete( final Vehicle vehicle )
	{

	}

	//

	@Override
	public List<Vehicle> byManufacturer( final String manufacturer, Integer limit )
	{
		return List.of();
	}

	@Override
	public List<Vehicle> byModel( final String model, Integer limit )
	{
		return List.of();
	}
}
