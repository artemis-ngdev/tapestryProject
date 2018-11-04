package org.library.search.pages;

import java.util.ArrayList;
import java.util.List;
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
    @Property
    @Inject
    @Symbol(SymbolConstants.TAPESTRY_VERSION)
    private String tapestryVersion;


    @Property
    @NotNull
    @Size(max = 100)
    @Parameter(required = false) 
    private String bookName;

    // Other pages
    @InjectPage
    private SearchResults searchResultsPage;


    @InjectComponent("searchForm")
    private Form form;

    @InjectComponent("bookName")
    private TextField bookNameField;
    
    void onValidateFromSearchForm() {

        // Note, this method is triggered even if server-side validation has already found error(s).

        if (bookName != null && bookName.equals("Acme")) {
            form.recordError(bookNameField, "Book XXX must not be Acme.");
        }

    }

    Object onSuccess() {
    	
//    	String filterToUpperCase = bookName.toUpperCase();
//    	List<Book> results =  getAllBooks()
//    						.stream()
//			    		    .filter(b-> {
//								
//								return b.getTitle().toUpperCase().contains(filterToUpperCase);
//							})
//			    		    .collect(Collectors.toList());
    	
        searchResultsPage.setSearchResults(getAllBooks());
        return searchResultsPage;
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
