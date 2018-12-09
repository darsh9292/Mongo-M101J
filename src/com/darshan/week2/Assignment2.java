package com.darshan.week2;

import java.util.Iterator;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class Assignment2
{
	public static void main(String[] args)
	{
		DBCollection collection = MongoUtil.getCollection("students", "grades");
		
		DBCursor cursor = collection.find(new BasicDBObject("type","homework")).sort(new BasicDBObject("student_id",1).append("score", 1));
		
		Iterator<DBObject> iterator = cursor.iterator();
		int i=0;
		while (iterator.hasNext())
		{
			DBObject dbObject = (DBObject) iterator.next();
			++i;
			if(i%2!=0)
			{
				collection.remove(dbObject);
			}
		}
		
		
	}
}
