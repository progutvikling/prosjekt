package bll.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class ImageServer {
	
	private static final int PORT = 8000;
	
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
        public void handle(HttpExchange t) throws IOException {
            String response = "images";
            t.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
    static class ConfigHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
            String response = "config";
            t.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}