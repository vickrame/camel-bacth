import java.util.Collection;

import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.ujoodha.config.PoolConnextionMongo;
import com.ujoodha.utils.PropertiesReader;

/**
 * 
 */

/**
 * @author vickrame
 *
 */

public class TestConnexionMongo {

	private MongoClient client = null;

	@Before
	public void before() {

		PropertiesReader.INSTANCE
				.initialyse("C:\\Dev\\workspace\\Camel-Batch\\config\\data.properties");

		client = PoolConnextionMongo.INSTANCE.getClient();

		Collection<DB> dbs = client.getUsedDatabases();
		dbs.forEach(item -> {
			System.out.println(item.getName());
		});

	}

	@After
	public void after() {
		// System.out.println("on rend le pool");

		PoolConnextionMongo.INSTANCE.releaseClient(client);
	}

	@Test
	public void connectionMongo() {
		MongoDatabase dataBase = client.getDatabase("vujDB2");
		MongoCollection<Document> collectionMongo = dataBase
				.getCollection("dataTableF");

		FindIterable<Document> findIt = collectionMongo.find();
		MongoCursor<Document> cursorIt = findIt.iterator();

		while (cursorIt.hasNext()) {
			Document doc = cursorIt.next();
			System.out.println(doc.toJson());
		}
	}

}
