package net.pyxzl.jsvc.daemonstarter;

import java.util.Arrays;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

public class DaemonStarter implements Daemon {
	private String		entryPoint;
	private String[]	args;

	public void init(final DaemonContext context) throws DaemonInitException, Exception {
		System.out.println("Initializing JSVC Daemon");
		String[] daemonArgs = context.getArguments();
		this.entryPoint = daemonArgs[0];
		this.args = Arrays.copyOfRange(daemonArgs, 1, daemonArgs.length);
	}

	public void start() throws Exception {
		System.out.println("Starting JSVC Daemon");
		try {
			Class.forName(this.entryPoint).getMethod("main", String[].class).invoke(null, (Object) this.args);
		} catch (Exception e) {
			System.out.println("There was an error launching the Daemon:");
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void stop() throws Exception {
		System.out.println("Stopping JSVC Daemon");
	}

	public void destroy() {
		System.out.println("Terminating JSVC Daemon");
	}
}