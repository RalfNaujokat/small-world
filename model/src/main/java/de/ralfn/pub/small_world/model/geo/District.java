package de.ralfn.pub.small_world.model.geo;

import de.ralfn.pub.small_world.model.property.HasId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class District
	implements HasId<Long>
{
	protected Long id;

	protected String name;
}
