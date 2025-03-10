package de.ralfn.pub.small_world.rest_server.impl;

import de.ralfn.pub.small_world.model.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class DataGenerator
{
	public DataGenerator()
	{
		try
		{
			firstNameFemale = read( "firstName-female.txt" );
			firstNameMale = read( "firstName-male.txt" );
			lastName = read( "lastName.txt" );
		}
		catch ( IOException e )
		{
			throw new RuntimeException( e );
		}
	}

	//

	public List<Person> createRandomPersonList( int count )
	{
		ArrayList<Person> result = new ArrayList<>();

		for ( int i = 0; i < count; i++ )
			result.add( createRandomPerson( i ) );

		return result;
	}

	public Person createRandomPerson( int i )
	{
		double p = Math.random();

		Person.Gender gender;
		if ( p < 0.5 )
			gender = Person.Gender.Female;
		else
			gender = Person.Gender.Male;

		String[] firstNames = gender == Person.Gender.Female ? firstNameFemale : firstNameMale;

		if ( p < 0.001 )
			gender = Person.Gender.Other;

		return Person.builder()
			.id( i + 1L )
			.gender( gender )
			.firstName( firstNames[ ( int )( Math.random() * firstNames.length ) ] )
			.lastName( lastName[ ( int )( Math.random() * lastName.length ) ] )
			.dayOfBirth( LocalDate.now().minusDays( ( int )( Math.random() * 365.25 * 110 ) ) )
			.build();
	}

	//

	private final String[] firstNameFemale;
	private final String[] firstNameMale;
	private final String[] lastName;

	private String[] read( String resourceName )
		throws
		IOException
	{
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		Stream<String> stream = new String( cl.getSystemResourceAsStream( resourceName ).readAllBytes() )
			.lines()
			.filter( Objects::nonNull )
			.filter( s -> !s.isBlank() )
			.filter( s -> !s.startsWith( "#" ) )
			.map( this::firstName );

		return ( String[] )stream.toArray( String[]::new );
	}

	private String firstName( String line )
	{
		return line.trim().split( "\\s+" )[ 0 ];
	}
}
