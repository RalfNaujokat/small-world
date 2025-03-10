package de.ralfn.pub.small_world.rest_server.impl;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RootController
	implements de.ralfn.pub.small_world.rest_server.api.RootController
{
	@Override
	public String get()
	{
		return "Ok";
	}

	private static final LocalDateTime started = LocalDateTime.now();

	@Override
	public String health()
	{
		return "%s: Running since %s"
			.formatted(
				LocalDateTime.now().toString(),
				started.toString()
			);
	}
}
