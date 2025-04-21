package de.ralfn.pub.small_world.api;

import de.ralfn.pub.commons.CRUD;
import de.ralfn.pub.small_world.model.Person;
import de.ralfn.pub.small_world.model.Vehicle;

import java.util.List;

public interface VehicleService
	extends CRUD.All<Vehicle, Long>
{
	/**
	 * @param manufacturer
	 * 	the manufacturer name(s) that should be found </br>
	 * 	the parameter name is used in .startsWith()
	 * @param limit
	 * 	the maximum number of vehicles that should be returned</br>
	 * 	the default limit is 100
	 * 	the absolute limit is 1000
	 *
	 * @return the list of matching persons
	 */
	List<Vehicle> byManufacturer( String manufacturer, Integer limit );

	/**
	 * @param model
	 * 	the model name(s) that should be found </br>
	 * 	the parameter name is used in .startsWith()
	 * @param limit
	 * 	the maximum number of vehicles that should be returned</br>
	 * 	the default limit is 100
	 * 	the absolute limit is 1000
	 *
	 * @return the list of matching persons
	 */
	List<Vehicle> byModel( String model, Integer limit );
}
