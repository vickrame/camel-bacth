///**
// * 
// */
//package com.ujoodha.config;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.broker.Connection;
//
//import nf.fr.eraasoft.pool.ObjectPool;
//import nf.fr.eraasoft.pool.PoolException;
//import nf.fr.eraasoft.pool.PoolSettings;
//import nf.fr.eraasoft.pool.PoolableObject;
//
//
//
//
//import com.ujoodha.utils.CamelBatchUtils;
//import com.ujoodha.utils.PropertiesReader;
//
///**
// * @author vickrame
// *
// */
//public enum PoolConnexionAMQP {
//
//	INSTANCE;
//
//	private PoolSettings<org.apache.activemq.broker.Connection> poolSettings;
//
//	private PoolConnexionAMQP() {
//		poolSettings = new PoolSettings<Connection>(
//				new PoolableObject<Connection>() {
//
//					private Connection client;
//
//					@Override
//					public Connection make() throws PoolException {
//
//						ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
//						factory.setUsername(PropertiesReader.INSTANCE
//								.getPropsFromKey(CamelBatchUtils.RABBIT_USER));
//						factory.setPassword(PropertiesReader.INSTANCE
//								.getPropsFromKey(CamelBatchUtils.RABBIT_PASSWORD));
//						factory.setVirtualHost(PropertiesReader.INSTANCE
//								.getPropsFromKey(CamelBatchUtils.RABBIT_VIRTUALHOST));
//						factory.setHost(PropertiesReader.INSTANCE
//								.getPropsFromKey(CamelBatchUtils.RABBIT_HOSTNAME));
//						factory.setPort(Integer.parseInt(PropertiesReader.INSTANCE
//								.getPropsFromKey(CamelBatchUtils.RABBIT_PORT)));
//
//						try {
//							client = factory.newConnection();
//						} catch (IOException | TimeoutException e) {
//							throw new RuntimeException(
//									"Impossible de construire le pool");
//						}
//
//						return client;
//					}
//
//					@Override
//					public boolean validate(Connection t) {
//						// TODO Auto-generated method stub
//						return false;
//					}
//
//					@Override
//					public void destroy(Connection t) {
//					}
//
//					@Override
//					public void activate(Connection t) throws PoolException {
//					}
//
//					@Override
//					public void passivate(Connection t) {
//					}
//				});
//
//		poolSettings.min(0).max(10);
//	}
//
//	/**
//	 * @return the poolSettings
//	 */
//	public PoolSettings<Connection> getPoolSettings() {
//		return poolSettings;
//	}
//
//	public Connection getClient() {
//		ObjectPool<Connection> objectPool = poolSettings.pool();
//
//		Connection client = null;
//		try {
//			client = objectPool.getObj();
//			System.out.println("Un client " + client);
//		} catch (PoolException e) {
//			e.printStackTrace();
//		}
//
//		return client;
//	}
//
//	public void releaseClient(final Connection client) {
//		ObjectPool<Connection> objectPool = poolSettings.pool();
//		objectPool.returnObj(client);
//	}
//
// }
