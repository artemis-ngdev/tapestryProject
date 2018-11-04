package org.library.search.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
 	private @NotNull @Size(max = 100) String searchTerm;
   
    public List<Book> getSearchResults() {  
		return getFilteredBooks();
	}

    public List<Book> getFilteredBooks() {
    	
    	final String filterToUpperCase = this.searchTerm.toUpperCase();
    	
    	final List<Book> allBooks = getAllBooks();
    	final List<Book> results = new ArrayList<Book>();
    	
    	if (allBooks.size() > 0 ) {
    		for(final Book bk: allBooks ) {
    			if ( bk.getTitle().toUpperCase().contains(filterToUpperCase)
    				||  bk.getAuthor().toUpperCase().contains(filterToUpperCase)) {
    				results.add( bk );
    			}
    		}
 
//    		results =  results
//    						.stream()
//			    		    .filter(x->x.getTitle().toUpperCase().contains(filterToUpperCase))
//    						.collect(Collectors.toList());
    		
    	}
    	
    	return results;
    }
    
	void onActivate(String arg) {
		
        this.setSearchTerm(arg);
        
    }
	 
	String onPassivate() {
	
		return this.searchTerm;
    }

	public Integer getNumResults() {
		return this.getSearchResults().size();
	}
	 
	
	private List<Book>  getAllBooks() {
		
    	ArrayList<Book> list = new ArrayList<Book>();
    	list.add( new Book("Lord of the Rings","RK Rowling" ));
    	list.add( new Book("Harry Potter and The Wooden Stone","RK Rowling" ));
    	list.add( new Book("Lord of the Rings","writer 2" ));
    	list.add( new Book("Lord of the Rings","writer 4" ));
    	return   list;
   
    }

	public void setSearchTerm(@NotNull @Size(max = 100) String insearchTerm) {
 		this.searchTerm = insearchTerm;
		
	}
	
	public String getSearchTerm() {
		return this.searchTerm;
	}
 }
