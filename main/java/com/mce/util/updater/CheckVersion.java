package com.mce.util.updater;

public class CheckVersion {
	public CheckVersion() {
		System.out.println(
				"Industrial Technologies Mod is checking for updates. Adding glycerin to the sulfuric and white fuming nitric acid mixture.");
		try {
			if (Integer.parseInt(UpdateInfo.getLatestVersion()) > UpdateInfo.thisVersion) {
				System.out.println("Industrial Technologies Mod Update Found! Nitroglycerin has been made!");
			} else {
				System.out.println("No Updates Found for Industrial Technologies Mod, not enough glycerin was added.");
			}
		} catch (Exception e) {
			System.out.println("An error has occurred! The glycerin was added too fast! Error ID: IDT-300");
			e.printStackTrace();
		}
	}
}
