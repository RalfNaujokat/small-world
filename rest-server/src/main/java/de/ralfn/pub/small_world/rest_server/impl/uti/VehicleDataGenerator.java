package de.ralfn.pub.small_world.rest_server.impl.uti;

import de.ralfn.pub.small_world.model.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDataGenerator
{
	public VehicleDataGenerator()
	{
		// TODO
	}

	//

	public List<Vehicle> createRandomVehicleList( int count )
	{
		ArrayList<Vehicle> result = new ArrayList<>();

		// TODO add my vehicles

		for ( int i = 1; i < count; i++ )
			result.add( createRandomVehicle( i ) );

		return result;
	}

	public Vehicle createRandomVehicle( int i )
	{
		return null;
	}
}
