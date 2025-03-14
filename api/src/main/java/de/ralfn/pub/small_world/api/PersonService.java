package de.ralfn.pub.small_world.api;

import de.ralfn.pub.commons.CRUD;
import de.ralfn.pub.small_world.model.Person;

import java.util.List;

public interface PersonService
	extends CRUD<Person, Long>
{
	List<Person> from( String city );
}
