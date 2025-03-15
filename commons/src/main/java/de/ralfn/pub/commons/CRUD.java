package de.ralfn.pub.commons;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface CRUD<ITEM extends HasId<ID>, ID>
{
	ITEM create( ITEM item );

	long size();
	ITEM read( ID id );
	List<ID> read( Predicate<ITEM> predicate, Comparator<ITEM> comparator );
	List<ITEM> read( List<ID> ids );

	ITEM update( ITEM item );

	void delete( ID id );
	void delete( ITEM item );
}
