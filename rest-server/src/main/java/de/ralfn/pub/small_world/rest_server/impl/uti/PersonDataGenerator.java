package de.ralfn.pub.small_world.rest_server.impl.uti;

import de.ralfn.pub.commons.Java;
import de.ralfn.pub.small_world.model.Person;
import de.ralfn.pub.small_world.model.geo.City;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class PersonDataGenerator
{
	public PersonDataGenerator()
	{
		try
		{
			String folder = "data/";

			firstNameFemale = readFirstWordOfTextFile( folder + "firstName-female.txt" );
			firstNameMale = readFirstWordOfTextFile( folder + "firstName-male.txt" );
			lastName = readFirstWordOfTextFile( folder + "lastName.txt" );
			street = readStreets( folder + "streets-germany.txt" );
			city = readCities( folder + "cities-germany.csv" );

			System.out.println( "Data Generator is using" );
			System.out.println( "%10d female first names.".formatted( firstNameFemale.length ) );
			System.out.println( "%10d male first names.".formatted( firstNameMale.length ) );
			System.out.println( "%10d last names.".formatted( lastName.length ) );
			System.out.println( "%10d street names.".formatted( street.length ) );
			System.out.println( "%10d city names.".formatted( city.length ) );
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

		result.add(
			Person.builder()
				.id( 0L )
				.firstName( "Ralf" )
				.lastName( "N." )
				.gender( Person.Gender.Male )
				.zip( "45899" )
				.cityName( "Gelsenkirchen" )
				.dayOfBirth( LocalDate.of( 1961, 12, 23 ) )
				.build()
		);

		for ( int i = 1; i < count; i++ )
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

		City c = city[ ( int )( Math.random() * city.length ) ];

		return Person.builder()
			.id( i + 1L )
			.gender( gender )
			.firstName( firstNames[ ( int )( Math.random() * firstNames.length ) ] )
			.lastName( lastName[ ( int )( Math.random() * lastName.length ) ] )
			.streetName( street[ ( int )( Math.random() * street.length ) ] )
			.houseNo( Integer.toString( ( int )( Math.random() * 100 ) ) )
			.zip( c.getZip() )
			.cityName( c.getName() )
			.dayOfBirth( LocalDate.now().minusDays( ( int )( Math.random() * 365.25 * 110 ) ) )
			.build();
	}

	//

	private final String[] firstNameFemale;
	private final String[] firstNameMale;
	private final String[] lastName;
	private final String[] street;
	private final City[] city;

	private String[] readFirstWordOfTextFile( String resourceName )
		throws
		IOException
	{
		InputStream is = Java.get()
			.classLoader()
			.getResourceAsStream( resourceName );

		if ( is == null )
			throw new RuntimeException( "Unable to load resource '%s'".formatted( resourceName ) );

		Stream<String> stream = new String( is.readAllBytes() )
			.lines()
			.filter( Objects::nonNull )
			.filter( s -> !s.isBlank() )
			.filter( s -> !s.startsWith( "#" ) )
			.map( this::firstWord );

		return ( String[] )stream.toArray( String[]::new );
	}

	private String[] readStreets( String resourceName )
		throws
		IOException
	{
		InputStream is = Java.get()
			.classLoader()
			.getResourceAsStream( resourceName );

		if ( is == null )
			throw new RuntimeException( "Unable to load resource '%s'".formatted( resourceName ) );

		Stream<String> stream = new String( is.readAllBytes() )
			.lines()
			.filter( Objects::nonNull )
			.filter( s -> !s.isBlank() )
			.filter( s -> !s.startsWith( "#" ) )
			.map( this::readStreet );

		return ( String[] )stream.toArray( String[]::new );
	}

	private String readStreet( String line )
	{
		String[] part = line.split( "\t" );

		return part[ 1 ];
	}

	private City[] readCities( String resourceName )
		throws
		IOException
	{
		InputStream is = Java.get()
			.classLoader()
			.getResourceAsStream( resourceName );

		if ( is == null )
			throw new RuntimeException( "Unable to load resource '%s'".formatted( resourceName ) );

		Stream<City> stream = new String( is.readAllBytes() )
			.lines()
			.filter( Objects::nonNull )
			.filter( s -> !s.isBlank() )
			.filter( s -> !s.startsWith( "#" ) )
			.filter( s -> !s.startsWith( "Schlüsselnummer" ) )
			.map( this::readCity );

		return ( City[] )stream.toArray( City[]::new );
	}

	private City readCity( String line )
	{
		String[] cell = line.split( ";" );
		return City.builder()
			.id( Long.valueOf( cell[ 0 ] ) )
			.name( cell[ 1 ] )
			.zip( cell[ 2 ] )
			.build();
	}

	private String firstWord( String line )
	{
		return line.trim().split( "\\s+" )[ 0 ];
	}
}
