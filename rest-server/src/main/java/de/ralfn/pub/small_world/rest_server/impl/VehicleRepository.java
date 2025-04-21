package de.ralfn.pub.small_world.rest_server.impl;

import de.ralfn.pub.small_world.model.Vehicle;
import de.ralfn.pub.small_world.rest_server.impl.uti.VehicleDataGenerator;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class VehicleRepository
	implements de.ralfn.pub.small_world.rest_server.api.VehicleRepository
{
	public VehicleRepository()
	{
		Thread.ofVirtual().start( () ->
			{
				VehicleDataGenerator vehicleDataGenerator = new VehicleDataGenerator();

				final int numberOfVehicles = 500_000;
				System.out.printf( "Starting data generation for %d...%n", numberOfVehicles );
				vehicles = vehicleDataGenerator.createRandomVehicleList( numberOfVehicles );
				System.out.printf( "%d vehicles generated!%n", numberOfVehicles );
			}
		);
	}

	//

	private static List<Vehicle> vehicles;

	@Override
	public Vehicle create( final Vehicle vehicle )
	{
		vehicles.add( vehicle );
		return vehicle;
	}

	@Override
	public long size()
	{
		return vehicles.size();
	}

	@Override
	public Vehicle read( final Long id )
	{
		return vehicles
			.stream()
			.filter( p -> p.getId().equals( id ) )
			.findFirst()
			.orElse( null );
	}

	@Override
	public List<Long> read( final Predicate<Vehicle> predicate, final Comparator<Vehicle> comparator )
	{
		return vehicles
			.stream()
			.filter( predicate )
			.sorted( comparator )
			.map( Vehicle::getId )
			.toList();
	}

	@Override
	public List<Vehicle> read( final List<Long> ids )
	{
		return ids
			.stream()
			.map( this::read )
			.filter( Objects::nonNull )
			.toList();
	}

	@Override
	public Vehicle update( final Vehicle vehicle )
	{
		delete( vehicle.getId() );
		return create( vehicle );
	}

	@Override
	public void delete( final Long id )
	{
		vehicles.remove( read( id ) );
	}

	@Override
	public void delete( final Vehicle vehicle )
	{
		delete( vehicle.getId() );
	}

	//

	@Override
	public List<Vehicle> byManufacturer( final String manufacturer, Integer limit )
	{
		return vehicles
			.stream()
			.filter( vehicle -> vehicle.getManufacturer().startsWith( manufacturer ) )
			.limit( limit )
			.toList();
	}

	@Override
	public List<Vehicle> byModel( final String model, final Integer limit )
	{
		return vehicles
			.stream()
			.filter( vehicle -> vehicle.getModel().startsWith( model ) )
			.limit( limit )
			.toList();
	}
}
