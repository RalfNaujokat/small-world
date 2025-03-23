package de.ralfn.pub.commons;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Standard operations on data sets
 */
public interface CRUD
{
	interface Create<ITEM extends HasId<ID>, ID>
	{
		ITEM create( ITEM item );
	}

	interface Read<ITEM extends HasId<ID>, ID>
	{
		long size();

		ITEM read( ID id );

		List<ID> read( Predicate<ITEM> predicate, Comparator<ITEM> comparator );

		List<ITEM> read( List<ID> ids );
	}

	interface Update<ITEM extends HasId<ID>, ID>
	{
		ITEM update( ITEM item );
	}

	interface Delete<ITEM extends HasId<ID>, ID>
	{
		void delete( ID id );

		void delete( ITEM item );
	}

	interface All<ITEM extends HasId<ID>, ID>
		extends
		Create<ITEM, ID>, Read<ITEM, ID>, Update<ITEM, ID>, Delete<ITEM, ID>
	{
	}
}
