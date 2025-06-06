package de.ralfn.pub.small_world.rest_client;

import de.ralfn.pub.commons.RestClient;
import de.ralfn.pub.commons.RestClient.Request;
import de.ralfn.pub.commons.RestClient.Response;
import de.ralfn.pub.small_world.api.PersonService;
import de.ralfn.pub.small_world.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class PersonServiceClient
	implements PersonService
{
	public PersonServiceClient( final RestClient restClient )
	{
		this.restClient = restClient;
	}

	//

	private final RestClient restClient;

	//

	@Override
	public Person create( final Person person )
	{
		Response<Person> response = restClient
			.post( Request.of( "", null, person ) );

		return response
			.body();
	}

	@Override
	public long size()
	{
		return 0;
	}

	@Override
	public Person read( final Long aLong )
	{
		return null;
	}

	@Override
	public List<Long> read( final Predicate<Person> predicate, final Comparator<Person> comparator )
	{
		return List.of();
	}

	@Override
	public List<Person> read( final List<Long> longs )
	{
		return List.of();
	}

	@Override
	public Person update( final Person person )
	{
		return null;
	}

	@Override
	public void delete( final Long aLong )
	{

	}

	@Override
	public void delete( final Person person )
	{

	}

	//

	@Override
	public List<Person> byCity( final String city, Integer limit )
	{
		return List.of();
	}

	@Override
	public List<Person> byLastName( final String lastName, Integer limit )
	{
		return List.of();
	}
}
