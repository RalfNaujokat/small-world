package de.ralfn.pub.small_world.api;

import de.ralfn.pub.commons.CRUD;
import de.ralfn.pub.small_world.model.Person;

import java.util.List;

public interface PersonService
	extends CRUD.All<Person, Long>
{
	/**
	 * @param city
	 * 	the city/cities that should be found </br>
	 * 	the parameter city is used in .startsWith()
	 * @param limit
	 * 	the maximum number of persons that should be returned</br>
	 * 	the default limit is 100
	 * 	the absolute limit is 1000
	 *
	 * @return the list of matching persons
	 */
	List<Person> byCity( String city, Integer limit );

	/**
	 * @param lastName
	 * 	the name(s) that should be found </br>
	 * 	the parameter name is used in .startsWith()
	 * @param limit
	 * 	the maximum number of persons that should be returned</br>
	 * 	the default limit is 100
	 * 	the absolute limit is 1000
	 *
	 * @return the list of matching persons
	 */
	List<Person> byLastName( String lastName, Integer limit );
}
