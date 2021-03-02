package com.nopalsoft.zombiekiller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.nopalsoft.zombiekiller.objetos.Hero;
import com.nopalsoft.zombiekiller.screens.SettingsScreen;

public class Settings {

	public final static int NUM_GEMS_SHARE_FACEBOOK = 250;
	public final static int NUM_GEMS_INVITE_FACEBOOK = 50;

	public final static boolean isTest = false;
	public final static int NUM_MAPS = 41;

	public static boolean isMusicOn;
	public static boolean isSoundOn;

	public static boolean didBuyNoAds;
	public static boolean didLikeFacebook;
	public static boolean didRate;

	public static boolean isPadEnabled;
	public static float padSize;
	public static float padPositionX;
	public static float padPositionY;
	public static float buttonSize;
	public static float buttonFirePositionX;
	public static float buttonFirePositionY;
	public static float buttonJumpPositionX;
	public static float buttonJumpPositionY;

	public static int numeroVecesJugadas;
	public static int skinSeleccionada;
	public static int gemsTotal;
	public static long zombiesKilled;

	public static int LEVEL_WEAPON;
	public static int LEVEL_CHANCE_DROP;
	public static int LEVEL_LIFE;
	public static int LEVEL_SHIELD;

	public static int[] arrSkullsMundo;// Cada posicion es un mundo

	private final static Preferences pref = Gdx.app.getPreferences("com.nopalsoft.zombiekiller");

	public static void save() {

		pref.putBoolean("isMusicOn", isMusicOn);
		pref.putBoolean("isSoundOn", isSoundOn);

		pref.putBoolean("didBuyNoAds", didBuyNoAds);
		pref.putBoolean("didLikeFacebook", didLikeFacebook);
		pref.putBoolean("didRate", didRate);

		pref.putBoolean("isPadEnabled", isPadEnabled);
		pref.putFloat("padSize", padSize);
		pref.putFloat("padPositionX", padPositionX);
		pref.putFloat("padPositionY", padPositionY);
		pref.putFloat("buttonSize", buttonSize);
		pref.putFloat("buttonFirePositionX", buttonFirePositionX);
		pref.putFloat("buttonFirePositionY", buttonFirePositionY);
		pref.putFloat("buttonJumpPositionX", buttonJumpPositionX);
		pref.putFloat("buttonJumpPositionY", buttonJumpPositionY);

		pref.putInteger("numeroVecesJugadas", numeroVecesJugadas);
		pref.putInteger("skinSeleccionada", skinSeleccionada);
		pref.putInteger("gemsTotal", gemsTotal);
		pref.putLong("zombiesKilled", zombiesKilled);

		pref.putInteger("LEVEL_WEAPON", LEVEL_WEAPON);
		pref.putInteger("LEVEL_CHANCE_DROP", LEVEL_CHANCE_DROP);
		pref.putInteger("LEVEL_LIFE", LEVEL_LIFE);
		pref.putInteger("LEVEL_SHIELD", LEVEL_SHIELD);

		for (int i = 0; i < arrSkullsMundo.length; i++) {
			pref.putInteger("arrSkullsMundo" + i, arrSkullsMundo[i]);
		}
		pref.flush();

	}

	public static void load() {
		arrSkullsMundo = new int[NUM_MAPS];

		if (isTest) {
			pref.clear();
			pref.flush();
		}

		isMusicOn = pref.getBoolean("isMusicOn", true);
		isSoundOn = pref.getBoolean("isSoundOn", true);

		didBuyNoAds = pref.getBoolean("didBuyNoAds", false);
		didLikeFacebook = pref.getBoolean("didLikeFacebook", false);
		didRate = pref.getBoolean("didRate", false);

		isPadEnabled = pref.getBoolean("isPadEnabled", false);
		padSize = pref.getFloat("padSize", SettingsScreen.DEFAULT_SIZE_PAD);
		padPositionX = pref.getFloat("padPositionX", SettingsScreen.DEFAULT_POSITION_PAD.x);
		padPositionY = pref.getFloat("padPositionY", SettingsScreen.DEFAULT_POSITION_PAD.y);
		buttonSize = pref.getFloat("buttonSize", SettingsScreen.DEFAULT_SIZE_BUTTONS);
		buttonFirePositionX = pref.getFloat("buttonFirePositionX", SettingsScreen.DEFAULT_POSITION_BUTTON_FIRE.x);
		buttonFirePositionY = pref.getFloat("buttonFirePositionY", SettingsScreen.DEFAULT_POSITION_BUTTON_FIRE.y);
		buttonJumpPositionX = pref.getFloat("buttonJumpPositionX", SettingsScreen.DEFAULT_POSITION_BUTTON_JUMP.x);
		buttonJumpPositionY = pref.getFloat("buttonJumpPositionY", SettingsScreen.DEFAULT_POSITION_BUTTON_JUMP.y);

		numeroVecesJugadas = pref.getInteger("numeroVecesJugadas", 0);
		skinSeleccionada = pref.getInteger("skinSeleccionada", Hero.TIPO_SWAT);
		gemsTotal = pref.getInteger("gemsTotal", 0);
		zombiesKilled = pref.getLong("zombiesKilled", 0);

		LEVEL_WEAPON = pref.getInteger("LEVEL_WEAPON", 0);
		LEVEL_CHANCE_DROP = pref.getInteger("LEVEL_CHANCE_DROP", 0);
		LEVEL_LIFE = pref.getInteger("LEVEL_LIFE", 0);
		LEVEL_SHIELD = pref.getInteger("LEVEL_SHIELD", 0);

		for (int i = 0; i < NUM_MAPS; i++) {
			arrSkullsMundo[i] = pref.getInteger("arrSkullsMundo" + i, 0);
		}

		if (isTest) {
			gemsTotal += 999999;
		}

	}

	public static void saveLevel(int level, int skulls) {
		int actualSkulls = arrSkullsMundo[level];
		if (actualSkulls < skulls) {
			arrSkullsMundo[level] = skulls;
		}
		save();
	}

	public static void saveNewPadSettings(float x, float y, float size) {
		padSize = size;
		padPositionX = x;
		padPositionY = y;
		save();
	}

	public static void saveNewButtonFireSettings(float x, float y, float size) {
		buttonSize = size;
		buttonFirePositionX = x;
		buttonFirePositionY = y;
		save();
	}

	public static void saveNewButtonJumpSettings(float x, float y, float size) {
		buttonSize = size;
		buttonJumpPositionX = x;
		buttonJumpPositionY = y;
		save();
	}

}
