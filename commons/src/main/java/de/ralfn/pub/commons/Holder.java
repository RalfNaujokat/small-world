package de.ralfn.pub.commons;

public interface Holder<T>
{
	T get();

	void set( T value );

	//

	public static <T> Holder<T> create()
	{
		return new Holder<T>()
		{
			private T value = null;

			@Override
			public T get()
			{
				return value;
			}

			@Override
			public void set( final T value )
			{
				this.value = value;
			}
		};
	}
}
