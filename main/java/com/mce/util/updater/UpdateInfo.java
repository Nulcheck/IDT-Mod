package com.mce.util.updater;

import java.io.InputStream;
import java.net.URL;

public class UpdateInfo {
	public static int thisVersion = 13;
	public static final String versionURL = "https://docs.google.com/document/d/1A2vTvI0PAIJqqC6r6bRU3zFOMVEk4p6mj9KKpkD1fB8/pub";

	public static String getLatestVersion() throws Exception {
		String data = getData("https://docs.google.com/document/d/1A2vTvI0PAIJqqC6r6bRU3zFOMVEk4p6mj9KKpkD1fB8/pub");
		return data.substring(data.indexOf("[version]") + 9,
				data.indexOf("[/version]"));
	}

	private static String getData(String address) throws Exception {
		URL url = new URL(address);
		InputStream html = null;
		html = url.openStream();

		int c = 0;
		StringBuffer buffer = new StringBuffer("");
		while (c != -1) {
			c = html.read();
			buffer.append((char) c);
		}
		return buffer.toString();
	}
}
