/**
 * 
 */
package com.ujoodha.main;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.rabbitmq.client.ConnectionFactory;
import com.ujoodha.common.exception.FunctionalException;
import com.ujoodha.config.CustomCamelContext;
import com.ujoodha.config.PoolConnextionMongo;
import com.ujoodha.config.routes.CustomRouteBuilder;
import com.ujoodha.config.routes.FileToAMQPRoute;
import com.ujoodha.config.routes.FileToElasticRouteBuilder;
import com.ujoodha.config.routes.FileToFileRoute;
import com.ujoodha.config.routes.FileToMongoRouteBuilder;
import com.ujoodha.config.routes.MongoToFile;
import com.ujoodha.config.routes.MongoToRabbitMqRouteBuilder;
import com.ujoodha.utils.CamelBatchUtils;
import com.ujoodha.utils.PropertiesReader;

/**
 * @author vickrame
 *
 */
public class BatchMain {

	// private static final Logger LOGGER =
	// LoggerFactory.getLogger("BatchMain");

	/**
	 * @param args
	 */
	public static void main(String... args) {

		// LOGGER.debug("debut");
		CommandLine cmd = configureBatch(args);

		analyseCommand(cmd);

	}

	private static CommandLine configureBatch(final String... args) {
		CommandLine cmd = null;
		try {
			Option commandOption = new Option("command", true,
					"demarrage du job");
			Option help = new Option("help", false, "commande de lancement");
			Option file = new Option("file", true, "fichier de configuration");
			Option job = new Option("job", true, "type du job");

			Options command = new Options();
			command.addOption(commandOption);
			command.addOption(file);
			command.addOption(help);
			command.addOption(job);

			CommandLineParser parser = new DefaultParser();
			cmd = parser.parse(command, args);

			// analyseCommand(cmd);
		} catch (ParseException e) {
			printHelp();
			e.printStackTrace();
		}
		return cmd;
	}

	private static void analyseCommand(CommandLine cmd) {

		boolean ret = false;
		if (cmd.hasOption("file")) {
			PropertiesReader.INSTANCE.initialyse(cmd.getOptionValue("file"));
		}

		if (cmd.hasOption("command")) {
			ret = true;
		} else if (cmd.hasOption("help")) {
			System.exit(0);
			printHelp();
		} else {
			System.err.println("Commande inconnue");
			System.out.println(cmd.toString());
			printHelp();
			System.exit(-1);
		}

		if (ret) {
			try {
				String nomJob = "";
				if (cmd.hasOption("job")) {
					nomJob = cmd.getOptionValue("job");
					executeJob(nomJob);
				} else {
					System.err.println("job manquant");
					printHelp();
					System.exit(-1);
				}

			} catch (FunctionalException e) {
				e.printStackTrace();
				printHelp();
				System.exit(-1);
			}
		}
	}

	private static void executeJob(final String nomJob)
			throws FunctionalException {
		System.out.println("Lancement du job");

		try {

			switch (nomJob) {
			case "es":
				copyFileInEs(nomJob);
				break;
			case "mongo":
				copyFileInMongo(nomJob);
				break;
			case "file":
				copyFileInDirectory(nomJob);
				break;
			case "mongoToFile":
				copyMongoToFile(nomJob);
				break;
			case "rabbit":
				copyMongoInRabbit(nomJob);
				break;
			case "filerabbit":
				copyFileToRabbit(nomJob);
				break;
			case "amqp":
				copyFileToAMQP(nomJob);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	private static void copyFileToAMQP(String nomJob)
			throws FunctionalException, IOException, TimeoutException {
		CustomCamelContext context = new CustomCamelContext(nomJob);

		ActiveMQComponent component = new ActiveMQComponent();

		component.setBrokerURL("tcp://localhost:61616");
		component.setUserName("admin");
		component.setPassword("admin");

		context.addComponent("activemq", component);

		CustomRouteBuilder builderRoute = new FileToAMQPRoute();
		// try {
		context.doJob(builderRoute);
		// } catch (FunctionalException e) {
		// TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private static void copyFileToRabbit(String nomJob)
			throws FunctionalException, IOException, TimeoutException {
		CustomCamelContext context = new CustomCamelContext(nomJob);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_USER));
		factory.setPassword(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_PASSWORD));
		factory.setVirtualHost(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_VIRTUALHOST));
		factory.setHost(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_HOSTNAME));
		factory.setPort(Integer.parseInt(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_PORT)));

		// MongoClient client = PoolConnextionMongo.INSTANCE.getClient();

		SimpleRegistry registry = new SimpleRegistry();
		registry.put("factoryRabbit", factory);
		// registry.put("mongoDb", client);

		context.setRegistry(registry);

		CustomRouteBuilder builderRoute = new FileToMongoRouteBuilder();
		context.doJob(builderRoute);

		// PoolConnextionMongo.INSTANCE.releaseClient(client);
	}

	private static void copyMongoInRabbit(String nomJob)
			throws FunctionalException, IOException, TimeoutException {
		CustomCamelContext context = new CustomCamelContext(nomJob);

		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_USER));
		factory.setPassword(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_PASSWORD));
		factory.setVirtualHost(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_VIRTUALHOST));
		factory.setHost(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_HOSTNAME));
		factory.setPort(Integer.parseInt(PropertiesReader.INSTANCE
				.getPropsFromKey(CamelBatchUtils.RABBIT_PORT)));

		MongoClient client = PoolConnextionMongo.INSTANCE.getClient();

		com.mongodb.BasicDBObject query = new BasicDBObject();
		query.put("nom", "ujoodha");

		SimpleRegistry registry = new SimpleRegistry();
		registry.put("factoryRabbit", factory);
		registry.put("mongoDb", client);
		registry.put("findByCriteria", query);

		context.setRegistry(registry);

		CustomRouteBuilder builderRoute = new MongoToRabbitMqRouteBuilder();
		context.doJob(builderRoute);

		PoolConnextionMongo.INSTANCE.releaseClient(client);
	}

	private static void copyMongoToFile(String nomJob)
			throws FunctionalException {
		CustomCamelContext context = new CustomCamelContext(nomJob);

		SimpleRegistry registry = new SimpleRegistry();
		MongoClient client = PoolConnextionMongo.INSTANCE.getClient();
		registry.put("mongoDb", client);
		context.setRegistry(registry);

		CustomRouteBuilder builderRoute = new MongoToFile();
		context.doJob(builderRoute);

		PoolConnextionMongo.INSTANCE.releaseClient(client);

	}

	private static void copyFileInDirectory(String nomJob)
			throws FunctionalException {
		CustomCamelContext context = new CustomCamelContext(nomJob);
		CustomRouteBuilder builderRoute = new FileToFileRoute();
		context.doJob(builderRoute);
	}

	private static void copyFileInMongo(String nomJob)
			throws FunctionalException {
		CustomCamelContext context = new CustomCamelContext(nomJob);
		SimpleRegistry registry = new SimpleRegistry();
		MongoClient client = PoolConnextionMongo.INSTANCE.getClient();
		registry.put("mongoDb", client);
		context.setRegistry(registry);
		CustomRouteBuilder builderRoute = new FileToMongoRouteBuilder();
		context.doJob(builderRoute);
		PoolConnextionMongo.INSTANCE.releaseClient(client);
	}

	private static void copyFileInEs(String nomJob) throws FunctionalException {
		CustomCamelContext context = new CustomCamelContext(nomJob);

		CustomRouteBuilder builderRoute = new FileToElasticRouteBuilder();

		context.doJob(builderRoute);
	}

	private static void printHelp() {
		System.err
				.println("Usage : java -jar ... -file <PATH>\\data.properties -command start -job file");
		System.err.println("command option [start|stop]");
		System.err.println("job option [es|mongo|rabbit|file]");
	}
}
