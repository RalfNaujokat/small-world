package de.ralfn.pub.commons;

import java.util.List;
import java.util.Properties;

public interface RestClient
{
	JsonConverter getJsonConverter();
	void setJsonConverter( JsonConverter jsonConverter );

	enum Method
	{
		Get,
		Put,
		Post,
		Patch,
		Delete,
	}

	interface Request<B>
	{
		String path();
		Properties header();
		B body();

		static <B> Request<B> of( String path, Properties header, B body )
		{
			return null;
		}
	}

	interface Response<B>
	{
		Properties header();
		B body();
		int httpResponseStatusCode();
		List<String> errorMessages();
	}

	<RQS, RSP> Response<RSP> call( Method method, Request<RQS> request );

	default <RQS, RSP> Response<RSP> get( Request<RQS> request )
	{
		return call( Method.Get, request );
	}

	default <RQS, RSP> Response<RSP> put( Request<RQS> request )
	{
		return call( Method.Put, request );
	}

	default <RQS, RSP> Response<RSP> post( Request<RQS> request )
	{
		return call( Method.Post, request );
	}

	default <RQS, RSP> Response<RSP> patch( Request<RQS> request )
	{
		return call( Method.Patch, request );
	}

	default <RQS, RSP> Response<RSP> delete( Request<RQS> request )
	{
		return call( Method.Delete, request );
	}
}
