package de.ralfn.pub.small_world.rest_server.impl;

import de.ralfn.pub.small_world.model.Person;
import de.ralfn.pub.small_world.rest_server.api.SmallWorldRepository;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Component
public class SmallWorldService
	implements de.ralfn.pub.small_world.rest_server.api.SmallWorldService
{
	private final SmallWorldRepository repository;

	public SmallWorldService( final de.ralfn.pub.small_world.rest_server.api.SmallWorldRepository repository )
	{
		this.repository = repository;
	}

	//

	@Override
	public Person create( final Person person )
	{
		return repository.create( person );
	}

	@Override
	public Person read( final Long id )
	{
		return repository.read( id );
	}

	@Override
	public List<Long> read( final Predicate<Person> predicate, final Comparator<Person> comparator )
	{
		return repository.read( predicate, comparator );
	}

	@Override
	public List<Person> read( final List<Long> ids )
	{
		return repository.read( ids );
	}

	@Override
	public Person update( final Person person )
	{
		return repository.update( person );
	}

	@Override
	public void delete( final Long id )
	{
		repository.delete( id );
	}

	@Override
	public void delete( final Person person )
	{
		repository.delete( person );
	}
}
