package com.ujoodha.common;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

public enum UserCache {

	INSTANCE;

	private AtomicReference<ConcurrentMap<UserKey, User>> cacheUtilisateur;

	private UserCache() {
		ConcurrentMap<UserKey, User> data = new ConcurrentHashMap<UserKey, User>(
				1000);
		cacheUtilisateur = new AtomicReference<ConcurrentMap<UserKey, User>>();
		cacheUtilisateur.set(data);
	}

	public void put(User user) {
		ConcurrentMap<UserKey, User> data = cacheUtilisateur.get();

		// boolean contains = data.containsKey(user.getKey());
		// if(contains)
		data.putIfAbsent(user.getKey(), user);
		// cacheUtilisateur.set(user);
	}

	public User get(User user) {
		ConcurrentMap<UserKey, User> data = cacheUtilisateur.get();

		return data.get(user.getKey());
	}
}
