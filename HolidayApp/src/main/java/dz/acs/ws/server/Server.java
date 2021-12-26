package dz.acs.ws.server;

import javax.xml.ws.Endpoint;

import dz.acs.ws.HolidayFront;

public class Server {

	public static void main(String[] args) {
		HolidayFront implementor = new HolidayFront();
		String address = "http://localhost:9000/holiday";
		System.err.println("Enpoint Running at http://localhost:9000/holiday ....");
        Endpoint.publish(address, implementor);

	}

}
