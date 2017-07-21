package com.mce.api;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * To access IDT classes.
 *
 * @author MCE626
 */
@SuppressWarnings("rawtypes")
class IDTClassAccess {

	static {
		AtomicBoolean isInstalled = new AtomicBoolean(true);

		classSmelterRecipes = getClassSafely("com.mce.handlers.custom_recipes.SmelterRecipes", isInstalled);
		classWelderRecipes = getClassSafely("com.mce.handlers.custom_recipes.WelderRecipes", isInstalled);
		isIDTInstalled = isInstalled.get();
	}

	static final Class classSmelterRecipes;
	static final Class classWelderRecipes;
	static final boolean isIDTInstalled;

	private IDTClassAccess() {
	}

	private static Class getClassSafely(String className, AtomicBoolean isInstalled) {
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			isInstalled.set(false);
			return null;
		}
	}
}
