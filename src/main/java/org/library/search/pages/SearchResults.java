package org.library.search.pages;

import java.io.Serializable;
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
 }
