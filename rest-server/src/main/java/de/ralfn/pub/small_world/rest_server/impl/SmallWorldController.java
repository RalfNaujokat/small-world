package de.ralfn.pub.small_world.rest_server.impl;

import de.ralfn.pub.small_world.model.Person;
import de.ralfn.pub.small_world.rest_server.api.SmallWorldService;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Component
public class SmallWorldController
	implements de.ralfn.pub.small_world.rest_server.api.SmallWorldController
{
	private final SmallWorldService service;

	public SmallWorldController( final SmallWorldService service )
	{
		this.service = service;
	}

	//

	@Override
	public Person create( final Person person )
	{
		return service.create( person );
	}

	@Override
	public long size()
	{
		return service.size();
	}

	@Override
	public Person read( final Long id )
	{
		return service.read( id );
	}

	@Override
	public List<Long> read( final Predicate<Person> predicate, final Comparator<Person> comparator )
	{
		return service.read( predicate, comparator );
	}

	@Override
	public List<Person> read( final List<Long> ids )
	{
		return service.read( ids );
	}

	@Override
	public Person update( final Person person )
	{
		return service.update( person );
	}

	@Override
	public void delete( final Long id )
	{
		service.delete( id );
	}

	@Override
	public void delete( final Person person )
	{
		service.delete( person );
	}

	//

	private static final int maxLimit = 1000;

	@Override
	public List<Person> byCity( final String city, Integer limit )
	{
		return service.byCity( city, Math.min( limit, maxLimit ) );
	}

	@Override
	public List<Person> byLastName( final String lastName, final Integer limit )
	{
		return service.byLastName( lastName, Math.min( limit, maxLimit ) );
	}
}
