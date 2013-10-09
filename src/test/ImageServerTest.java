package test;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

import bll.admin.ImageServer;

public class ImageServerTest {
	
	//I am aware of the redundancy in these tests.
	//I will do some refactoring later.

	@Test
	public void connectToServerAndFetchImagesTest() throws IOException {
		ImageServer server = new ImageServer();
		server.start();
		URL url = new URL("http://localhost:8000/images");
		URLConnection conn = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		assertEquals("images", in.readLine());
		server.stop(0);
	}
	
	@Test
	public void connectToServerAndFetchConfigTest() throws IOException {
		ImageServer server = new ImageServer();
		server.start();
		URL url = new URL("http://localhost:8000/config");
		URLConnection conn = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		assertEquals("config", in.readLine());
		server.stop(0);
	}
}
