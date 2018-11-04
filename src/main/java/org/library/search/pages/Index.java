package org.library.search.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.library.model.Book;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

/**
 * Start page of application search.
 */
public class Index
{
    
	private static final Logger LOGGER = Logger.getLogger(SearchResults.class.getName());
    
	 
    @Property
    @NotNull
    @Size(max = 100)
    @Parameter(required = false) 
    private String bookName;

    @InjectPage
    private SearchResults searchResultsPage;


    @InjectComponent("searchForm")
    private Form form;

    @InjectComponent("bookName")
    private TextField bookNameField;
    
  
    void onValidateFromSearchForm() {
        if ( bookName == null || "".equals(bookName)) {
            form.recordError(bookNameField, "Book must be entered to do the search");
          }
    }

    Object onSuccess() {
        this.searchResultsPage.setSearchTerm(bookName);
        return searchResultsPage;
    }
    
    
}
