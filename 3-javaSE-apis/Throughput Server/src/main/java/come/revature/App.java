package come.revature;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.*;
// Our goal today is to create a very basic server to act a search engine of sorts
// We'll provide a book (War and Peace) and we'll use the server to search this book for words
// and return how many times the words appear
public class App {
	
	// We need to point to a file that we're looking to read from
	
	private static final String INPUT_FILE = "C:\\Users\\brygu\\Desktop\\220613-demos\\notes-and-demos\\3-javaSE-apis\\Throughput Server\\src\\main\\resources\\war_and_peace.txt";
	
	private static final int NUMBER_OF_THREADS = 1;
	
	public static void main(String[] args) {
		
		String text = "";
		
		try {
			text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
			
			// This is where we'll set up and start the server
			// Let's start our server
			startServer(text);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void startServer(String text) throws IOException {
		/* Create the start server method by calling the HttpServer.create() method.
		 * 
		 * 1st param. Takes address of our localhost and a port we want to listen on from
		 * com.sun.net package in the form of SocketAddress object
		 * 
		 * 2nd param. is a backlog size which is the size of queue for HTTP server requests. We're going to keep it at 0
		 * because all requests should end up in our thread pool queue instead
		 */
		
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		// search should look like http://localhost:8000/search?word='theword'
		
		/*
		 * Create a context which assigns a handler object to a specific http route.
		 * This handler handle each incoming http request and sends a response.
		 * client can send requests to http://localhost:8000/search -> trigger a method inside our application
		 */
		
		server.createContext("/search", new WordCountHandler(text));
		
		/*
		 * Executor schedule each incoming HTTP request to a pool of threads which will handle those requests
		 */
		
		Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		/*
		 * Let's pass the executor object to our server
		 * This is why we're using HTTPServer from com.sun.net package as opposed to some other frameworks
		 */
		
		server.setExecutor(executor);
		
		// Start the server with the .start() method;
		server.start();
	}
	
	public static class WordCountHandler implements HttpHandler{
		
		private String text;
		
		public WordCountHandler(String text) {
			this.text = text;
		}

		@Override
		public void handle(HttpExchange httpExchange) throws IOException {
			// HttpExchange object is going to essentially handle the encapsulation of both the request and response
			// for HTTP interactions
			
			// This method below will pull the word=talk from the request: http://localhost:8000/search?word=talk
			String query = httpExchange.getRequestURI().getQuery();
			
			// URL is universal resource locator
			// URI is universal resource identifier
			
			// word=talk needs to be split so we can get "talk" from word and make sure it received as an "action"
			
			String[] keyValuePair = query.split("=");
			String action = keyValuePair[0];
			String word = keyValuePair[1];
			
			// Check that query parameter is right
			if (!action.equals("word")) {
				// If the URL was wrong or malformed send back an error message
				httpExchange.sendResponseHeaders(400, 0); // Status code 400 denotes client side error
				return;
			}
			
			
			// Being here means the action is word which is good
			// Let's make some method to count the time the word is found in the text:
			String count = countWord(word); // "The word _____ appeared ___ times
			
			// Lets convert the string object to something we can send back in an HttpResponse
			byte[] response = count.getBytes();
			
			// Let's use our httpresponseheaders method again
			// This takes in 2 params, ( status code, length of response body)
			httpExchange.sendResponseHeaders(200, response.length);
			
			
			// Represent the response body as an output stream
			OutputStream outputStream = httpExchange.getResponseBody();
			
			// Write the response to output stream
			outputStream.write(response);
			
			// close our stream
			outputStream.close();
		}

		// This is going to return a phrase that denotes how many times a word appeared in the text
		private String countWord(String word) {
			
			System.out.println("countWord() method triggered!");
			
			int count = 0;
			int index = 0;
			
			// Run some loop that will check for every appearance of the word passed through
			// We're using the index (which we'll increment each time to capture exactly where the word appeared
			// so we don't repeat outselves)
			
			while (index >=0) {
				
				// Text is a string object that we'll make in a minute but it holds all the text from 
				// our war and peace file
				index = text.indexOf(word, index);
				
				// if the index return is positive then we found the word in the book
				// if it is negative we did not
				
				if (index >= 0) {
					count++;
					index++;
				}
			}
			
			return "The word " + word + " appeared " + count + " times!";
		}
		
	}

}
