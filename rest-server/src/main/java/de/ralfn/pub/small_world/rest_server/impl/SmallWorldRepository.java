package de.ralfn.pub.small_world.rest_server.impl;

import de.ralfn.pub.small_world.model.Person;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class SmallWorldRepository
	implements de.ralfn.pub.small_world.rest_server.api.SmallWorldRepository
{
	private final List<Person> persons = createRandomData();

	private static List<Person> createRandomData()
	{
		ArrayList<Person> result = new ArrayList<>();
		return result;
	}

	@Override
	public Person create( final Person person )
	{
		persons.add( person );
		return person;
	}

	@Override
	public Person read( final Long id )
	{
		return persons
			.stream()
			.filter( p -> p.getId().equals( id ) )
			.findFirst()
			.orElse( null );
	}

	@Override
	public List<Long> read( final Predicate<Person> predicate, final Comparator<Person> comparator )
	{
		return persons
			.stream()
			.filter( predicate )
			.sorted( comparator )
			.map( Person::getId )
			.toList();
	}

	@Override
	public List<Person> read( final List<Long> ids )
	{
		return ids
			.stream()
			.map( this::read )
			.filter( Objects::nonNull )
			.toList();
	}

	@Override
	public Person update( final Person person )
	{
		delete( person.getId() );
		return create( person );
	}

	@Override
	public void delete( final Long id )
	{
		persons.remove( read( id ) );
	}

	@Override
	public void delete( final Person person )
	{
		delete( person.getId() );
	}
}
