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
public class Vehicle
	implements HasId<Long>
{
	public enum Type
	{
		PassengerCar,
		Motorcycle,
	}

	//

	protected Long id;

	protected Type type;

	protected String manufacturer;
	protected String model;

	LocalDate registrationDate;
}
