package de.ralfn.pub.small_world.model;

import de.ralfn.pub.small_world.model.property.HasId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
	protected LocalDate dayOfBirth;
}
