package de.ralfn.pub.commons;

public interface Java
{
	default ClassLoader classLoader()
	{
		return classLoader( null );
	}

	ClassLoader classLoader( Class<?> sourceClass );

	//

	public static Java get()
	{
		return new Java()
		{
			@Override
			public ClassLoader classLoader( Class<?> sourceClass )
			{
				ClassLoader classLoader = null;

				if ( sourceClass != null && ( classLoader = sourceClass.getClassLoader() ) != null )
					return classLoader;

				if ( ( classLoader = Thread.currentThread().getContextClassLoader() ) != null )
					return classLoader;

				if ( ( classLoader = ClassLoader.getSystemClassLoader() ) != null )
					return classLoader;

				return null;
			}
		};
	}
}
