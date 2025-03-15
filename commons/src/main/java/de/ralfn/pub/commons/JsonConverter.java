package de.ralfn.pub.commons;

public interface JsonConverter
{
	<T> String toJson( T object );
	<T> T toObject( String json );
}
