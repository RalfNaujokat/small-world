package de.ralfn.pub.small_world.api.commons;

import de.ralfn.pub.small_world.model.property.HasId;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface CRUD<ITEM extends HasId<ID>, ID>
{
	ITEM create( ITEM item );

	ITEM read( ID id );
	List<ID> read( Predicate<ITEM> predicate, Comparator<ITEM> comparator );
	List<ITEM> read( List<ID> ids );

	ITEM update( ITEM item );

	void delete( ID id );
	void delete( ITEM item );
}
