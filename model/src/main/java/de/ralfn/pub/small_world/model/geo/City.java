package de.ralfn.pub.small_world.model.geo;

import de.ralfn.pub.commons.HasId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City
	implements HasId<Long>
{
	protected Long id;

	protected Long countryId;
	protected Long stateId;
	protected Long districtId;

	protected String zip;
	protected String name;
}
