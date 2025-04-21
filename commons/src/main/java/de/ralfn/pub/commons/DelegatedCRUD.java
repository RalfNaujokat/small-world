package de.ralfn.pub.commons;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Standard operations on data sets
 */
public interface DelegatedCRUD
{
	interface DelegatedCreate<ITEM extends HasId<ID>, ID>
		extends CRUD.Create<ITEM, ID>
	{
		CRUD.Create<ITEM, ID> delegate();

		default ITEM create( ITEM item )
		{
			return delegate().create( item );
		}
	}

	interface DelegatedRead<ITEM extends HasId<ID>, ID>
		extends CRUD.Read<ITEM, ID>
	{
		CRUD.Read<ITEM, ID> delegate();

		default long size()
		{
			return delegate().size();
		}

		default ITEM read( ID id )
		{
			return delegate().read( id );
		}

		default List<ID> read( Predicate<ITEM> predicate, Comparator<ITEM> comparator )
		{
			return delegate().read( predicate, comparator );
		}

		default List<ITEM> read( List<ID> ids )
		{
			return delegate().read( ids );
		}
	}

	interface DelegatedUpdate<ITEM extends HasId<ID>, ID>
		extends CRUD.Update<ITEM, ID>
	{
		CRUD.Update<ITEM, ID> delegate();

		default ITEM update( ITEM item )
		{
			return delegate().update( item );
		}
	}

	interface DelegatedDelete<ITEM extends HasId<ID>, ID>
		extends CRUD.Delete<ITEM, ID>
	{
		CRUD.Delete<ITEM, ID> delegate();

		default void delete( ID id )
		{
			delegate().delete( id );
		}

		default void delete( ITEM item )
		{
			delegate().delete( item );
		}
	}
}
