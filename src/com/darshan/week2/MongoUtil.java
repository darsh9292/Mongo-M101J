package com.darshan.week2;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoUtil
{
	private static MongoClient _client = null;

	public static MongoClient getClient()
	{
		try
		{
			if (_client == null)
				_client = new MongoClient();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return _client;
	}

	public static DBCollection getCollection(String database, String collection)
	{
		MongoClient client = getClient();
		DB db = client.getDB(database);
		return db.getCollection(collection);
	}
	
}