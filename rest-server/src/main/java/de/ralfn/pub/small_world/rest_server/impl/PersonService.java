package de.ralfn.pub.small_world.rest_server.impl;

import de.ralfn.pub.commons.Holder;
import de.ralfn.pub.small_world.model.Person;
import de.ralfn.pub.small_world.rest_server.api.PersonRepository;

import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

@Component
public class PersonService
	implements de.ralfn.pub.small_world.rest_server.api.PersonService
{
	private final PersonRepository repository;

	public PersonService( final PersonRepository repository )
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
	public long size()
	{
		return repository.size();
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

	//

	@Override
	public List<Person> byCity( final String city, final Integer limit )
	{
		final Holder<List<Person>> result = Holder.create();
		Thread.ofVirtual().start( () ->
			{
				result.set( repository.byCity( city, limit ) );
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
	public List<Person> byLastName( final String lastName, final Integer limit )
	{
		return repository.byLastName( lastName, limit );
	}
}
