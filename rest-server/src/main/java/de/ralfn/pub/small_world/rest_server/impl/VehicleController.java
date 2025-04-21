package de.ralfn.pub.small_world.rest_server.impl;

import de.ralfn.pub.small_world.model.Vehicle;
import de.ralfn.pub.small_world.rest_server.api.VehicleService;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Component
public class VehicleController
	implements de.ralfn.pub.small_world.rest_server.api.VehicleController
{
	private final VehicleService service;

	public VehicleController( final VehicleService service )
	{
		this.service = service;
	}

	//

	@Override
	public Vehicle create( final Vehicle vehicle )
	{
		return service.create( vehicle );
	}

	@Override
	public long size()
	{
		return service.size();
	}

	@Override
	public Vehicle read( final Long id )
	{
		return service.read( id );
	}

	@Override
	public List<Long> read( final Predicate<Vehicle> predicate, final Comparator<Vehicle> comparator )
	{
		return service.read( predicate, comparator );
	}

	@Override
	public List<Vehicle> read( final List<Long> ids )
	{
		return service.read( ids );
	}

	@Override
	public Vehicle update( final Vehicle vehicle )
	{
		return service.update( vehicle );
	}

	@Override
	public void delete( final Long id )
	{
		service.delete( id );
	}

	@Override
	public void delete( final Vehicle vehicle )
	{
		service.delete( vehicle );
	}

	//

	private static final int maxLimit = 1000;

	@Override
	public List<Vehicle> byManufacturer( final String manufacturer, Integer limit )
	{
		return service.byManufacturer( manufacturer, Math.min( limit, maxLimit ) );
	}

	@Override
	public List<Vehicle> byModel( final String model, final Integer limit )
	{
		return service.byModel( model, Math.min( limit, maxLimit ) );
	}
}
