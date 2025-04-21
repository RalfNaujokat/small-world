package de.ralfn.pub.small_world.rest_server.impl;

import de.ralfn.pub.commons.Holder;
import de.ralfn.pub.small_world.model.Vehicle;
import de.ralfn.pub.small_world.rest_server.api.VehicleRepository;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Component
public class VehicleService
	implements de.ralfn.pub.small_world.rest_server.api.VehicleService
{
	private final VehicleRepository repository;

	public VehicleService( final VehicleRepository repository )
	{
		this.repository = repository;
	}

	//

	@Override
	public Vehicle create( final Vehicle vehicle )
	{
		return repository.create( vehicle );
	}

	@Override
	public long size()
	{
		return repository.size();
	}

	@Override
	public Vehicle read( final Long id )
	{
		return repository.read( id );
	}

	@Override
	public List<Long> read( final Predicate<Vehicle> predicate, final Comparator<Vehicle> comparator )
	{
		return repository.read( predicate, comparator );
	}

	@Override
	public List<Vehicle> read( final List<Long> ids )
	{
		return repository.read( ids );
	}

	@Override
	public Vehicle update( final Vehicle vehicle )
	{
		return repository.update( vehicle );
	}

	@Override
	public void delete( final Long id )
	{
		repository.delete( id );
	}

	@Override
	public void delete( final Vehicle vehicle )
	{
		repository.delete( vehicle );
	}

	//

	@Override
	public List<Vehicle> byManufacturer( final String manufacturer, final Integer limit )
	{
		final Holder<List<Vehicle>> result = Holder.create();
		Thread.ofVirtual().start( () ->
			{
				result.set( repository.byManufacturer( manufacturer, limit ) );
			} );
		while ( result.get() == null )
		{
			try
			{
				Thread.sleep( 100 );
			}
			catch ( InterruptedException e )
			{
				throw new RuntimeException( e );
			}
		}
		return result.get();
	}

	@Override
	public List<Vehicle> byModel( final String model, final Integer limit )
	{
		return repository.byModel( model, limit );
	}
}
