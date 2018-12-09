package com.darshan.week3;

import com.darshan.week2.MongoUtil;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class SchoolHw3_1
{
	public static void main(String[] args)
	{
		DBCollection collection = MongoUtil.getCollection("school", "students");
		DBCursor cursor = collection.find();
		try
		{
			while (cursor.hasNext())
			{
				DBObject dbObject = (DBObject) cursor.next();
				BasicDBList scores = (BasicDBList) dbObject.get("scores");
				
				Object minScoreObj=null;
				double minScore = Double.MAX_VALUE;
				for (Object eachScore : scores) 
				{ 
					BasicDBObject scoreObj = (BasicDBObject) eachScore;
					String type= (String) scoreObj.get("type");
					double score = (Double) scoreObj.get("score");
					if("homework".equals(type) && score<minScore)
					{
						minScore = score;
						minScoreObj = eachScore;
					}
				}
				
				if(minScoreObj!=null)
				{
					scores.remove(minScoreObj);
				}
				
				//System.out.println(scores);
				collection.update(new BasicDBObject("_id",dbObject.get("_id")),
							new BasicDBObject("$set", new BasicDBObject("scores",scores) ));
				System.out.println("Complete");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cursor.close();
		}
	}
}
