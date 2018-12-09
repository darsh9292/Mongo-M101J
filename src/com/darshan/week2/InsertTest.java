/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.darshan.week2;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import java.net.UnknownHostException;

public class InsertTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB courseDB = client.getDB("course");
        DBCollection collection = courseDB.getCollection("insertTest");

        collection.drop();

        DBObject doc = new BasicDBObject().append("x", "ab1cd");

        WriteResult result = collection.insert(doc);
        System.out.println(result.toString());
        System.out.println(result.getN());
        

        BasicDBObject dbObject = new BasicDBObject();
        dbObject.put("x",  java.util.regex.Pattern.compile("1"));
        try(DBCursor cursor = collection.find(dbObject))
		{
			while (cursor.hasNext())
			{
				System.out.println((BasicDBObject) cursor.next());
			}
		}
        		

    }
}
