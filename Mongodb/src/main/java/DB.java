import java.util.Iterator;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DB {

	public static void main(String[] args) {
	
		MongoClient mc=new MongoClient("localhost",27017);
		MongoDatabase md=mc.getDatabase("Sample");
		
//		MongoCursor<String> mc1=mc.listDatabaseNames().iterator();
//		while(mc1.hasNext())
//		{
//			System.out.println(mc1.next());
//		}
		Scanner s=new Scanner(System.in);
		MongoCollection<Document> mcd=md.getCollection("Data");
		//mcd.insertOne(new Document().append("name","Nallaal").append("age",s.nextInt()));
		FindIterable<Document> df=mcd.find();
		Iterator it=df.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		BasicDBObject dbo=new BasicDBObject();
		dbo.put("name","Adhavan");
		dbo.put("age",2);
		MongoCursor<Document> mc2=mcd.find(dbo).iterator();
		while(mc2.hasNext())
		{ 
			System.out.println(mc2.next());
		}
		
	}

}
