package org.library.search.pages;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import org.apache.tapestry5.annotations.Import;
import org.library.model.Book;


@Import(stylesheet="context:css/olive.css")
public class SearchResults implements Serializable {
	
	private static final Logger LOGGER = Logger.getLogger(SearchResults.class.getName());
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
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
 }
