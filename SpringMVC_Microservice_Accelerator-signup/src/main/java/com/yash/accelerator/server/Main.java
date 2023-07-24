package com.yash.accelerator.server;



import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;

/**
 * Allow the servers to be invoke from the command-line. The jar is built with
 * this as the <code>Main-Class</code> in the jar's <code>MANIFEST.MF</code>.
 * 
 * @author kartavya.soni
 */
public class Main {
	protected static Logger logger = Logger.getLogger(Main.class
			.getName());
	public static void main(String[] args) {

		String serverName = "NO-VALUE";

		switch (args.length) {
		case 2:
			// Optionally set the HTTP port to listen on, overrides
			// value in the <server-name>-server.yml file
			System.setProperty("server.port", args[1]);
			// Fall through into ..

		case 1:
			serverName = args[0].toLowerCase();
			break;

		default:
			usage();
			return;
		}

		// Tell server to look for <server-name>-server.properties or
		// <server-name>-server.yml (this app. uses YAML)
		System.setProperty("spring.config.name", serverName + "-server");

		 if (serverName.equals("signup")) {
			SpringApplication.run(SignUpServer.class, args);
		}else {
			logger.info("Unknown server type: " + serverName);
			usage();
		}
	}

	protected static void usage() {
		logger.info("Usage: java -jar ... <server-name> [server-port]");
		logger.info("     where server-name is 'registration', "
				+ "'signup' or 'signin' or 'web' and server-port > 1024");
	}
}

