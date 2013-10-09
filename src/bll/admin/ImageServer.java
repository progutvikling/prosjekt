package bll.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import dal.admin.DatabaseManager;
import dal.admin.Image;

public class ImageServer {

	private static final int PORT = 8000;
	private static final int NUMBER_OF_IMAGES_TO_SERVE = 100;

	private HttpServer server;

	public ImageServer() {
		try {
			initServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initServer() throws IOException {
		ExecutorService excutor;
		InetSocketAddress addr = new InetSocketAddress("localhost", PORT);
		server = HttpServer.create(addr, 0);
		server.createContext("/images", new ImagesHandler());
		server.createContext("/config", new ConfigHandler());
		excutor = Executors.newCachedThreadPool();
		server.setExecutor(excutor);
	}

	public void start() {
		server.start();
	}

	public void stop(int seconds) {
		server.stop(seconds);
	}

	static class ImagesHandler implements HttpHandler {
		public void handle(HttpExchange exchange) throws IOException {
			String response = getJsonRepresentationOfLastImages(NUMBER_OF_IMAGES_TO_SERVE);
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}

		public String getJsonRepresentationOfLastImages(int numberOfImages) {
			DatabaseManager dbm = new DatabaseManager();
			ArrayList<Image> lastImages = dbm.getLast(numberOfImages);
			return ImageParser.getJsonFromImage(lastImages);
		}
	}

	static class ConfigHandler implements HttpHandler {
		public void handle(HttpExchange exchange) throws IOException {
			String response = "config";
			exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.close();
		}
	}
}