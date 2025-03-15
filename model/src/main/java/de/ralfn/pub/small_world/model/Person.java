package de.ralfn.pub.small_world.model;

import de.ralfn.pub.commons.HasId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person
	implements HasId<Long>
{
	public enum Gender
	{
		Female,
		Male,
		Other,
	}

	//

	protected Long id;

	protected String firstName;
	protected String lastName;
	protected Gender gender;

	protected String zip;
	protected String cityName;

	protected LocalDate dayOfBirth;
}
