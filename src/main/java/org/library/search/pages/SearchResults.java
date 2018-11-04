package org.library.search.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.library.model.Book;


@Import(stylesheet="context:css/custom.css")
public class SearchResults implements Serializable {
	
	private static final Logger LOGGER = Logger.getLogger(SearchResults.class.getName());
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	 @Property
    private Book book;
	
    private List<Book> searchResults;
   
    public List<Book> getSearchResults() {
    	LOGGER.info("--------------");
    	searchResults = getAllBooks();
		return searchResults;
	}

	public void setSearchResults(List<Book> searchResults) {
		this.searchResults = searchResults;
	}

	void onActivate(List<Book> searchResults) {
        this.setSearchResults(searchResults);
    }
	 
	List<Book> onPassivate() {
        return this.searchResults;
    }

	public Integer getNumResults() {
		return this.getSearchResults().size();
	}
	
	public String getBookTitle() {
		return "hello";
	}
	 
	
	  private static List<Book>  getAllBooks()
	    {
	    	ArrayList<Book> list = new ArrayList<Book>();
	    	 
	    	list.add( new Book("Lord of the Rings","RK Rowling" ));
	    	list.add( new Book("Harry Potter and The Wooden Stone","RK Rowling" ));
	    	list.add( new Book("Lord of the Rings","writer 2" ));
	    	list.add( new Book("Lord of the Rings","writer 4" ));
	     	
	    	return   list;
	   
	    }
 }
